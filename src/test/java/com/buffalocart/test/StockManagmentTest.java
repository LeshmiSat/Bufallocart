package com.buffalocart.test;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.pages.SignIn;
import com.buffalocart.pages.StockManagmentPage;
import com.buffalocart.utilities.ExcelUtility;

public class StockManagmentTest extends Bases {
	
	 @Test(priority=1,dataProvider="dp")
	  public void verifySignin(String n,String s) {
		  SignIn si=new SignIn(driver);
		  si.set(n,s);
		  si.signin(); 
		 
	  }
	  @DataProvider
	  public Object[][] dp() throws InvalidFormatException, IOException {
		  Object[][] data= ExcelUtility.getDataFromSheet(System.getProperty("user.dir")+"/src/test/resources/validlogin.xlsx"); 
		  return data;  

		}
  @Test(priority=2,description="TC_020_StockManagement")
  public void verifyUserList() {
		 
		 StockManagmentPage smp=new StockManagmentPage(driver);
		 
		  List<String> list1=smp.getExpectedValue();
		  List<String> list=smp.getActualUserManagementTabValues();
		  SoftAssert s=new SoftAssert();
		  s.assertEquals(list, list1, "tabs didnt exist");
		  
		  System.out.println(list);
		  System.out.println(list1);
		 
}
}


