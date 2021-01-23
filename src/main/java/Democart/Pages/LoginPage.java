package Democart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Democart_Util.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	
	private By Email_id = By.id("input-email");
	private By Password = By.id("input-password");
	private By LoginBtn = By.cssSelector("input[value='Login']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleutil = new  ElementUtil(driver);
	}
	
	public Accountpage DoLogin(String un, String pwd) {
		System.out.println("login with Usrename:"+un+"Password:"+pwd);
		eleutil.doSendKeys(Email_id, un);
		eleutil.doSendKeys(Password, pwd);
		eleutil.doClick(LoginBtn);
		return new Accountpage(driver);
		
	}

}
