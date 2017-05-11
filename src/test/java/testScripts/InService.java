package testScripts;

import java.io.IOException;

import webPages.InServicePage;
import webPages.UnitProgressChasingPage;
import testReports.TestReports;
import util.TestUtil;
import core.Core;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class InService extends Core{


	@BeforeClass
	@Parameters({"env"})
	public static void refresh(String env){

/* 		int i = Core.DataTable.getCellRowNum("loginQA", "dbName", env);

		try {
			util.DBUtills.refreshQueue(
					DataTable.getCellData("loginQA", "IP", i),
					DataTable.getCellData("loginQA", "Port", i),
					DataTable.getCellData("loginQA", "dbName", i),
					DataTable.getCellData("loginQA", "UN", i),
					DataTable.getCellData("loginQA", "PW", i)
					);
		} catch (Exception e) {
			System.out.println("Something went worg while running the job at back-end at environment: "+	DataTable.getCellData("loginQA", "dbName", 3));
			e.printStackTrace();
		}
*/
		
	}
	
	
	
	@BeforeMethod
	public void beforeMethod(){
		startTime=TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");
		
	}

 
	@Test (priority = 1, enabled = true)
	public void enterInServiceDate() {
		try{
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");
			
			InServicePage ipp = PageFactory.initElements(driver, InServicePage.class);
			ipp.openInServiceDateProgress();
			for(int i = 2; i <= DataTable.getRowCount("PO_Detail"); i++){
				ipp.enterInService(DataTable.getCellData("PO_Detail", "UnitNoToMaintain", i));
			}
			
			
			Description = "Pass";
			for(int j = 0 ; j< ipp.al.size() ; j++){
				Description = Description.concat(ipp.al.get(j));
			}
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Passed");
			Assert.assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			Description = "Fail : "+e.getMessage();
			APPLICATION_LOGS.debug("Test Case: "+getTCName()+" Failed and error message is : "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	
  @AfterMethod
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