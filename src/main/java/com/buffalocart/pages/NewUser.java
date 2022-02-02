package com.buffalocart.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.buffalocart.utilities.PageUtility;



public class NewUser {
	WebDriver driver;
	
	@FindBy(xpath="//a[@title=\"User\"]")
	private WebElement us_er;
	
	@FindBy(xpath="//a[@href=\"#new\"]")
	private WebElement New_User;
	
	
	@FindBy(xpath="//input[@name=\"fullname\"]")
	private WebElement full_name;
	
	
	@FindBy(xpath="//input[@name=\"username\"]")
	private WebElement username;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	private WebElement password;
	
	@FindBy(xpath="//input[@name=\"confirm_password\"]")
	private WebElement cfm_password;
	
	@FindBy(xpath="//input[@name=\"email\"]")
	private WebElement mail;
	
	@FindBy(xpath="//select[@id=\"user_type\"]")
	private WebElement dropdown1;
	
	@FindBy(xpath="//button[@class=\"btn dropdown-toggle btn-default\"]")
	private WebElement dropdown2;
	
	@FindBy(xpath="//span[@title=\"Select Designation\"]")
	private WebElement dropdown3;
	
	@FindBy(xpath="//i[@class=\"fa fa-plus\"]")
	private WebElement plus;
	
	@FindBy(xpath="//button[@name=\"save\"]")
	private WebElement popupsave;
	
	@FindBy(xpath="//input[@name=\"designations\"]")
	private WebElement designation;
	
	@FindBy(xpath="//input[@name=\"deptname\"]")
	private WebElement department;
	
	
	
	@FindBy(xpath="//button[@class=\"btn btn-sm btn-primary\"]")
	private WebElement save;
	
	
	public NewUser(WebDriver driver) {
		this.driver = driver; 	
		PageFactory.initElements(driver,this); 	
		
	     }
	
	public void user() {
		us_er.click();
		New_User.click();
	}
	
	public void createNewUser(String fn, String un, String pw, String cpw, String mailid) {
		full_name.sendKeys(fn);
		username.sendKeys(un);
		password.sendKeys(pw);
		cfm_password.sendKeys(cpw);
		mail.sendKeys(mailid);
		Select s1=new Select(dropdown1);
		s1.selectByIndex(1);
		
//		Select s2=new Select(dropdown2);
//		s2.selectByIndex(0);
	}
	
	public void desigNation() {
		
		//PageUtility.scroll(driver);
		
		plus.click();

                    PageUtility.waitForElementTobeClickable(driver, designation,20); 
                    department.sendKeys("IT");
                   designation.sendKeys("lead");
           		popupsave.click();
           		
            
           		PageUtility.waitForElementTobeClickable(driver, save, 100);
           		save.submit();
	}

	

}
