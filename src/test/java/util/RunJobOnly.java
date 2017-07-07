package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import config.Configuration;

public class RunJobOnly {

	public static ExcelReader datatable;
	public static void main(String[] args) {

		String ENV;

		ENV = "STG1";
		//datatable = new ExcelReader(System.getProperty("user.dir")+"//src//test//java//config//DataTable.xlsx");
		datatable = new ExcelReader(Configuration.exlPath_File);
		
		int i = datatable.getCellRowNum("loginQA", "dbName", ENV);
		
		
		
		try {
			//refreshQueue(													// For Continue
			util.DBUtills.refreshQueue(									// For once only
					datatable.getCellData("loginQA", "IP", i), 
					datatable.getCellData("loginQA", "Port", i),
					datatable.getCellData("loginQA", "dbName", i),
					datatable.getCellData("loginQA", "UN", i),
					datatable.getCellData("loginQA", "PW", i)
					);
	} catch (Exception e) {
		e.printStackTrace();
	}
		System.out.println(ENV+" has been refreshed");

	}

	
	private final static String dcn = "oracle.jdbc.driver.OracleDriver";
	private static Connection con;
	
	public static void refreshQueue(String ip,String port,String dbName,String un,String pw) throws Exception{
		String dbUrl = "jdbc:oracle:thin:@//"+ip+":"+port+"/"+dbName;		
		try{
			con = DriverManager.getConnection(dbUrl,un,pw);			
			System.out.println("Connection Created");
			int j = 0;
			while(1==1){
				System.out.println("============  "+j+++"  ============");
/*				String s = "Select TAH_ID, SRLH_SRLH_ID, TRX_CODE, FMS_FMS_ID, STATUS, EA_ACCOUNT_CODE,CREATE_DATE, TAL_REASON, ORIGIN_PGM from TAL_TRX_HEADER WHERE FMS_FMS_ID IN "
						+ "(SELECT FMS_ID FROM FLEET_MASTERS WHERE UNIT_NO = 00996515)";
*/

				CallableStatement stmt = con.prepareCall("BEGIN willow2k.process_stage_maint.refresh_stages(); END;");
				System.out.println("Start Execution");
				stmt.execute();
				System.out.println("Execution Finished");
			}
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
