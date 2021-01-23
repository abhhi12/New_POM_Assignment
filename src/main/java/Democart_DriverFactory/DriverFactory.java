package Democart_DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop) {
		String browsername = prop.getProperty("browser");
		
		switch(browsername) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());
			break;
		 
		case "firefox":
			WebDriverManager.chromedriver().setup();
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
			break;
		 
		case "safari":
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
			break;
		
		default:
			System.out.println("Please Pass the correct Browser name" + browsername);
			break;
		}
		getDriver().manage().deleteAllCookies();
	    getDriver().manage().window().maximize();
		
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	public Properties init_prop() {
		Properties prop = null;//null because if properties not loaded then it will return null
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");//yaha path se copy karna hai 
			prop = new Properties();//yaha object creat karna hai Properties ka
			prop.load(ip);//or yaha load function se ip me jo v config.prop me se aya hai, yaha a jaye ga. or is try and catch clouse se surround karna hai
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
 }
	
	public String getScreenShot() {
		File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+ System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
	}
	
	
	
	
	
}
