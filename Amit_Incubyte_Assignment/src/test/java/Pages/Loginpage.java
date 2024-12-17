package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	@FindBy(id="email")
	  WebElement username;
	
	@FindBy(id="pass")
	  WebElement password;
	
	@FindBy(id="send2")
	  WebElement Sendbtn;
	
	@FindBy(xpath="//div[@class='welcome-msg']")
	  WebElement dashboardMessage;
	
	
	By username_id = By.id("email");
	By password_id = By.id("pass");
	By btn_signin = By.id("send2");
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterSignIn(String user, String pass) throws InterruptedException {
		username.sendKeys(user);
		password.sendKeys(pass);
		Thread.sleep(2000);
		Sendbtn.click();

	}

}
