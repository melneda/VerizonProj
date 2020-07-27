package com.qa.verizonwireless.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.verizonwireless.base.BasePage;
import com.qa.verizonwireless.util.Constants;
import com.qa.verizonwireless.util.ElementUtil;

public class FinalPage  extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	// Constructor
      
	   public FinalPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//Locators
	By text= By.xpath("//span[text()='Galaxy S20 5G UW']");
	By chartloc=By.xpath("//a[@class='cart-icon ']");
	//By chartloc=By.xpath("//button[@aria-label='Shopping Cart']");
	//By chartloc=By.xpath("//div[@class='gnav20-row-two']//button[@class='gnav20-cart']");
	//By chartloc=By.xpath("//a[contains(@class,‘cart-icon’)]//*[local-name()=‘svg’]");
	//By chartloc=By.xpath("//button[@class='gnav20-cart']/preceding::div[@class='gnav20-unifiedcart']");
	By chartname=By.xpath("//span[text()='Galaxy S20 5G UW']");
	
	
	//Title
	public String finalPageTitle() {
   return elementUtil.doGetPageTitle();
   //return elementUtil.waitForGetPageTitle(Constants.FINAL_PAGE_TITLE);

	}
	
	
	//Gettext
	public String phoneTextName() {
	//WebDriverWait wait= new WebDriverWait(driver,5);
	//wait.until(ExpectedConditions.textToBePresentInElementLocated(text, "Samsung Galaxy S20 5G UW"));
		return elementUtil.doGetText(text);
	}	

	
	
	public String  SelectedPhoneOnChartt() {
	//	elementUtil.waitForElementClicable(chartloc);
		driver.findElement(chartloc).click();
		return driver.findElement(chartname).getText();  
				
		

	}
		 }
	
	
	
	
	



