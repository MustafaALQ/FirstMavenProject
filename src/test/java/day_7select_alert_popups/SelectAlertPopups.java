package day_7select_alert_popups;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectAlertPopups {

	public static void selectDemo() throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/select-menu");

		WebElement colors = driver.findElement(By.id("oldSelectMenu"));
		Select letsSelect = new Select(colors);
		WebElement firstSelectedColor = letsSelect.getFirstSelectedOption();
		System.out.println("First Dropdown text color: " + firstSelectedColor.getText());

		List<WebElement> allColors = letsSelect.getOptions();
		System.out.println("Number of available colors is: " + allColors.size());
		
		for(WebElement color : allColors)	{
			System.out.println("Color is: " + color.getText());
		}
	}
	
	
	public static void countryDrpDwn()	{
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		
		WebElement countryDrpDwn= driver.findElement(By.xpath("(//div[@class=\"ui fluid search selection dropdown\"])[1]"));
		
		
		
	}
	
	
	public static void noSuchElementException() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		
		WebElement countryDrpDwn= driver.findElement(By.xpath("(//div[class=\"ui fluid search selection dropdown\"])[1]"));

		System.out.println(countryDrpDwn.getText());
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		noSuchElementException();
	}
	
}
