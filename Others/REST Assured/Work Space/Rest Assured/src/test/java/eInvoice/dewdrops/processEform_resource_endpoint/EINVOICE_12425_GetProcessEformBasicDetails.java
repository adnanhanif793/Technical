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

public class EINVOICE_12425_GetProcessEformBasicDetails extends TestBase {
	@Test()
	public void getProcessEformBasic() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		//String processEformId=db.getProcessEform("processeform_id", tenantid);
		String processEformId=reader.getCellData("Filters", "ProcesseFormId",2);
		//System.out.println(processEformId);
		String url=URL.getEndPoint(dewdrops_APIList.getProcessEformBasic,processEformId,"/basicDetails");
	    Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
	    assertTrue(TestUtil.verifyResponse(res));
		Reporter.log("Response of getProcessEformBasic"+" "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.entityData.processEformId"), Arrays.asList(processEformId));
	}
	@Test()
	public void getProcessEformBasic_InvalidUserId() {
		String userId=" ";
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		//String processEformId=db.getProcessEform("processeform_id", tenantid);
		String processEformId=reader.getCellData("Filters", "ProcesseFormId",2);
		System.out.println(processEformId);
		String url=URL.getEndPoint(dewdrops_APIList.getProcessEformBasic,processEformId,"/basicDetails");
	    Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
	    assertFalse(TestUtil.verifyResponse(res));
		Reporter.log("Response of getProcessEformBasic"+" "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
	}
	@Test()
	public void getProcessEformBasic_InvalidTenant() {
		String userId=TestUtil.getUserid();
		String tenantid=" ";
		int trackingNumber=TestUtil.randomTrackingNumber();
		//String processEformId=db.getProcessEform("processeform_id", tenantid);
		String processEformId=reader.getCellData("Filters", "ProcesseFormId",2);
		System.out.println(processEformId);
		String url=URL.getEndPoint(dewdrops_APIList.getProcessEformBasic,processEformId,"/basicDetails");
	    Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
	    assertFalse(TestUtil.verifyResponse(res));
		Reporter.log("Response of getProcessEformBasic"+" "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
	}
	@Test()
	public void getProcessEformBasic_InvalidProcessEformId() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String entityId = TestUtil.randomentityId();
		//String processEformId=db.getProcessEform("processeform_id", tenantid);
		String processEformId=reader.getCellData("Filters", "ProcesseFormId",2);
		System.out.println(processEformId);
		String url=URL.getEndPoint(dewdrops_APIList.getProcessEformBasic,entityId,"/basicDetails");
	    Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
	    assertFalse(TestUtil.verifyResponse(res));
		Reporter.log("Response of getProcessEformBasic"+" "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
	}
	@Test()
	public void getProcessEformBasic_InvalidTrackingId() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		String processEformId=reader.getCellData("Filters", "ProcesseFormId",2);
		System.out.println(processEformId);
		String url=URL.getEndPoint(dewdrops_APIList.getProcessEformBasic,processEformId,"/basicDetails");
	    Response res=Webservices.GETRequestWithHeader(url, userId, tenantid);
	    assertFalse(TestUtil.verifyResponse(res));
		Reporter.log("Response of getProcessEformBasic"+" "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
	}
}
