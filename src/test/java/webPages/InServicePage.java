package webPages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Core;
import config.Configuration;

public class InServicePage {
	
	
	WebDriver driver;
	
	public InServicePage(WebDriver driver) {
		this.driver = driver;
	}

	
	
	@FindBy(how = How.XPATH , using = Configuration.StyleOfBody)
	public WebElement StyleOfBody;
	
	@FindBy(how = How.XPATH , using = Configuration.OrderToDelivery)
	public WebElement OrderToDelivery;

	public ArrayList<String> al = new ArrayList<String>();
	
	
	
	public void openInServiceDateProgress(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		
		if(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span")).isDisplayed()){
			Core.isElementClickable(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span"))).click();
		}

		while(!StyleOfBody.getAttribute("style").contains("none")){}
		while(!driver.findElement(By.xpath("//*[@id='left']")).getAttribute("style").contains("display: block")){

			Core.isElementClickable(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span"))).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
		}

		//	check! Whether the OrderToDelivery is expanded or not
		if(!OrderToDelivery.getAttribute("aria-expanded").equalsIgnoreCase("true")){

			//	if not! click OrderToDelivery button
			Core.isElementVisible(OrderToDelivery).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
		}

		//	Click on Unit Progress Chasing link at side window
		Core.isElementClickable(driver.findElement(By.xpath("//*[@id='menuForm:j_idt19']//*[text()='Unit Progress Chasing']"))).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}

		//	Click on PurchaseOrderReleaseButton link at side window
		Core.isElementClickable(driver.findElement(By.xpath("//*[text()='In Service Date Progress']"))).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}
	}
	
	public void enterInService(String UnitNo){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		String message;
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='unitNoTxt']")).clear();
		driver.findElement(By.xpath("//*[@id='unitNoTxt']")).sendKeys(UnitNo);
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='filter']")).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}

		if(!driver.findElement(By.xpath("//*[@id='unitProgress_data']/tr[1]/td[1]")).getText().equalsIgnoreCase("No records found.")){

			while(!driver.findElement(By.xpath("//*[@id='updateInServiceDateDialog']")).getAttribute("aria-hidden").equalsIgnoreCase("false")){
				driver.findElement(By.xpath("//*[@id='unitProgress_data']/tr[1]/td[15]/a")).click();
				while(!StyleOfBody.getAttribute("style").contains("none")){}
			}
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			driver.findElement(By.xpath("//*[@id='InServiceDateCal_input']")).clear();
			String date = Core.DataTable.getCellData("PO_Detail", "In Service Date", Core.DataTable.getCellRowNum("PO_Detail", "UnitNoToMaintain", UnitNo));

			if(date.indexOf("-")>=0) date = date.replace("-", "");
			if(date.indexOf("/")>=0) date = date.replace("/", "");

			driver.findElement(By.xpath("//*[@id='InServiceDateCal_input']")).sendKeys(date);
			driver.findElement(By.xpath("//*[@id='inServiceOdoReading_input']")).clear();
			driver.findElement(By.xpath("//*[@id='inServiceOdoReading_input']")).sendKeys("16");
			driver.findElement(By.xpath("//*[@id='updateInServiceDateBtn']")).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			message = driver.findElement(By.xpath("//*[@id='messages']")).getText();
			if(message.contains("successfully")){
				al.add("<br> Unit# "+UnitNo+", "+message);
			}
			else{
				if(driver.findElement(By.xpath("//*[@id='updateInServiceDateDialog']")).getAttribute("aria-hidden").equalsIgnoreCase("false")){
					message = driver.findElement(By.xpath("//*[@id='inServiceMessages']")).getText();
					al.add("<br> <FONT COLOR=red>"+UnitNo+"</font>, "+message);
					driver.findElement(By.xpath("//*[@id='cancel']")).click();
					while(!StyleOfBody.getAttribute("style").contains("none")){}
				}
				else{
					al.add("<br> <FONT COLOR=red>"+UnitNo+"</font>, Not able to enter InService Date");
				}
			}			
			
		}
		else{
			al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Not Found");
			System.out.println("Unit# "+UnitNo+" Found with duplicate entries");
			//throw new NoSuchElementException("Duplicate entries for Unit No. "+UnitNo+" with the same number found on Purchase Order Release Page for ConfirmPO");
		}
	}

	
	
	
}
