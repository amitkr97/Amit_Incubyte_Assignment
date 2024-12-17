package StepDefinitions;


import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Loginpage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginSteps {
	
	//@FindBy(xpath="//div[@class='welcome-msg']")
   // WebElement dashboardMessage;
	WebDriver driver = null;
	Loginpage login;
   

    // Step to initialize the browser and open the Magento sign-in page
    @Given("^I navigate to Magento sign-in page$")
    public void i_navigate_to_magento_sign_in_page() {
        // Setup WebDriver (use WebDriverManager if preferred)
    	
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    // Step to sign in with the newly created email and password
    @When("^I sign in with the newly created (.*) and (.*)$")
    public void i_sign_in_with_the_newly_created_email_and_password(String user, String pass) throws InterruptedException {
        // Go to the sign-in page
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        // Fill in the login form
        login = new Loginpage(driver);
        
        login.enterSignIn(user, pass);
        
//        WebElement emailField = driver.findElement(By.id("email"));
//        emailField.sendKeys("amit.kumar002@example.com");
//
//        WebElement passwordField = driver.findElement(By.id("pass"));
//        passwordField.sendKeys("Password123");
//
//        // Click on the "Sign In" button
//        WebElement signInButton = driver.findElement(By.id("send2"));
//        signInButton.click();
    }

    // Step to verify that the user is logged in and directed to the dashboard
    @Then("I should be logged in successfully and see the user dashboard")
    public void i_should_see_the_user_dashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dashboardMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"logged-in\"]")));
        assertTrue(dashboardMessage.isDisplayed());

        // Optionally verify that the correct user's name is displayed in the dashboard
        WebElement userName = driver.findElement(By.xpath("//*[text()=\"amit.kumar002@example.com\"]"));
        assertTrue(userName.isDisplayed());

        // Close the browser after the test
        driver.quit();
    }
}
