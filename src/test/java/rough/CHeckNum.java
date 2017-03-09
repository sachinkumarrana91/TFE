package rough;

import org.openqa.selenium.By;

public class CHeckNum {
	public static String a = "Invoice Details do not match the Invoice Amount. Please correct the data and post. Invoice Amount: $99.00 Invoice Details: $300.00 Ok";
	public static String b = "1.1";
	public static String c = "1.56";
	
	public static void main(String[] args) {
		//String a = driver.findElement(By.xpath("//*[@id='confirmDialogForm']")).getText();
		//System.out.println(a.substring(0, a.indexOf("Invoice Amount:")));
		System.out.println((""+Math.abs((Math.random()*100))+"").substring(0,(""+Math.abs((Math.random()*100))+"").lastIndexOf('.')+3));
	}

}
