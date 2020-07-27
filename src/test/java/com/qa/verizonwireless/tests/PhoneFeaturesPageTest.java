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
import com.qa.verizonwireless.pages.PhoneFeaturesPage;
import com.qa.verizonwireless.pages.SmartPhonePage;
import com.qa.verizonwireless.util.ElementUtil;

public class PhoneFeaturesPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	ElementUtil elementutil;
	SmartPhonePage smartPhonePage;
	PhoneFeaturesPage phonefeaturespage;
	
	@BeforeTest
	public void setup() throws InterruptedException {
	basePage=new BasePage();
	prop=basePage.init_properties();
	String browserName=prop.getProperty("browser");
	driver=basePage.init_driver(browserName);	
	driver.get(prop.getProperty("url"));
	mainPage=new  MainPage(driver);
	smartPhonePage=mainPage.phoneToClick();
	smartPhonePage=new SmartPhonePage(driver);
    phonefeaturespage=smartPhonePage.clickSamsung520();// buraya bagladik
    phonefeaturespage=new PhoneFeaturesPage(driver);
}


@Test(priority=1)
   public void phoneFeaturesPageVerify() {
	String title=phonefeaturespage.getFeaturesPageTitle();
	System.out.println("Phone features page title is"+title);
	Assert.assertEquals(title, "Samsung Galaxy S20 5G UW Price, Colors & Reviews | Buy Now");
	//Assert.assertEquals(title, "Verizon Wireless, Smartphone Deals & Plans | First to 5G");

}	

@Test(priority=2)
public void PageClicksTest() throws InterruptedException {
	Thread.sleep(5000);
	phonefeaturespage.clicksOnThePage();
	
}

@AfterTest
public void tearDown() {
	driver.close();
}

}
	




