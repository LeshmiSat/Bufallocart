package com.buffalocart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()   
	{
		File src=new File("./Configuration/config.properties");
		
		try 
		{
        FileInputStream fis= new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
		
			
	}
	
	public String getApplicationURL() {
		String URL= pro.getProperty("baseURL");
		return URL;
		
		
	}
	
	public String getChromePath() {
		String chromepath= pro.getProperty("chromepath");
		return chromepath;

}

	public String getFirefoxPath() {
		String firefoxpath= pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getEdgePath() {
		String edgepath= pro.getProperty("edgepath");
		return edgepath;
	
}
}