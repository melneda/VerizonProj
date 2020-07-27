package com.qa.verizonwireless.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.verizonwireless.base.BasePage;
import com.qa.verizonwireless.util.ElementUtil;

public class SmartPhonePage extends BasePage{

public WebDriver driver;
public ElementUtil elementUtil;

	
//Constructors
  public SmartPhonePage(WebDriver driver) {
	this.driver=driver;
	elementUtil=new ElementUtil(driver);
	
	}	
	
	//Locators
	//By samsung= By.xpath("//a[@aria-label='Samsung Galaxy S20 5G UW']");
     By samsung=By.id("tile_dev13400024");
	
    //Page Title
	public String  getSmartPhonePageTitle() {
		return elementUtil.doGetPageTitle();
		
	}
public PhoneFeaturesPage clickSamsung520() {
	elementUtil.doClick(samsung);
	return new PhoneFeaturesPage(driver);
}

}
