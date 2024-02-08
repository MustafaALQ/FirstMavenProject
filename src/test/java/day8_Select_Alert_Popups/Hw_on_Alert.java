package day8_Select_Alert_Popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hw_on_Alert {

	
	public static void Hw_3() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//go to https://demoqa.com/alerts 
		driver.get("https://demoqa.com/alerts");
		
		//Click on the third 'Click me' button and get the text of it
		driver.findElement(By.id("confirmButton")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		//verify if the text equals to "Do you confirm action?"
		
		String verifyText= "Do you confirm action?";
		
		
		if(alert.getText().equals(verifyText)) {
			System.out.println("PASS: Confirm Action text is matching");
			alert.dismiss();
		} else {
			System.out.println("FAIL: Confirm Action text is not matching");
		}
		
		
		WebElement actualConfirmSuit = driver.findElement(By.id("confirmResult"));
		
		String expectedConfirmSuit= "You selected Cancel";
		
		if(expectedConfirmSuit.equals(actualConfirmSuit.getText()))	{
			System.out.println("PASS: text matches the You selected Cancel");
		}else {
			System.out.println("FAIL: doesn't match the You selected Cancel");
		}
		
			
	}
	
	public static void Hw_4() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.id("promtButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("PrimeTech");
		alert.accept();
		
		String expectedPromptResult = "You entered PrimeTech";
		WebElement actualPromptResult = driver.findElement(By.id("promptResult"));
		System.out.println(actualPromptResult.getText());
		if(expectedPromptResult.equals(actualPromptResult.getText())) {
			System.out.println("PASS: text does match for PrimeTech");
		}else {
			System.out.println("FALSE: text does not match for PrimeTech");
		}
		
	}
	
	
	
	
	public static void main(String[] args)	{
		Hw_3();
		Hw_4();
		
	}
	
}
