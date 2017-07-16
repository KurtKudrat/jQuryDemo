package com.jQuryDemo;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Tests {
	public WebDriver driver;
	final static Logger logger = Logger.getLogger(Tests.class);
	JqueryStartSetUp jQuery = new JqueryStartSetUp();

	@Test(enabled = false)
	public void draggableTest() throws Exception {
		driver = jQuery.setDriver();
		logger.info("Opening page selecting the sidebar section Draggable........");
		// jQuery.selectFromSideBar("Interactions", "Draggable");
		jQuery.selectFromSidebar("Draggable");
		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		Actions act = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		// act.dragAndDropBy(drag, 200, 192).perform();
		act.clickAndHold(drag).moveByOffset(200, 100).perform();

		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	@Test(enabled = false)
	public void droppable() throws InterruptedException {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Droppable");
		logger.info("Opening page selecting the sidebar section Droppable........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).perform();

		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	// not working
	@Test(enabled = false)
	public void resizable() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Resizable");
		logger.info("Opening page selecting the sidebar section Resizable........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		WebElement clickPoint = driver.findElement(
				By.cssSelector(".ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"));

		Actions act = new Actions(driver);
		act.clickAndHold(clickPoint);
		Thread.sleep(3000);
		act.moveByOffset(300, 300).release().build().perform();

		Thread.sleep(10000);
		driver.close();
		driver.quit();
	}

	@Test(enabled = false)
	public void selectable() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Selectable");
		logger.info("Opening page selecting the sidebar section Selectable........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		Actions act = new Actions(driver);
		WebElement itemList = driver.findElement(By.id("selectable"));
		List<WebElement> items = itemList.findElements(By.tagName("li"));
		act.keyDown(Keys.COMMAND).click(items.get(0)).click(items.get(2)).click(items.get(4)).click(items.get(6))
				.build().perform();

		Thread.sleep(10000);
		driver.close();
		driver.quit();

	}

	// not working
	@Test(enabled = false)
	public void sortable() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Sortable");
		logger.info("Opening page selecting the sidebar section Sortable........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		WebElement sortList = driver.findElement(By.id("sortable"));
		List<WebElement> listItems = sortList.findElements(By.tagName("li"));

		Actions act = new Actions(driver);
		// act.dragAndDrop(listItems.get(0),
		// listItems.get(5)).build().perform();
		act.clickAndHold(listItems.get(0)).moveByOffset(0, 87).release().build().perform();

		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	@Test(enabled = false)
	public void accordion() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Accordion");
		logger.info("Opening page selecting the sidebar section accordion........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		WebElement accordion = driver.findElement(By.id("accordion"));
		List<WebElement> accordionHeaders = accordion.findElements(By.tagName("h3"));
		for (WebElement temp : accordionHeaders) {
			String className = temp.getAttribute("class");
			if (!className.contains("active")) {
				temp.click();
			}
		}
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	@Test(enabled = false)
	public void autocomplete() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Autocomplete");
		logger.info("Opening page selecting the sidebar section autocomplete........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		WebElement input = driver.findElement(By.id("tags"));
		input.sendKeys("a");
		Thread.sleep(2000);
		WebElement list = driver.findElement(By.id("ui-id-1"));
		List<WebElement> lists = list.findElements(By.tagName("li"));
		lists.get(0).click();

		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	@Test(enabled = false)
	public void button() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Button");
		logger.info("Opening page selecting the sidebar section autocomplete........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("/html/body/div/button")).click();
		driver.findElement(By.xpath("/html/body/div/input")).click();
		driver.findElement(By.xpath("/html/body/div/a")).click();
		driver.findElement(By.xpath("/html/body/button")).click();
		driver.findElement(By.xpath("/html/body/input")).click();
		driver.findElement(By.xpath("/html/body/a")).click();

		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

	@Test(enabled = false)
	public void checkboxradio() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Checkboxradio");
		logger.info("Opening page selecting the sidebar section checkboxradio........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		List<WebElement> fieldsets = driver.findElements(By.tagName("fieldset"));
		List<WebElement> radios = fieldsets.get(0).findElements(By.tagName("label"));
		for (WebElement temp : radios) {
			if (!temp.getAttribute("class").contains("active")) {
				temp.click();
			}
		}

		List<WebElement> radios2 = fieldsets.get(1).findElements(By.tagName("label"));
		for (WebElement temp : radios2) {
			if (!temp.getAttribute("class").contains("active")) {
				temp.click();
			}
		}

		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	@Test(enabled = false)
	public void controlgroup() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Controlgroup");
		logger.info("Opening page selecting the sidebar section controlgroup........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		List<WebElement> fieldsets = driver.findElements(By.tagName("fieldset"));
		List<WebElement> div = fieldsets.get(0).findElements(By.tagName("div"));
		WebElement carTypeDropDown = div.get(0).findElement(By.id("car-type-button"));
		carTypeDropDown.click();

		Thread.sleep(1000);

		WebElement carTypeMenu = driver.findElement(By.id("car-type-menu"));
		List<WebElement> carTypeMenulists = carTypeMenu.findElements(By.tagName("li"));
		for (WebElement temp : carTypeMenulists) {
			if (temp.getText().contains("Luxury")) {
				temp.click();
			}
		}

		div.get(0).findElement(By.xpath("//div/label[2]")).click();
		div.get(0).findElement(By.xpath("//div/label[3]")).click();
		div.get(0).findElement(By.id("horizontal-spinner")).sendKeys("3");
		div.get(0).findElement(By.tagName("button")).click();

		// rent a car section 2

		List<WebElement> div2 = fieldsets.get(1).findElements(By.tagName("div"));

		WebElement carTypeDropDown2 = div2.get(0).findElement(By.id("ui-id-8-button"));
		carTypeDropDown2.click();
		WebElement carTypeMenu2 = driver.findElement(By.id("ui-id-8-menu"));
		List<WebElement> carTypeMenulists2 = carTypeMenu2.findElements(By.tagName("li"));
		for (WebElement temp : carTypeMenulists2) {
			if (temp.getText().contains("SUV")) {
				temp.click();
			}
		}

		Thread.sleep(1000);
		div2.get(0)
				.findElement(By.cssSelector(
						".ui-button.ui-widget.ui-checkboxradio-radio-label.ui-checkboxradio-label.ui-controlgroup-item"))
				.click();
		div2.get(0).findElement(By.cssSelector(".ui-button.ui-widget.ui-checkboxradio-label.ui-controlgroup-item"))
				.click();
		div2.get(0).findElement(By.id("vertical-spinner")).sendKeys("3");
		div2.get(0).findElement(By.id("book")).click();

		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	@Test(enabled = false)
	public void datepicker() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Datepicker");
		logger.info("Opening page selecting the sidebar section Datepicker........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.id("datepicker")).click();

		WebElement calender = driver.findElement(By.id("ui-datepicker-div"));
		WebElement table = calender.findElement(By.tagName("tbody"));
		List<WebElement> tds = table.findElements(By.tagName("td"));
		for (WebElement temp : tds) {
			if (temp.getText().contains("28")) {
				temp.click();

				Thread.sleep(5000);
				driver.close();
				driver.quit();
			}
		}
	}

	@Test(enabled = false)
	public void dialog() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Dialog");
		logger.info("Opening page selecting the sidebar section Dialog........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		driver.findElement(
				By.cssSelector(".ui-button.ui-corner-all.ui-widget.ui-button-icon-only.ui-dialog-titlebar-close"))
				.click();

		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

	@Test(enabled = false)
	public void menu() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Menu");
		logger.info("Opening page selecting the sidebar section Menu........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		Actions act = new Actions(driver);
		WebElement menu = driver.findElement(By.id("menu"));
		List<WebElement> menuContens = menu.findElements(By.tagName("li"));
		for (WebElement temp : menuContens) {
			if (temp.getText().contains("Music")) {
				act.moveToElement(temp).build().perform();
				Thread.sleep(1000);
				WebElement subMenu = temp.findElement(By.tagName("ul"));
				if (subMenu.getAttribute("aria-expanded").contains("true")) {
					List<WebElement> subMenuContens = subMenu.findElements(By.tagName("li"));
					for (WebElement content : subMenuContens) {
						if (content.getText().contains("Rock")) {
							act.moveToElement(content).build().perform();
							Thread.sleep(1000);
							WebElement subMenu2 = content.findElement(By.tagName("ul"));
							if (subMenu.getAttribute("aria-expanded").contains("true")) {
								List<WebElement> subMenuContens2 = subMenu2.findElements(By.tagName("li"));
								for (WebElement content2 : subMenuContens2) {
									if (content2.getText().contains("Alternative")) {
										act.moveToElement(content2).build().perform();
										Thread.sleep(1000);
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	@Test(enabled = false)
	public void selectmenu() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Selectmenu");
		logger.info("Opening page selecting the sidebar section Selectmenu........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		/*
		 * WebElement fieldset = driver.findElement(By.tagName("fieldset"));
		 * List<WebElement> selects =
		 * fieldset.findElements(By.tagName("select")); for (WebElement temp :
		 * selects) { Select sc = new Select(temp); if
		 * (temp.getAttribute("name").contains("speed")) {
		 * 
		 * temp.click(); sc.selectByVisibleText("Slow"); } else if
		 * (temp.getAttribute("name").contains("speed")) { sc.selectByIndex(4);
		 * 
		 * } else if (temp.getAttribute("name").contains("files")) {
		 * sc.selectByIndex(4);
		 * 
		 * } else if (temp.getAttribute("name").contains("number")) {
		 * sc.selectByIndex(4);
		 * 
		 * } else if (temp.getAttribute("name").contains("salutation")) {
		 * sc.selectByIndex(4);
		 * 
		 * }
		 * 
		 * }
		 */
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

	@Test(enabled = false)
	public void slider() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Slider");
		logger.info("Opening page selecting the sidebar section Slider........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);

		WebElement sliderbtn = driver.findElement(By.cssSelector(".ui-slider-handle.ui-corner-all.ui-state-default"));
		Actions acs = new Actions(driver);
		acs.clickAndHold(sliderbtn).moveByOffset(270, 0).release().build().perform();
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

	@Test(enabled = false)
	public void Spinner() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Spinner");
		logger.info("Opening page selecting the sidebar section Spinner........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);
		
		WebElement selectUp = driver.findElement(By.xpath("/html/body/p[1]/span/a[1]"));
		int i = 0;
		while (i <5) {
			selectUp.click();
			i++;
		}
		
		driver.findElement(By.id("getvalue")).click();
		
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert(); 
		alert.dismiss();
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}
	
	@Test(enabled = false)
	public void tabs() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Tabs");
		logger.info("Opening page selecting the sidebar section Tabs........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);
		
		WebElement tablist = driver.findElement(By.xpath("//*[@id='tabs']/ul"));
		List<WebElement> lists = tablist.findElements(By.tagName("li"));
		for (WebElement temp:lists){
			if (! temp.getAttribute("class").contains("active")){
				temp.click();
			}
		}
		Thread.sleep(5000);
		driver.close();
		driver.quit();	
	}
	
	@Test(enabled = true)
	public void tooltip() throws Exception {
		driver = jQuery.setDriver();
		jQuery.selectFromSidebar("Tooltip");
		logger.info("Opening page selecting the sidebar section Tooltip........");

		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);
		
		WebElement toolTip = driver.findElement(By.xpath("/html/body/p[1]/a"));
		System.out.println("ToolTip text : "+ toolTip.getAttribute("title"));
		
		Actions act = new Actions(driver);
		act.moveToElement(toolTip);
		Thread.sleep(1000);

		Thread.sleep(5000);
		driver.close();
		driver.quit();	
	}
}
