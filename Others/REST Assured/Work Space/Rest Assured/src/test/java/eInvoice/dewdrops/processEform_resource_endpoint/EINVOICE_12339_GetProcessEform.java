package eInvoice.dewdrops.processEform_resource_endpoint;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.testng.Reporter;
import org.testng.annotations.Test;

import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestBase;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

public class EINVOICE_12339_GetProcessEform extends TestBase {
	@Test()
		public void getProcessEform() {
			String userId=TestUtil.getUserid();
			String tenantid=TestUtil.getTenantid();
			int trackingNumber=TestUtil.randomTrackingNumber();
			String entityId =TestUtil.randomentityId();
			System.out.println(entityId);
			//String processEformId=db.getProcessEform("processeform_id", tenantid);
			String processEformId=reader.getCellData("Filters", "ProcesseFormId",2);
			System.out.println(processEformId);
			String url=URL.getEndPoint(dewdrops_APIList.getProcessEform,processEformId);
		    Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
		    assertTrue(TestUtil.verifyResponse(res));
			Reporter.log("Response of getProcessEform"+res.asString(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
			assertEquals(res.jsonPath().get("businessEntity.entityData.processEform.processEformId"), Arrays.asList(processEformId));
		}


@Test()
public void getProcessEformInvalid() {
	String userId="";
	String tenantid=TestUtil.getTenantid();
	int trackingNumber=TestUtil.randomTrackingNumber();
	//String processEformId1=db.getFilterDetails("filter_id", tenantid, userId);
	String processEformId=reader.getCellData("Filters", "ProcesseFormId",2);
	String url=URL.getEndPoint(dewdrops_APIList.getProcessEform,processEformId);
	Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
	assertFalse(TestUtil.verifyResponse(res));
	Reporter.log("Response "+res.asString(),true);
	assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
}
}