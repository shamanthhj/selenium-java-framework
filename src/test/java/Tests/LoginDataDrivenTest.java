package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;
import Utils.ExcelUtil;

public class LoginDataDrivenTest extends BaseClass {
	@DataProvider(name = "loginData")
	public Object[][] loginData(){
		String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
		return ExcelUtil.getTestData(path, "Login");
	}
	
	@Test(dataProvider = "loginData")
	public void testLoginWithMultipleUsers(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		if(username.equals("Admin") && password.equals("admin123")) {
			Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed with valid credentials");
		} else {
			String errorMsg = loginPage.getInvalidLoginMessage();
			Assert.assertEquals(errorMsg, "Invalid credentials", "Expected error for invalid credentials");
		}
	}

}
