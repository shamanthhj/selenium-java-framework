package Base;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public String appURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public String browser = "chrome";
	
	@BeforeMethod
	public void setup() {
		if (browser.equalsIgnoreCase("chrome"))
		{
			/*WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();*/
			WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            
            options.addArguments("--headless=new"); 
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            options.setBinary("/usr/bin/chromium-browser"); 

            driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(appURL);
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver != null)
			driver.quit();
	}

}
