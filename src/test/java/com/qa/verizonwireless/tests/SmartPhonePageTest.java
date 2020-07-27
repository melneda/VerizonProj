package com.qa.verizonwireless.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizonwireless.base.BasePage;
import com.qa.verizonwireless.pages.MainPage;
import com.qa.verizonwireless.pages.SmartPhonePage;
import com.qa.verizonwireless.util.ElementUtil;

public class SmartPhonePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	ElementUtil elementutil;
	SmartPhonePage smartPhonePage;
	
	@BeforeTest
	public void setup() throws InterruptedException {
	basePage=new BasePage();
	prop=basePage.init_properties();
	String browserName=prop.getProperty("browser");
	driver=basePage.init_driver(browserName);	
	driver.get(prop.getProperty("url"));
	mainPage=new  MainPage(driver);
	smartPhonePage=mainPage.phoneToClick();// buraya bagladik
	smartPhonePage=new SmartPhonePage(driver);
	}	
	
	@Test(priority=1)
	public void smartPhonePageVerify() {
		String title=smartPhonePage.getSmartPhonePageTitle();
		System.out.println("Smart phone page title is" +title);
		Assert.assertEquals(title, "Smartphones - Buy The Newest Cell Phones | Verizon Wireless");
  }
	

  @Test(priority=2)
   public void  samsungPhoneClick(){
	smartPhonePage.clickSamsung520();
  }
	
  @AfterTest
  public void tearDown() {
   driver.quit();
  
  
}
}




