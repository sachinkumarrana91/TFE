package testScripts;

import java.io.IOException;

import webPages.VisionLoginPage;
import testReports.TestReports;
import util.TestUtil;
import core.Core;
import util.Log;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import config.Configuration;

public class VisionLogin extends Core{

	@BeforeTest
	public void beforeMethod(){
		startTime=TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");
	}

	@Test
	@Parameters({"env"})
	public void loginQA(String env) {
		try{
			Log.info("log4j from xml file");
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");

			if(env.equalsIgnoreCase("QA1")) driver.get(Configuration.QA1);
			if(env.equalsIgnoreCase("QA2")) driver.get(Configuration.QA2);
			if(env.equalsIgnoreCase("QA3")) driver.get(Configuration.QA3);
			if(env.equalsIgnoreCase("QA4")) driver.get(Configuration.QA4);
			if(env.equalsIgnoreCase("STG1")) driver.get(Configuration.STG1);

			VisionLoginPage vlp = PageFactory.initElements(driver, VisionLoginPage.class);
			vlp.doLogin(DataTable.getCellData(TestCaseName, "UserName", 2),DataTable.getCellData(TestCaseName, "Password", 2));

			Description = "Pass";
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Passed");
			Assert.assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			Description = "Fail : "+e.getMessage();
			APPLICATION_LOGS.debug("Test Case: "+getTCName()+" Failed and error message is : "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
  
	
	
	
  @AfterTest
  	public void AfterMethod() throws IOException{
	  try{	
		  String ScreenShotPath = TestUtil.captureScreenshot(driver, getTCResult());
		  TestReports.addTestCase(getTCName(), 
				  startTime, 
				  TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),
				  Description.substring(0, 4), 	
				  ScreenShotPath,
				  Description);  
	  }catch(Exception e){
		  System.out.println(e.getMessage());
	  }
	  
  }
  
  
}