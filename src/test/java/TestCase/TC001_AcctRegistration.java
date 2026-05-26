package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.Registration_Page;

public class TC001_AcctRegistration extends BaseCase{
	
	@Test
	public void acct_registration()
	{
		HomePage hp=new HomePage(driver);
		hp.click_my_account();
		hp.click_register();
		
		Registration_Page rp=new Registration_Page(driver);
		rp.set_firstname(randomstring());
		rp.set_lastname(randomstring());
		rp.set_email(alphanumericstring()+"@gmail.com");
		rp.set_telephone(randomnumber());
		String password=alphanumericstring();
		rp.set_password(password);
		rp.set_confirm_password(password);
		rp.tick_tickbox();
		rp.click_continue();
		
		Assert.assertEquals(rp.get_confirmation_message(), "Your Account Has Been Created!");
	}
	
}
