package webPages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

public class VehicleOrderStatusPage {
	
	WebDriver driver;
	public ArrayList<String> al = new ArrayList<String>();

	public VehicleOrderStatusPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = "//*[@id='menuForm:j_idt19']//*[text()='Rental Calculation']")
	public WebElement RentalCalculation;
	
	@FindBy(how = How.XPATH , using = Configuration.StyleOfBody)
	public WebElement StyleOfBody;

	@FindBy(how = How.XPATH , using = Configuration.OrderToDelivery)
	public WebElement OrderToDelivery;
	
	public void openVehicleOrderStatus(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		
		//Expand left Bar
		if(driver.findElement(By.xpath("//*[@id='left-toggler']/span")).getAttribute("style").contains("display: block")){
			while(driver.findElement(By.xpath("//*[@id='left-toggler']/span")).getAttribute("style").contains("display: block")){
				Core.isElementClickable(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span"))).click();
			}
		}
		while(!StyleOfBody.getAttribute("style").contains("none")){}

		//	check! Whether the OrderToDelivery is expanded or not
		if(!OrderToDelivery.getAttribute("aria-expanded").equalsIgnoreCase("true")){

			//	if not! click OrderToDelivery button
			Core.isElementVisible(OrderToDelivery).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
		}

		//	Click on Vehicle Order Status link at side window
		Core.isElementClickable(driver.findElement(By.xpath("//*[@id='menuForm:j_idt19']//*[text()='Vehicle Order Status']"))).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}
	}

	public void enterStatus(String Unit) throws InterruptedException{
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");

		//	Enter Unit No
		Core.isElementVisible(driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:searchUnitNo']"))).clear();
		driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:searchUnitNo']")).sendKeys(Unit);

		//	Click Search Button
		Core.isElementVisible(driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:searchVehicleOrderStatusBtn']"))).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		if(driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:ccVehicleOrderStatusDataTableId_data']/tr[1]/td[1]")).getText().equalsIgnoreCase("No records found")){
			al.add("<br> Unit# "+Unit+" does not have any PO to process");
		}
		else{
			//*[@id='maintainVehicleOrderStatusCCId:ccVehicleOrderStatusDataTableId']/div[1]/a/img
			//*[@id='maintainVehicleOrderStatusCCId:ccVehicleOrderStatusDataPanel1_content']//*[text()='15_RECEIVD']
			while(!(driver.findElements(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:ccVehicleOrderStatusDataTableId:0:configCode']//label[text()='Please Select']")).size()>0)){
				driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:ccVehicleOrderStatusDataTableId']/div[1]/a/img")).click();	
				while(!StyleOfBody.getAttribute("style").contains("none")){}
			}
			while(!(driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:ccVehicleOrderStatusDataTableId:0:configCode_panel']")).getAttribute("style").contains("display: block"))){
				driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:ccVehicleOrderStatusDataTableId:0:configCode']//label[text()='Please Select']")).click();
				while(!StyleOfBody.getAttribute("style").contains("none")){}
			}
			driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:ccVehicleOrderStatusDataTableId:0:configCode_items']//*[text()='15_RECEIVD']")).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}

			driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:ccVehicleOrderStatusDataTableId:0:startDateCal_input']")).sendKeys(new SimpleDateFormat("MMddyyyy").format(Calendar.getInstance().getTime()));
			while(!StyleOfBody.getAttribute("style").contains("none")){}

			driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:ccVehicleOrderStatusDataTableId:0:j_idt152']")).sendKeys("QA-Manual");
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			
			driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:ccVehicleOrderStatusDataTableId:0:j_idt161']")).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			String message = driver.findElement(By.xpath("//*[@id='maintainVehicleOrderStatusCCId:dialogErrorMsgID']")).getText();
			
			al.add("<br> For "+Unit+", "+message+" with 15_RECEIVD");
		}
	}
	
	
	
}
