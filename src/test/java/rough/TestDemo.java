package rough;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.Core;
import util.ExcelReader;
import util.Log;
public class TestDemo {

	
	@BeforeClass
	public void beforeClass(){
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	@AfterClass
	public void afterClass(){
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
	}	

	@BeforeMethod
	public void beforeMethod(){
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	@AfterMethod
	public void afterMethod(){
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	@BeforeTest
	public void beforeTest(){
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	@AfterTest
	public void afterTest(){
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
	}	

	@Test
	public void test1(){
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	@Test
	public void test2(){
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	
	public static void main(String... ertsakjcbskcbs) throws ParseException{
		//String todaysDate = new SimpleDateFormat("MMddyyyy").format(Calendar.getInstance().getTime());
		String s = "Quote number 336665/1/1 has been accepted with Unit No 00995898";
		//System.out.println(s.indexOf("accepted with Unit No "));
		System.out.println (s.substring(s.length()-8,s.length()));
	
	
	
	
	}




	
	
}
