package com.adactinhotel.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactinhotel.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//pagefactory OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type=submit]") 
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'New User Register Here')]") 
	WebElement NewUserRegBtn;
	
	@FindBy(xpath="/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/img[1]") 
	WebElement logo;
	//adding all webelemnts
	//Actions:
			public String validateLoginPageTitle(){
				return driver.getTitle();
			}
			
			public boolean validateImage(){
				return logo.isDisplayed();
			}
			
			public SearchHotelPage login(String un, String pwd){
				username.sendKeys(un);
				password.sendKeys(pwd);
				loginBtn.click();
				    	//JavascriptExecutor js = (JavascriptExecutor)driver;
				    	//js.executeScript("arguments[0].click();", loginBtn);
				    	
				return new SearchHotelPage();
			}
	

}
