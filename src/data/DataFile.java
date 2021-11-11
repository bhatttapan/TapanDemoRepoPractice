package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("C:\\TAPAN\\STUDY\\QUALITY ASSURANCE NIKUL SIR\\Testing\\NikulTest.xlsx");
	public String wrongEmail=d.getCellData("Data1", "UserName", 3);
	public String wrongPassword =d.getCellData("Data1", "Password", 2);
	public String invalidEmail=d.getCellData("Data1", "UserName", 4);
	public String globalErrMsg = d.getCellData("Data1", "Global Error", 2);;
	public String emptyEmailErrMsg=d.getCellData("Data1", "Email Error", 4);;
	public String emptyPasswordErrMsg=d.getCellData("Data1", "Password Error", 3);;
	public String invalidEmailErrMsg=d.getCellData("Data1", "Email Error", 5);;

}
