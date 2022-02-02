package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class=\"hidden-xs\"]")
	private WebElement demo;
	
@FindBy(xpath="//button[@type=\"submit\"]")
private WebElement logout;

public Logout(WebDriver driver) {
	this.driver = driver; 	
	PageFactory.initElements(driver,this); 	
	
}

public void signOut() {
	
	demo.click();
	logout.click();
	
}
}


