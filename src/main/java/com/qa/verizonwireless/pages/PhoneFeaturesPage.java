package com.qa.verizonwireless.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.verizonwireless.base.BasePage;
import com.qa.verizonwireless.util.ElementUtil;

public class PhoneFeaturesPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;

	//Constractor
	public PhoneFeaturesPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	
	}		
	//Locators	
	By colors=By.xpath("//input[@aria-label='Cloud Pink color']");
	By gb=By.xpath("//p[text() ='128GB']");
	By price=By.xpath("//input[@id='pricingOption1']");
    //By delivery=By.xpath("//input[@aria-label='FREE Same Day Delivery']");
	By continuebtn=By.xpath("//button[@id='ATC-Btn']");
	By zipcode=By.id("zipcode");
    By confirmBtn=By.xpath("//button[contains(@class,'defaultPrimaryCTA')]");
  // By newcustomer=By.xpath("x//button[@aria-label='New Customer']");
   //  By newcustomer=By.xpath("//*[text()=‘New Customer’]");
    By newcustomer=By.xpath("// button[@aria-label='New Customer']");
    By nextbtn=By.xpath("//button[@aria-label='Next']");
	
	
	//Title
	
	public String getFeaturesPageTitle() {
       return elementUtil.doGetPageTitle();
      
	}       
		
	public FinalPage  clicksOnThePage() throws InterruptedException {
	Thread.sleep(3000);
	 elementUtil.doClick(colors);
	 elementUtil.doClick(gb);
	 elementUtil.doClick(price);
	 elementUtil.doClick(continuebtn);
	 elementUtil.doSendKeys(zipcode, "11234");
	 elementUtil.doClick(confirmBtn);
	 WebDriverWait wait = new WebDriverWait(driver, 5);
	 wait.until(ExpectedConditions.presenceOfElementLocated(newcustomer));
	 driver.findElement(newcustomer).click();
	 return  new FinalPage(driver);
	 
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

