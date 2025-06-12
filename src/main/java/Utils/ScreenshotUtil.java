package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.BaseClass;

public class ScreenshotUtil {
	public static String captureScreenshot(String testName) {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/reports/screenshots/" + testName + ".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return destination;
	}

}
