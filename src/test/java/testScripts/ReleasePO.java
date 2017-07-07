package testScripts;

import java.io.IOException;
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


public class ReleasePO extends Core{


	@BeforeClass
	@Parameters({"env"})
	public static void refresh(String env){

 		int i = Core.DataTable.getCellRowNum("loginQA", "dbName", env);

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

		
	}
	
	
	
	@BeforeMethod
	public void beforeMethod(){
		startTime=TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");
		
	}

 
	@Test (priority = 1, enabled = true)
	public void openPurchaseOrderRelease() {
		try{
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");
			
			UnitProgressChasingPage upc = PageFactory.initElements(driver, UnitProgressChasingPage.class);
			upc.clickPurchaseOrderReleaseButton();
			
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
	
	@Test (priority = 2, enabled = true)
	public void savePO() {
		try{
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");
			
			UnitProgressChasingPage upc = PageFactory.initElements(driver, UnitProgressChasingPage.class);
			
			for(int i = 2; i <= DataTable.getRowCount("PO_Detail"); i++){
				//upc.searchUnitnMaintainPO(DataTable.getCellData("PO_Detail", "UnitNoToMaintain", i));
				upc.savePO(DataTable.getCellData("PO_Detail", "UnitNoToMaintain", i), "AAAAAAAAAAAAAAAAA", "00042884", "Pool");
			}
			
			Description = "Pass";
			for(int j = 0 ; j< upc.al.size() ; j++){
				Description = Description.concat(upc.al.get(j));
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
	
	@Test (priority = 3, enabled = true)
	public void releasePO() {
		try{
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");
			
			UnitProgressChasingPage upc = PageFactory.initElements(driver, UnitProgressChasingPage.class);
			for(int i = 2; i <= DataTable.getRowCount("PO_Detail"); i++){
				upc.releasePO(DataTable.getCellData("PO_Detail", "UnitNoToMaintain", i));
			}

			Description = "Pass";
			for(int j = 0 ; j< upc.al.size() ; j++){
				Description = Description.concat(upc.al.get(j));
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
	
	@Test (priority = 4, enabled = true)
	public void confirmPO() {
		try{
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");
			
			UnitProgressChasingPage upc = PageFactory.initElements(driver, UnitProgressChasingPage.class);
			for(int i = 2; i <= DataTable.getRowCount("PO_Detail"); i++){
				upc.confirmPO(DataTable.getCellData("PO_Detail", "UnitNoToMaintain", i));
			}
			
			Description = "Pass";
			for(int j = 0 ; j< upc.al.size() ; j++){
				Description = Description.concat(upc.al.get(j));
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