package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name=\"user_name\"]")
	private WebElement username;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	private WebElement Password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement Signin;
	
	@FindBy(xpath="//div[@class=\"alert alert-danger\"]")
	private WebElement InvalidCredentials;
	
	public SignIn(WebDriver driver) {
		this.driver = driver; 	
		PageFactory.initElements(driver,this); 	
		
	}
	
	public void set(String name,String pass) { 		
		username.sendKeys(name); 		
		Password.sendKeys(pass); 
	}
	
	public boolean isAlertPresent() {
		boolean b1=InvalidCredentials.isDisplayed();
		return b1;
	}
	
	public void signin() {
		Signin.click();
		
		}

}
