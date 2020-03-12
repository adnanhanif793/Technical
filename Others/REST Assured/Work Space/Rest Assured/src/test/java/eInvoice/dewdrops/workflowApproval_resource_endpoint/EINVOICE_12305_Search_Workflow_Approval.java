package eInvoice.dewdrops.workflowApproval_resource_endpoint;
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

public class EINVOICE_12305_Search_Workflow_Approval  extends TestBase{
	
	@Test
	public void testsearchWorkflow_using_entityNumber() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String Fieldname=reader.getCellData("approval", "fieldname",2 );
	  String value=reader.getCellData("approval", "value",2 );
	  String url=URL.getEndPoint(dewdrops_APIList.Search_Approval+"allRequests");
      String s1 = JsonPath.getCellData("JsonBody", "JsonData",2);
	 // String createIssuePayLaod = TestUtil.generatePayLoadString("approval_search");
	  JSONObject js=new JSONObject(s1);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
	  JSONObject js4=js3.getJSONObject(0);
	  JSONArray js5=js4.getJSONArray("criteria");
	  JSONObject js6=js5.getJSONObject(1);
	  js6.put("fieldName",Fieldname);
	  js6.put("value",value);
	  String finalJson = ((Object) js).toString();
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.entityNumber[0]"), value);
	  }
	@Test
	public void testsearchWorkflow_using_entityInitiator() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String Fieldname=reader.getCellData("approval", "fieldname",3 );
	  String value=reader.getCellData("approval", "value",3 );
	  String url=URL.getEndPoint(dewdrops_APIList.Search_Approval+"allRequests");
      String s1 = JsonPath.getCellData("JsonBody", "JsonData",2);
	  //String createIssuePayLaod = TestUtil.generatePayLoadString("approval_search");
	  JSONObject js=new JSONObject(s1);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
	  JSONObject js4=js3.getJSONObject(0);
	  JSONArray js5=js4.getJSONArray("criteria");
	  JSONObject js6=js5.getJSONObject(1);
	  js6.put("fieldName",Fieldname);
	  js6.put("value",value);
	  String finalJson = ((Object) js).toString();
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.entityInitiator[0]"), value);
	  }
	@Test
	public void testsearchWorkflow_using_entityCreatedBy() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String Fieldname=reader.getCellData("approval", "fieldname",4 );
		  String value=reader.getCellData("approval", "value",4 );
		  String url=URL.getEndPoint(dewdrops_APIList.Search_Approval+"allRequests");
	      String s1 = JsonPath.getCellData("JsonBody", "JsonData",2);
		  //String createIssuePayLaod = TestUtil.generatePayLoadString("approval_search");
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
		  JSONObject js4=js3.getJSONObject(0);
		  JSONArray js5=js4.getJSONArray("criteria");
		  JSONObject js6=js5.getJSONObject(1);
		  js6.put("fieldName",Fieldname);
		  js6.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("responseResult1-> "+res.asString(),true);
		  assertEquals(res.jsonPath().get("result.entityCreatedBy[0]"), value);
		  }

	@Test
	public void testsearchWorkflow_using_approvalType() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String Fieldname=reader.getCellData("approval", "fieldname",5 );
		  String value=reader.getCellData("approval", "value",5 );
		  String url=URL.getEndPoint(dewdrops_APIList.Search_Approval+"allRequests");
	      String s1 = JsonPath.getCellData("JsonBody", "JsonData",2);
		  //String createIssuePayLaod = TestUtil.generatePayLoadString("approval_search");
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
		  JSONObject js4=js3.getJSONObject(0);
		  JSONArray js5=js4.getJSONArray("criteria");
		  JSONObject js6=js5.getJSONObject(1);
		  js6.put("fieldName",Fieldname);
		  js6.put("value",Integer.parseInt(value.substring(0, 1)));
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("responseResult1-> "+res.asString(),true);
		  assertEquals(res.jsonPath().get("result.approvalType[0]"), Integer.parseInt(value.substring(0, 1)));
		  }
	
	@Test
	public void testsearchWorkflow_using_approvalValue() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String Fieldname=reader.getCellData("approval", "fieldname",6 );
		  String value=reader.getCellData("approval", "value",6 );
		  String url=URL.getEndPoint(dewdrops_APIList.Search_Approval+"allRequests");
	      String s1 = JsonPath.getCellData("JsonBody", "JsonData",2);
		  //String createIssuePayLaod = TestUtil.generatePayLoadString("approval_search");
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
		  JSONObject js4=js3.getJSONObject(0);
		  JSONArray js5=js4.getJSONArray("criteria");
		  JSONObject js6=js5.getJSONObject(1);
		  js6.put("fieldName",Fieldname);
		  js6.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("responseResult1-> "+res.asString(),true);
		  assertEquals(res.jsonPath().get("result.approvalValue[0]"), value);
		  }
	@Test
	public void testsearchWorkflow_using_approvalId() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String Fieldname=reader.getCellData("approval", "fieldname",7 );
		  String value=reader.getCellData("approval", "value",7 );
		  String url=URL.getEndPoint(dewdrops_APIList.Search_Approval+"allRequests");
	      String s1 = JsonPath.getCellData("JsonBody", "JsonData",2);
		 // String createIssuePayLaod = TestUtil.generatePayLoadString("approval_search");
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
		  JSONObject js4=js3.getJSONObject(0);
		  JSONArray js5=js4.getJSONArray("criteria");
		  JSONObject js6=js5.getJSONObject(1);
		  js6.put("fieldName",Fieldname);
		  js6.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("responseResult1-> "+res.asString(),true);
		  assertEquals(res.jsonPath().get("result.approvalId[0]"), value);
		  }
	
	@Test
	public void testsearchWorkflow_using_entityCurrency() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String Fieldname=reader.getCellData("approval", "fieldname",8 );
		  String value=reader.getCellData("approval", "value",8 );
		  String url=URL.getEndPoint(dewdrops_APIList.Search_Approval+"allRequests");
	      String s1 = JsonPath.getCellData("JsonBody", "JsonData",2);
		  //String createIssuePayLaod = TestUtil.generatePayLoadString("approval_search");
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
		  JSONObject js4=js3.getJSONObject(0);
		  JSONArray js5=js4.getJSONArray("criteria");
		  JSONObject js6=js5.getJSONObject(1);
		  js6.put("fieldName",Fieldname);
		  js6.put("value",value);
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("responseResult1-> "+res.asString(),true);
		  assertEquals(res.jsonPath().get("result.entityCurrency[0]"), value);
		  }
	


	@Test
	public void testsearchWorkflow_using_status() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String Fieldname=reader.getCellData("approval", "fieldname",10 );
		  String value=reader.getCellData("approval", "value",10 );
		  String url=URL.getEndPoint(dewdrops_APIList.Search_Approval+"allRequests");
	      String s1 = JsonPath.getCellData("JsonBody", "JsonData",2);
		  //String createIssuePayLaod = TestUtil.generatePayLoadString("approval_search");
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
		  JSONObject js4=js3.getJSONObject(0);
		  JSONArray js5=js4.getJSONArray("criteria");
		  JSONObject js6=js5.getJSONObject(1);
		  js6.put("fieldName",Fieldname);
		  js6.put("value",Integer.parseInt(value.substring(0, 1)));
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("responseResult1-> "+res.asString(),true);
		  assertEquals(res.jsonPath().get("result.status[0]"), Integer.parseInt(value.substring(0, 1)));
		  }
	@Test
	public void testsearchWorkflow_using_processingStatus() throws Exception {
		  String userId=TestUtil.getUserid();
	      String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String Fieldname=reader.getCellData("approval", "fieldname",11 );
		  String value=reader.getCellData("approval", "value",11 );
		  String url=URL.getEndPoint(dewdrops_APIList.Search_Approval+"allRequests");
	      String s1 = JsonPath.getCellData("JsonBody", "JsonData",2);
		 // String createIssuePayLaod = TestUtil.generatePayLoadString("approval_search");
		  JSONObject js=new JSONObject(s1);
		  JSONObject js2=js.getJSONObject("criteriaGroup");
		  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
		  JSONObject js4=js3.getJSONObject(0);
		  JSONArray js5=js4.getJSONArray("criteria");
		  JSONObject js6=js5.getJSONObject(1);
		  js6.put("fieldName",Fieldname);
		  js6.put("value",Integer.parseInt(value.substring(0, 1)));
		  String finalJson = ((Object) js).toString();
		  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("responseResult1-> "+res.asString(),true);
		  assertEquals(res.jsonPath().get("result.processingStatus[0]"), Integer.parseInt(value.substring(0, 1)));
		  }
	
}
