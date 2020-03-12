package eInvoice.dewdrops.workflowApproval_resource_endpoint;

import static org.junit.Assert.assertFalse;
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

public class EINVOICE_12294_remindWorkflowApproval extends TestBase {
	@Test
	public void testdelegateWorkflowWithValidApprovalId() throws Exception {
		  String userId=TestUtil.getUserid();
		  String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String approvalId=reader.getCellData("Workflow", "Approvalid_remind",2 );
		  String workflowInstanceId=reader.getCellData("Workflow", "workflowInstanceId_remind",2);
		  String url=URL.getEndPoint(dewdrops_APIList.remindworkflow_Api,approvalId,"/remindWorkflowApproval");
          String s1 = JsonPath.getCellData("JsonBody", "JsonData",13);
		 // String createIssuePayLaod = TestUtil.generatePayLoadString("remindWorkflowApproval");
		  JSONObject existingPreferenceObject = new JSONObject(s1);
	      JSONArray jsonChildObject = (JSONArray) existingPreferenceObject.get("businessEntity");
	      JSONObject js1=(JSONObject) jsonChildObject.get(0);
	      JSONObject js2=js1.getJSONObject("entityData");
	      js2.put("workflowInstanceId", workflowInstanceId);
	      String finalJson = ((Object) existingPreferenceObject).toString();
	      //System.out.println(finalJson);
	      Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response "+res.asString(),true);
          assertEquals(res.jsonPath().get("businessEntity.entityData.id[0]"), approvalId,"Somne thing wrong approvalId not matching ");

}
	@Test
	public void testdelegateWorkflowWithInValidApprovalId() throws Exception {
		  String userId=TestUtil.getUserid();
		  String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String approvalId=reader.getCellData("Workflow", "Approvalid_remind",3 );
		  String workflowInstanceId=reader.getCellData("Workflow", "workflowInstanceId_remind",2);
		  String url=URL.getEndPoint(dewdrops_APIList.remindworkflow_Api,approvalId,"/remindWorkflowApproval");
          String s1 = JsonPath.getCellData("JsonBody", "JsonData",13);
		  //String createIssuePayLaod = TestUtil.generatePayLoadString("remindWorkflowApproval");
		  JSONObject existingPreferenceObject = new JSONObject(s1);
	      JSONArray jsonChildObject = (JSONArray) existingPreferenceObject.get("businessEntity");
	      JSONObject js1=(JSONObject) jsonChildObject.get(0);
	      JSONObject js2=js1.getJSONObject("entityData");
	      js2.put("workflowInstanceId", workflowInstanceId);
	      String finalJson = ((Object) existingPreferenceObject).toString();
	      //System.out.println(finalJson);
	      Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
		  assertFalse(TestUtil.verifyResponse(res));
		  Reporter.log("Response "+res.asString(),true);
          assertNotEquals(res.jsonPath().get("businessEntity.entityData.id[0]"), approvalId,"Somne thing wrong approvalId not matching ");

}

}
