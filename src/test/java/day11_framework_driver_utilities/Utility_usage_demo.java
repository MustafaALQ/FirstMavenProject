package day11_framework_driver_utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtils;

public class Utility_usage_demo {

	
	
	
	
	
	public static void AlertUtilsDemo()	{
		BrowserUtils util = new BrowserUtils();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.id("alertButton")).click();
		util.alert_accept(driver);
		
		
	}
	
	
	public static void main(String[] args) {
		AlertUtilsDemo();
	}
}
