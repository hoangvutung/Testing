package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
	MobileElement registerNew;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
	MobileElement emailRegister;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
	MobileElement user;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
	MobileElement password;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
	MobileElement confirmPassword;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
	MobileElement registerButton;

	public Register(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
	}

	public void newRegister(String email, String userName, String pass, String confirmPass) {
		registerNew.click();
		emailRegister.sendKeys(email);
		user.sendKeys(userName);
		password.sendKeys(pass);
		confirmPassword.sendKeys(confirmPass);
		registerButton.click();
	}

}
