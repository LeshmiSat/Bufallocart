package com.buffalocart.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public  class PageUtility {
	
	public static WebElement waitForElementTobeVisible(WebDriver driver,WebElement elementToBeLoaded,int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time,1));
		WebElement element= wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;
	}
	
	public static WebElement waitForElementTobeClickable(WebDriver driver,WebElement elementToBeLoaded,int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time,1));
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(elementToBeLoaded));
		return element;
	}
	
	public static void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		  File source=ts.getScreenshotAs(OutputType.FILE);	    	
		  FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"/Screenshots/"+ tname +".png"));
		  System.out.println("Screenshot taken");
	}
	
	public static void scroll(WebDriver driver) {
		  JavascriptExecutor js=(JavascriptExecutor)driver; 	   
		  js.executeScript("window.scrollBy(0,70)");  		
		  WebElement user = driver.findElement(By.name("element")); 		
		  js.executeScript("arguments[0].scrollIntoView()",user); 
	}
	
	public static void selectItemByIndex(WebElement element,int value) {
		Select s= new Select(element);
		s.selectByIndex(value);
				
	}
	public static void selectItemByVisibletext(WebElement element,String text) {
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}

}
