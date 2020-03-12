package eInvoice.dewdrops.supplier_resource_endpoint;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;
import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.TestBase;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

public class EINVOICE_12278_Search_Supplier  extends TestBase{
	
	@Test
	public void testsearchSupplier_using_NAME() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  String Fieldname=reader.getCellData("supplier", "fieldname",2 );
	  String value=reader.getCellData("supplier", "value",2 );
	  String url=URL.getEndPoint(dewdrops_APIList.searchSupplier_Api);
	  String s1 = JsonPath.getCellData("JsonBody", "JsonData",16);
	  JSONObject js=new JSONObject(s1);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteria");
	  JSONObject js4=js3.getJSONObject(0);
	  js4.put("fieldName",Fieldname);
	  js4.put("value",value);
	  String finalJson = ((Object) js).toString();
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("Response-> "+res.asString(),true);
	  assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
	  assertEquals(res.jsonPath().get("result.name[0]"), value);
	  }
	@Test
	public void testsearchSupplier_using_SupplierID() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  String Fieldname=reader.getCellData("supplier", "fieldname",3 );
		  String value=reader.getCellData("supplier", "value",3 );
		  String url=URL.getEndPoint(dewdrops_APIList.searchSupplier_Api);
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",16);
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteria");
		  JSONObject js4=js3.getJSONObject(0);
		  js4.put("fieldName",Fieldname);
		  js4.put("value",value.substring(0, value.length()-2));
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response-> "+res.asString(),true);
		  assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		  assertEquals(res.jsonPath().get("result.supplierId[0]"), value.substring(0, value.length()-2));
		  }
	@Test
	public void testsearchSupplier_using_ERP_ID() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  String Fieldname=reader.getCellData("supplier", "fieldname",4 );
		  String value=reader.getCellData("supplier", "value",4 );
		  String url=URL.getEndPoint(dewdrops_APIList.searchSupplier_Api);
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",16);
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteria");
		  JSONObject js4=js3.getJSONObject(0);
		  js4.put("fieldName",Fieldname);
		  js4.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response-> "+res.asString(),true);
		  assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		  assertEquals(res.jsonPath().get("result.erpId[0]"), value);
		  }
	@Test
	public void testsearchSupplier_using_USER_OU() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  String Fieldname=reader.getCellData("supplier", "fieldname",5 );
		  String value=reader.getCellData("supplier", "value",5);
		  String url=URL.getEndPoint(dewdrops_APIList.searchSupplier_Api);
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",16);
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteria");
		  JSONObject js4=js3.getJSONObject(0);
		  js4.put("fieldName",Fieldname);
		  js4.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid);
		  assertTrue(TestUtil.verifyResponse(res));  
		  Reporter.log("Response-> "+res.asString(),true);
		  assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		 
		  }
	@Test
	public void testsearchSupplier_using_SEARCH_BY_ACTIVE_ONHOLD_SUPPLIERS() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  String Fieldname=reader.getCellData("supplier", "fieldname",7);
		  String value=reader.getCellData("supplier", "value",7);
		  String url=URL.getEndPoint(dewdrops_APIList.searchSupplier_Api);
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",16);
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteria");
		  JSONObject js4=js3.getJSONObject(0);
		  js4.put("fieldName",Fieldname);
		  js4.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response-> "+res.asString(),true);
		  assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		  }
	@Test
	public void testsearchSupplier_using_SEARCH_BY_ACTIVE() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  String Fieldname=reader.getCellData("supplier", "fieldname",8);
		  String value=reader.getCellData("supplier", "value",8);
		  String url=URL.getEndPoint(dewdrops_APIList.searchSupplier_Api);
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",16);
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteria");
		  JSONObject js4=js3.getJSONObject(0);
		  js4.put("fieldName",Fieldname);
		  js4.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response-> "+res.asString(),true);
		  assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		  }

	@Test
	public void testsearchSupplier_using_SEARCH_ONLY_GLOBAL_SUPPLIER() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  String Fieldname=reader.getCellData("supplier", "fieldname",9);
		  String value=reader.getCellData("supplier", "value",9);
		  String url=URL.getEndPoint(dewdrops_APIList.searchSupplier_Api);
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",16);
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteria");
		  JSONObject js4=js3.getJSONObject(0);
		  js4.put("fieldName",Fieldname);
		  js4.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response-> "+res.asString(),true);
		  assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		  }
	@Test
	public void testsearchSupplier_using_SEARCH_BY_DISPLAY_GLOBAL_SUPPLIER_ID() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  String Fieldname=reader.getCellData("supplier", "fieldname",10);
		  String value=reader.getCellData("supplier", "value",10);
		  String url=URL.getEndPoint(dewdrops_APIList.searchSupplier_Api);
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",16);
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteria");
		  JSONObject js4=js3.getJSONObject(0);
		  js4.put("fieldName",Fieldname);
		  js4.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response-> "+res.asString(),true);
		  assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		  }
	@Test
	public void testsearchSupplier_using_SEARCH_IN_DELETED() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  String Fieldname=reader.getCellData("supplier", "fieldname",6);
		  String value=reader.getCellData("supplier", "value",6);
		  String url=URL.getEndPoint(dewdrops_APIList.searchSupplier_Api);
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",16);
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteria");
		  JSONObject js4=js3.getJSONObject(0);
		  js4.put("fieldName",Fieldname);
		  js4.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response-> "+res.asString(),true);
		  assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		  }
	@Test
	public void testsearchSupplier_using_SEARCH_IN_SUPPLIER_IDS() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  String Fieldname=reader.getCellData("supplier", "fieldname",10);
		  String value=reader.getCellData("supplier", "value",10);
		  String url=URL.getEndPoint(dewdrops_APIList.searchSupplier_Api);
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",16);
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteria");
		  JSONObject js4=js3.getJSONObject(0);
		  js4.put("fieldName",Fieldname);
		  js4.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response-> "+res.asString(),true);
		  assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		  }
}
