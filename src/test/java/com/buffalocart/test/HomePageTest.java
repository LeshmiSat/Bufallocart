package com.buffalocart.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.buffalocart.extendreport.ExtendReportManager;
import com.buffalocart.pages.ForgotPassword;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.SignIn;
import com.buffalocart.utilities.ExcelUtility;

import junit.framework.Assert;

public class HomePageTest extends Bases
{
	ExtendReportManager er=new ExtendReportManager();
	SoftAssert s=new SoftAssert();

	@Test(priority=2,dataProvider="dp",description="TC_024_Verify Whether Attendance is Marked")
	public void verifyAttendanceMark(String n, String p)   {
		
		;
		  SignIn si=new SignIn(driver);
		  si.set(n,p);
		  
		  HomePage hp=new HomePage(driver);
			 
			String actual=hp.markAttendance();
			String exp="Clock Out";
			
			s.assertEquals(actual, exp,"cant mark attendance");
		  
		
	}
	
	 @DataProvider
	  public Object[][] dp() throws InvalidFormatException, IOException {
		  Object[][] data= ExcelUtility.getDataFromSheet(System.getProperty("user.dir")+"/src/test/resources/validlogin.xlsx"); 
		  return data;  

		}
  
	 @Test(priority=1,description="TC_021_Verify Get Your Accout Page")
		public void verifyGetYourAccountPage() {
			
			HomePage hp=new HomePage(driver);
			String actualURL=hp.getAcc();
			String expURL="https://erp.buffalocart.com/login/register";
			s.assertEquals(actualURL, expURL,"cannot load getAccount");
			
			
		}
		
		@Test(priority=3,description="TC_022_Verify Home Page title")
		public void verifyhomePagetitle() {
			
				
			HomePage hp=new HomePage(driver);
		
			String expectedtitle="Manage Client";
			String actualtitle=driver.getTitle();
			
		
			s.assertEquals(actualtitle, expectedtitle,"invalid title");
			
		}
		
		@Test(priority=4,description="TC_023_Verify date in home page")
		
		public void  verifydate() {
			HomePage hp=new HomePage(driver);
			String actual=hp.getDate();
			String exp=" Saturday 29 January-2022";
			System.out.println(actual);
			System.out.println(exp);
			s.assertEquals(actual,exp,"date didnt match");
			
		}
		
//		 @Test(priority=1,description="TC_024_Verify Whether Attendance is Marked")
//			public void verifyAttendanceMark() throws Exception {
//			
//				
//			 HomePage hp=new HomePage(driver);
//			 
//				String actual=hp.markAttendance();
//				String exp="Clock Out";
//				
//				s.assertEquals(actual, exp,"cant mark attendance");
//				er.getScreenshot(driver, exp);
//			}
		
		@Test(priority = 5, description = "TC_025_Verify Search Menu ")
		public void verifySearchMenu() {

		
			HomePage hp = new HomePage(driver);
			String expectedtitle = "User";
			String actualtitle = hp.search();
			
			s.assertEquals(actualtitle, expectedtitle, "Search Is Not Working");
			
		}
		
}