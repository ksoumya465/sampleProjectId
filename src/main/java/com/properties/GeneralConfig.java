package com.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GeneralConfig {
	public static Properties prop ;
	public String gmailEmailId=null;
	public String gmailPwd=null;
	
	
	public GeneralConfig(String fileName) {
		try {
		    prop = readPropertiesFile(fileName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args){  
		String fileName ="src/main/resources/generalConfig.properties";
		//GeneralConfig config = new GeneralConfig(fileName);
		//System.out.println("Email : "+getGmailEmailId()+"\n Password : "+getGmailPwd());
	}*/
	
	   public static Properties readPropertiesFile(String fileName) throws IOException {
		      FileInputStream fis = null;
		      Properties prop = null;
		      try {
		    	  System.out.println("+++++++++++ "+new File("."). getAbsolutePath());
		         fis = new FileInputStream(fileName);
		         prop = new Properties();
		         prop.load(fis);
		         System.out.println("----Email : "+ prop.getProperty("gmail.emailId"));
		      } catch(FileNotFoundException fnfe) {
		         fnfe.printStackTrace();
		      } catch(IOException ioe) {
		         ioe.printStackTrace();
		      } finally {
		         fis.close();
		      }
		      return prop;
		   }

	public String getGmailEmailId() {
		return prop.getProperty("gmail.emailId");
	}

	public void setGmailEmailId(String gmailEmailId) {
		this.gmailEmailId = gmailEmailId;
	}

	public String getGmailPwd() {
		return prop.getProperty("gmail.pasword");
	}

	public void setGmailPwd(String gmailPwd) {
		this.gmailPwd = prop.getProperty("gmail.pasword") ;
	}
	
	public String getValue(String key) {
		return prop.getProperty(key);
	}
}
