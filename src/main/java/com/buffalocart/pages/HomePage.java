package com.buffalocart.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class HomePage {
	WebDriver driver;
	
	
	
	@FindBy(xpath = "//small[@class='text-sm']")
	private WebElement date;
	
	@FindBy(xpath = "//a[@class='btn btn-block btn-default']")
	private WebElement getAcc;
	
	@FindBy(xpath = "//button[@name='mark_attendance']")
	private WebElement markattendance;
	
	@FindBy(xpath = "//a[@class='btn btn-danger clock_in_button']")
	private WebElement clockIn;
	
	@FindBy(xpath = "//input[@id='s-menu']")
	private WebElement searchMenu;
	
	@FindBy(xpath = "//a[@title='User']")
	private WebElement userTitle;
	
	public HomePage(WebDriver driver) {
		this.driver = driver; 	
		PageFactory.initElements(driver,this); 	
	}
	public String getDate() {
		SimpleDateFormat timestamp=new SimpleDateFormat (" EEEE dd MMMMM-yyyy");
		String currentdate=timestamp.format(Calendar.getInstance().getTime());
		return currentdate;
	}
	
	public String getAcc() {
		getAcc.click();
		PageUtility.waitForElementTobeVisible(driver, getAcc, 10);
		driver.navigate().back();
		return driver.getCurrentUrl();
		
	}
	
	
	public String search() {
		searchMenu.sendKeys("User");
		return userTitle.getText();
	}
	
public String markAttendance() {
		
		PageUtility.waitForElementTobeVisible(driver, markattendance, 40);
		
		markattendance.click();
         return clockIn.getText();
		
	}
	
	
	
	

}
