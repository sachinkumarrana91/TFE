package webPages;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Core;
import config.Configuration;

public class AcceptanceQueuePage {
	
	
	WebDriver driver;
	
	public AcceptanceQueuePage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = Configuration.QuoteInput)
	public WebElement QuoteInput;
	
	@FindBy(how = How.XPATH , using = Configuration.SearchButton)
	public WebElement SearchButton;
	
	@FindBy(how = How.XPATH , using = Configuration.StyleOfBody)
	public WebElement StyleOfBody;

	public String QuoteNo = Configuration.QuoteNo;
	
	@FindBy(how = How.XPATH , using = Configuration.AcceptQuote)
	public WebElement AcceptQuote;
	
	@FindBy(how = How.XPATH , using = Configuration.QuoteStatus)
	public WebElement QuoteStatus;

	@FindBy(how = How.XPATH , using = "//*[@id='menuForm']//*[text()='Acceptance Queue']")
	public WebElement AcceptanceQueue;

	@FindBy(how = How.XPATH , using = Configuration.OrderToDelivery)
	public WebElement OrderToDelivery;

	public ArrayList<String> al = new ArrayList<String>();
	

	
	
	public void OpenAcceptanceQueue(){
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
		Core.isElementVisible(AcceptanceQueue).click();
	}
	
	public void AcceptQuote(String QuoteNo){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
/*		Core.isElementVisible(QuoteInput).sendKeys(QuoteNo);
		Core.isElementVisible(SearchButton).click();
*/
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='filterQuoteIdTxt']")).clear();
		driver.findElement(By.xpath("//*[@id='filterQuoteIdTxt']")).sendKeys(QuoteNo);
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		driver.findElement(By.xpath("//*[@id='filter']")).click();
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		if(driver.findElements(By.xpath(this.QuoteNo+QuoteNo+"')]")).size()==1){
			Core.isElementClickable(driver.findElement(By.xpath(this.QuoteNo+QuoteNo+"')]"))).click();
			Core.isElementClickable(AcceptQuote).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			String message = driver.findElement(By.xpath("//*[@id='messages']/div")).getText();
			if(message.contains("accepted")){
				Core.DataTable.setCellData("PO_Detail", "UnitNoToMaintain", Core.DataTable.getRowCount("PO_Detail")+1, message.substring(message.length()-8,message.length()));
			}
			
			al.add("<br> "+message);
			}
		else
			if(driver.findElements(By.xpath(this.QuoteNo+QuoteNo+"')]")).size()==0){
				al.add("<br> Quote# <FONT COLOR=red>"+QuoteNo+"</font> Not Found on Accaptance Quote Page");
				//System.out.println("Quote# "+QuoteNo+" Not Found on Accaptance Quote Page");
				//throw new NoSuchElementException("Not Able to find the Quote No. on Accaptance Quote Form, May be it has already been Accepted/Rejected");
			}
			else{
				al.add("<br> Quote# "+QuoteNo+" Found with multiple entries on Accaptance Quote Page");
				//System.out.println("Quote# <FONT COLOR=red>"+QuoteNo+"</font> Found with multiple entries on Accaptance Quote Page");
				//throw new NoSuchElementException("Duplicate Quotes with the same number found on Accaptance Quote Form");
			}
	}

	public String CheckStatus(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		while(!StyleOfBody.getAttribute("style").contains("none")){
		}
		Core.isElementClickable(QuoteStatus);
		
		return QuoteStatus.getText();
	}

	
	
}
