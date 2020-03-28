package testing.task2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementNotVisibleException;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(SmokeTest.class)
public class SecondTest {
	WebDriver driver;
	HomePage homePage;
	@Before
	public void BeforeTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	homePage = PageFactory.initElements(driver, HomePage.class);
    	driver.get("https://jdi-framework.github.io/tests/index.htm");
    	WebDriverWait dynamicElement = new WebDriverWait(driver, 10);
    	dynamicElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/header/div/nav/ul[2]/li/a/div/i")));
    	assertEquals(homePage.isLoggedIn(FIRST_PAGE_DATA.LOGIN.str, FIRST_PAGE_DATA.PASSWORD.str),true);
    	homePage.Metals.click();
	}
	@Test
    public void SecondPage_1() {
    	homePage.Submit.click();
    	assertEquals(driver.getTitle(),SECONDPAGE_DATA.TITLE.str);
    	assertEquals(homePage.Result.getText(),SECONDPAGE_DATA.RESULT.strArr[0]);
    }
	@Test
    public void SecondPage_2() {
    	homePage.selectRadioElements(SECONDPAGE_DATA.SUM.strArr[2]);
    	homePage.Submit.click();
    	assertEquals(driver.getTitle(),SECONDPAGE_DATA.TITLE.str);
    	assertEquals(homePage.Result.getText(),SECONDPAGE_DATA.RESULT.strArr[1]);
    }
    @After
    public void AfterTest() {
    	driver.close();
    }

}
