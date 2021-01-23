package Democar_Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Democart_BaseTest.BaseTest;

public class AccountpageTeast extends BaseTest {
	
	@BeforeClass
	public void importLoginpageToEnterInto() {
		accpage=logpage.DoLogin(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test
	public void LogoutFromAccountsPage() {
		accpage.dologout();
	}
	
	

}
