package com.qa.verizonwireless.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizonwireless.base.BasePage;
import com.qa.verizonwireless.pages.FinalPage;
import com.qa.verizonwireless.pages.MainPage;
import com.qa.verizonwireless.pages.PhoneFeaturesPage;
import com.qa.verizonwireless.pages.SmartPhonePage;
import com.qa.verizonwireless.util.ElementUtil;

public class FinalPageTest {
	
		WebDriver driver;
		BasePage basePage;
		Properties prop;
		MainPage mainPage;
		ElementUtil elementutil;
		SmartPhonePage smartPhonePage;
		PhoneFeaturesPage phonefeaturespage;
		FinalPage finalpage;
		
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
		phonefeaturespage=smartPhonePage.clickSamsung520();
		phonefeaturespage=new PhoneFeaturesPage(driver); 
		finalpage=phonefeaturespage.clicksOnThePage();// buraya bagladik
		finalpage=new FinalPage(driver);
		
	}
			
	@Test(priority=1, enabled=true)
	    public void FinalPageVerify() {
		String title=finalpage.finalPageTitle();
		System.out.println("Smart phone page title is" +title);
		Assert.assertEquals(title, "Verizon | Customize your Device");
		//Assert.assertEquals(title, "Samsung Galaxy S20 5G UW Price, Colors & Reviews | Buy Now	");

	}	
	@Test(priority=2, enabled=true)
	public void VerifySelectedPhone() {
	String name= finalpage.phoneTextName();
	System.out.println("Selected Phone is"+ name);
	Assert.assertEquals(name, "Galaxy S20 5G UW");
	}
	
	@Test(priority=3, enabled=true)
	public void VerifySelectedPhoneOnChartTest() throws InterruptedException {
//	Thread.sleep(5000);
	String name= finalpage.SelectedPhoneOnChartt();
	System.out.println("Selected Phone is"+ name);
	Assert.assertEquals(name, "Galaxy S20 5G UW");
	}

	@AfterTest
	 public void teardown() {
		driver.quit();
		
	}
	
}
	
	


