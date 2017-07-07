package rough;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
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

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import core.Core;
import util.ExcelReader;
import util.Log;
public class TestDemo {

	
/*	@BeforeClass
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
	
*/
	
	
	
	public static void main(String... ertsakjcbskcbs) throws ParseException{
		
		//String s  = "pirates of the carribeans : dead men tell no tales pirates of the carribeans : dead men tell no tales";
		String s  = "PON00216216";
			//executeDone(s);

			System.out.println("INV"+s.substring(s.indexOf('N')+3,11));
	
	
	}	





	 public static void executeDone(String given){
		 int number = 0;
		 int decimalLocation = 0;
		 String check;
		 if(given.contains(".")){
			 decimalLocation = given.length()-(given.indexOf(".")+1);
			 check = given.replace(".", "");
		 }
		 else
			 check=given;
		 
		 for(int i = 0 ; i<check.length(); i++){
			 number = (int)(number + (check.charAt(i)-48)*(Math.pow(10, (check.length()-i-1))));
		 }
		 
		 System.out.println(number/Math.pow(10, decimalLocation));
	 }
	 
	 
	 
		 

}