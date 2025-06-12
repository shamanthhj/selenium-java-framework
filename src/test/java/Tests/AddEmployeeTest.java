package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.AddEmployeePage;
import Pages.DashboardPage;
import Pages.LoginPage;

public class AddEmployeeTest extends BaseClass {
	
	@Test(groups = {"smoke"})
	public void addEmployeeSuccessfully() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("Admin", "admin123");
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Login failed or dashboard not visible.");
		
		AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
		addEmployeePage.addNewEmployee("Ghost", "Rider");
	}

}
