package eInvoice.dewdrops.workflowApproval_resource_endpoint;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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

public class EINVOICE_12886_rejectWorkflowApproval extends TestBase {
	@Test
	public void approveeWorkflowWithValidApprovalId() throws Exception {
		  String userId=TestUtil.getUserid();
		  String tenantid=TestUtil.getTenantid();
		  int trackingNumber=TestUtil.randomTrackingNumber();
		  String RejectId=reader.getCellData("Workflow", "RejectId",2 );
		  String url=URL.getEndPoint(dewdrops_APIList.RejectWorkflowApproval,RejectId,"/rejectWorkflowApproval");
	      String s1 = JsonPath.getCellData("JsonBody", "JsonData",12);
		 // String createIssuePayLaod = TestUtil.generatePayLoadString("rejectWorkflowApproval");
	      Response res=Webservices.POSTRequestWithHeader(url, s1, userId, tenantid, trackingNumber);
		  assertTrue(TestUtil.verifyResponse(res));
		  Reporter.log("Response "+res.asString(),true);
          assertEquals(res.jsonPath().get("businessEntity.entityData.id[0]"), RejectId,"Somne thing wrong approvalId not matching ");
}


}
