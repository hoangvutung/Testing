package testing.task4;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;
	HomePage homePage;
	@Given("^User is on Home Page$")
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	homePage = PageFactory.initElements(driver, HomePage.class);
    	driver.get("https://jdi-framework.github.io/tests/index.htm");
    	WebElement dynamicElement = (new WebDriverWait(driver, 10))
    			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/header/div/nav/ul[2]/li/a/div/i")));
	}
	@When("^Log in$")
	public void login() {
		assertEquals(homePage.isLoggedIn(FIRST_PAGE_DATA.LOGIN.str, FIRST_PAGE_DATA.PASSWORD.str),true);
	}
	@Then("^Test the home page$")
	public void testPage1() {
		assertEquals(java.util.Optional.ofNullable(homePage.getIconsNumber()),java.util.Optional.ofNullable(FIRST_PAGE_DATA.ICONS_NUMBERS.i));
        for (int i = 0; i < FIRST_PAGE_DATA.ICONS_NUMBERS.i; i++) {
           assertEquals(homePage.getPictureText(i), FIRST_PAGE_DATA.TEXT.strArr[i]);
        }
        assertEquals(homePage.getMainTitle(), FIRST_PAGE_DATA.MAIN_HEADER.str);
        assertEquals(homePage.getMainText(), FIRST_PAGE_DATA.HOME_PAGE.str);
	}
	@When("^Click on Metals and Color page$")
	public void metals() {
		homePage.Metals.click();
	}
	@Then("^Test the second page$")
	public void TestPage2() {
		homePage.Submit.click();
    	assertEquals(driver.getTitle(),SECONDPAGE_DATA.TITLE.str);
    	assertEquals(homePage.Result.getText(),SECONDPAGE_DATA.RESULT.strArr[0]);
	}
	@When("^Click on different page$")
	public void differentPage() {
		homePage.serviceLeftSection.click();
    	homePage.serviceHeader.click();
    	homePage.differentElementsPageButton.click();
	}
	
	@Then("^Test the third page$")
	public void TestPage3() {
		homePage.selectBoxElements(THIRDPAGE_DATA.CHECK_BOXES.strArr[0]);
    	String str1= homePage.Log.get(0).getText().substring(9, homePage.Log.get(0).getText().length());
    	assertEquals(str1,THIRDPAGE_DATA.LOG.strArr[0]);
	}
	@Then("^Close Chrome$")
	public void afterTest() {
		driver.close();
	}

}
