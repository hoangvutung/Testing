package testing.task1;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSearchTest {
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();//create an instance for webdriver named wd of type chrome
		wd.get("https://www.google.com");//open google
		TestSearch search= new TestSearch(wd);
		search.searchText("Qt Creator IDE");
		search.verifyFirstResult("Qt Creator IDE");
		wd.quit();
	}
}
