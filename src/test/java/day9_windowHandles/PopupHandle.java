package day9_windowHandles;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupHandle {

	public static void Hw_2Popup() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("http://demo.guru99.com/popup.php");

		// Get title and store it in a variable.
		String ActualParentWebTitle = driver.getTitle();
		System.out.println("Title is: " + ActualParentWebTitle);

		// Click on Click Here button and switch over to next window, provide an email
		// click Submit.
		driver.findElement(By.xpath("//a[contains(text(),\"Click\")]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("barone")));

		Set<String> windowHandles = driver.getWindowHandles();

		Iterator<String> iterator = windowHandles.iterator();
		String parentWindow = iterator.next();
		String secondWindow = iterator.next().toString();

		System.out.println("Parent window ID: " + parentWindow);
		System.out.println("Second window ID: " + secondWindow);
		driver.switchTo().window(secondWindow);

		driver.findElement(By.name("emailid")).sendKeys("mustafaalqaseer88@gmail.com" + Keys.ENTER);

		String userID = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText();
		String password = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]")).getText();
		System.out.println("User ID is :" + userID + " Password Is: " + password);

		String expectedText = "This access is valid only for 20 days";
		WebElement actualText = driver.findElement(By.xpath("//h3"));

		if (actualText.toString().equals(expectedText)) {
			System.out.println("PASS: Actual Text aligns with expected text");
		} else {
			System.out.println("FAIL: Actual Text does not align with expected text");
		}

		driver.close();

		driver.switchTo().window(parentWindow);

		if (driver.getTitle().equals(ActualParentWebTitle)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}
	
	public static void switchWindow()	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/browser-windows");
		String windowTitle = driver.getTitle();
		//Get the main window ID and store it in a String called mainWindowId, 
		String mainWindowID = driver.getWindowHandle();
		
		//click on the new tab button
		driver.findElement(By.id("tabButton")).click();
		
	
		
		//Get window IDs and store it into a Set
		Set<String> windowIDs =driver.getWindowHandles();	
		Iterator<String> iterate = windowIDs.iterator();
		String parentWindowID = iterate.next();
		if(parentWindowID.equals(mainWindowID)) {
			System.out.println("PASS: we are in the main window ");
		}else {
			System.out.println("FAIL: We are not in the same main window");
		}
		
		String secondWindowID = iterate.next();
		//Switch to the second window
		driver.switchTo().window(secondWindowID);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sampleHeading")));
		
		//Verify that there is a text called 'This is a sample page'
		String expectedlSamplePage = "This is a sample page";
		WebElement actualSamplePage = driver.findElement(By.id("sampleHeading"));
		if(actualSamplePage.getText().equals(expectedlSamplePage)) {
			System.out.println("PASS: Sample Page Text matches with the expected");
		} else {
			System.out.println("FAIL: sample page Text does not match with the expected");
		}
		driver.close();
		driver.switchTo().window(parentWindowID);
		if(windowTitle.equals(driver.getTitle())) {
			System.out.println("PASS: We are in the parent window");
		}else {
			System.out.println("FAIL: we are not in the parent window");
		}
		
		
	}
	
	public static void nestedIframe() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// go to https://demoqa.com/nestedframes
		
		driver.get("https://demoqa.com/nestedframes");
		// get the main content text
		String mainContent = driver.findElement(By.xpath("(//div[@id=\"framesWrapper\"])/div[1]")).getText();
		
		// switch to parent frame and get the text 
		driver.switchTo().frame("frame1");
		String parentFrameText = driver.findElement(By.xpath("//*[contains(text(),\"Parent\")]")).getText();
		System.out.println("Parent Frame Text: "+parentFrameText);
		// switch to child frame and get the text 
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc=\"<p>Child Iframe</p>\"]")));
		String childFrameText = driver.findElement(By.xpath("//*[contains(text(),\"Child Iframe\")]")).getText();
		System.out.println("Child Frame Text: "+childFrameText);
		// switch back to parent frame and get the text (print)
		driver.switchTo().parentFrame(); 
		String parentFrameText1 = driver.findElement(By.xpath("//*[contains(text(),\"Parent\")]")).getText();
		System.out.println("Parent Frame Text 2 : "+parentFrameText1);
		// driver goes back to parent frame.
		// vs 
		// switch to defalt content and get the text
		driver.switchTo().defaultContent(); 
		String mainContent1 = driver.findElement(By.xpath("(//div[@id=\"framesWrapper\"])/div[1]")).getText();
		System.out.println(mainContent1);
		// driver goes back to default frame
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
	     Hw_2Popup();
		
	}
}
