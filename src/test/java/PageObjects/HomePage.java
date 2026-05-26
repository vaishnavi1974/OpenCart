package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (xpath="//a[@title='My Account']//span[@class='hidden-xs hidden-sm hidden-md']") WebElement MyAcct_loc;
	@FindBy (xpath="//li[@class='dropdown open']//li[1]//a[1]") WebElement Register_loc;
	@FindBy (xpath="//*[@id='top-links']/ul/li[2]/ul/li[2]/a") WebElement Login_loc;
	
	public void click_my_account()
	{
		MyAcct_loc.click();
	}
	
	public void click_register()
	{
		Register_loc.click();
	}
	
	public void click_login()
	{
		Login_loc.click();
	}
	
}
