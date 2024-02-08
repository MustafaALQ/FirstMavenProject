package day9_windowHandles;

import java.time.Duration;
import java.util.Set;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlesDemo {

	public static void demoQAWindowHandlesDemo() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		driver.get("https://demoqa.com/browser-windows");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
		
		String mainWindowID = driver.getWindowHandle();
		System.out.println("Main window Id:" + mainWindowID);
		
		driver.findElement(By.id("tabButton")).click();
		
		//switch to the second window 
		// in order to switch to new window, we have to know the id of the new window
		//by using getWinfowHandles, driver gets all the available window ids in the current browser instace
		Set<String> windowIDs =driver.getWindowHandles();
		
		Iterator<String> iterates = windowIDs.iterator();
		//at this stage, Iterator has the items inside the set object.
		//
		String firstWindowID = iterates.next();   //iterator goes to the first item in the iteration
		// at this stage, iterator is at the first item.
		
		String secondWindowId = iterates.next();
		
		driver.switchTo().window(secondWindowId);
		
		// and verify there is a text as "This is a sample page"
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
		if(driver.findElement(By.id("sampleHeading")).getText().equals("This is a sample page")){
			System.out.println("Second window text Matches. Pass");
		}
		
		//close the second window
		driver.close();
		
		//at this point, where is the driver focus?
		// at this point, driver focus is on the second window
		// we have to switch back if we wanna to interact with the other window window items.
		driver.switchTo().window(mainWindowID);
		System.out.println(driver.findElement(By.id("tabButton")).getText());
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public static void main(String [] args)	{
		demoQAWindowHandlesDemo();
		
	}
}
