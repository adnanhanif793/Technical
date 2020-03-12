package eInvoice.dewdrops.supplier_resource_endpoint;

import static org.testng.Assert.assertEquals;
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

public class EINVOICE_13428_getSupplierAccountGroups extends TestBase {

	  @Test()
			public void getSupplierAccountGroups() {
				String userId=TestUtil.getUserid();
				String tenantid=TestUtil.getTenantid();
				int trackingNumber=TestUtil.randomTrackingNumber();
				String url=URL.getEndPoint(dewdrops_APIList.getSupplierAccountGroups);
				Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
				assertTrue(TestUtil.verifyResponse(res));
				Reporter.log("Response "+res.asString(),true);
				assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
				assertEquals(res.jsonPath().get("businessEntity.entityData.OTHERS"), Arrays.asList("Others"));
			}
	  
	  @Test()
		public void getSupplierAccountGroups_Invaiduser_id() {
			String userId="trackingNumber";
			String tenantid=TestUtil.getTenantid();
			int trackingNumber=TestUtil.randomTrackingNumber();
			String url=URL.getEndPoint(dewdrops_APIList.getSupplierAccountGroups);
			Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
			Reporter.log("Response "+res.asString(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
			assertEquals(res.jsonPath().get("errors.errorDescription"), Arrays.asList("Invalid User Id."));
		}
	  @Test()
		public void getSupplierAccountGroups_Invalidtenant_id() {
			String userId=TestUtil.getUserid();
			String tenantid="Invalid_TenantId";
			int trackingNumber=TestUtil.randomTrackingNumber();
			String url=URL.getEndPoint(dewdrops_APIList.getSupplierAccountGroups);
			Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
			Reporter.log("Response "+res.asString(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
			assertEquals(res.jsonPath().get("errors.errorDescription"), Arrays.asList("Invalid User Id."));
		}
	  @Test()
		public void getSupplierAccountGroups_InvalidTrackingNuber() {
			String userId=TestUtil.getUserid();
			String tenantid=TestUtil.getTenantid();
			String url=URL.getEndPoint(dewdrops_APIList.getSupplierAccountGroups);
			Response res=Webservices.GETRequestWithHeader(url, userId, tenantid);
			Reporter.log("Response "+res.asString(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
			assertEquals(res.jsonPath().get("errors.errorDescription"), Arrays.asList("ERR_TRACKING_NUMBER_MISSING"));
		}



}
