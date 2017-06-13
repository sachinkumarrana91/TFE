package testScripts;

import java.io.IOException;

import webPages.UpfitProgressPage;
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
import org.testng.annotations.BeforeClass;


public class UpfitProgress extends Core{

	@BeforeClass
	@Parameters({"env"})
	public static void refresh(String env){

		Boolean b = false;
		for(int i = 2; i <= DataTable.getRowCount("PO_Detail"); i++){
			if(!DataTable.getCellData("PO_Detail", "DA?", i).equalsIgnoreCase("1")){
				b= true;
			}
		}		
		
		
		if(b==true){
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

	}

	
	@BeforeTest
	public void beforeMethod(){
		startTime=TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");
	}

	@Test
	public void UpfitProgressTest() {
		try{
			Log.info("log4j from xml file");
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");

			UpfitProgressPage upp = PageFactory.initElements(driver, UpfitProgressPage.class);
			upp.openUpfitProgress();
			for(int i = 2; i <= DataTable.getRowCount("PO_Detail"); i++){
				if(!DataTable.getCellData("PO_Detail", "DA?", i).equalsIgnoreCase("1")){
					upp.processUnit(DataTable.getCellData("PO_Detail", "UnitNoToMaintain", i));
				}
				else{
					upp.al.add("<br> Unit# <FONT COLOR=red>"+DataTable.getCellData("PO_Detail", "UnitNoToMaintain", i)+"</font> have no Dealer Accessory");
				}
			}

			Description = "Pass";
			for(int j = 0 ; j< upp.al.size() ; j++){
				Description = Description.concat(upp.al.get(j));
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