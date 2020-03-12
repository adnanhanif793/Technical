package eInvoice.dewdrops.invoice_resource_endpoint;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.testng.Reporter;
import org.testng.annotations.Test;

import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

public class EINVOICE_12228_DeleteFilterApiWithFilterId extends EINVOICE_12167_UpdateFilterWithCreateFilterInput {
	 @Test()
		public void Delete_Filter_Api() {
			String userId=TestUtil.getUserid();
			String tenantid=TestUtil.getTenantid();
			int trackingNumber=TestUtil.randomTrackingNumber();
		    String url=URL.getEndPoint(dewdrops_APIList.Delete_Filter_Api,res1,"/delete");
		    Response res=Webservices.DeleteRequestWithHeader(url, userId, tenantid, trackingNumber);
		    assertTrue(TestUtil.verifyResponse(res));
		    Reporter.log("Response "+res.asString(),true);
			Reporter.log("Status Code "+res.statusCode(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
			assertEquals(res.jsonPath().get("businessEntity.entityData.info1"),Arrays.asList("Deleted filter successfully"));
		}
	 
	 @Test()
		public void Delete_Filter_Api_InvalidId() {
			String userId="";
			String tenantid=TestUtil.getTenantid();
			int trackingNumber=TestUtil.randomTrackingNumber();
		    String url=URL.getEndPoint(dewdrops_APIList.Delete_Filter_Api,res1,"/delete");
		    Response res=Webservices.DeleteRequestWithHeader(url, userId, tenantid, trackingNumber);
		    assertFalse(TestUtil.verifyResponse(res));
			Reporter.log("Response "+res.asString(),true);
			Reporter.log("StatusCode "+res.statusCode(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
		}
}
