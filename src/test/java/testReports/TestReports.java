package testReports;


import java.io.*;

import util.TestUtil;


public class TestReports {
	public static int scriptNumber=1;
	public static String indexResultFilename;
	public static String currentDir;
	public static String currentSuiteName;
	public static int tcid;
	//  can i do this
	//public static String currentSuitePath;
	
	public static double passNumber;
	public static double failNumber;
	public static boolean newTest=true;
	
	public static void startTesting(String filename,String testStartTime,String env,String rel)
	  {
		indexResultFilename = filename;
		currentDir = indexResultFilename.substring(0,indexResultFilename.lastIndexOf("//"));
		
		//System.out.println("Current directory is: "+currentDir);
		System.out.println("Current filename is: "+indexResultFilename);
		
		FileWriter fstream =null;
		 BufferedWriter out =null;
	      try{
	    // Create file 
	   
	     fstream = new FileWriter(filename);
	     out = new BufferedWriter(fstream);

        String RUN_DATE = TestUtil.now("dd.MMMMM.yyyy").toString();
	    
	    String ENVIRONMENT = env;
	    String RELEASE = rel;
	    
	    out.newLine();
	  
	    out.write("<html>\n");
	    	out.write("<HEAD>\n");
	    		out.write("<TITLE>Devil Project</TITLE>\n");

	    		// For Matrix Rain Fall effect on the report {
	    		out.write("<style>\n");
	    		out.write("*{\n");
	    		out.write("margin: 0;\n");
	    		out.write("padding: 0;\n");
	    		out.write("}\n");
	    		out.write("body {background: black;}\n");
	    		out.write("canvas {\n");
	    		out.write("display:block;\n");
	    		out.write("width: 100vw;\n");
	    		out.write("height: 100vh;\n");
	    		out.write("display: absolute;\n");
	    		out.write("position: fixed;\n");
	    		out.write("top: 0;\n");
	    		out.write("left: 0;\n");
	    		out.write("z-index: -9999;\n");
	    		out.write("}\n");
	    		out.write("</style>\n");
	    		// For Matrix Rain Fall effect on the report {
	    		
	    		
	    	out.write("</HEAD>\n");
	    	out.write("<body>\n");

	    	
	    	
	    	
	    	
	    	
	    	
    		// For Matrix Rain Fall effect on the report {
    		out.write("<canvas id=\"c\"></canvas>\n");
    		out.write("<script>\n");
    		out.write("var c = document.getElementById(\"c\");\n");
	    	out.write("var ctx = c.getContext(\"2d\");\n");
    		out.write("c.height = window.innerHeight;\n");
	    	out.write("c.width = window.innerWidth;\n");
    		out.write("var matrix = \"ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789@#$%^&*()*&^%\";\n");
	    	out.write("matrix = matrix.split(\"\");\n");
    		out.write("var font_size = 10;\n");
	    	out.write("var columns = c.width/font_size;\n");
    		out.write("var drops = [];\n");
	    	out.write("for(var x = 0; x < columns; x++)\n");
    		out.write("drops[x] = 1;\n");
	    	out.write("function draw()\n");
    		out.write("{\n");
	    	out.write("ctx.fillStyle = \"rgba(0, 0, 0, 0.04)\";\n");
    		out.write("ctx.fillRect(0, 0, c.width, c.height);\n");
	    	out.write("ctx.fillStyle = \"#0F0\";\n");
    		out.write("ctx.font = font_size + \"px arial\";\n");
	    	out.write("for(var i = 0; i < drops.length; i++)\n");
    		out.write("{\n");
	    	out.write("var text = matrix[Math.floor(Math.random()*matrix.length)];\n");
    		out.write("ctx.fillText(text, i*font_size, drops[i]*font_size);\n");
	    	out.write("if(drops[i]*font_size > c.height && Math.random() > 0.975)\n");
    		out.write("drops[i] = 0;\n");
    		out.write("drops[i]++;\n");
	    	out.write("}\n");
    		out.write("}\n");
	    	out.write("setInterval(draw, 35);\n");
    		out.write("</script>\n");
    		// For Matrix Rain Fall effect on the report {

	    	
	    	
	    	
	    	
	    	out.write("<table  border=0 cellspacing=0 cellpadding=0 >\n");
	    			out.write("<tr>\n");
	    				out.write("<td width=150 align=left>\n");
	    					
/*    						out.write("<img src=\"file:/C:/Users/Sachin.kumar/Desktop/MAL_DIRECT_LOGO_TAG.png\" alt="some_text" style="opacity:0.5;filter:alpha(opacity=40);\"/>\n");
*/    						out.write("<img src=\"http://www.mikealbertlandscape.com/tco-calculator/images/logo.png\" alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\">\n");

						out.write("</td>\n"); 
	    			out.write("</tr>\n");
	    		out.write("</table>\n");

	    		out.write("<h2 align=center><FONT COLOR=WHITE alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\" FACE=AriaL SIZE=6><u><b>Test Automation Report</b></u></FONT></h2>\n");
	     
	     
	     out.write("<table align=left border=1 cellspacing=1 cellpadding=1 >\n");

	     out.write("<tr>\n");
	     out.write("<th colspan=2  bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\" ><FONT COLOR=WHITE FACE=Arial SIZE=4.5><u>Test Details</u></FONT></th>\n");
	     out.write("</tr>\n");

	     out.write("<tr>\n");
         out.write("<td width=125 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\" ><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>Run Date</b></FONT></td>\n");
         out.write("<td width=175 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>"+RUN_DATE+"</b></FONT></td>\n");
	     out.write("</tr>\n");
	     		
	     out.write("<tr>\n");
         out.write("<td width=125 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>Run StartTime</b></FONT></td>\n");
         out.write("<td width=175 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>"+testStartTime+"</b></FONT></td>\n");
	     out.write("</tr>\n");

	     out.write("<tr>\n");
         out.write("<td width=125 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>Run EndTime</b></FONT></td>\n");
         out.write("<td width=175 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>END_TIME</b></FONT></td>\n");
	     out.write("</tr>\n");

	     out.write("<tr>\n");
         out.write("<td width=125 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>Environment</b></FONT></td>\n");
         out.write("<td width=175 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>"+ENVIRONMENT+"</b></FONT></td>\n");
	     out.write("</tr>\n");
	     
	     out.write("<tr>\n");
         out.write("<td width=125 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>Release</b></FONT></td>\n");
         out.write("<td width=175 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>"+RELEASE+"</b></FONT></td>\n");
	     out.write("</tr>\n");

	     out.write("</table>\n");
	     
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	     
	     out.write("<table align=right border=1 cellspacing=1 cellpadding=1 >\n");

	     out.write("<tr>\n");
	     out.write("<th colspan=2 bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=4.5><u>Execution Statistics</u></FONT></th>\n");
	     out.write("</tr>\n");

	     out.write("<tr>\n");
         out.write("<td width=150 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>Test Case Executed</b></FONT></td>\n");
         out.write("<td width=150 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>"+"Test_Case_Executed#"+"</b></FONT></td>\n");
	     out.write("</tr>\n");
	     		
	     out.write("<tr>\n");
         out.write("<td width=150 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>Test Case Passed</b></FONT></td>\n");
         out.write("<td width=150 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>"+"Test_Case_Passed#"+"</b></FONT></td>\n");
	     out.write("</tr>\n");

	     out.write("<tr>\n");
         out.write("<td width=150 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>Pass Percentage</b></FONT></td>\n");
         out.write("<td width=150 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>"+"Pass_Percentage#"+"</b></FONT></td>\n");
	     out.write("</tr>\n");
	     
	     //#BCE954
	     
	     out.write("<tr>\n");
         out.write("<td width=150 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>Test Case Failed</b></FONT></td>\n");
         out.write("<td width=150 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=RED FACE=Arial SIZE=2.75><b>"+"Test_Case_Failed#"+"</b></FONT></td>\n");
	     out.write("</tr>\n");
	     
	     out.write("<tr>\n");
         out.write("<td width=150 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE=Arial SIZE=2.75><b>Fail Percentage</b></FONT></td>\n");
         out.write("<td width=150 align=left bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=RED FACE=Arial SIZE=2.75><b>"+"Fail_Percentage#"+"</b></FONT></td>\n");
	     out.write("</tr>\n");

	     out.write("</table>\n");
	     
	     out.write("<br>\n");
	     out.write("<br>\n");
	     out.write("<br>\n");
	     out.write("<br>\n");
	     out.write("<br>\n");
	     out.write("<br>\n");
	     out.write("<br>\n");

	    //Close the output stream
	    out.close();
	    }catch (Exception e){//Catch exception if any
	      System.err.println("Error: " + e.getMessage());
	    }finally{
	    	
		    fstream=null;
		    out=null;
	    }
	  }
	
    public static void startSuite(String suiteName){ // That method add the header of the table when suite execute

	    FileWriter fstream =null;
		BufferedWriter out =null;
		currentSuiteName = suiteName.replaceAll(" ", "_");
	
		tcid=1;
	    try{


	    fstream = new FileWriter(indexResultFilename,true);
	  	out = new BufferedWriter(fstream);
	      
    	out.write("<h4> <FONT COLOR=WHITE alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\" FACE= Arial  SIZE=4.5> <u>"+suiteName+" Report :</u></h4>\n");
        out.write("<table  border=1 cellspacing=1 cellpadding=1 width=100%>\n");
    	out.write("<tr>\n");
        out.write("<td width=5%  align= center  bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>Test Script#</b></td>\n");
        out.write("<td width=20% align= center  bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>Test Case Name</b></td>\n");
        out.write("<td width=5% align= center  bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>Status</b></td>\n");
        out.write("<td width=35% align= center  bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>Description</b></td>\n");
        out.write("<td width=15% align= center  bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>Run Start Time</b></td>\n");
        out.write("<td width=15% align= center  bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>Run End Time</b></td>\n");
        out.write("<td width=5% align= center  bgcolor=BLACK alt=\"some_text\" style=\"opacity:0.5;filter:alpha(opacity=40);\"><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>Screen Shot</b></td>\n");

        out.write("</tr>\n");
        out.close();
	    }catch(Exception e){
		      System.err.println("Error: " + e.getMessage());
	    }finally{
	    	
		    fstream=null;
		    out=null;
	    }
	}
    
    public static void endSuite(){
    	 FileWriter fstream =null;
 		BufferedWriter out =null;
 		
 	    try{
 	    fstream = new FileWriter(indexResultFilename,true);
 	    System.out.println(indexResultFilename);
 	  	out = new BufferedWriter(fstream);
        out.write("</table>\n");
        out.write("</body>\n");
        out.write("</html>\n");
        out.close();
 	    }catch(Exception e){
		      System.err.println("Error: " + e.getMessage());
	    }finally{
	    	
		    fstream=null;
		    out=null;
	    }

    }
	
	public static void addTestCase(String testCaseName,String testCaseStartTime,String testCaseEndTime,String status, String ScreenShotPath, String Description){
		newTest=true;
		FileWriter fstream=null;
		BufferedWriter out=null;
		
		
		try {
		   //<! add test case entry into main report////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		   
			 fstream = new FileWriter(indexResultFilename,true);
			 out = new BufferedWriter(fstream);
			// out.newLine();
			
			 out.write("<tr>\n");
			 //System.out.println(currentSuitePath);
		     out.write("<td width=5% align= center ><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>"+scriptNumber+"</b></td>\n");
		     if(status.equalsIgnoreCase("Skipped") || status.equalsIgnoreCase("Skip"))
		    	 out.write("<td width=20% align= center ><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>"+testCaseName+"</b></td>\n");
		     else
		    	// out.write("<td width=40% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b><a href=file:///"+currentDir+"//"+currentSuiteName+"_TC"+tcid+"_"+testCaseName.replaceAll(" ", "_")+DriverScript.year+"_"+DriverScript.date+"_"+(DriverScript.month+1)+"_"+DriverScript.day+"_"+DriverScript.min+"_" +DriverScript.sec+".html>"+testCaseName+"</a></b></td>\n");
		    	//out.write("<td width=40% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b><a href=http://"+TestUtil.Handeler()+":8080"+"//TestReports"+"//"+currentSuiteName+"_TC"+tcid+"_"+testCaseName.replaceAll(" ", "_")+PageFactory_TestCase.year+"_"+PageFactory_TestCase.date+"_"+(PageFactory_TestCase.month+1)+"_"+PageFactory_TestCase.day+"_"+PageFactory_TestCase.min+"_" +PageFactory_TestCase.sec+".html>"+testCaseName+"</a></b></td>\n");
		     	out.write("<td width=20% align= center ><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>"+testCaseName.replaceAll(" ", "_")+"</b></td>\n");
		    	 //out.write("<td width=40% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b><a href="+currentSuiteName+"_TC"+tcid+"_"+testCaseName.replaceAll(" ", "_")+".html>"+testCaseName+"</a></b></td>\n");
		     tcid++;
		     if(status.startsWith("Pass")){
		     out.write("<td width=5% align= center  bgcolor=#BCE954><FONT COLOR=black FACE=Arial SIZE=2><b>"+status+"</b></td>\n");
		     out.write("<td width=5% align= center  bgcolor=#BCE954><FONT COLOR=black FACE=Arial SIZE=2><b>"+Description+"</b></td>\n");
		     }
		     else if(status.startsWith("Fail")){
		    	 out.write("<td width=5% align= center  bgcolor=Red><FONT COLOR=black FACE= Arial  SIZE=2><b>"+status+"</b></td>\n");
		    	 out.write("<td width=5% align= center  bgcolor=yellow><FONT COLOR=black FACE= Arial  SIZE=2><b>"+Description+"</b></td>\n");
		     }
		     else if(status.equalsIgnoreCase("Skipped") || status.equalsIgnoreCase("Skip")){
			     out.write("<td width=5% align= center  bgcolor=yellow><FONT COLOR=153E7E FACE=Arial SIZE=2><b>"+status+"</b></td>\n");
			     out.write("<td width=5% align= center  bgcolor=yellow><FONT COLOR=153E7E FACE=Arial SIZE=2><b>"+Description+"</b></td>\n");
		     }
		     out.write("<td width=15% align= center ><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>"+testCaseStartTime+"</b></td>\n");
		     out.write("<td width=15% align= center ><FONT COLOR=WHITE FACE= Arial  SIZE=2><b>"+testCaseEndTime+"</b></td>\n");
 			 out.write("<td align=center width=5%><FONT COLOR=WHITE FACE=Arial SIZE=1><b><a href=http://"+TestUtil.Handeler()+":8080/screenshots/"+ScreenShotPath+".jpeg"+" target=_blank>Screen Shot</a></b></td>");
 			 //out.write("<td align=center width=10%><FONT COLOR=black FACE=Arial SIZE=1><b><a href=http://"+TestUtil.Handeler()+":8080/screenshots/"+ScreenShotPath+".jpeg"+" target=_blank>"+"C:/Selenium_3rd_Tools/apache-tomcat-9.0.0.M13/webapps/ROOT/screenshots/"+ScreenShotPath+".jpeg"+"</a></b></td>");

		     out.write("</tr>\n");
		     
		     scriptNumber++;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}finally{
			try {
				//out.write("</table>\n");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		newTest=false;
		Description = null;
	}
	
	
    
    

	public static void updateEndTime(String endTime) {
		StringBuffer buf = new StringBuffer();
		try{
		    // Open the file that is the first 
		    // command line parameter
		    FileInputStream fstream = new FileInputStream(indexResultFilename);
		    // Get the object of DataInputStream
		    DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    
		    
		    //Read File Line By Line
		    
		    while ((strLine = br.readLine()) != null)   {
		    	
		    
		    	
		     if(strLine.indexOf("END_TIME") !=-1){
		    	 strLine=strLine.replace("END_TIME", endTime);
		     }
		     buf.append(strLine);
		     
		     
		    }
		  //Close the input stream
		    in.close();
		    //System.out.println(buf);
		    FileOutputStream fos=new FileOutputStream(indexResultFilename);
			 DataOutputStream   output = new DataOutputStream (fos);	 
	    	 output.writeBytes(buf.toString());
	    	 fos.close();
		    
		    }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }
		
	}

	
	public static void updateTestCount(String TestCaseExecuted) {
		StringBuffer buf = new StringBuffer();
		try{
		    // Open the file that is the first 
		    // command line parameter
		    FileInputStream fstream = new FileInputStream(indexResultFilename);
		    // Get the object of DataInputStream
		    DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    
		    
		    //Read File Line By Line
		    
		    while ((strLine = br.readLine()) != null)   {
		    	
		    
		    	
		     if(strLine.indexOf("Test_Case_Executed#") !=-1){
		    	 strLine=strLine.replace("Test_Case_Executed#", TestCaseExecuted);
		     }
		     buf.append(strLine);
		     
		     
		    }
		  //Close the input stream
		    in.close();
		    //System.out.println(buf);
		    FileOutputStream fos=new FileOutputStream(indexResultFilename);
			 DataOutputStream   output = new DataOutputStream (fos);	 
	    	 output.writeBytes(buf.toString());
	    	 fos.close();
		    
		    }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }
	}

	public static void updatePassedTestCount(String TestCasePassed) {
		StringBuffer buf = new StringBuffer();
		try{
		    // Open the file that is the first 
		    // command line parameter
		    FileInputStream fstream = new FileInputStream(indexResultFilename);
		    // Get the object of DataInputStream
		    DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    
		    
		    //Read File Line By Line
		    
		    while ((strLine = br.readLine()) != null)   {
		    	
		    
		    	
		     if(strLine.indexOf("Test_Case_Passed#") !=-1){
		    	 strLine=strLine.replace("Test_Case_Passed#", TestCasePassed);
		     }
		     buf.append(strLine);
		     
		     
		    }
		  //Close the input stream
		    in.close();
		    //System.out.println(buf);
		    FileOutputStream fos=new FileOutputStream(indexResultFilename);
			 DataOutputStream   output = new DataOutputStream (fos);	 
	    	 output.writeBytes(buf.toString());
	    	 fos.close();
		    
		    }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }
	}
	
	public static void updateFailedTestCount(String TestCaseFailed) {
		StringBuffer buf = new StringBuffer();
		try{
		    // Open the file that is the first 
		    // command line parameter
		    FileInputStream fstream = new FileInputStream(indexResultFilename);
		    // Get the object of DataInputStream
		    DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    //Read File Line By Line
		    
		    while ((strLine = br.readLine()) != null)   {
		    	
		     if(strLine.indexOf("Test_Case_Failed#") !=-1){
		    	 strLine=strLine.replace("Test_Case_Failed#", TestCaseFailed);
		     }
		     buf.append(strLine);
		     
		     
		    }
		  //Close the input stream
		    in.close();
		    //System.out.println(buf);
		    FileOutputStream fos=new FileOutputStream(indexResultFilename);
			 DataOutputStream   output = new DataOutputStream (fos);	 
	    	 output.writeBytes(buf.toString());
	    	 fos.close();
		    
		    }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }
	}
	

	public static void updatePassedTestPercentage(String TestPassPercentage) {
		StringBuffer buf = new StringBuffer();
		try{
		    // Open the file that is the first 
		    // command line parameter
		    FileInputStream fstream = new FileInputStream(indexResultFilename);
		    // Get the object of DataInputStream
		    DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    //Read File Line By Line
		    
		    while ((strLine = br.readLine()) != null)   {
		    	
		     if(strLine.indexOf("Pass_Percentage#") !=-1){
		    	 strLine=strLine.replace("Pass_Percentage#", TestPassPercentage+"%");
		     }
		     buf.append(strLine);
		     
		     
		    }
		  //Close the input stream
		    in.close();
		    //System.out.println(buf);
		    FileOutputStream fos=new FileOutputStream(indexResultFilename);
			 DataOutputStream   output = new DataOutputStream (fos);	 
	    	 output.writeBytes(buf.toString());
	    	 fos.close();
		    
		    }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }
	}

	public static void updateFailedTestPercentage(String TestFailPercentage) {
		StringBuffer buf = new StringBuffer();
		try{
		    // Open the file that is the first 
		    // command line parameter
		    FileInputStream fstream = new FileInputStream(indexResultFilename);
		    // Get the object of DataInputStream
		    DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    //Read File Line By Line
		    
		    while ((strLine = br.readLine()) != null)   {
		    	
		     if(strLine.indexOf("Fail_Percentage#") !=-1){
		    	 strLine=strLine.replace("Fail_Percentage#", TestFailPercentage+"%");
		     }
		     buf.append(strLine);
		     
		     
		    }
		  //Close the input stream
		    in.close();
		    //System.out.println(buf);
		    FileOutputStream fos=new FileOutputStream(indexResultFilename);
			 DataOutputStream   output = new DataOutputStream (fos);	 
	    	 output.writeBytes(buf.toString());
	    	 fos.close();
		    
		    }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }
	}
	
}
