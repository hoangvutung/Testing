package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
	MobileElement loginEmail;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
	MobileElement loginPwd;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
	MobileElement signInButton;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
	MobileElement registerButton;

	public Login(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
	}

	public void enterEmailAndPassword(String email, String password) {
		loginEmail.sendKeys(email);
		loginPwd.sendKeys(password);
		signInButton.click();
	}

}
