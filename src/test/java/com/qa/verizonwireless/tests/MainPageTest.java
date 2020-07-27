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
import com.qa.verizonwireless.pages.MainPage;
import com.qa.verizonwireless.util.Constants;
import com.qa.verizonwireless.util.ElementUtil;

public class MainPageTest  {
	
WebDriver driver;
BasePage basePage;
Properties prop;
MainPage mainPage;
ElementUtil elementutil;


@BeforeTest
public void setUp() throws InterruptedException {
	
basePage=new BasePage();
prop=basePage.init_properties();
String browserName=prop.getProperty("browser");
driver=basePage.init_driver(browserName);	
driver.get(prop.getProperty("url"));
mainPage=new  MainPage(driver);
Thread.sleep(5000);
}

@Test(priority=1)
public void verifyMainPageTitleTest() throws InterruptedException  {
String title=mainPage.getPageTitle();
//String title=driver.getTitle();
System.out.println("Main page title is"+title);
	Assert.assertEquals(title,"Verizon Wireless, Smartphone Deals & Plans | First to 5G" );
	//Assert.assertEquals(title,Constants.HOME_PAGE_TITLE);
    Thread.sleep(5000);

	}


@Test(priority=2)
public void phoneToSmartClick() throws InterruptedException {
	mainPage.phoneToClick();
}


@AfterTest
public void tearDown() {
	driver.quit();
}
}	
	




	
	
