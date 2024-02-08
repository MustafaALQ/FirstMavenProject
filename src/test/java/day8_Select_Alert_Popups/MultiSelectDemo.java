package day8_Select_Alert_Popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiSelectDemo {

	public static void deselectDemo() {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://demoqa.com/select-menu");
	}

	public static void selectMultiDeselectDemo() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://demoqa.com/select-menu");

		WebElement mulltiCarSelect = driver.findElement(By.id("cars"));

		Select select = new Select(mulltiCarSelect);
		select.selectByVisibleText("Audi");
		select.selectByVisibleText("Saab");
		Thread.sleep(2000);

		select.deselectByVisibleText("Audi");
	}

	public static void ebDriverWaitDemo() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		driver.get("https://ebay.com");

		driver.findElement(By.linkText("Motors")).click();

		WebDriverWait letsWait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement addVehicleLink = driver.findElement(By.xpath("//div[text()='Add a vehicle']"));
		letsWait.until(ExpectedConditions.visibilityOf(addVehicleLink));

		System.out.println("system is visible");
	}
	
	public static void alertDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.xpath("//button[@id=\"timerAlertButton\"]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println("alert text is: "+ alert.getText());
		alert.dismiss();
		
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		alertDemo();
	}
}
