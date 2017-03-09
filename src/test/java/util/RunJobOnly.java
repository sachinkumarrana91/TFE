package util;

public class RunJobOnly {

	public static ExcelReader datatable;
	public static void main(String[] args) {

		String ENVi;
		String ENVj;

		ENVi = "DEV1";
		ENVj = "QA2";

/*		ENV = "QA1";

		ENV = "QA3";

		ENV = "DEV1";

		ENV = "STG1";
*/
		datatable = new ExcelReader(System.getProperty("user.dir")+"//src//test//java//config//DataTable.xlsx");
		int i = datatable.getCellRowNum("loginQA", "dbName", ENVi);
		
		
		
		try {
			util.DBUtills.refreshQueue(
					datatable.getCellData("loginQA", "IP", i),
					datatable.getCellData("loginQA", "Port", i),
					datatable.getCellData("loginQA", "dbName", i),
					datatable.getCellData("loginQA", "UN", i),
					datatable.getCellData("loginQA", "PW", i)
					);
	} catch (Exception e) {
		e.printStackTrace();
	}
		System.out.println(ENVi+" has been refreshed");

/*		int j = datatable.getCellRowNum("loginQA", "dbName", ENVj);
		try {
			util.DBUtills.refreshQueue(
					datatable.getCellData("loginQA", "IP", j),
					datatable.getCellData("loginQA", "Port", j),
					datatable.getCellData("loginQA", "dbName", j),
					datatable.getCellData("loginQA", "UN", j),
					datatable.getCellData("loginQA", "PW", j)
					);
	} catch (Exception e) {
		e.printStackTrace();
	}
		System.out.println(ENVj+" has been refreshed");
*/
	}




}
