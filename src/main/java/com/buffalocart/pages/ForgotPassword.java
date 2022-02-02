package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class ForgotPassword {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class=\"fa fa-check\"]")
	private WebElement remember_checkbox;
	
	@FindBy(xpath="//a[@href=\"https://erp.buffalocart.com/login/forgot_password\"]")
     private WebElement forgot_password;
	
	@FindBy(xpath="//a[@href=\"https://erp.buffalocart.com/login\"]")
    private WebElement remembered_password;
	
	@FindBy(xpath="//input[@name=\"email_or_username\"]")
	private WebElement username;
	
	@FindBy(xpath="//div[@class=\"alert alert-danger\"]")
	private WebElement Alert;
	
	@FindBy(xpath="//button[@name=\"flag\"]")
	private WebElement submit;
	
	
	
	public ForgotPassword(WebDriver driver) {
		this.driver = driver; 	
		PageFactory.initElements(driver,this);
		
	     }
	
	
	public void forgot() {
		
		
		forgot_password.click();
		username.sendKeys("admin");
		submit.click();
		
	}
	

	public void forgotforinvalidadmin() {
		
		
		forgot_password.click();
		username.sendKeys("leshmi");
		submit.click();
		
	}
	
	
	public boolean alert() {
		boolean b= Alert.isDisplayed();
				return b;
	}
	public boolean rememberpassword() {
		
	boolean b=remember_checkbox.isDisplayed();
	return b;
	}
	
	public void remember_password() {
		
		remembered_password.click();
	}
	

	
}
