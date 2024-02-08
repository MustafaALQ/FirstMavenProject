package day10_ActionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDemo {

	public static void actionsHoverClass()	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/menu");
		
		//mouse hover over to the menu item 2
		Actions act = new Actions(driver);
		WebElement menuItem2 = driver.findElement(By.linkText("Main Item 2"));
		act.moveToElement(menuItem2).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SUB SUB LIST »")));
		WebElement subSubList = driver.findElement(By.linkText("SUB SUB LIST »"));
		act.moveToElement(subSubList).build().perform();
		
		// then hover over the sub sub item 1
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sub Sub Item 1")));
		WebElement subSubList1 = driver.findElement(By.linkText("Sub Sub Item 1"));
		act.moveToElement(subSubList1).build().perform();
		
	}
	
	public static void dragAndDrop() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/droppable");
		
		Actions act = new Actions(driver);
		WebElement dragMeBox = driver.findElement(By.id("draggable"));
		WebElement dropHereBox = driver.findElement(By.id("droppable"));
		
		act.dragAndDrop(dragMeBox, dropHereBox).build().perform();
	}
	
	
	
	
	public static void main(String[] args) {
		dragAndDrop();
	}
}
