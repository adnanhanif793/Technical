package eInvoice.dewdrops.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import eInvoice.dewdrops.db.dewdropsDBAccess;

public class TestBase {

	
	protected dewdropsDBAccess db=new dewdropsDBAccess();
	protected Xls_reader reader=new Xls_reader(System.getProperty("user.dir") +"\\src\\test\\resources\\ApiTestData_QA.xlsx");
	protected Xls_reader JsonPath=new Xls_reader(System.getProperty("user.dir") +"\\src\\test\\resources\\JsonStorage.xlsx");

	@BeforeSuite
	public void connectDB() {
		db.getConnection();
	}
	
	//Reading config file 
	public static Properties prop;
	public static Properties ReadPropertiesFile(){
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	@AfterSuite
	public void closeDB() {
		db.closeConnection();
	}

}