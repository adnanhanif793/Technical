package eInvoice.dewdrops.invoice_resource_endpoint;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestBase;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

public class EINVOICE_12275_CreditMemoFilter  extends TestBase {
	@Test
	public void testcreditmemofilter_using_cmnumber() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();;
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String Fieldname=reader.getCellData("filterAPI", "fieldname",2 );
	  String value=reader.getCellData("filterAPI", "valuecreditmemo",2 );
	  String url=URL.getEndPoint(dewdrops_APIList.filterAPI_CreditMemo);
	  String s1 = JsonPath.getCellData("JsonBody", "JsonData",8);
	  //String createIssuePayLaod = TestUtil.generatePayLoadString("Filter_API_CreditMemo");
	  JSONObject js=new JSONObject(s1);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
	  JSONObject js4=js3.getJSONObject(0);
	  JSONArray js5=js4.getJSONArray("criteria");
	  JSONObject js6=js5.getJSONObject(0);
	  js6.put("fieldName",Fieldname);
	  js6.put("value",value);
	  String finalJson = ((Object) js).toString();
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  System.out.println("Response123456"+" "+res.toString());
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.invoiceNumber[0]"), value);
	  }
	@Test
	public void testcreditmemofilter_using_supplierName() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String Fieldname=reader.getCellData("filterAPI", "fieldname",3 );
	  String value=reader.getCellData("filterAPI", "valuecreditmemo",3 );
	  String url=URL.getEndPoint(dewdrops_APIList.filterAPI_CreditMemo);
	  String s1 = JsonPath.getCellData("JsonBody", "JsonData",8);
	 // String createIssuePayLaod = TestUtil.generatePayLoadString("Filter_API_CreditMemo");
	  JSONObject js=new JSONObject(s1);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
	  JSONObject js4=js3.getJSONObject(0);
	  JSONArray js5=js4.getJSONArray("criteria");
	  JSONObject js6=js5.getJSONObject(0);
	  js6.put("fieldName",Fieldname);
	  js6.put("value",value);
	  String finalJson = ((Object) js).toString();
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.supplierName[0]"), value);
	  }

	@Test
	public void testcreditmemofilter_using_status() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String Fieldname=reader.getCellData("filterAPI", "fieldname",5 );
	  String value=reader.getCellData("filterAPI", "valuecreditmemo",5 );
	  String url=URL.getEndPoint(dewdrops_APIList.filterAPI_CreditMemo);
	  String s1 = JsonPath.getCellData("JsonBody", "JsonData",8);
	  // String createIssuePayLaod = TestUtil.generatePayLoadString("Filter_API_CreditMemo");
      JSONObject js=new JSONObject(s1);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
	  JSONObject js4=js3.getJSONObject(0);
	  JSONArray js5=js4.getJSONArray("criteria");
	  JSONObject js6=js5.getJSONObject(0);
	  js6.put("fieldName",Fieldname);
	  js6.put("value",value.substring(0, 3));
	  String finalJson = ((Object) js).toString();
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.status[0]"), Integer.parseInt(value.substring(0, 3)));
	  }
	@Test
	public void testcreditmemofilter_using_ponumber() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String Fieldname=reader.getCellData("filterAPI", "fieldname",6 );
	  String value=reader.getCellData("filterAPI", "valuecreditmemo",6 );
	  String url=URL.getEndPoint(dewdrops_APIList.filterAPI_CreditMemo);
	  String s1 = JsonPath.getCellData("JsonBody", "JsonData",8);
		 // String createIssuePayLaod = TestUtil.generatePayLoadString("Filter_API_CreditMemo");
		  JSONObject js=new JSONObject(s1);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
	  JSONObject js4=js3.getJSONObject(0);
	  JSONArray js5=js4.getJSONArray("criteria");
	  JSONObject js6=js5.getJSONObject(0);
	  js6.put("fieldName",Fieldname);
	  js6.put("value",value);
	  String finalJson = ((Object) js).toString();
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.purchaseOrderNumber[0]"), value);
	  }

}

