package eInvoice.dewdrops.invoice_resource_endpoint;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

public class EINVOICE_12163_FetchingSavedFilters {
	@Test()
	public void Saved_Filter_Api() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.FetchSavedFilters_Api);
	    Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
	    assertTrue(TestUtil.verifyResponse(res));
	    Reporter.log("Response "+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.entityData[0].userId[0]"), userId);
	}
	@Test()
	public void Saved_Filter_InvalidApi() {
		String userId="";
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.FetchSavedFilters_Api);
	    Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
	    assertFalse(TestUtil.verifyResponse(res));
	    Reporter.log("Response "+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
		
	}
	
}
