package eInvoice.dewdrops.workflowApproval_resource_endpoint;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;
import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestBase;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class EINVOICE_12290_delegateWorkflowApproval extends TestBase {
	@Test
	public void testdelegateWorkflowWithValidData() throws Exception {
		  String userId=TestUtil.getUserid();
		  String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String approvalId=reader.getCellData("Workflow", "Approvalid_delegate",2 );
		  String delegateuserlId=reader.getCellData("Workflow", "Approvalid_delegate",2 );
		  String url=URL.getEndPoint(dewdrops_APIList.delegateWorkflow_Api,approvalId,"/delegateWorkflowApproval");
          String s1 = JsonPath.getCellData("JsonBody", "JsonData",6);
		  //String createIssuePayLaod = TestUtil.generatePayLoadString("delegateworkflow");
		  JSONObject existingPreferenceObject = new JSONObject(s1);
	      JSONArray jsonChildObject = (JSONArray) existingPreferenceObject.get("businessEntity");
	      JSONObject js1=(JSONObject) jsonChildObject.get(0);
	      JSONObject js2=js1.getJSONObject("entityData");
	      js2.put("delegatedUserId", delegateuserlId);
	      String finalJson = ((Object) existingPreferenceObject).toString();
	      Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response "+res.asString(),true);
          assertEquals(res.jsonPath().get("businessEntity.entityData.id[0]"), approvalId,"Somne thing wrong approvalId not matching ");

}
	@Test
	public void testdelegateWorkflowWithInvalidData() throws Exception {
		  String userId=TestUtil.getUserid();
		  String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String approvalId=reader.getCellData("Workflow", "Approvalid_delegate",3 );
		  String delegateuserlId=reader.getCellData("Workflow", "Approvalid_delegate",2 );
		  String url=URL.getEndPoint(dewdrops_APIList.delegateWorkflow_Api,approvalId,"/delegateWorkflowApproval");
          String s1 = JsonPath.getCellData("JsonBody", "JsonData",6);
		  //String createIssuePayLaod = TestUtil.generatePayLoadString("delegateworkflow");
		  JSONObject existingPreferenceObject = new JSONObject(s1);
	      JSONArray jsonChildObject = (JSONArray) existingPreferenceObject.get("businessEntity");
	      JSONObject js1=(JSONObject) jsonChildObject.get(0);
	      JSONObject js2=js1.getJSONObject("entityData");
	      js2.put("delegatedUserId", delegateuserlId);
	      String finalJson = ((Object) existingPreferenceObject).toString();
	      Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertFalse(TestUtil.verifyResponse(res));
		  Reporter.log("Response "+res.asString(),true);
          assertNotEquals(res.jsonPath().get("businessEntity.entityData.id[0]"), approvalId,"Somne thing wrong approvalId not matching ");

}
}