package com.buffalocart.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buffalocart.pages.AllLead;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.SignIn;
import com.buffalocart.utilities.ExcelUtility;

public class AllLeadTest extends Bases {
	 @Test(priority=1,dataProvider="dp")
	  public void verifyLogin(String n,String s) {
		  SignIn si=new SignIn(driver);
		  si.set(n,s);
		  si.signin();
		  
		
		 
	  }
	  @DataProvider
	  public Object[][] dp() throws InvalidFormatException, IOException {
		  Object[][] data= ExcelUtility.getDataFromSheet(System.getProperty("user.dir")+"/src/test/resources/validlogin.xlsx"); 
		  return data;  

		}
  @Test(priority=2,description="TC_007_AllLead pageDisplayed")
  public void verifyTheLeadpage() {
	 
	  
	  AllLead al=new AllLead(driver);
	  al.allLead();
	 String expectedTile="All Leads";
	 String ActualTitle=driver.getTitle();
	 Assert.assertEquals(ActualTitle, expectedTile);
	  
	  
	  
  }
}
