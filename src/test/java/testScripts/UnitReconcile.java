package testScripts;

import java.io.IOException;

import webPages.UnitReconcilePage;
import testReports.TestReports;
import util.TestUtil;
import core.Core;
import util.Log;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class UnitReconcile extends Core{


	@BeforeClass
	public void addNewSheet(){
		DataTable.removeSheet("Unit_to_Reconcile_Output");
		DataTable.addSheet("Unit_to_Reconcile_Output");
		DataTable.setHeaderCell("Unit_to_Reconcile_Output", 0, "Unit");
		DataTable.setHeaderCell("Unit_to_Reconcile_Output", 1, "Unit_desc");
		DataTable.setHeaderCell("Unit_to_Reconcile_Output", 2, "VIN");
		DataTable.setHeaderCell("Unit_to_Reconcile_Output", 3, "Vendor");
		DataTable.setHeaderCell("Unit_to_Reconcile_Output", 4, "PO Amount_Shown");
		DataTable.setHeaderCell("Unit_to_Reconcile_Output", 5, "PON");
		DataTable.setHeaderCell("Unit_to_Reconcile_Output", 6, "INV_Entered");
		DataTable.setHeaderCell("Unit_to_Reconcile_Output", 7, "PO Amount_posted");
	}
	
	@BeforeTest
	public void beforeMethod(){
		startTime=TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");
	}

	@Test
	public void UntRec() {
		try{
			Log.info("log4j from xml file");
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");

			UnitReconcilePage urp = PageFactory.initElements(driver, UnitReconcilePage.class);
			urp.openUnitReconcilation();
			for(int i = 2; i <= DataTable.getRowCount("PO_Detail"); i++){
				urp.getPOforUnit(DataTable.getCellData("PO_Detail", "UnitNoToMaintain", i));
			}
			
			
			Description = "Pass";
			for(int j = 0 ; j< urp.al.size() ; j++){
				Description = Description.concat(urp.al.get(j));
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