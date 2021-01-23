package Democart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Democart_Util.ElementUtil;

public class Accountpage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	
	private By logout = By.linkText("Logout");
	
	public Accountpage(WebDriver driver) {
	   this.driver=driver;
	   eleutil = new ElementUtil(driver);
	}
	
	public void dologout() {
		eleutil.doClick(logout);
	}
}
