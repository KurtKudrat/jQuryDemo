package com.jQuryDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JqueryStartSetUp {
	private  WebDriver driver;

	public WebDriver setDriver() {
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		//driver = new ChromeDriver();
		
		
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		//cap.setCapability("jenkins.label","redhat5 && amd64");
		
		try {
			driver = new RemoteWebDriver
					(new URL("http://ec2-34-201-210-172.compute-1.amazonaws.com:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/");
		return driver;
		
		
		

	}
	
	
	
	public void selectFromSidebar(String selectionLink){
		List<WebElement> urls = driver.findElements(By.tagName("a"));
		for(WebElement temp:urls){
			if(temp.getText().contains(selectionLink)){
				temp.click();
				break;
			}
		}
	}
	

	/*public void selectFromSideBar(String sidebarSection, String interactionType) {
		
		WebElement sidebarElm = driver.findElement(By.id("sidebar"));
		List<WebElement> sidebarSections = sidebarElm.findElements(By.tagName("aside"));
		for (WebElement temp : sidebarSections) {
			WebElement sidebarHeader = temp.findElement(By.tagName("h3"));
			String sidebarHeaderStr = sidebarHeader.getText();
			System.out.println("side bar header : "+ sidebarHeader);
			if (sidebarHeaderStr.contains(sidebarSection)) {
				WebElement sidebarSelect = temp.findElement(By.tagName("ul"));
				List<WebElement> sidebarSelections = sidebarSelect.findElements(By.tagName("li"));
				for (WebElement select : sidebarSelections) {
					String selectionName = select.findElement(By.tagName("a")).getText();
					System.out.println("the sidebar contents " + selectionName);
					if (selectionName.contains(interactionType)) {
						select.click();
						break;

					}
				}
			}
		}
	}*/


}
