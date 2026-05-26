package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (xpath="/html/head/title") WebElement title_loc;
	@FindBy (xpath="//*[@id=\"column-right\"]/div/a[13]") WebElement logout_loc;
	
	public void logout_btn()
	{
		logout_loc.click();
	}
	
	public String  msgconfirmation()
	{
		return title_loc.getText();
	}

	public String get_title()
	{
		return driver.getTitle();
	}

}
