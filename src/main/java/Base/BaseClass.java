package Base;


import java.io.BufferedReader;
import java.io.InputStreamReader;
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
			try {
				if (browser.equalsIgnoreCase("chrome")) {
					// Get current Chromium version
					Process process = Runtime.getRuntime().exec("chromium-browser --version");
					BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
					String versionOutput = reader.readLine();
					String version = versionOutput.replaceAll("[^0-9.]", "").split("\\.")[0];
					System.out.println("Detected Chromium version: " + version);

					// Setup compatible ChromeDriver
					WebDriverManager.chromedriver().browserVersion(version).setup();

					// Headless & secure options for Jenkins
					ChromeOptions options = new ChromeOptions();
					options.setBinary("/usr/bin/chromium-browser");
					options.addArguments("--headless"); //
					options.addArguments("--no-sandbox");
					options.addArguments("--disable-dev-shm-usage");
					options.addArguments("--disable-gpu");
					options.addArguments("--remote-debugging-port=9222"); // 

					driver = new ChromeDriver(options);
				} else if (browser.equalsIgnoreCase("edge")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}

				if (driver != null) {
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					driver.get(appURL);
				} else {
					System.err.println("WebDriver is null. Setup failed.");
				}
			} catch (Exception e) {
				System.err.println("Error setting up WebDriver: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver != null)
			driver.quit();
	}

}
