package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUppage {
	
WebDriver driver;
	
	@FindBy(id="firstname")
	  WebElement first_name;
	
	@FindBy(id="lastname")
	  WebElement last_name;
	
	@FindBy(id="email_address")
	  WebElement email_address_txt;
	
	@FindBy(id="password")
	  WebElement password_txt;
	
	@FindBy(id="password-confirmation")
	  WebElement password_conf;
	
	@FindBy(xpath="//button[@title='Create an Account']")
	  WebElement create_acc_btn;
	
	public SignUppage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void SignUp_details(String fname, String lname, String email, String pass, String pass_conf) {
		first_name.sendKeys(fname);
		last_name.sendKeys(lname);
		email_address_txt.sendKeys(email);
		password_txt.sendKeys(pass);
		password_conf.sendKeys(pass_conf);
		//create_acc_btn.click();
	}
	
	public void create_account_button() {
		create_acc_btn.click();
	}


}
