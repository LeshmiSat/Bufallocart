package com.buffalocart.test;

import org.testng.annotations.Test;

import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.NewLead;
import com.buffalocart.pages.SignIn;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.PageUtility;

import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class SigninTest extends Bases {
	@Test(priority=1,description="TC_001_verifyLoginTitle")
	
	public void verifyLoginTitle() {
		String actualTitle= driver.getTitle();
		String expectedtitle="Welcome to Codecarrots";
		Assert.assertEquals(actualTitle,expectedtitle);
		
	}
	
	
  @Test(priority=2,dataProvider = "dp",description="TC_002_SignIn")
  public void verifySignIn(String n, String s) throws IOException  {
	  SignIn si=new SignIn(driver);
	  si.set(n,s);
	 si.signin(); 
	
	
	
	if(si.isAlertPresent()==false)
	{
		 Assert.assertFalse(si.isAlertPresent());
		 System.out.println("Login Successful");
		 
		
	}else
	{
		Assert.assertTrue(si.isAlertPresent());
		 System.out.println("Login failed :invalid Credentials entered");
		 
		   PageUtility.captureScreen(driver,"signIn");
	
	
  }
  }

  @DataProvider
  public Object[][] dp() throws InvalidFormatException, IOException {
	  Object[][] data= ExcelUtility.getDataFromSheet(System.getProperty("user.dir")+"/src/test/resources/Buffalocartlogin.xlsx"); 
	  return data;  

	}
  
 
  @Test(priority=3,description="TC_003_Homepage")
  public void verifyHomepageTitle() throws IOException {
	  SignIn si=new SignIn(driver);
	  
	  String actualTitle= driver.getTitle();
		String expectedtitle="Codecarrots";
		
		
	  if(actualTitle.equals(expectedtitle))
		 {
		   
		  Assert.assertEquals(expectedtitle, actualTitle);
		 }
		 else
		 {
			
			
		   PageUtility.captureScreen(driver,"homepage");
			 
		 }
		 	  
  }
}
 
