package webPages;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Core;
import config.Configuration;

public class ThirdPartyProgressPage {
	
	WebDriver driver;
	public ArrayList<String> al = new ArrayList<String>();

	public ThirdPartyProgressPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = Configuration.StyleOfBody)
	public WebElement StyleOfBody;
	
	@FindBy(how = How.XPATH , using = Configuration.OrderToDelivery)
	public WebElement OrderToDelivery;

	@FindBy(how = How.XPATH , using = "//*[@id='menuForm:j_idt19']//*[text()='Unit Progress Chasing']")
	public WebElement UnitProcessingChasing;
	
	public void openThirdPartyProgress(){
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
		Core.isElementClickable(driver.findElement(By.xpath("//*[@id='inputPanel_content']/table//*[text()='Third Party Progress']"))).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}
	
	}

	public void releaseThirdParty(String UnitNo){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='unitNoTxtId']")).clear();
		driver.findElement(By.xpath("//*[@id='unitNoTxtId']")).sendKeys(UnitNo);
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='filter']")).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		
		if(driver.findElements(By.xpath("//*[@id='DT_UI_ID_data']//td[2]/span[contains(text(),'"+UnitNo+"')]")).size()==1){
			driver.findElement(By.xpath("//*[@id='DT_UI_ID_data']//td[2]/span[contains(text(),'"+UnitNo+"')]")).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			int DA_Count = driver.findElements(By.xpath(".//*[@id='DT_UI_ID_data']//td[2]/span[contains(text(),'"+UnitNo+"')]/parent::*/following-sibling::td[2]//a")).size();
			if(DA_Count != 1){
				Core.isElementClickable(driver.findElement(By.xpath("//*[@id='upfitLogisticsBtn']"))).click();
				while(!StyleOfBody.getAttribute("style").contains("none")){}
				while(driver.findElements(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']//td[1]/a[1]")).size()!=DA_Count){
					for(int i = 1; i<=DA_Count; i++){
						if(!driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[3]//label")).getText().equals(" ")){
							System.out.println("start"+driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[3]//label")).getText()+"end");
							driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[3]/div")).click();
							while(!StyleOfBody.getAttribute("style").contains("none")){}
							driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT:1:j_idt85_items']/li[1]")).click();
							while(!StyleOfBody.getAttribute("style").contains("none")){}
						}
					}
					
				}

				while(driver.findElements(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']//td[1]/a[1]")).size()!= 0 ){
					for(int i = 2; i <=DA_Count ; i++){
						while(driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[3]//label")).getText().equals(" ") && 
								driver.findElements(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT:"+(i-1)+":j_idt85_items']/li")).size() > 1){
							driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT_data']/tr["+i+"]/td[3]/div")).click();
							while(!StyleOfBody.getAttribute("style").contains("none")){}
							driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressDT:"+(i-1)+":j_idt85_items']/li[2]")).click();
							while(!StyleOfBody.getAttribute("style").contains("none")){}
						}
					}
			
				}
				driver.findElement(By.xpath("//*[@id='ccUpfitProgress:ccUpfitProgressSaveBtn']")).click();
				while(!StyleOfBody.getAttribute("style").contains("none")){}
			}
			
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			Core.isElementClickable(driver.findElement(By.xpath("//*[@id='releasePOBtn']"))).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			if(driver.findElements(By.xpath("//*[@id='documentListDialog:documentListDT_data']")).size()!=0 && driver.findElement(By.xpath("//*[@id='documentListDialog:documentListDT_data']")).isDisplayed()){
				for(int i= 1 ; i <= driver.findElements(By.xpath("//*[@id='documentListDialog:documentListDT_data']/tr")).size() ; i++){
					if(driver.findElement(By.xpath("//*[@id='documentListDialog:documentListDT_data']/tr["+i+"]/td[2]//a")).getText().equalsIgnoreCase("View")){
						driver.findElement(By.xpath("//*[@id='documentListDialog:documentListDT_data']/tr["+i+"]/td[2]//a")).click();
						while(!(StyleOfBody.getAttribute("style").contains("none")) && 
								!(driver.findElement(By.xpath("//*[@id='documentListDialog:documentListDT_data']"+"/tr["+i+"]/td[3]//img")).getAttribute("id").contains("ccCheckMarkImg"))){}
						while(!StyleOfBody.getAttribute("style").contains("none")){}
					}
				}
				driver.findElement(By.xpath("//*[@id='documentListDialog:ccDoneBtn']/span")).click();;
			}
			al.add("<br> Unit# "+UnitNo+" has been released");
			while(!StyleOfBody.getAttribute("style").contains("none")){}
		}
		else{
			if(driver.findElements(By.xpath("//*[@id='DT_UI_ID_data']//td[2]/span[contains(text(),'"+UnitNo+"')]")).size()==0){
				al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Not Found");
				System.out.println("Unit# "+UnitNo+" Not Found ");
			}
				
			else{
				al.add("<br> Unit# "+UnitNo+" Found with multiple entries");
				System.out.println("Unit# <FONT COLOR=red>"+UnitNo+"</font> Found with multiple entries");
			}
		}
	}
	
}
