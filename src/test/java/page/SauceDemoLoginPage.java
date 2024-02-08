package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class SauceDemoLoginPage {

	// how do we create a page class
	
	// 1. we need a class for a page of the application
	// 2. we need to create a constructor with page factory of selenium
	// then collect the WebElements
	
	public SauceDemoLoginPage()	{
		PageFactory.initElements(Driver.getDriver(), this);
	}
	// what this line telling is: hey pageFactory, initialize all the elments in this class with driver instance
	// whenever an object of this class is created.
	
	
	// how do we collect WebElements
	
	 @FindBy ( id = "user-name")
	 public WebElement loginUserName;
	 
	 @FindBy (id = "password")
	 public WebElement loginPassword;
	 
	 @FindBy (id = "login-button")
	 public WebElement loginButton;
	
	 @FindBy(css = "h3[data-test='error']")
	 public WebElement loginEmptyError;
}
