package TestCase;
import org.testng.annotations.DataProvider;

public class DP {
	@DataProvider(name="LoginData")
	public Object[][] LoginData(){
		return new Object[][] {
			{"asdfzxc@gmail.com","vdwq","Valid"},
			{"vaishnavi@gmail.com","asdfg","Invalid"},
			{"zxcvb@gmail.com","sdfgh","Invalid"},
			{"laksh@yahoo.com","Lakshmi","invalid"},
			{"laks@yahoo.com","xyz","invalid"}
		};
	}
}
