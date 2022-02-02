package com.buffalocart.test;

import org.testng.annotations.Test;

import com.buffalocart.utilities.ReadConfig;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Bases {
	
	public WebDriver driver;
	
	  ReadConfig readconfig=new ReadConfig();
	  @Parameters("browser")
	  @BeforeClass
	  public void testInitialize(String br) {
		  
		if(br.equals("chrome"))
		{
		  System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		   driver=new ChromeDriver();
		   
		}else if(br.equals("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
		   driver=new FirefoxDriver();
		}else if(br.equals("edge"))
		{

			 System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
		   driver=new EdgeDriver();
		}
	 
			
		driver.get(readconfig.getApplicationURL());
		driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
	 }
	  
	
	

  @AfterClass
	  public void tearDown() {
			
			 driver.close();
		}

	       
	}
