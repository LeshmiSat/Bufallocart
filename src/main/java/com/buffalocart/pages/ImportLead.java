package com.buffalocart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportLead {
	WebDriver driver;
	
	@FindBy(xpath="//a[@href=\"https://erp.buffalocart.com/admin/leads/import_leads\"]")
	private WebElement import_lead;
	
	@FindBy(xpath="//div[@class=\"fileinput fileinput-new\"]")
	private WebElement choose_file;
	
	@FindBy(xpath="//button[@class=\"btn btn-sm btn-primary\"]")
	private WebElement upload;
	
	@FindBy(xpath="//div[@class=\"col-sm-9\"]")
	private List<WebElement> radiobtn;
	
	public ImportLead(WebDriver driver) {
		this.driver = driver; 	
		PageFactory.initElements(driver,this); 	
		
	     }
	
	public void importLeadPage() {
		
		import_lead.click();
	}
	public void fileupload() {
		choose_file.click();
		
		
		
	}
	
	public void radiobutton() {
		radiobtn.get(0).click();
		upload.click();
	}
	
	
	

}
