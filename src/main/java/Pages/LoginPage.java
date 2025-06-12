package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	private By usernameField = By.name("username");
	private By passwordField = By.name("password");
	private By loginButton = By.cssSelector("button[type='submit']");
	private By invalidMsg = By.xpath("//p[text()='Invalid credentials']");
	
	public void enterUsername(String username)
	{
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLogin() 
	{
		driver.findElement(loginButton).click();
	}
	
	public String getInvalidLoginMessage()
	{
		WebElement msg = driver.findElement(invalidMsg);
		return msg.getText();
	}
	
	public void login(String username, String password)
	{
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

}
