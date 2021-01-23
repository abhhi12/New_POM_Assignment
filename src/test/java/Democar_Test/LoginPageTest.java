package Democar_Test;

import org.testng.annotations.Test;

import Democart_BaseTest.BaseTest;

public class LoginPageTest extends BaseTest {
	
	@Test
	public void doLoginTest() {
		logpage.DoLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

}
