package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	private WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver= driver;
	}
	
	private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	
	public boolean isDashboardDisplayed() {
		return driver.findElement(dashboardHeader).isDisplayed();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

}
