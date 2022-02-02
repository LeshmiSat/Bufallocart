package com.buffalocart.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buffalocart.pages.Logout;
import com.buffalocart.pages.SignIn;
import com.buffalocart.utilities.ExcelUtility;

public class LogoutTest extends Bases {
	
	 @Test(priority=1,dataProvider="dp")
	  public void verifyNewLead(String n,String s) {
		  SignIn si=new SignIn(driver);
		  si.set(n,s);
		  si.signin(); 
		 
	  }
	  @DataProvider
	  public Object[][] dp() throws InvalidFormatException, IOException {
		  Object[][] data= ExcelUtility.getDataFromSheet(System.getProperty("user.dir")+"/src/test/resources/validlogin.xlsx"); 
		  return data;  

		}
  @Test(priority=2,description="TC_006_Logout")
  public void verifyLogoutpage() {
	  Logout lg=new Logout(driver);
	  
	  lg.signOut();
  }
}
