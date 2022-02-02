package com.buffalocart.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buffalocart.pages.AllLead;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.ImportLead;
import com.buffalocart.pages.SignIn;
import com.buffalocart.utilities.ExcelUtility;

import junit.framework.Assert;

public class ImportleadTest extends Bases {
	
	
	
	@Test(priority=1,dataProvider="dp")
	  public void verifyNewLead(String n,String s) {
		  SignIn si=new SignIn(driver);
		  si.set(n,s);
		  si.signin(); 
		  AllLead al=new AllLead(driver);
		  al.allLead();
		 
	  }
	  @DataProvider
	  public Object[][] dp() throws InvalidFormatException, IOException {
		  Object[][] data= ExcelUtility.getDataFromSheet(System.getProperty("user.dir")+"/src/test/resources/validlogin.xlsx"); 
		  return data;  

		}
  @Test(priority=2,description="TC_008_verifypagetitle")
  public void verifyImprtLeadpage() {
	  ImportLead Ip =new ImportLead(driver);
	  Ip. importLeadPage();
	String  Expectedtitle= "Import Leads";
	String Actualtitle= driver. getTitle();
	Assert.assertEquals(Expectedtitle, Actualtitle);
	
  }
  
  @Test(priority=3,description="TC_009_FileUpload")
  public void verifyUploadFile() {
	  ImportLead Ip =new ImportLead(driver);
	  Ip. fileupload();
	  Ip.radiobutton();
	  
	  String  Expectedtitle= "All Leads";
		String Actualtitle= driver. getTitle();
		Assert.assertEquals(Expectedtitle, Actualtitle); 
	  
	  
	  
	  
	  
	  
	  
  }
}
