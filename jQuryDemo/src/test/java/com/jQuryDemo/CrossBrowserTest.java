package com.jQuryDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	public WebDriver driver;
	@Test
	@Parameters("browser")
	public void verifyPageTitle(String browserName){
		
		if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")){
			driver = new SafariDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			driver = new ChromeDriver();
		}
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/");
		System.out.println(browserName + " : " + driver.getTitle());
		driver.quit();
		
	}

}
