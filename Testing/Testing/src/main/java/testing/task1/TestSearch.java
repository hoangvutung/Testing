package testing.task1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestSearch {
	private WebDriver webdriver;
	public TestSearch(WebDriver wd) {
		webdriver=wd;
	}
	 public void searchText(String textToSearch) {
		WebElement elem = webdriver.findElement(By.name("q"));
		elem.sendKeys(new String[]{textToSearch});
		elem.submit();
	 }
	 public void verifyFirstResult(String correctText) {
		 List<WebElement> results = webdriver.findElements(By.xpath("//*[@id=\"rso\"]/div[1]/div[1]/div/div[1]/a/h3"));
	     assertEquals(correctText, results.get(0).getText());
	 }

}
