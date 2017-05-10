package webPages;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Core;
import config.Configuration;

public class UnitReconcilePage {
	
	WebDriver driver;
	public ArrayList<String> al = new ArrayList<String>();

	public UnitReconcilePage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = "//*[@id='menuForm:j_idt19']//*[text()='Rental Calculation']")
	public WebElement RentalCalculation;
	
	@FindBy(how = How.XPATH , using = "//*[@id='menuForm:j_idt19']//*[text()='Unit Reconciliation']")
	public WebElement UnitReconciliation;
	
	@FindBy(how = How.XPATH , using = "//*[@id='unit']")
	public WebElement UnitNo;

	@FindBy(how = How.XPATH , using = "//*[@id='search']")
	public WebElement Search;

	@FindBy(how = How.XPATH , using = "//*[@id='dvQuickModal']")
	public WebElement StyleOfBody;

	@FindBy(how = How.XPATH , using = "//*[@id='processButton']")
	public WebElement Process;

	@FindBy(how = How.XPATH , using = "//*[@id='invoiceNumber']")
	public WebElement InvoiceNumber;

	@FindBy(how = How.XPATH , using = "//*[@id='invoiceAmount_input']")
	public WebElement InvoiceAmount;

	@FindBy(how = How.XPATH , using = "//*[@id='nextBtn']")
	public WebElement Next;
	
	@FindBys( {
		   @FindBy(how = How.ID , using = Configuration.OK)
	})
	public List<WebElement> OK;

	@FindBy(how = How.ID , using = Configuration.OK)
	public WebElement OKAccept;

	@FindBy(how = How.XPATH , using = "//*[@id='post']")
	public WebElement PostInvoice;
	
	@FindBy(how = How.XPATH , using = "//*[@id='okBtn']/span[text()='Post']")
	public WebElement PostPopUp;
	
	@FindBy(how = How.XPATH , using = "//*[@id='messages']")
	public WebElement Message;
	
	
	public void openUnitReconcilation(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");

		if(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span")).isDisplayed()){
			Core.isElementClickable(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span"))).click();
		}
		while(!driver.findElement(By.xpath("//*[@id='left']")).getAttribute("style").contains("display: block")){
			Core.isElementClickable(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span"))).click();
		}

		
		if(!RentalCalculation.getAttribute("aria-expanded").equalsIgnoreCase("true")){
			Core.isElementVisible(RentalCalculation).click();
		}
		Core.isElementClickable(UnitReconciliation).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}
	}

	public void getPOforUnit(String Unit) throws InterruptedException{
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");

		Core.isElementVisible(UnitNo).clear();
		UnitNo.sendKeys(Unit);
		Core.isElementVisible(Search).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		if(driver.findElement(By.xpath("//*[@id='resultsTable_data']/tr[1]/td[1]")).getText().equalsIgnoreCase("No Records Found")){
			al.add("<br> Unit# "+Unit+" does not have any PO to process");
		}
		else
		processPO(Unit);
		
	}
	
	public void processPO(String Unit) throws InterruptedException{
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		
		//	Count the un-posted POs on UNTREC for the given unit
		int i = Core.DataTable.getRowCount("Unit_to_Reconcile_Output");
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		while(!driver.findElement(By.xpath("//*[@id='resultsTable_data']/tr[1]/td[1]")).getText().equalsIgnoreCase("No Records Found")){
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			String actualAmount;// = (""+Math.abs((Math.random()*100))+"").substring(0,(""+Math.abs((Math.random()*100))+"").lastIndexOf('.')+3);
			String PONum;
			i++;
			
			//	Get the description of selected PO
			String PO = driver.findElement(By.xpath("//*[@id='resultsTable_data']/tr[1]/td[1]")).getText();

			Core.DataTable.setCellData("Unit_to_Reconcile_Output", "Unit", 				i, Unit);
			Core.DataTable.setCellData("Unit_to_Reconcile_Output", "Unit_desc", 		i, PO);
			Core.DataTable.setCellData("Unit_to_Reconcile_Output", "VIN", 				i, driver.findElement(By.xpath("//*[@id='resultsTable_data']/tr[1]/td[2]")).getText());
			Core.DataTable.setCellData("Unit_to_Reconcile_Output", "Vendor", 			i, driver.findElement(By.xpath("//*[@id='resultsTable_data']/tr[1]/td[3]")).getText());

			//	Get the give amount for the selected PO
			String PO_Amount_Shown = driver.findElement(By.xpath("//*[@id='resultsTable_data']/tr[1]/td[4]")).getText();
			Core.DataTable.setCellData("Unit_to_Reconcile_Output", "PO Amount_Shown", 	i, PO_Amount_Shown);

			//	Click on first(Top most) PO
			driver.findElement(By.xpath("//*[@id='resultsTable_data']/tr[1]/td[1]")).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}

			//	Click on process for the selected PO
			Process.click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}

			//	Get the PON number
			PONum = driver.findElement(By.xpath("//*[@id='j_idt40' or text()='PO Number:']/following::td[2]")).getText();

			Core.DataTable.setCellData("Unit_to_Reconcile_Output", "PON", 				i, PONum);

			//	Clear the Invoice Number
			InvoiceNumber.clear();
			//System.out.println("INV"+PONum.substring(PONum.indexOf('N')+1,11));;

			//	Enter the Invoice Number
			InvoiceNumber.sendKeys("INV"+PONum.substring(PONum.indexOf('N')+1,11));

			Core.DataTable.setCellData("Unit_to_Reconcile_Output", "INV_Entered", 		i, "INV"+PONum.substring(PONum.indexOf('N')+1,11));

			//	Clear the Invoice Amount
			InvoiceAmount.clear();
			if(PO_Amount_Shown.equalsIgnoreCase("$0.00")){
				actualAmount = (""+Math.abs((Math.random()*100))+"").substring(0,(""+Math.abs((Math.random()*100))+"").lastIndexOf('.')+3);
			}
			else{
				actualAmount = PO_Amount_Shown;
			}
			InvoiceAmount.sendKeys(actualAmount);
			Next.click();
			
			//	Handle VIN Pop-ups
			Core.handleVINpopup();

			if(PO_Amount_Shown.equalsIgnoreCase("$0.00")){																	// Amount was 0 ? than 
				driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//span/input")).clear();
				driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//span/input")).sendKeys(actualAmount);
			}
				
			while(!StyleOfBody.getAttribute("style").contains("none")){}

			if(driver.findElements(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Base Vehicle']/parent::*/following-sibling::td[6]/span/input")).size()>1){		//	Works for Main PO only, because Base Vehicle would be enable for main PO only.
				String prev_BaseVehicleAmount = driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Base Vehicle']/parent::*/following-sibling::td[6]/span/input")).getAttribute("value");
				String prev_BaseVehicleAmountClient = driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Base Vehicle']/parent::*/following-sibling::td[9]")).getAttribute("value");
				if(prev_BaseVehicleAmount.indexOf(".")>=0){ 	// If value is not an integer
					prev_BaseVehicleAmount = prev_BaseVehicleAmount.substring(0, prev_BaseVehicleAmount.lastIndexOf("."));		// Make it integer
				}
				if(prev_BaseVehicleAmount.indexOf(",")>=0){ 	// is having comma i.e ","
					prev_BaseVehicleAmount = prev_BaseVehicleAmount.replace(",", "");
				}
				
				// Enter new amount to the Base Vehicle (i.e. Previous + 100.00 $)
				long new_BaseVehicleAmount = util.TestUtil.strToInt(prev_BaseVehicleAmount) + 100;
				//System.out.println(new_BaseVehicleAmount);
				driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Base Vehicle']/parent::*/following-sibling::td[6]/span/input")).clear();
				WebElement e = driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Base Vehicle']/parent::*/following-sibling::td[6]/span/input"));
				//e.sendKeys("$"+new_BaseVehicleAmount+".00");
				e.sendKeys(""+new_BaseVehicleAmount+"");
				driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Base Vehicle']/parent::*/following-sibling::td[4]")).click();
				//e.sendKeys(Keys.TAB);
				
				//	Update Base Vehile for client
				if(driver.findElements(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Base Vehicle']/parent::*/following-sibling::td[9]/span/input")).size()>0){
					if(prev_BaseVehicleAmountClient.indexOf(".")>=0){ 	// If value is not an integer
						prev_BaseVehicleAmountClient = prev_BaseVehicleAmountClient.substring(0, prev_BaseVehicleAmountClient.lastIndexOf("."));		// Make it integer
					}
					if(prev_BaseVehicleAmountClient.indexOf(",")>=0){ 	// is having comma i.e ","
						prev_BaseVehicleAmountClient = prev_BaseVehicleAmountClient.replace(",", "");
					}
					
					// Enter new amount to the Base Vehicle (i.e. Previous + 100.00 $)
					long new_BaeVehicleAmountClient = util.TestUtil.strToInt(prev_BaseVehicleAmountClient) + 200;
					driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Base Vehicle']/parent::*/following-sibling::td[9]/span/input")).clear();
					e = driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Base Vehicle']/parent::*/following-sibling::td[9]/span/input"));
					e.sendKeys("$"+new_BaeVehicleAmountClient+".00");
					driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Base Vehicle']/parent::*/following-sibling::td[4]")).click();
					//e.sendKeys(Keys.TAB);
				}

				
				//	Update reclaims only if they are enables and value is $0.00
				String claim_Name_Array[] = {"VRB Reclaim","Price Protection - Client","Price Protection - Mike Albert","MAL Incentive Money - Reclaim","Reclaim Incentives - Dealer","Reclaim Incentives - Manufacturer","Early Order Incentive"};
				long lastClaim = 0;
				
				for(String claim_Name : claim_Name_Array){
					if(driver.findElements(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='"+claim_Name+"']")).size()==1
							&&	driver.findElements(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='"+claim_Name+"']/parent::*/following-sibling::td[6]/span/input")).size()>0
							&&	driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='"+claim_Name+"']/parent::*/following-sibling::td[6]/span/input[2]")).getAttribute("value").equalsIgnoreCase("0")
							){
						driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='"+claim_Name+"']/parent::*/following-sibling::td[6]/span/input")).clear();
						lastClaim = lastClaim + 100 ;
						driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='"+claim_Name+"']/parent::*/following-sibling::td[6]/span/input")).sendKeys(""+lastClaim+"");
						driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='"+claim_Name+"']/parent::*/following-sibling::td[4]")).click();
					}
				}				
				
			
			}
			//	Update CD Fee if it was not $0.00 initially
			else
				if(!PO_Amount_Shown.equalsIgnoreCase("$0.00"))
					if(driver.findElements(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Courtesy Delivery Fee']")).size()==1
					&&	driver.findElements(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Courtesy Delivery Fee']/parent::*/following-sibling::td[6]/span/input")).size()>0
					){
						String prev_CDFee = driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Courtesy Delivery Fee']/parent::*/following-sibling::td[6]/span/input")).getAttribute("value");
						if(prev_CDFee.indexOf(".")>=0){ 	// If value is not an integer
							prev_CDFee = prev_CDFee.substring(0, prev_CDFee.lastIndexOf("."));		// Make it integer
						}
						if(prev_CDFee.indexOf(",")>=0){ 	// is having comma i.e ","
							prev_CDFee = prev_CDFee.replace(",", "");
						}
						
						// Enter CD Fee
						long new_CDFee = util.TestUtil.strToInt(prev_CDFee) + 75;
						driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Courtesy Delivery Fee']/parent::*/following-sibling::td[6]/span/input")).clear();
						WebElement e = driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Courtesy Delivery Fee']/parent::*/following-sibling::td[6]/span/input"));
						e.sendKeys(""+new_CDFee+"");
						driver.findElement(By.xpath("//*[@id='capitalCostDatatableTable_data']//*[text()='Courtesy Delivery Fee']/parent::*/following-sibling::td[4]")).click();
						
					}
			
			PostInvoice.click();
			while(!driver.findElement(By.id("confirmDialogId")).getAttribute("style").contains("block")){}
			//System.out.println(driver.findElement(By.xpath("//*[@id='confirmDialogForm']")).getText());
				
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			if(driver.findElement(By.xpath("//*[@id='confirmDialogForm']")).getText().contains("do not match the Invoice Amount")){
				actualAmount = driver.findElement(By.xpath("//*[@id='confirmDialogForm']//*[text()='Invoice Details:']/following::td/span")).getText();
				driver.findElement(By.xpath("//*[@id='okBtnId2']")).click();
				while(!StyleOfBody.getAttribute("style").contains("none")){}
				driver.findElement(By.xpath("//*[@id='j_idt34']//a/span[text()='Invoice Entry']")).click();
				while(!StyleOfBody.getAttribute("style").contains("none")){}
				InvoiceAmount.clear();
				InvoiceAmount.sendKeys(actualAmount);
				Next.click();
				
				//	Handle VIN Pop-ups
				Core.handleVINpopup();

				PostInvoice.click();
				while(!driver.findElement(By.id("confirmDialogId")).getAttribute("style").contains("block")){}
			}

			PostPopUp.click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			//System.out.println(PONum+" for "+Unit+" "+Message.getText());

			Core.DataTable.setCellData("Unit_to_Reconcile_Output", "PO Amount_posted", 	i, actualAmount);

			driver.findElement(By.xpath("//*[@id='j_idt34']//a/span[text()='Unit Reconciliation']")).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			al.add("<br> Unit# "+Unit+" with PO "+PONum+" has been to processed");
	
		}	
	}
	
	
	
}
