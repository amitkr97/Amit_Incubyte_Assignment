package Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//import reportingAndLogging.EReporter;

public class HelperClass {

	private static HelperClass helperClass;
	private static WebDriver driver;
	private static Properties properties;

	private final static int pageLoadTimeout = 60;
	private final static int implicitTimeout = 10;

	private static JavascriptExecutor js;

	private static WebDriverManager webDriverManager = null;

	private HelperClass() {

	}

	public static WebDriver getDriver() {

		return driver;
	}

	public static String getProperties(String value) {
		return properties.getProperty(value);
	}

	public static WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

//	public static void initialization(String browser) {
//		try {
//			if(browser.trim().equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().setup();
//		        driver = new ChromeDriver();
//			}else if(browser.trim().equalsIgnoreCase("firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//		        driver = new FirefoxDriver();
//			}
//		}
//	}

}
