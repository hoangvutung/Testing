package testing.task3;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestTask3 {

	@Test
	public void test1() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/users");
		String responseBody = response.getBody().asString();
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200 );
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		List<String> names =jsonPathEvaluator.get("name");
		assertEquals(names.get(0),"Leanne Graham");
		List<String> ids=jsonPathEvaluator.get("id");
		assertEquals(ids.size(),10);
	}

	@Test
	public void test2() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/posts");
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200 );
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		List<String> titles =jsonPathEvaluator.get("title");
		assertEquals(titles.get(0),"sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
	}

}
