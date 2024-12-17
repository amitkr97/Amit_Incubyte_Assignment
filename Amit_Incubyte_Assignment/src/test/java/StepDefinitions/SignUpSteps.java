package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Loginpage;
import Pages.SignUppage;

import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class SignUpSteps {

	
	WebDriver driver = null;
	SignUppage signup;

    // Step to initialize the browser and open the Magento sign-up page
    @Given("I am on the Magento sign-up page")
    public void i_am_on_the_magento_sign_up_page() {
        // Setup WebDriver (use WebDriverManager if preferred)
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    // Step to fill in the sign-up form
    @When("^I enter a valid (.*), (.*), (.*), (.*) and (.*)$")
    public void i_enter_valid_user_details(String fname, String lname, String email, String pass, String pass_conf) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Fill in the sign-up form
        signup = new SignUppage(driver);
       
        signup.SignUp_details(fname, lname, email, pass, pass_conf);
//        WebElement firstName = driver.findElement(By.id("firstname"));
//        firstName.sendKeys("John");
//
//        WebElement lastName = driver.findElement(By.id("lastname"));
//        lastName.sendKeys("Doe");
//
//        WebElement email = driver.findElement(By.id("email_address"));
//        email.sendKeys("amit.kumar003@example.com");
//
//        WebElement password = driver.findElement(By.id("password"));
//        password.sendKeys("Password123");
//
//        WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
//        confirmPassword.sendKeys("Password123");
    }

    // Step to click the "Create an Account" button
    @When("I click on the \"Create an Account\" button")
    public void i_click_on_the_create_an_account_button() {
//        WebElement createAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
//        createAccountButton.click();
    	 signup = new SignUppage(driver);
    	 signup.create_account_button();
    }

    // Step to verify successful account creation
    @Then("I should see a success message confirming my account creation")
    public void i_should_see_a_success_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='message-success success message']")));
        assertTrue(successMessage.isDisplayed());
        

        // Close the browser after the test
        driver.quit();
    }
}
