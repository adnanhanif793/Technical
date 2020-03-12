package eInvoice.dewdrops.workflowApproval_resource_endpoint;

import static org.testng.Assert.assertEquals;
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

public class EINVOICE_12880_approveWorkflowApproval extends TestBase {
	@Test
	public void approveeWorkflowWithValidApprovalId() throws Exception {
		  String userId=TestUtil.getUserid();
		  String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String approvalId=reader.getCellData("Workflow", "Approvalid_remind",2 );
		  String url=URL.getEndPoint(dewdrops_APIList.ApproveWorkflowApproval,approvalId,"/approveWorkflowApproval");
	      String s1 = JsonPath.getCellData("JsonBody", "JsonData",3);
		 // String createIssuePayLaod = TestUtil.generatePayLoadString("approveWorkflowApproval");
		  JSONObject existingPreferenceObject = new JSONObject(s1);
	      JSONArray jsonChildObject = (JSONArray) existingPreferenceObject.get("businessEntity");
	      JSONObject js1=(JSONObject) jsonChildObject.get(0);
	      JSONObject js2=js1.getJSONObject("entityData");
	      js2.put("approvedAmount", reader.getCellData("Workflow", "Amount", 2));
	      String finalJsonApprove = ((Object) existingPreferenceObject).toString();
	      //System.out.println(finalJsonApprove);
	      Response res=Webservices.POSTRequestWithHeader(url, finalJsonApprove, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response "+res.asString(),true);
          assertEquals(res.jsonPath().get("businessEntity.entityData.id[0]"), approvalId,"Somne thing wrong approvalId not matching ");
}
}