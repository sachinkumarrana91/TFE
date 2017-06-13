package testScripts;

import java.io.IOException;

import webPages.VisionLoginPage;
import testReports.TestReports;
import util.TestUtil;
import core.Core;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class VisionLogin extends Core{

	@BeforeTest
	public void beforeMethod(){
		startTime=TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");
	}

	@Test
	@Parameters({"env","user","SessionId","overrideLoginPage"})
	public void loginQA(String env, String user, String SessionId, String overrideLoginPage) {
		try{
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");

			driver.get("http://vis-"+env+"/vision/view");
			
			VisionLoginPage vlp = PageFactory.initElements(driver, VisionLoginPage.class);
			if(overrideLoginPage.equalsIgnoreCase("NO"))	vlp.doLogin(user,DataTable.getCellData(TestCaseName, "Password", DataTable.getCellRowNum(TestCaseName, "UserName", user)));
			else											vlp.doLogin(SessionId,env,"");

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