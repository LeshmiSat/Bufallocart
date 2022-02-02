package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockManagmentPage {
	 WebDriver driver;
	
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath = "//a[@href=\"#stock\"]")
	private WebElement stockicon;
	
	
	private final String _Stock = "//ul[@id=\"stock\"]";
    @FindBy(xpath = _Stock)
    private List<WebElement> Stock;
    
   

	public StockManagmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public List<String> getActualUserManagementTabValues()
    {
       stockicon.click();
        List<String> list = new ArrayList<String>();
        for (int i = 0;i< Stock.size();i++)
        {
            list.add(Stock.get(i).getText());
        }
        return list;
    }
	public List<String> getExpectedValue() {
		List<String> list1=new ArrayList<String>();
		list1.add("Items");
		list1.add("Supplier");
		list1.add("Purchase");
		list1.add("Return Stock");
		list1.add("Purchase Payment");
		
		
		
		return list1;
		
	}

}
