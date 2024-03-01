package com.adactinhotel.qa.testcases;

import com.adactinhotel.qa.base.TestBase;
import com.adactinhotel.qa.pages.LoginPage;
import com.adactinhotel.qa.pages.SearchHotelPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	SearchHotelPage selectHotelPage;
	
	public LoginPageTest() {
		super(); // call the test base class constructor
	}
	
    @BeforeMethod
    public void setUp(){
		initialization();
		loginPage= new LoginPage();	
	}
     @Test(priority=1)
     public void loginPageTitleTest() {
    	 String title=loginPage.validateLoginPageTitle();
    	 Assert.assertEquals(title, "Adactin.com - Hotel Reservation System");
     }
     
     @Test(priority=2)
 	public void ImageTest() throws InterruptedException{
 		boolean flag = loginPage.validateImage();
 		Thread.sleep(5000);
 		Assert.assertTrue(flag);
 	}
     @Test(priority=3)
 	public void loginTest(){
    	 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 selectHotelPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
 	}
    @AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
