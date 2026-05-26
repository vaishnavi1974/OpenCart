package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration_Page extends BasePage{
	
	public Registration_Page(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (xpath="//input[@name='firstname']") WebElement firstname_loc;
	@FindBy (xpath="//input[@name='lastname']") WebElement lastname_loc;
	@FindBy (xpath="//input[@name='email']") WebElement email_loc;
	@FindBy (xpath="//input[@name='telephone']") WebElement telephone_loc;
	@FindBy (xpath="//input[@name='password']") WebElement password_loc;
	@FindBy (xpath="//input[@name='confirm']") WebElement confirm_pass_loc;
	@FindBy (xpath="//input[@name='agree']") WebElement tickbox_loc;
	@FindBy (xpath="//input[@value='Continue']") WebElement continue_btn;
	@FindBy (xpath="//div[@class='col-sm-9']//h1") WebElement msgconfirmation;
	
	public void set_firstname(String name)
	{
		firstname_loc.sendKeys(name);
	}
	
	public void set_lastname(String lastname)
	{
		lastname_loc.sendKeys(lastname);
	}
	
	public void set_email(String email)
	{
		email_loc.sendKeys(email);
	}
	
	public void set_telephone(String telephone)
	{
		telephone_loc.sendKeys(telephone);
	}
	
	public void set_password(String password) {
		password_loc.sendKeys(password);
	}
	
	public void set_confirm_password(String confirm_pass)
	{
		confirm_pass_loc.sendKeys(confirm_pass);
	}
	
	public void tick_tickbox()
	{
		tickbox_loc.click();
	}
	
	public void click_continue()
	{
		continue_btn.click();
	}
	
	public String get_confirmation_message()
	{
		try
		{
			return msgconfirmation.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
}
