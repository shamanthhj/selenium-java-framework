package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.DashboardPage;
import Pages.LoginPage;

public class DashboardTest extends BaseClass {
	
	@Test(groups = {"smoke", "regression"})
	public void verifyDashboardVisbleAfterLogin() {
		System.out.println("Driver in DashboardTest: " + driver);
		Assert.assertNotNull(driver, "Driver is null!");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("Admin", "admin123");
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "DashBoard is not visible after login.");
	}

}
