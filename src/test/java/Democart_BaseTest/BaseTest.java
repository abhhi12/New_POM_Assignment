package Democart_BaseTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Democart.Pages.Accountpage;
import Democart.Pages.LoginPage;
import Democart_DriverFactory.DriverFactory;

public class BaseTest {
	WebDriver driver;
	DriverFactory df;
	public Properties prop;
	public LoginPage logpage;
	public Accountpage accpage;
	
	@BeforeTest
	public void SetUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver=df.init_driver(prop);
		driver.get(prop.getProperty("url"));
		logpage = new LoginPage(driver);
		accpage = new Accountpage(driver);
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();

 }
}
