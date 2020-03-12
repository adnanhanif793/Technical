package eInvoice.dewdrops.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Reporter;

import io.restassured.response.Response;

public class TestUtil {
	
	public final static int RESPONSE_CODE_200 = 200;
	public final static int RESPONSE_CODE_201 = 201;
	public final static int RESPONSE_CODE_400 = 400;	
	public final static int RESPONSE_CODE_401 = 401;
	public final static int RESPONSE_CODE_500 = 500;
	public static final String Bad_Request="INVOICE-40000";
	public static final String Mandatory_Field="INVOICE-40009";
	public static final String Invalid_User="INVOICE-40106";
	public static final String Err_Json_Mapping="INVOICE-40025";
	public static final String Internal_Server_Error="INVOICE-500";
	public static final String Err_Getting_Entity="EINVOICE-50008";
	public final static String WeatherSheetName = "WeatherInfo";
	public final static String InternalServerError = "INVOICE-500";
	public final static String ERR_TRACKING_NUMBER_MISSING = "INVOICE-40105";

	
	public static String readDataFromFile(String filePath) throws FileNotFoundException, IOException {
        //return IOUtils.toString(new FileInputStream(new File(getFileAbsolutePath(filePath))),"UTF-8");
        return IOUtils.toString(new FileInputStream(new File(filePath)),"UTF-8");
    }

    public static String getTest_JSON() throws FileNotFoundException, IOException {
        return readDataFromFile(System.getProperty("user.dir")+"\\src\\main\\java\\eInvoice\\dewdrops\\jsonData\\CREDITMMO_APPOORTIONMENT.json");
    }
    
	public static String getUrl(){
		return TestBase.ReadPropertiesFile().getProperty("baseurl").trim();
	}
	
	public static String getTenantid() {
		return TestBase.ReadPropertiesFile().getProperty("tenantId").trim();
	}
	
	public static String getUserid() {
		return TestBase.ReadPropertiesFile().getProperty("userid").trim();
	}
	
	public static String getDBUserName() {
		return TestBase.ReadPropertiesFile().getProperty("username").trim();
	}
	public static String getDBPassword() {
		return TestBase.ReadPropertiesFile().getProperty("password").trim();
	}
	
	public static String getDBDriverName() {
		return TestBase.ReadPropertiesFile().getProperty("drivername").trim();
	}
	
	public static String getUserFirstName() {
		return TestBase.ReadPropertiesFile().getProperty("userfirstname").trim();
	}
	
	public static String getUserLastName() {
		return TestBase.ReadPropertiesFile().getProperty("userlastname").trim();
	}
	
	public static String generatePayLoadString(String filename){
		
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\eInvoice\\dewdrops\\jsonData\\"+filename+".json";
		try {
			return new String(Files.readAllBytes(Paths.get(filePath)));
			
		} catch (Exception e) {
	
			return null;
		}
    
		
	
}
	 /**
    Compare two lists
   */
   public static boolean compareTwoListObjects(List<Object> excepted, List<Object> actual) {
       if (actual.size() != excepted.size()) {
	      return false;
	      } 
    for (Object value : actual) {
	    if (!excepted.contains(value)) {
		return false;
	}
}
return true;
}
   /**
    * This function will return random tracking number
    * @return
    */
   public static int randomTrackingNumber() {
	   Random random = new Random();
	   int x = random.nextInt(900) + 100;
	   return x;
   }

   /**
    * This function will veify the response
    *
    */
   public static boolean verifyCorrectResponse(Response res) {
	   boolean status=false;
	   if(res.getStatusCode()==200)
		   status=true;
	   else 
		   status=false;
	   
	   return status;
   }
   
   /**
    * This function will return random entityid
    * @return
    */
   public static String randomentityId() {
	   Random random = new Random();
	   int x = random.nextInt(900000) + 100000;
	   return String.valueOf(x);
   }
   
   
   /**
    * This function will check error codes in response 
    * @return
    */
   public static boolean verifyResponse(Response res) {
	   if(res.getBody().asString().contains("errorDescription") || res.getBody().asString()=="") {
		   Reporter.log("Error "+res.jsonPath().get("errors.errorDescription"),true);
		   return false;}
		   else
			  return true;
   }
   
   /**
    * This function will generate random filter name 
    * @return
    */
   public static String generateRandomFilterName() {
	   String s1="Filter"+System.currentTimeMillis();
	  return s1;
	   
   }
   
   
}