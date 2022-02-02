package com.buffalocart.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buffalocart.pages.NewUserLogin;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.PageUtility;


public class NewUserLoginTest extends Bases {
	

	
	@Test(dataProvider="dp",description="TC_017_NewuserLogin")
	
  public void verifyNewUserSignin(String n, String s) throws IOException  {
	  NewUserLogin nl=new NewUserLogin(driver);
	  nl.set(n,s);
	 nl.signin(); 
	 String actualTitle= driver.getTitle();
		String expectedtitle="Codecarrots";
		
		Assert.assertEquals(expectedtitle, actualTitle);
	 
}
	
@DataProvider
public Object[][] dp() throws InvalidFormatException, IOException {
	  Object[][] data= ExcelUtility.getDataFromSheet(System.getProperty("user.dir")+"/src/test/resources/newuserlogin.xlsx"); 
	  return data;  

	}
}
