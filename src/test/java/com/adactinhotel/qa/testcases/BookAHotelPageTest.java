package com.adactinhotel.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactinhotel.qa.base.TestBase;
import com.adactinhotel.qa.pages.BookAHotelPage;
import com.adactinhotel.qa.pages.BookingConfirmationPage;
import com.adactinhotel.qa.pages.LoginPage;
import com.adactinhotel.qa.pages.SearchHotelPage;
import com.adactinhotel.qa.pages.SelectHotelPage;

public class BookAHotelPageTest extends TestBase {

	LoginPage loginPage;
	SearchHotelPage searchHotelPage;
	SelectHotelPage selectHotelPage;
	BookAHotelPage bookAHotelPage;
	BookingConfirmationPage bookingConfirmationPage;

	public BookAHotelPageTest() {
		super(); // call the test base class constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(); // to access the login page class methods
		searchHotelPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // to access
																										// login method
		searchHotelPage = new SearchHotelPage();
		selectHotelPage = new SelectHotelPage();
		bookAHotelPage = new BookAHotelPage();
		searchHotelPage.select_locationviadropdown();
		searchHotelPage.select_hotelviadropdown();
		searchHotelPage.select_roomtypeviadropdown();
		searchHotelPage.submit();
		selectHotelPage.selectHotel();
		selectHotelPage.submit();
	}

	@Test
	public void bookAHotelPageTitleTest() {
		String title = bookAHotelPage.validateBookAHotelPageTitle();
		Assert.assertEquals(title, "Adactin.com - Book A Hotel");
	}

	@Test
	public void userDetailsTest() {
		bookAHotelPage.enterBookingDetails();
	}
	
	@Test
	public void ceritcardDetailsTest() {
		bookAHotelPage.select_creditCardDetails();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
