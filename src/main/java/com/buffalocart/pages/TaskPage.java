package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[@title=\"Tasks\"]")
	private WebElement task;
	
	@FindBy(xpath="//a[@href=\"#assign_task\"]")
	private WebElement new_task;
	
	@FindBy(xpath="//a[@href=\"#task_list\"]")
	private WebElement all_task;
	
	public TaskPage(WebDriver driver) {
		this.driver = driver; 	
		PageFactory.initElements(driver,this); 	
		
	     }
	
	public void taskicon() {
		
		task.click();
		
		
	}
	
	public void newtask() {
		
		new_task.click();
		all_task.click();
	}

}
