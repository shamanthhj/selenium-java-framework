package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {
	private WebDriver driver;
	
	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By pimMenu = By.xpath("//span[text()='PIM']");
	private By addButton = By.xpath("//button[text()=' Add ']");
	private By firstName = By.name("firstName");
	private By lastName = By.name("lastName");
	private By saveButton = By.xpath("//button[@type='submit']");
	
	public void navigateToAddEmployee() {
		driver.findElement(pimMenu).click();
		driver.findElement(addButton).click();
	}
	
	public void enterEmployeeDetails(String fname, String lname) {
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
	}
	
	public void clickSave() {
		driver.findElement(saveButton).click();
	}
	
	public void addNewEmployee(String fname, String lname) {
		navigateToAddEmployee();
		enterEmployeeDetails(fname, lname);
		clickSave();
	}
}
