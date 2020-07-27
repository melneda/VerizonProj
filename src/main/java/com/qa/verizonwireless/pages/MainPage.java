package com.qa.verizonwireless.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.verizonwireless.base.BasePage;
import com.qa.verizonwireless.util.ElementUtil;
import com.qa.verizonwireless.util.Constants;

public class MainPage  extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	// locators
	
	//By phones= By.xpath("//li[@id='secondLevel0']");
	//By phones=By.xpath("//button[text()='Phones list']");
	By phones=By.xpath("//button[contains(text(),'Phones list')]");

//	By phones = By.xpath("//*[@id='secondLevel0']/child::span");
	By smartphones = By.xpath("//*[contains(text(),'Smartphones') "
			+ "and @id='thirdLevel00']");
	//By smartphones=By.xpath("//a[@id='thirdLevel00']");
	
	//Constructors
	public MainPage(WebDriver driver) {
		   this.driver=driver;
		   elementUtil=new ElementUtil(driver);
		
	}
	
// Page title
	public String getPageTitle() {
	//return  elementUtil.doGetPageTitle();
    return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
  //   return driver.getTitle();
	}	 
	   
	public SmartPhonePage phoneToClick( ) throws InterruptedException {// buna bak baglanti
		WebDriverWait wait= new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phones));
	     elementUtil.moveToElement(phones);
	     elementUtil.doClick(smartphones);
		return new SmartPhonePage(driver);
	
	}
}	

	


