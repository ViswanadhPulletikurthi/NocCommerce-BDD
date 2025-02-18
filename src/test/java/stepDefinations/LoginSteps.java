package stepDefinations;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.LoginPage;
import io.cucumber.java.en.*;

import java.time.Duration;


public class LoginSteps {
    WebDriver driver;
    LoginPage lp;

    @Given("User opens OrangeHRM login page")
    public void user_opens_OrangeHRM_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lp = new LoginPage(driver);
    }
    
    @Then("User should able to see the OrangeHRM logo on the Login page")
    public void user_should_able_to_see_the_orange_hrm_logo_on_the_login_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(lp.logo));  // Wait for logo to be visible
        Assert.assertTrue(lp.isLogoDisplayed());
    }
    @When("User enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) throws InterruptedException {
    	Thread.sleep(10);
        lp.setUserName(username);
        lp.setPassword(password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        lp.clickLogin();
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(expectedTitle, driver.getTitle());
        System.out.println("page title is "+expectedTitle);
        driver.quit();
    }
}
