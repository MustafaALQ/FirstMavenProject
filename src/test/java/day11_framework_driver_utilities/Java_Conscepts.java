package day11_framework_driver_utilities;

import org.openqa.selenium.WebElement;

public class Java_Conscepts {

	public static String concatString(String a, String b) {
		
		return a.concat(b);
	}
	
	public void clickBtn(WebElement btn)	{
		btn.click();
	}
	
	public void printBoth(WebElement element, String input)	{
		 
		element.sendKeys(input);
	}
	
	public String webElementString(WebElement element) {
		
		return element.getText();
	}
	
	public static void main(String[] args) {
		System.out.println(concatString("Mustafa" , "Omar " ));
	}
}
