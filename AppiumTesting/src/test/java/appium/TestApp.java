package appium;

import io.appium.java_client.android.AndroidDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestApp {
	private static AndroidDriverManager driverManager;
	static AndroidDriver driver;
	private Login login;
	private Register register;
	private AddExpense addExpense;

	@BeforeClass
	public static void prepareTest() {
		driverManager = new AndroidDriverManager();
		driver = driverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Before
	public void beforeTest() {
		driver.launchApp();
		login = new Login(driver);
		register = new Register(driver);
		addExpense = new AddExpense(driver);
	}

	@Test
	public void testRegister() {
		register.newRegister("loging@login.com", "myUser", "123456789", "123456789");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(login.signInButton));
		assertEquals(driver.currentActivity(), ".activities.LoginActivity");
	}

	@Test
	public void testLogin() {
		register.newRegister("loging@login.com", "myUser", "123456789", "123456789");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(login.signInButton));
		login.enterEmailAndPassword("loging@login.com", "123456789");
		wait.until(ExpectedConditions.visibilityOf(addExpense.addExpenseButton));
		assertEquals(driver.currentActivity(), ".activities.BudgetActivity");
	}

	@Test
	public void testExpense() {
		register.newRegister("loging@login.com", "myUser", "123456789", "123456789");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(login.signInButton));
		login.enterEmailAndPassword("loging@login.com", "123456789");
		wait.until(ExpectedConditions.visibilityOf(addExpense.addExpenseButton));
		addExpense.addNewExpense("Ticket", "1000", "01/01/2020", "Travel");
		wait.until(ExpectedConditions.visibilityOf(addExpense.addExpenseButton));
		assertTrue(addExpense.checkInfo("Ticket"));
	}

	@After
	public void afterTest() {
		driver.closeApp();
	}

	@AfterClass
	public static void quit() {
		driverManager.quitDriver();
	}
}
