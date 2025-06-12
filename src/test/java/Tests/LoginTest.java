package Tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test(priority=1, groups={"regression"})
	public void validLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("Admin", "admin123");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("dashboard"), "Login failed - Dashboard not reached.");
		
	}
	
	@Test(priority=2, groups={"smoke"})
	public void invalidLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("Admin", "Wrong");
		String errorMsg = loginPage.getInvalidLoginMessage();
		Assert.assertEquals(errorMsg, "Invalid credentials", "Incorrect error message displayed.");

	}
	
	@Test(priority=3)
	public void emptyLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("", "");
		String errorMsg = loginPage.getInvalidLoginMessage();
		Assert.assertEquals(errorMsg, "This should fail", "Intentional failure to trigger screenshot and report.");
	}

}
