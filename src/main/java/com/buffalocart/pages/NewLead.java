package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.buffalocart.utilities.PageUtility;

public class NewLead {
	WebDriver driver;
	
	@FindBy(xpath= "//a[@href=\"#create\"]")
	private WebElement lead;
	
	
	@FindBy(xpath="//input[@name=\"lead_name\"]")
	private WebElement title;

	@FindBy(name="organization")
	private WebElement organ;
	
	@FindBy(xpath="//input[@name=\"contact_name\"]")
	private WebElement name;

	
	@FindBy(xpath="//input[@name=\"email\"]")
	private WebElement email;
	
	@FindBy(xpath="//input[@name=\"phone\"]")
	private WebElement phn;

	@FindBy(xpath="//input[@name=\"mobile\"]")
	private WebElement mobile;
	

	@FindBy(xpath="//textarea[@name=\"address\"]")
	private WebElement address;

    @FindBy(xpath="//input[@name=\"city\"]")
	private WebElement city;

	@FindBy(xpath="//input[@name=\"state\"]")
	private WebElement state;

	@FindBy(xpath="//select[@name=\"lead_source_id\"]")
	private WebElement source;
	
	@FindBy(xpath="//select[@name=\"lead_status_id\"]")
	private WebElement status;
	
	@FindBy(xpath="//select[@name=\"country\"]")
	private WebElement country;
	
	@FindBy(xpath="//button[@class=\"btn btn-sm btn-primary\"]")
	private WebElement save;
	
	@FindBy(xpath="//li[@class=\"parsley-required\"]")
	private WebElement fieldrequired;

 
     public NewLead(WebDriver driver) {
	this.driver = driver; 	
	PageFactory.initElements(driver,this); 	
	
     }
     
     public void set1(String ti,String or,String em,String mo,String ci,String n,String ph,String add,String st) {
    	 lead.click();
    	 title.sendKeys(ti);
    	 organ.sendKeys(or);
    	 name.sendKeys(n);
    	 email.sendKeys(em);
    	 phn.sendKeys(ph);
    	 mobile.sendKeys(mo);
    	 address.sendKeys(add);
    	 city.sendKeys(ci);
    	 state.sendKeys(st);
    	 
    	
 		PageUtility.selectItemByVisibletext(source,"Google");
 		
 		PageUtility.selectItemByVisibletext(status,"Open");
		
 		PageUtility.selectItemByVisibletext(country,"India");
     }
     public void submit() {
   	 
    	 save.click();
    	 
     }
     
     public boolean required() {
    	 
    	
   	  
    	 boolean b2= fieldrequired.isDisplayed();
    	
    	 return b2;
    	 
    	 
     }
}
