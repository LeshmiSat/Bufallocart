package com.buffalocart.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.pages.AllLead;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.NewLead;
import com.buffalocart.pages.SignIn;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.PageUtility;

public class NewLeadTest extends Bases {
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
	 
  @Test(priority=2,dataProvider="dp2",description="TC_004_Lead")
	 public void verifyAddleadpage(String tit,String organi,String na,String email,String phone,String Mob,String Addr,String cit,String sta ) throws IOException {
	  
	  AllLead al=new AllLead(driver);
	  al.allLead();
	 	 
		 NewLead ld=new NewLead(driver);
	  ld.set1(tit,organi,na,email,phone,Mob,Addr,cit,sta);
	  
	 
	
	 
		 ld.required();
		
		 Assert.assertEquals(ld.required(), true,"Enter Details");
		
		  PageUtility.captureScreen(driver,"leadpage");
		
	
			 
		  
	  }
  
	   @DataProvider
	  public Object[][] dp2() throws InvalidFormatException, IOException {
		  Object[][] data= ExcelUtility.getDataFromSheet(System.getProperty("user.dir")+"/src/test/resources/lead.xlsx"); 
		  return data;  

		}
	   
	   @Test(priority=3,description="TC_005_Save")
	   public void verifySaveNewLead() {
		   
		   NewLead ld=new NewLead(driver);
		   ld.submit();
		   SoftAssert softAssert=new SoftAssert();
		   softAssert.assertAll();
	   }
}
	  
	  
	  
	  

