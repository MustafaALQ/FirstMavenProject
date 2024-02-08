package day_7select_alert_popups;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDrpDwnHw {

	
	
	
	
	public static void dropDown() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://amazon.com");
		
		WebElement drop = driver.findElement(By.id("searchDropdownBox"));
		Select dropDown= new Select(drop);
	
		List <WebElement> dropDwnOption = dropDown.getOptions();
     	System.out.println(dropDwnOption.size());
     	
     	for(WebElement each: dropDwnOption)	{
     		System.out.println(each.getText());
     	}
	  	
     	if(dropDwnOption.size()==58)	{
     		System.out.println("TRUE: There are 58 options in the drop down");
     	} else {
     		System.out.println("FALSE: There are not 58 options in the drop down");
     	}
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
	dropDown();	
	}
	
}
