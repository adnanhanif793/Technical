package eInvoice.dewdrops.processEform_resource_endpoint;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestBase;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

public class EINVOICE_12341_UpdateProcessEform extends TestBase{
	@Test()
	public  void Eform_Updation() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.updateProcessEform);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",18);
	    System.out.println("JsonBody"+s1);
	   // String createIssuePayLaod = TestUtil.generatePayLoadString("UpdateProcessEform");
	    Response res=Webservices.POSTRequestWithHeader(url, s1,userId, tenantid, trackingNumber);
	    assertTrue(TestUtil.verifyResponse(res));
		Reporter.log("Response of Eform_Updation"+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.entityData.tenantId"), Arrays.asList(tenantid));
}
	@Test()
	public  void Eform_Updation_Status_1() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.updateProcessEform);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",18);
	   // String createIssuePayLaod = TestUtil.generatePayLoadString("UpdateProcessEform");
	    JSONObject js = new JSONObject(s1);
	    JSONArray js1 = js.getJSONArray("businessEntity");
	    JSONObject js2 = js1.getJSONObject(0);
		JSONObject js3 = (JSONObject) js2.get("entityData");
		js3.put("status", 1);
		js3.put("type", 1);
		String finalJson = ((Object) js).toString();
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    assertTrue(TestUtil.verifyResponse(res));
		Reporter.log("Response of Eform_Updation_Status_1"+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.entityData.tenantId"), Arrays.asList(tenantid));	
	}
	@Test()
	public  void Eform_Updation_Status_2() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.updateProcessEform);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",18);
	    //String createIssuePayLaod = TestUtil.generatePayLoadString("UpdateProcessEform");
	    JSONObject js = new JSONObject(s1);
	    JSONArray js1 = js.getJSONArray("businessEntity");
	    JSONObject js2 = js1.getJSONObject(0);
		JSONObject js3 = (JSONObject) js2.get("entityData");
		js3.put("status", 2);
		js3.put("type", 0);
		String finalJson = ((Object) js).toString();
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    assertTrue(TestUtil.verifyResponse(res));
		Reporter.log("Response of Eform_Updation_Status_2 "+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.entityData.tenantId"), Arrays.asList(tenantid));	
	}
	@Test()
	public  void Eform_Updation_StatusandType_Invalid() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String entityId = TestUtil.randomentityId();
	    String url=URL.getEndPoint(dewdrops_APIList.updateProcessEform);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",18);
	    //String createIssuePayLaod = TestUtil.generatePayLoadString("UpdateProcessEform");
	    JSONObject js = new JSONObject(s1);
	    JSONArray js1 = js.getJSONArray("businessEntity");
	    JSONObject js2 = js1.getJSONObject(0);
		JSONObject js3 = (JSONObject) js2.get("entityData");
		js3.put("status", entityId);
		js3.put("type", entityId);
		String finalJson = ((Object) js).toString();
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    assertFalse(TestUtil.verifyResponse(res));
		Reporter.log("Response of Eform_Updation_StatusandType_Invalid "+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
			
	}
	@Test()
	public  void Eform_Updation_ProcessCode_InValid() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String entityId = TestUtil.randomentityId();
	    String url=URL.getEndPoint(dewdrops_APIList.updateProcessEform);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",18);
	  //  String createIssuePayLaod = TestUtil.generatePayLoadString("UpdateProcessEform");
	    JSONObject js = new JSONObject(s1);
	    JSONArray js1 = js.getJSONArray("businessEntity");
	    JSONObject js2 = js1.getJSONObject(0);
		JSONObject js3 = (JSONObject) js2.get("entityData");
		js3.put("processCode", entityId);
		String finalJson = ((Object) js).toString();
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    assertFalse(TestUtil.verifyResponse(res));
		Reporter.log("Response of Eform_Updation_ProcessCode_InValid"+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
	}
	@Test()
	public  void Eform_Updation_Description_InValid() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String entityId = TestUtil.randomentityId();
	    String url=URL.getEndPoint(dewdrops_APIList.updateProcessEform);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",18);
	  //  String createIssuePayLaod = TestUtil.generatePayLoadString("UpdateProcessEform");
	    JSONObject js = new JSONObject(s1);
	    JSONArray js1 = js.getJSONArray("businessEntity");
	    JSONObject js2 = js1.getJSONObject(0);
		JSONObject js3 = (JSONObject) js2.get("entityData");
		js3.put("description", "");
		String finalJson = ((Object) js).toString();
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    assertFalse(TestUtil.verifyResponse(res));
		Reporter.log("Response of Eform_Updation_ProcessCode_InValid"+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
	}
	@Test()
	public  void Eform_Updation_Tenant_Invalid() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=" ";
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.updateProcessEform);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",18);
	   // String createIssuePayLaod = TestUtil.generatePayLoadString("UpdateProcessEform");
	    Response res=Webservices.POSTRequestWithHeader(url, s1,userId, tenantid, trackingNumber);
	    assertFalse(TestUtil.verifyResponse(res));
		Reporter.log("Response of Eform_Updation"+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
	
}
	@Test()
	public  void Eform_Updation_UserId_Invalid() throws JSONException  {
		String userId=" ";
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.updateProcessEform);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",18);
	    //String createIssuePayLaod = TestUtil.generatePayLoadString("UpdateProcessEform");
	    Response res=Webservices.POSTRequestWithHeader(url, s1,userId, tenantid, trackingNumber);
	    assertFalse(TestUtil.verifyResponse(res));
		Reporter.log("Response of Eform_Updation"+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
		
}
	@Test()
	public  void Eform_Updation_ProcessEformId_InValid() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String entityId = TestUtil.randomentityId();
	    String url=URL.getEndPoint(dewdrops_APIList.updateProcessEform);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",18);
	   // String createIssuePayLaod = TestUtil.generatePayLoadString("UpdateProcessEform");
	    JSONObject js = new JSONObject(s1);
	    JSONArray js1 = js.getJSONArray("businessEntity");
	    JSONObject js2 = js1.getJSONObject(0);
		JSONObject js3 = (JSONObject) js2.get("entityData");
		js3.put("processEformId", "");
		String finalJson = ((Object) js).toString();
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    assertFalse(TestUtil.verifyResponse(res));
		Reporter.log("Response of Eform_Updation_ProcessCode_InValid"+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
	}
	@Test()
	public  void Eform_Updation_DynamicEformId_Valid() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String entityId = TestUtil.randomentityId();
	    String url=URL.getEndPoint(dewdrops_APIList.updateProcessEform);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",18);
	   //s String createIssuePayLaod = TestUtil.generatePayLoadString("UpdateProcessEform");
	    JSONObject js = new JSONObject(s1);
	    JSONArray js1 = js.getJSONArray("businessEntity");
	    JSONObject js2 = js1.getJSONObject(0);
		JSONObject js3 = (JSONObject) js2.get("entityData");
		js3.put("dynamicFormId", "");
		String finalJson = ((Object) js).toString();
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    assertTrue(TestUtil.verifyResponse(res));
		Reporter.log("Response of Eform_Updation_ProcessCode_InValid"+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.entityData.tenantId"), Arrays.asList(tenantid));
	}
}
