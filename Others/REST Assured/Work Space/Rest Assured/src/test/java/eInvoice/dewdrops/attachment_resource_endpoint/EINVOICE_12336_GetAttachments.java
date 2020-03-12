package eInvoice.dewdrops.attachment_resource_endpoint;
/**
 * Get the attachment based on the parameters and tenantId passed.
 * @author ashiwani.ranjan
 *
 */

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.testng.Reporter;
import org.testng.annotations.Test;
import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestBase;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

public class EINVOICE_12336_GetAttachments extends TestBase {
	@Test
	public void testgetAttachmentWithValiddata() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String attachmentId=db.getAttachmentId("attachment_id", tenantid, userId);
		String url=URL.getEndPoint(dewdrops_APIList.Get_Attachment_Api,attachmentId);
		Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
		TestUtil.verifyResponse(res);
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.jsonPath().get("businessEntity.entityData.documentMappings[0].attachmentId[0]"), attachmentId);
		
	}
	
	@Test
	public void testgetAttachmentWithInvaliddata() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String attachmentId=TestUtil.randomentityId();
		String url=URL.getEndPoint(dewdrops_APIList.Get_Attachment_Api,attachmentId);
		Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
		TestUtil.verifyResponse(res);
		Reporter.log("Response "+res.asString(),true);
		assertNotEquals(res.jsonPath().get("businessEntity.entityData.documentMappings[0].attachmentId[0]"), attachmentId);
		
	}

}
