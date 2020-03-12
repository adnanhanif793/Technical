package eInvoice.dewdrops.invoice_resource_endpoint;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
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

public class EINVOICE_12162_SavedFilterWithId extends TestBase {
    @Test()
	public void SavedFilter_GET() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		//String FilterId=db.getFilterDetails("filter_id", tenantid, userId);
		String FilterId=reader.getCellData("Filters", "filter_id",2 );
		String url=URL.getEndPoint(dewdrops_APIList.savedFilter_Api,FilterId);
		Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
		assertTrue(TestUtil.verifyResponse(res));
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.entityData.filterId"), Arrays.asList(FilterId));
	}
    
    @Test()
   	public void SavedFilter_GET_InvalidData() {
   		String userId=TestUtil.getUserid();
   		String tenantid=TestUtil.getTenantid();
   		int trackingNumber=TestUtil.randomTrackingNumber();
   		String entityId = TestUtil.randomentityId();
   		//String FilterId=db.getFilterDetails("filter_id", tenantid, userId);
   		String url=URL.getEndPoint(dewdrops_APIList.savedFilter_Api,entityId);
   		Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
   		assertTrue(TestUtil.verifyResponse(res));
   		Reporter.log("Response1 "+res.asString(),true);
   		assertNotEquals(res.jsonPath().get("businessEntity.entityData.filterId"), Arrays.asList(entityId));
   		
   	}
    @Test()
   	public void SavedFilter_GET_InvData() {
   		String userId=" ";
   		String tenantid=TestUtil.getTenantid();
   		int trackingNumber=TestUtil.randomTrackingNumber();
   		//String FilterId=db.getFilterDetails("filter_id", tenantid, userId);
   		String FilterId=reader.getCellData("Filters", "filter_id",2 );
   		String url=URL.getEndPoint(dewdrops_APIList.savedFilter_Api,FilterId);
   		Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
   		assertFalse(TestUtil.verifyResponse(res));
   		Reporter.log("Response "+res.asString(),true);
   		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
   		
   	}
       
}
