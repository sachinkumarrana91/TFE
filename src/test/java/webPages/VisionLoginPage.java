package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Core;
import config.Configuration;

public class VisionLoginPage {
	
	WebDriver driver;
	
	public VisionLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = Configuration.username)
	public WebElement username;
	
	@FindBy(how = How.XPATH , using = Configuration.passsword)
	public WebElement passsword;
	
	@FindBy(how = How.XPATH , using = Configuration.loginButton)
	public WebElement loginButton;
	
	@FindBy(how = How.XPATH , using = "//*[@id='dvQuickModal']")
	public WebElement StyleOfBody;

	
	public void doLogin(String UserName, String Password) throws InterruptedException{
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");

		username.sendKeys(UserName);
		passsword.sendKeys(Password);
		loginButton.click();
		

		//Expand left Bar
		if(driver.findElement(By.xpath("//*[@id='left-toggler']/span")).getAttribute("style").contains("display: block")){
			Core.isElementClickable(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span"))).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
		}



	
	}
	
	public void doLogin(String SessionId, String env, String abcd) throws InterruptedException{
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");

		//driver.navigate().to("http://vis-"+env+"/vision/view/handler.xhtml?audsid="+SessionId+"&corp_entity=1&origin=UTMENULP&query_mode=N&LOGIN_USER=GROVER_S&module=acceptance_queue&width=1920&height=1080");
		driver.navigate().to("http://vis-"+env+"/vision/view/handler.xhtml?audsid="+SessionId+"&corp_entity=1&origin=UTMENULP&query_mode=N&LOGIN_USER=GROVER_S&module=acceptance_queue&width=1920&height=1080");

		//Expand left Bar
		if(driver.findElement(By.xpath("//*[@id='left-toggler']/span")).getAttribute("style").contains("display: block")){
			Core.isElementClickable(driver.findElement(By.xpath("//*[@id='left-toggler']/span/a/span"))).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
		}



	
	}
	
	
	
	
}
