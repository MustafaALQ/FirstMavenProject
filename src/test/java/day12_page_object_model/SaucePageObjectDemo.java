package day12_page_object_model;


import page.SauceDemoLoginPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class SaucePageObjectDemo {

	public static void main(String[] args) throws InterruptedException {
		sauceLoginDemo();
		
	}
	
	
	
	public static void sauceLoginDemo() throws InterruptedException {
		// go to website 
		// type username
		// click sigin
		SauceDemoLoginPage loginPage = new SauceDemoLoginPage();
		
		BrowserUtils utils = new BrowserUtils();
		
		//go to website
		Driver.getDriver().get(DataReader.getProperty("sauce_url"));
		
		utils.waitForElementToBeVisible(loginPage.loginUserName);
		utils.highlightElement(loginPage.loginUserName);
		loginPage.loginUserName.sendKeys(DataReader.getProperty("sauce_username"));
		loginPage.loginPassword.sendKeys(DataReader.getProperty("sauce_password"));
		loginPage.loginButton.click();
	}
	
	
}
