package com.buffalocart.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.buffalocart.pages.ForgotPassword;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.SignIn;
import com.buffalocart.utilities.PageUtility;

import junit.framework.Assert;

public class ForgotPasswordTest extends Bases {
	
	 
  @Test(priority=2,description="TC_016_forgotpassword")
  public void forgotpasswordPage() {
	  ForgotPassword fp=new ForgotPassword(driver);
	  fp.forgot();
	String  Expectedurl="https://erp.buffalocart.com/login";
	String  Actualurl=driver.getCurrentUrl();
	Assert.assertEquals(Expectedurl, Actualurl);
	  
	  
  }
  @Test(priority=3,description="TC_017_invalidforgot")
  public void verifyInvalidLogin() throws IOException {
	  
	  ForgotPassword fp=new ForgotPassword(driver);
	  fp.forgotforinvalidadmin();
	  
	  if(fp.alert()==true)
		{
			 Assert.assertTrue(true);
			  PageUtility.captureScreen(driver,"forgotinvalid");
			 
			
		}else
		{
			Assert.assertTrue(false);
		
	  }
	  
  }
  
  @Test(priority=1,description="TC_018_rememberPassword")
  public void verifyRememberPassword() {
	  ForgotPassword fp=new ForgotPassword(driver);
	  fp.rememberpassword();
	  
	  Assert.assertEquals(fp.rememberpassword(),true);
	  
  }
  
  @Test(priority=4,description="TC_019_rememberedPassword")
  public void verifyRememberedPassword() {
	  ForgotPassword fp=new ForgotPassword(driver);
	  fp.remember_password();
	  String expectedurl="https://erp.buffalocart.com/login";
	  String Actualurl=driver.getCurrentUrl();
	  Assert.assertEquals(expectedurl, Actualurl);
	  
  }
  
 
}
