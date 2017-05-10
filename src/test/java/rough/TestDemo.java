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
		
		
String prev_BaeVehicleAmount = "12245";

System.out.println(new SimpleDateFormat("MMddyyyy").format(Calendar.getInstance().getTime()));
	

		

/*		int crystal = 25;
		
		for(int i=1; i<=crystal; i++){
			for(int j=1; j<=crystal-i; j++){
				System.out.print(" ");
			}
			for(int k=crystal-i+1; k<=crystal; k++){
				if(i==k)			System.out.print(" ");
				if(i+k==crystal*2)	System.out.print(" ");
				else				System.out.print("*");
			}
			for(int l=crystal+1; l<crystal+i; l++){
				if(i==l)			System.out.print(" ");
				if(i+l==crystal*2)	System.out.print(" ");
				else				System.out.print("*");
			}
			for(int l=crystal+i; l<=(crystal*2)-1; l++){
				System.out.print(" ");
			}
			System.out.println();
		}
		for(int i=(crystal-1); i>=1; i--){
			for(int j=1; j<=crystal-i; j++){
				System.out.print(" ");
			}
			for(int k=crystal-i+1; k<=crystal; k++){
				if(i==k)			System.out.print(" ");
				if(i+k==crystal*2)	System.out.print(" ");
				else				System.out.print("*");
			}
			for(int l=crystal+1; l<crystal+i; l++){
				if(i==l)			System.out.print(" ");
				if(i+l==crystal*2)	System.out.print(" ");
				else				System.out.print("*");
			}
			for(int l=crystal+i; l<=(crystal*2)-1; l++){
				System.out.print(" ");
			}
			System.out.println();
		}

*/	
	
/*		for(int i=1; i<=crystal; i++){
			for(int j=1; j<=crystal-i; j++){
				System.out.print(" ");
			}
			for(int k=crystal-i+1; k<=crystal; k++){
				System.out.print("*");
			}
			for(int l=crystal+1; l<crystal+i; l++){
				System.out.print("*");
			}
			for(int l=crystal+i; l<=(crystal*2)-1; l++){
				System.out.print(" ");
			}
			System.out.println();
		}
		for(int i=(crystal-1); i>=1; i--){
			for(int j=1; j<=crystal-i; j++){
				System.out.print(" ");
			}
			for(int k=crystal-i+1; k<=crystal; k++){
				System.out.print("*");
			}
			for(int l=crystal+1; l<crystal+i; l++){
				System.out.print("*");
			}
			for(int l=crystal+i; l<=(crystal*2)-1; l++){
				System.out.print(" ");
			}
			System.out.println();
		}

*/		
	
	
	}




	
	
}
