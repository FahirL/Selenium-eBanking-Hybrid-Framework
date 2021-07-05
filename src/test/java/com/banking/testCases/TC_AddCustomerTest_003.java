package com.banking.testCases;

import java.io.IOException;


import org.junit.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
    
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		Thread.sleep(5000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		logger.info("providing customer details...");
		addcust.custName("Fahir");
		addcust.custgender("male");
		addcust.custdob("10", "25", "1993");
		Thread.sleep(5000);
		addcust.custaddress("Bosna");
		addcust.custcity("Sarajevo");
		addcust.custstate("Bosna");
		addcust.custpinno("500013");
		addcust.custtelephoneno("38762666111");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("asd1a5s");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		logger.info("validation started...");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed...");
		}
		else {
			logger.info("test case failed...");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			
		}

	}
	

}
