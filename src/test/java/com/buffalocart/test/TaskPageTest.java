package com.buffalocart.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.pages.SignIn;
import com.buffalocart.pages.TaskPage;
import com.buffalocart.utilities.ExcelUtility;

import junit.framework.Assert;

public class TaskPageTest extends Bases {
	@Test(priority=1,dataProvider="dp")
	  public void verifyTaskLogin(String n,String s) {
		  SignIn si=new SignIn(driver);
		  si.set(n,s);
		  si.signin();
	} 
		  @DataProvider
		  public Object[][] dp() throws InvalidFormatException, IOException {
			  Object[][] data= ExcelUtility.getDataFromSheet(System.getProperty("user.dir")+"/src/test/resources/validlogin.xlsx"); 
			  return data;  

	}
		  
  @Test(priority=2,description="TC_014_Taskicon")
  public void verifyTaskIcon_() {
	  TaskPage Tp=new TaskPage(driver);
	  Tp.taskicon();
	  
	  String Expectedtitle="All Task";
	  String Actualtitle= driver. getTitle();
		Assert.assertEquals(Expectedtitle, Actualtitle);
	  
  }@Test(priority=3,description="TC_015_NewTask")
  
  public void verifyAddnewTask() {
	  TaskPage Tp=new TaskPage(driver);
	  Tp.taskicon();
	  
	  SoftAssert softAssert= new SoftAssert();
	  softAssert.assertAll();
	  
	  
	  
	  
	  
  }
}
