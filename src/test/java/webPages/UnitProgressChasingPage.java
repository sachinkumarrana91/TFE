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

public class UnitProgressChasingPage {
	
	
	WebDriver driver;
	
	public UnitProgressChasingPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = Configuration.PurchaseOrderReleaseButton)
	public WebElement PurchaseOrderReleaseButton;
	
	@FindBy(how = How.XPATH , using = Configuration.UnitNoInput)
	public WebElement UnitNoInput;
	
	@FindBy(how = How.XPATH , using = Configuration.SearchButton)
	public WebElement SearchButton;
	
	public String UnitNo = Configuration.UnitNo;
	
	@FindBy(how = How.XPATH , using = Configuration.maintainPOButton)
	public WebElement maintainPOButton;
	
	@FindBy(how = How.XPATH , using = Configuration.StyleOfBody)
	public WebElement StyleOfBody;
	
	@FindBy(how = How.XPATH , using = Configuration.VINTextField)
	public WebElement VINTextField;
	
	@FindBy(how = How.XPATH , using = Configuration.DeliveringDealerTextField)
	public WebElement DeliveringDealerTextField;
	
	@FindBy(how = How.XPATH , using = Configuration.SaveButton)
	public WebElement SaveButton;
	
	@FindBys( {
		   @FindBy(how = How.ID , using = Configuration.OK)
	})
	public List<WebElement> OK;

	@FindBy(how = How.ID , using = Configuration.OK)
	public WebElement OKAccept;
	
	@FindBy(how = How.XPATH , using = Configuration.AcquisitionType)
	public WebElement AcquisitionType;
	
	public String SelectAcquisitionType = Configuration.SelectAcquisitionType;
	
	@FindBy(how = How.XPATH , using = Configuration.ReleasePOBtn)
	public WebElement ReleasePOBtn;
	
	@FindBy(how = How.XPATH , using = Configuration.ConfirmPOBtn)
	public WebElement ConfirmPOBtn;
	
	@FindBy(how = How.XPATH , using = Configuration.OrderingLeadTime)
	public WebElement OrderingLeadTime;

	public String DocumentList = Configuration.DocumentList;

	public String message = Configuration.message;

	@FindBy(how = How.XPATH , using = Configuration.OrderToDelivery)
	public WebElement OrderToDelivery;

	@FindBy(how = How.XPATH , using = "//*[@id='menuForm:j_idt19']//*[text()='Unit Progress Chasing']")
	public WebElement UnitProcessingChasing;

	public ArrayList<String> al = new ArrayList<String>();
	
	
	
	public void clickPurchaseOrderReleaseButton(){
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
			while(!OrderToDelivery.getAttribute("aria-expanded").equalsIgnoreCase("true")){
				while(!StyleOfBody.getAttribute("style").contains("none")){}
				Core.isElementVisible(OrderToDelivery).click();
				while(!StyleOfBody.getAttribute("style").contains("none")){}
			}
		}
		//	Click on Unit Progress Chasing link at side window
		Core.isElementClickable(driver.findElement(By.xpath("//*[@id='menuForm:j_idt19']//*[text()='Unit Progress Chasing']"))).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}

		//	Click on PurchaseOrderReleaseButton link at side window
		Core.isElementClickable(PurchaseOrderReleaseButton).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}
	}
	

	public void savePO(String UnitNo,String VIN, String DealerCode, String SelectAcquisitionType) throws InterruptedException{
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		while(!StyleOfBody.getAttribute("style").contains("none")){}

		//	Enter Unit No
		driver.findElement(By.xpath("//*[@id='unitNoTxtId']")).clear();
		driver.findElement(By.xpath("//*[@id='unitNoTxtId']")).sendKeys(UnitNo);
		while(!StyleOfBody.getAttribute("style").contains("none")){}

		//	Click Search for the entered Unit No.
		driver.findElement(By.xpath("//*[@id='filter']")).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}

		if(driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==1){
			
			//	Select Unit
			Core.isElementClickable(driver.findElement(By.xpath(this.UnitNo+UnitNo+"')]"))).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}

			//	Click MaintainPO
			Core.isElementClickable(maintainPOButton).click();
			al.add("<br> Unit# "+UnitNo+" Found to proceed");

			//	Enter VIN
			Core.isElementVisible(VINTextField).clear();
			Core.isElementVisible(VINTextField).sendKeys(VIN);

			//	Enter Dealer Code
			Core.isElementVisible(DeliveringDealerTextField).clear();
			Core.isElementVisible(DeliveringDealerTextField).sendKeys(DealerCode);

			//	Click Acquisition Type Drop-down
			while(!driver.findElement(By.xpath(this.SelectAcquisitionType)).isDisplayed()){
			Core.isElementClickable(AcquisitionType).click();
			}
			//	Select Acquisition Type
			Core.isElementClickable(driver.findElement(By.xpath(this.SelectAcquisitionType+"//*[text()='"+SelectAcquisitionType+"']"))).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			
			//	Enter Lead Time
			if(!Core.isElementVisible(OrderingLeadTime).getAttribute("style").contains("color: darkgray")){
				OrderingLeadTime.clear();
				OrderingLeadTime.sendKeys("10");
			}
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			
			//	Get number of 3rd Parties
			String ThirdPartyCount = driver.findElement(By.xpath("//*[@id='maintainPOPanelMain_content']//*[text()='No. of 3rd Party POs:']/parent::*/following-sibling::td[1]/span")).getText();
			Core.DataTable.setCellData("PO_Detail", "DA?", Core.DataTable.getCellRowNum("PO_Detail", "UnitNoToMaintain", UnitNo), ThirdPartyCount);
			
			//	Click Save button
			Core.isElementClickable(SaveButton).click();

			//	Handle VIN Pop-ups
			Core.handleVINpopup();
			while(!driver.findElement(By.xpath("//*[@id='unitNoTxtId']")).isDisplayed()) {}
		
		}
		else
			if(driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==0){
				al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Not Found");
				System.out.println("Unit# "+UnitNo+" Not Found ");
				//throw new NoSuchElementException("Not Able to find the Unit No. on Purchase Order Release Page");
			}
			else{
				al.add("<br> Unit# "+UnitNo+" Found with multiple entries");
				System.out.println("Unit# <FONT COLOR=red>"+UnitNo+"</font> Found with multiple entries");
				//throw new NoSuchElementException("Duplicate entries for Unit No. "+UnitNo+" with the same number found on Accaptance Quote Form");
			}
		
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		
}

	
	public void releasePO(String UnitNo) throws InterruptedException{
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");

		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='unitNoTxtId']")).clear();
		driver.findElement(By.xpath("//*[@id='unitNoTxtId']")).sendKeys(UnitNo);
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='filter']")).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}

		if((driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==1)	&&	
				!(driver.findElement(By.xpath("//*[@id='DT_UI_ID_data']//td[4]/span[contains(text(),'"+UnitNo+"')]"+
				"/parent::td[1]/following-sibling::td[6]/span")).getText().equalsIgnoreCase("Released"))){

			Core.isElementClickable(driver.findElement(By.xpath(this.UnitNo+UnitNo+"')]"))).click();
			Core.isElementClickable(maintainPOButton).click();
			al.add("<br> Unit# "+UnitNo+" Found to release");
		
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			ReleasePOBtn.click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			
			//	Handle VIN Pop-ups
			Core.handleVINpopup();

			if(!(driver.findElements(By.xpath("//*[@id='documentListDialog:documentListDT_data']")).size()== 0)){
				String originalHandle = driver.getWindowHandle();
				if(driver.findElements(By.xpath(DocumentList)).size()>0){
					for(int i= 1 ; i <= driver.findElements(By.xpath(DocumentList+"/tr")).size() ; i++){
						int winCount;
						if(driver.findElement(By.xpath(DocumentList+"/tr["+i+"]/td[2]//a")).getText().equalsIgnoreCase("View")){
							
							winCount = driver.getWindowHandles().size();
							while(!(driver.getWindowHandles().size() == winCount+1)){
								Thread.sleep(1500);
								Core.isElementClickable(driver.findElement(By.xpath(DocumentList+"/tr["+i+"]/td[2]//a"))).click();
							}
							winCount = 0;

							while(!StyleOfBody.getAttribute("style").contains("none")){}
							driver.switchTo().window(originalHandle);
							
							while(!(StyleOfBody.getAttribute("style").contains("none")) && 
									!(driver.findElement(By.xpath(DocumentList+"/tr["+i+"]/td[3]//img")).getAttribute("id").contains("ccCheckMarkImg"))){}
						}
					}
					
					
					while(!StyleOfBody.getAttribute("style").contains("none")){}
					for(String handle : driver.getWindowHandles()) {
				        if (!handle.equals(originalHandle)) {
				            driver.switchTo().window(handle);
				            driver.close();
				        }
				    }
				    driver.switchTo().window(originalHandle);
					while(!StyleOfBody.getAttribute("style").contains("none")){}
					driver.findElement(By.xpath("//*[@id='documentListDialog:ccDoneBtn']/span")).click();
					while(!StyleOfBody.getAttribute("style").contains("none")){}
				}
			}
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			while(!driver.findElement(By.xpath("//*[@id='unitNoTxtId']")).isDisplayed()) {}

		}
		else
			if(driver.findElement(By.xpath("//*[@id='DT_UI_ID_data']//td[4]/span[contains(text(),'"+UnitNo+"')]"+
					"/parent::td[1]/following-sibling::td[6]/span")).getText().equalsIgnoreCase("Released")){
				al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> has been released already");
				System.out.println("Unit# "+UnitNo+" has been released already");
			}
			else
				if(driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==0){
					al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Not Found for release");
					System.out.println("Unit# "+UnitNo+" Not Found for release");
					//throw new NoSuchElementException("Not Able to find the Unit No. on Purchase Order Release Page for Relase");
				}
				else{
					al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Found with duplicate entries");
					System.out.println("Unit# "+UnitNo+" Found with duplicate entries");
					//throw new NoSuchElementException("Duplicate entries for Unit No. "+UnitNo+" with the same number found on Purchase Order Release Page for Relase");
				}
		while(!StyleOfBody.getAttribute("style").contains("none")){}
	}
	
	public void confirmPO(String UnitNo) throws InterruptedException{
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");

		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='unitNoTxtId']")).clear();
		driver.findElement(By.xpath("//*[@id='unitNoTxtId']")).sendKeys(UnitNo);
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='filter']")).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}

		if(driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==1){
			Core.isElementClickable(driver.findElement(By.xpath(this.UnitNo+UnitNo+"')]"))).click();
			Core.isElementClickable(maintainPOButton).click();
			al.add("<br> Unit# "+UnitNo+" Found to confirm");

			while(!StyleOfBody.getAttribute("style").contains("none")){}
			//Confirm Button clicking
			if(ConfirmPOBtn.getAttribute("aria-disabled").contentEquals("false")){
				ConfirmPOBtn.click();
				
				//	Handle VIN Pop-ups
				Core.handleVINpopup();
			
				if(driver.findElement(By.xpath(DocumentList)).isDisplayed()){
					String originalHandle = driver.getWindowHandle();
					int winCount;
					for(int i= 1 ; i <= driver.findElements(By.xpath(DocumentList+"/tr")).size() ; i++){
						if(Core.isElementVisible(driver.findElement(By.xpath(DocumentList+"/tr["+i+"]/td[2]//a"))).getText().equalsIgnoreCase("View")){

							winCount = driver.getWindowHandles().size();
							while(!(driver.getWindowHandles().size() == winCount+1)){
								Thread.sleep(1500);
								driver.findElement(By.xpath(DocumentList+"/tr["+i+"]/td[2]//a")).click();
							}
							winCount = 0;
							
							while(!StyleOfBody.getAttribute("style").contains("none")){}
							driver.switchTo().window(originalHandle);
							
							
							while(!(StyleOfBody.getAttribute("style").contains("none")) && 
									!(driver.findElement(By.xpath(DocumentList+"/tr["+i+"]/td[3]//img")).getAttribute("id").contains("ccCheckMarkImg"))){}
						
						}
					}
					while(!StyleOfBody.getAttribute("style").contains("none")){}
					for(String handle : driver.getWindowHandles()) {
				        if (!handle.equals(originalHandle)) {
				            driver.switchTo().window(handle);
				            driver.close();
				        }
				    }
				    driver.switchTo().window(originalHandle);
					while(!StyleOfBody.getAttribute("style").contains("none")){}
					driver.findElement(By.xpath("//*[@id='documentListDialog:ccDoneBtn']/span")).click();
					while(!StyleOfBody.getAttribute("style").contains("none")){}
					while(!driver.findElement(By.xpath("//*[@id='unitNoTxtId']")).isDisplayed()) {}
				}
			
			}
			else{
				throw new NoSuchElementException(UnitNo+" may be not released yet ! Please release the Unit first than go for confirm");
			}
			while(!StyleOfBody.getAttribute("style").contains("none")){}
		}
	
		else
			if(driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==0){
				al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Not Found to confirm");
				System.out.println("Unit# "+UnitNo+" Not Found to confirm");
				//throw new NoSuchElementException("Not Able to find the Unit No. on Purchase Order Release Page for Confirm");
			}
			else{
				al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Found with duplicate entries");
				System.out.println("Unit# "+UnitNo+" Found with duplicate entries");
				//throw new NoSuchElementException("Duplicate entries for Unit No. "+UnitNo+" with the same number found on Purchase Order Release Page for ConfirmPO");
			}
	}
	
}
