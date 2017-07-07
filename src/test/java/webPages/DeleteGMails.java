package webPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class DeleteGMails {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
		WebDriver d = new FirefoxDriver();
		//WebDriver d = new InternetExplorerDriver();
		
		
		d.get("https://accounts.google.com/Login?");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		while(!d.findElement(By.xpath("//*[@id='identifierId']")).isDisplayed()){}
		d.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("sachinkumarrana91@gmail.com");
		d.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
		
		while(!d.findElement(By.xpath("//*[@id='password']//input")).isDisplayed()){}
		d.findElement(By.xpath("//*[@id='password']//input")).sendKeys("***********************");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.findElement(By.xpath("//*[@id='passwordNext']//span")).click();
		
		while(!(d.findElements(By.xpath("//*[@id='gbwa']/div[1]/a")).size()==1)){}
		while(!d.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).getAttribute("aria-expanded").equalsIgnoreCase("true")){
			d.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).click();
		}
		d.findElement(By.xpath("//*[@id='gbwa']/div[2]//*[text()='Gmail']")).click();
		
		
		while(!d.findElement(By.xpath("//*[@class='aAA J-KU-Jg J-KU-Jg-K9']")).isDisplayed()){}
		while(!d.findElement(By.xpath("//*[@class='aAA J-KU-Jg J-KU-Jg-K9']/td[4]")).getAttribute("aria-selected").equalsIgnoreCase("true")){
			d.findElement(By.xpath("//*[@class='aAA J-KU-Jg J-KU-Jg-K9']/td[4]//*[text()='Forums']")).click();
		}
		while(d.findElements(By.xpath("//*[@id=':10n']/tbody/tr[1]")).size()>0){
			while(!d.findElement(By.xpath("//*[@id=':39']/div[1]/span")).getAttribute("aria-checked").equalsIgnoreCase("true")){
				d.findElement(By.xpath("//*[@id=':39']/div[1]/span/div")).click();
			}
			for(int i = 1; i<= d.findElements(By.xpath("//*[@id=':1zs']/tbody/tr")).size(); i++){
				if(d.findElements(By.xpath("//*[@id=':1zs']/tbody/tr["+i+"]/td[7]/img")).size()==1){
					while(!d.findElement(By.xpath("//*[@id=':1zs']/tbody/tr["+i+"]/td[2]/div")).getAttribute("aria-checked").equalsIgnoreCase("false")){
						d.findElement(By.xpath("//*[@id=':1zs']/tbody/tr["+i+"]/td[2]/div/div")).click();
					}
				}
			}
			if(d.findElements(By.xpath("//*[@id=':5']/div[3]/div[1]/div[1]/div/div/div[2]/div[3]/div/div")).size()==1){
				d.findElement(By.xpath("//*[@id=':5']/div[3]/div[1]/div[1]/div/div/div[2]/div[3]/div/div")).click();
			}
		}
		
		
		
		Actions ac = new Actions(d);
		ac.click();
		ac.clickAndHold();
		ac.doubleClick();
		
		
		
		
		
		
	}

}
