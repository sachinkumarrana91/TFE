package webPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.Core;
import config.Configuration;

public class UpfitProgressPage {
	
	WebDriver driver;
	public ArrayList<String> al = new ArrayList<String>();
	public static Robot robot;
	public UpfitProgressPage(WebDriver driver) throws AWTException {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = Configuration.StyleOfBody)
	public WebElement StyleOfBody;
	
	@FindBy(how = How.XPATH , using = Configuration.OrderToDelivery)
	public WebElement OrderToDelivery;

	@FindBy(how = How.XPATH , using = "//*[@id='menuForm:j_idt19']//*[text()='Unit Progress Chasing']")
	public WebElement UnitProcessingChasing;
	
	public void openUpfitProgress(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");

		while(!StyleOfBody.getAttribute("style").contains("none")){}
		if(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span")).isDisplayed()){
			Core.isElementClickable(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span"))).click();
		}

		while(!StyleOfBody.getAttribute("style").contains("none")){}
		while(!driver.findElement(By.xpath("//*[@id='left']")).getAttribute("style").contains("display: block")){
			Core.isElementClickable(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span"))).click();
		}

		while(!StyleOfBody.getAttribute("style").contains("none")){}
		if(!OrderToDelivery.getAttribute("aria-expanded").equalsIgnoreCase("true")){
		Core.isElementVisible(OrderToDelivery).click();
		}

		while(!StyleOfBody.getAttribute("style").contains("none")){}

		Core.isElementClickable(driver.findElement(By.xpath("//*[@id='menuForm:j_idt19']//*[text()='Unit Progress Chasing']"))).click();

		while(!StyleOfBody.getAttribute("style").contains("none")){}
		Core.isElementClickable(driver.findElement(By.xpath("//*[@id='inputPanel_content']/table//*[text()='Upfit Progress']"))).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}
	
	}

	public void processUnit(String UnitNo) throws ParseException{
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='unitNoTxt']")).clear();
		driver.findElement(By.xpath("//*[@id='unitNoTxt']")).sendKeys(UnitNo);
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='filter']")).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		if(driver.findElements(By.xpath("//*[@id='unitProgress_data']//td[3]//span[text()='"+UnitNo+"']")).size()==1){
			String todaysDate = new SimpleDateFormat("MMddyyyy").format(Calendar.getInstance().getTime());
			String date;
			String dateToEnter;
			while(driver.findElements(By.xpath("//*[@id='unitProgress_data']//td[3]//span[text()='"+UnitNo+"']")).size()!=0){
				int checkCount = driver.findElements(By.xpath("//*[@id='unitProgress_data']//td[3]//span[text()='"+UnitNo+"']/ancestor::td[@role='gridcell']/following-sibling::td[2]/span/img[@title='Work complete']")).size();
				driver.findElement(By.xpath("//*[@id='unitProgress_data']//td[3]//span[text()='"+UnitNo+"']")).click();
				while(!StyleOfBody.getAttribute("style").contains("none")){}
				driver.findElement(By.xpath("//button/span[text()='Vendor Sequence']")).click();
				while(!driver.findElement(By.id("ccUpfitProgress:ccUpfitProgressDialog")).getAttribute("style").contains("block") && !StyleOfBody.getAttribute("style").contains("none")){}
				int i = checkCount+1;
				if(i==1){																																									//First Row
					if(driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[4]/span/input")).getAttribute("class").contains("ui-state-disabled")){	//First Column has a date
						date = driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[4]/span/input")).getAttribute("value").replace("/", "");

						if(Core.daysDifferance(todaysDate, date)<9)		dateToEnter = Core.addDaystoDate(todaysDate, -1);
						else											dateToEnter = Core.addDaystoDate(date, +7);

						driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[5]//input")).sendKeys(dateToEnter);
					}
					else
						{																																									//First Column is blank
							date = Core.addDaystoDate(todaysDate, -60);
							driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[4]//input")).clear();
							driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[4]//input")).sendKeys(date);
						}
					}
				else{																																										//Other than first row
					if(driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[4]/span/input")).getAttribute("class").contains("ui-state-disabled")){	//First Column has a date
						date = driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[4]/span/input")).getAttribute("value").replace("/", "");

						if(Core.daysDifferance(todaysDate, date)<9)		dateToEnter = Core.addDaystoDate(todaysDate, -1);
						else											dateToEnter = Core.addDaystoDate(date, +7);

						driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[5]//input")).sendKeys(dateToEnter);
					}
					else																																									//First Column is blank
						{
						date = driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+(i-1)+"]/td[5]/span/input")).getAttribute("value").replace("/", "");

						if(Core.daysDifferance(todaysDate, date)<9)		dateToEnter = Core.addDaystoDate(todaysDate, -1);
						else											dateToEnter = Core.addDaystoDate(date, +7);

						driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[4]//input")).sendKeys(dateToEnter);
						}
				}
				while(!StyleOfBody.getAttribute("style").contains("none")){}
				driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressSaveBtn']")).click();
				while(driver.findElement(By.id("ccUpfitProgress:ccUpfitProgressDialog")).getAttribute("style").contains("block")){}
				while(!StyleOfBody.getAttribute("style").contains("none")){}
				
			}
				
			al.add("<br> For Unit# "+UnitNo+" UpFit has complete");
		}
		else{
			if(driver.findElements(By.xpath("//*[@id='unitProgress_data']//td[3]//span[text()='"+UnitNo+"']")).size()==0){
				al.add("<br> Unit# "+UnitNo+" not found for UpFit");
			}
			else{
				al.add("<br> Unit# "+UnitNo+" multiple records found for UpFit");
			}
			
		}
	
	
	
	
	
	}
			
			
			
			
			
			
			
			
			
			
			
}