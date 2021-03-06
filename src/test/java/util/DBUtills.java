package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtills{
	private static Connection con;
	
	public static void refreshQueue(String ip,String port,String dbName,String un,String pw) throws Exception{
		String dbUrl = "jdbc:oracle:thin:@//"+ip+":"+port+"/"+dbName;		
		try{
			con = DriverManager.getConnection(dbUrl,un,pw);			
			System.out.println("Connection Created");
			CallableStatement stmt = con.prepareCall("BEGIN willow2k.process_stage_maint.refresh_stages(); END;");
			System.out.println("Start Execution");
			stmt.execute();
			System.out.println("Execution Finished");
		}
		catch(Exception e){
			System.out.println("Class dbUtil | Method refreshQueue | Exception desc : " + e.getMessage());
			throw(e);
		}
		finally{			
			con.close();
		}
	}
	
	
}
