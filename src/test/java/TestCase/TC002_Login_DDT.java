package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;

public class TC002_Login_DDT extends BaseCase{
	@Test(dataProvider="LoginData",dataProviderClass=DP.class)
	public void logintest(String email,String pass,String Status)
	{
		HomePage hp=new HomePage(driver);
		hp.click_my_account();
		hp.click_login();
		
		LoginPage lp=new LoginPage(driver);
		lp.enter_email(email);
		lp.enter_password(pass);
		lp.click_login();
		
		MyAccountPage mp=new MyAccountPage(driver);
		System.out.println(mp.msgconfirmation());
		boolean target_page=mp.get_title().equals("My Account");
		if(Status.equalsIgnoreCase("Valid"))
		{
			if(target_page==true)
			{
				mp.logout_btn();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(Status.equalsIgnoreCase("invalid"))
		{
			if(target_page==true)
			{
				mp.logout_btn();
				Assert.assertTrue(false);
			}
		}
	}
}