package PageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@FindBy(xpath = "//img[@alt='company-branding']")
	public
    WebElement logo;

	@FindBy(name = "username")
	@CacheLookup
	WebElement usernameField;

	@FindBy(name = "password")
	@CacheLookup
	WebElement passwordField;

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement loginButton;
	
	public boolean isLogoDisplayed() {
        try {
            return logo.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	public void setUserName(String username) {
		usernameField.sendKeys(username);

	}

	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

}
