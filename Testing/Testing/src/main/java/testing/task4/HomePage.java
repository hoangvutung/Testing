package testing.task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {
	 public WebDriver driver;
//home Page
	    @FindBy(css = ".profile-photo")
	    WebElement ProfileIcon;

	    @FindBy(css = "#Login")
	    WebElement LoginIn;

	    @FindBy(css = "#Password")
	    WebElement PasswordIn;

	    @FindBy(css = "form .btn-login")
	    WebElement EnterIn;

	    @FindBy(css = ".logout")
	    WebElement LogOutIn;

	    @FindBy(css = ".icons-benefit")
	    List<WebElement> IconsIn;

	    @FindBy(css = ".benefit-txt")
	    List<WebElement> TextsIn;

	    @FindBy(css = ".main-title")
	    WebElement MainTitleIn;

	    @FindBy(css = ".main-txt")
	    WebElement MainTextIn;
	    //Metals and Colors
	    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]/ul/li[4]/a/span")
	    WebElement Metals;
	    
	    @FindBy(css = ".checkbox")
	    List<WebElement> Elements;
	    
	    @FindBy(css = ".radio")
	    List<WebElement> Radios;
	    
	    @FindBy(xpath = "//*[@id=\"even-selector\"]")
	    WebElement Even;
	  
	    @FindBy(xpath = "//*[@id=\"submit-button\"]")
	    WebElement Submit;
	    
	    @FindBy(xpath = "//*[@id=\"mCSB_2_container\"]/section[2]/div[2]/div/ul")
	    WebElement Result;
	    // Different Element
	    @FindBy(css = "li.sub-menu")
	    WebElement serviceLeftSection;

	    @FindBy(css = "li.dropdown")
	    WebElement serviceHeader;
	    
	    @FindBy(css = ".dropdown-menu | [href=\"page8.htm\"]")
	    WebElement differentElementsPageButton;
	    
	    @FindBy(css = ".label-checkbox")
	    List<WebElement> checkBoxes;

	    @FindBy(css = ".label-radio")
	    List<WebElement> radios2;
	    
	    @FindBy(css = ".logs li")
	    List<WebElement> Log;
	  
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    public boolean isLoggedIn(String Login, String Password) {
	        ProfileIcon.click();
	        LoginIn.sendKeys(Login);
	        PasswordIn.sendKeys(Password);
	        EnterIn.click();
	        return LogOutIn.isDisplayed();
	    }

	    public int getIconsNumber() {
	        return IconsIn.size();
	    }

	    public String getPictureText(int i) {
	        return TextsIn.get(i).getText();
	    }

	    public String getMainTitle() {
	        return MainTitleIn.getText();
	    }

	    public String getMainText() {
	        return MainTextIn.getText();
	    }
	   
	    public void selectRadioElements(String str) {
	        for (int i = 0; i < Radios.size(); i++) {
	            if (Radios.get(i).getText().contains(str)) {
	                Radios.get(i).click();
	            }
	        }
	    }
	    public void selectBoxElements(String str) {
	        for (int i = 0; i < checkBoxes.size(); i++) {
	            if (checkBoxes.get(i).getText().contains(str)) {
	            	checkBoxes.get(i).click();
	            }
	        }
	    }
	    public void selectRadioElements2(String str) {
	        for (int i = 0; i < radios2.size(); i++) {
	            if (radios2.get(i).getText().contains(str)) {
	            	radios2.get(i).click();
	            }
	        }
	    }
}
