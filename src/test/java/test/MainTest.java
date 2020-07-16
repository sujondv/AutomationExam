package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.MainPage;
import util.BrowserFactory;

public class MainTest {

	WebDriver driver;
	
	

	@Test (priority=1)
	public void checkToggleAllCheckBox() throws Exception {
		driver = BrowserFactory.launchBrowser();
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		Thread.sleep(3000);
		mainPage.clickOnToggleAll();
		Assert.assertTrue(mainPage.isNissanSelected());
		Assert.assertTrue(mainPage.isHondaSelected());
		mainPage.tearDown();
		}
	
	@Test (priority=2)
	public void checkAddCatagory() throws Exception {
		driver = BrowserFactory.launchBrowser();
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		Thread.sleep(3000);
		mainPage.addCatagory();
		Thread.sleep(3000);
		mainPage.validateAddCatagory();
		mainPage.tearDown();
	}
	
	@Test (priority=3)
	public void checkRemoveButton() throws Exception {
		driver = BrowserFactory.launchBrowser();
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.clickOnZeroCheckBox();
		mainPage.clickOnRemoveButton();
		Thread.sleep(3000);
		Assert.assertFalse(mainPage.isToyotaDisplayed());
		mainPage.tearDown();
		}
	
	@Test (priority=4)
	public void checkMonthDropDown() throws Exception {
		driver = BrowserFactory.launchBrowser();
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.validateDropDownList();
		mainPage.tearDown();
		}
	
	
}
