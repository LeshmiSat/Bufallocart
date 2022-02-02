package com.buffalocart.pages;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class AllLead {
	
	WebDriver driver;
	 
	@FindBys(@FindBy(xpath="//table[@id=\"DataTables\"]//tbody//tr"))
	private List<WebElement> row;
	
	@FindBy(xpath="//table[@id=\"DataTables\"]//th")
     private List<WebElement>col;
	
	@FindBy(xpath="//table[@id=\"DataTables\"]//td")
    private List<WebElement>cell;
	
	@FindBy(xpath="//input[@type=\"search\"]")
	private WebElement search;
	
	@FindBy(xpath="//a[@title=\"Leads\"]")
	private WebElement lead;
	
	public AllLead(WebDriver driver) {
		this.driver = driver; 	
		PageFactory.initElements(driver,this); 	
		
	     }
	
	
	public void allLead() {
		
	lead.click();
			}
			 
	
	

		
		
		
	}

