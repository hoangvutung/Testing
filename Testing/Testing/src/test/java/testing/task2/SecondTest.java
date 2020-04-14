package testing.task2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(SmokeTest.class)
public class SecondTest {
	/*WebDriver driver;
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
    }*/
	WebDriver driver;
	HomePage homePage;
	@Before
	public void BeforeTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	homePage = PageFactory.initElements(driver, HomePage.class);
    	driver.get("https://jdi-framework.github.io/tests/index.htm");
    	WebElement dynamicElement = (new WebDriverWait(driver, 10))
    			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/header/div/nav/ul[2]/li/a/div/i")));
	}
	@Test
    public void FirstPage_1() {
        assertEquals(java.util.Optional.ofNullable(homePage.getIconsNumber()),java.util.Optional.ofNullable(FIRST_PAGE_DATA.ICONS_NUMBERS.i));
        for (int i = 0; i < FIRST_PAGE_DATA.ICONS_NUMBERS.i; i++) {
           assertEquals(homePage.getPictureText(i), FIRST_PAGE_DATA.TEXT.strArr[i]);
        }
    }
	@Test
    public void FirstPage_2() {
        assertEquals(homePage.getMainTitle(), FIRST_PAGE_DATA.MAIN_HEADER.str);
        assertEquals(homePage.getMainText(), FIRST_PAGE_DATA.HOME_PAGE.str);
	}
    
    @After
    public void AfterTest() {
    	driver.close();
    }

}
