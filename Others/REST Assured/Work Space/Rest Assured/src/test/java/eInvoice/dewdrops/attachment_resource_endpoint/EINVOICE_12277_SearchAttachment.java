package eInvoice.dewdrops.attachment_resource_endpoint;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

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

public class EINVOICE_12277_SearchAttachment extends TestBase {
	@Test
	public void testSearchAttachmentsWithValidInput() throws Exception {
	  String userId=TestUtil.getUserid();
	  String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String attachementname=reader.getCellData("SearchAttachment", "AttachmentName",2 );
	  String url=URL.getEndPoint(dewdrops_APIList.Search_Attachement_Api);
	  String s1 = JsonPath.getCellData("JsonBody", "JsonData",14);
	  //String createIssuePayLaod = TestUtil.generatePayLoadString("Search_Attachments_API");
	  JSONObject existingPreferenceObject = new JSONObject(s1);
      JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
      JSONArray result = jsonChildObject.getJSONArray("criteriaGroup");
      JSONObject result1 = result.getJSONObject(0);
      //System.out.println("jsonChildObject --> : " + jsonChildObject);
      JSONArray result2 = result1.getJSONArray("criteria");
      //System.out.println("result --> : " + result);
      JSONObject result3 = result2.getJSONObject(0);
      //System.out.println("result1 --> : " + result1);
      result3.put("value", attachementname);
      String finalJson = ((Object) existingPreferenceObject).toString();
      //System.out.println("finalJson1 --> : " + finalJson);
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult-> "+res.asString(),true);
	  Reporter.log("Error -"+res.jsonPath().get("processingErrors"),true);
	  Reporter.log("Total Records "+res.jsonPath().get("pagination.totalRecords"),true);
	  Reporter.log("Error "+res.jsonPath().get("errors.errorCode"),true);
	  
//	  ArrayList<String> attachidfromResponse=res.jsonPath().get("result.attachmentId");
//	  ArrayList<String> attachidfromDB=db.getAttachmentIds("attachment_id",tenantid,userId,"screenshot-1.png");
//	  System.out.println(attachidfromDB);
//	  assertEquals(attachidfromResponse,attachidfromDB,"List is not matching,it is not expected");
	  assertEquals(res.jsonPath().get("result.name[0]"),attachementname,"Some thing wrong");
	 }
	
	@Test
	public void testSearchAttachmentsWithWrongInput() throws Exception {
		  String userId=TestUtil.getUserid();
		  String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String attachementname1=reader.getCellData("SearchAttachment", "AttachmentName",3 );
		  String url=URL.getEndPoint(dewdrops_APIList.Search_Attachement_Api);
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",14);
		//  String createIssuePayLaod = TestUtil.generatePayLoadString("Search_Attachments_API");
		  JSONObject existingPreferenceObject = new JSONObject(s1);
	      JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
	      JSONArray result = jsonChildObject.getJSONArray("criteriaGroup");
	      JSONObject result1 = result.getJSONObject(0);
	     // System.out.println("jsonChildObject --> : " + jsonChildObject);
	      JSONArray result2 = result1.getJSONArray("criteria");
	     // System.out.println("result --> : " + result);
	      JSONObject result3 = result2.getJSONObject(0);
	     // System.out.println("result1 --> : " + result1);
	      result3.put("value", attachementname1);
	      String finalJson = ((Object) existingPreferenceObject).toString();
	     // System.out.println("finalJson1 --> : " + finalJson);
		  Response res1=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res1));
		  Reporter.log("responseResult-> "+res1.asString(),true);
		  Reporter.log("Error -"+res1.jsonPath().get("processingErrors"),true);
		  Reporter.log("Total Records "+res1.jsonPath().get("pagination.totalRecords"),true);
		  Reporter.log("Error "+res1.jsonPath().get("errors.errorCode"),true);
//		  ArrayList<String> attachidfromResponse=res1.jsonPath().get("result.attachmentId");
//		  ArrayList<String> attachidfromDB=db.getAttachmentIds("attachment_id",tenantid,userId,attachementname1);
//		  assertEquals(attachidfromResponse,attachidfromDB,"List is not matching,it is not expected");
		  assertNotEquals(res1.jsonPath().get("result.name[0]"),attachementname1,"Some thing wrong");
		 }
}
