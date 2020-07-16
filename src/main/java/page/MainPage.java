package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MainPage {

	WebDriver driver;

	public MainPage(WebDriver driver) {

		this.driver = driver;
	}

	// Elements Library

	@FindBy(how = How.XPATH, using = "//input[@name='allbox']")
	WebElement TOGGLE_ALL_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@name='todo[0]']")
	WebElement ZERO_CHECKBOX_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@name='todo[1]']")
	WebElement ONE_CHECKBOX_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@name='todo[2]']")
	WebElement TWO_CHECKBOX_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@value='Remove']")
	WebElement REMOVE_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@name='categorydata']")
	WebElement ADD_CATAGORY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@value='Add category']")
	WebElement ADD_CATAGORY_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//span[text()='dev']")
	WebElement DEV_LOCATOR;
	@FindBy(how = How.XPATH, using = "//select[@name='due_month']")
	WebElement MONTH_DROPDOWN_LOCATOR;
	
	String actualName = "dev";
	String expectedName = DEV_LOCATOR.getText();
	
	// Methods to interact with Elements

	public void clickOnToggleAll() {

		TOGGLE_ALL_LOCATOR.click();
	}
	public void clickOnZeroCheckBox() {

		ZERO_CHECKBOX_LOCATOR.click();
	}
	public void clickOnRemoveButton() {

		REMOVE_BUTTON_LOCATOR.click();
	}

	public boolean isNissanSelected() {
		return ONE_CHECKBOX_LOCATOR.isSelected(); 
		
	}

	public boolean isHondaSelected() {
		return TWO_CHECKBOX_LOCATOR.isSelected();
		
	}
	public boolean isToyotaDisplayed() {
		return ZERO_CHECKBOX_LOCATOR.isDisplayed();
		
	}
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	public void addCatagory() {
		ADD_CATAGORY_FIELD_LOCATOR.sendKeys(actualName);
		ADD_CATAGORY_BUTTON_LOCATOR.click();
	}
	public void validateAddCatagory() {
		Assert.assertEquals(actualName, expectedName, "Did not match !!!");
	}
	public void validateDropDownList() {

		String[] values = { "None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Select select = new Select(MONTH_DROPDOWN_LOCATOR);
		List<WebElement> dropdownvalues = select.getOptions();
		System.out.println("DropDownList Size: " + dropdownvalues.size());
		for (int i = 0; i < dropdownvalues.size(); i++) {
			Assert.assertEquals(values[i], dropdownvalues.get(i).getText(), "DropDownList validation failed !!!");
		}
		System.out.println("DropDownList Validation Successful");
	}

}
