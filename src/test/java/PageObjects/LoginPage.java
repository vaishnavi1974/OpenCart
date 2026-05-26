package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	//WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (xpath="//*[@id=\"input-email\"]") WebElement email_loc;
	@FindBy (xpath="//*[@id=\"input-password\"]") WebElement password_loc;
	@FindBy (xpath="//*[@id=\"content\"]/div/div[2]/div/form/input") WebElement login_btn_loc;
	
	public void enter_email(String email)
	{
		email_loc.sendKeys(email);
	}
	
	public void enter_password(String pass)
	{
		password_loc.sendKeys(pass);
	}
	
	public void click_login()
	{
		login_btn_loc.click();
	}

}
