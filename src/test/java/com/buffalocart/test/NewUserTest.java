package com.buffalocart.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.pages.NewUser;
import com.buffalocart.pages.SignIn;
import com.buffalocart.utilities.ExcelUtility;

import junit.framework.Assert;

public class NewUserTest extends Bases {
	

	@Test(priority=1,dataProvider="dp")
	  public void verifyUserSignin(String n,String s) {
		  SignIn si=new SignIn(driver);
		  si.set(n,s);
		  si.signin();
	} 
		  @DataProvider
		  public Object[][] dp() throws InvalidFormatException, IOException {
			  Object[][] data= ExcelUtility.getDataFromSheet(System.getProperty("user.dir")+"/src/test/resources/validlogin.xlsx"); 
			  return data;  

	}
		  
  @Test(priority=2,description="TC_010_verifyTitlepage")
  public void verifyUserPage() {
	  NewUser Nw=new NewUser(driver);
	  
	  Nw.user();
	  
	  String Expectedtitle="User List";
	  String Actualtitle= driver. getTitle();
		Assert.assertEquals(Expectedtitle, Actualtitle);
	  
  }
  @Test(priority=3,dataProvider="dp2",description="TC_011_Createnewuser")
  public void verifyCreateNewUserpage(String full,String user,String pass,String cpass,String em) {
	  
	  NewUser Nw=new NewUser(driver);
	  Nw.createNewUser(full, user, pass, cpass, em);
	  Nw.desigNation();
	  SoftAssert softAssert= new SoftAssert();
	  softAssert.assertAll();
  }
  @DataProvider
  public Object[][] dp2() throws InvalidFormatException, IOException {
	  Object[][] data= ExcelUtility.getDataFromSheet(System.getProperty("user.dir")+"/src/test/resources/newUser.xlsx"); 
	  return data;  

}
	  
	  
	  @Test(priority=4,description="TC_013_Created")
	  public void verifyCreateUser() {
		  NewUser Nw=new NewUser(driver);
//		  Nw.Createuser();
		  String Expectedtitle="User List";
		  String Actualtitle= driver. getTitle();
			Assert.assertEquals(Expectedtitle, Actualtitle);
		  
  }
}
