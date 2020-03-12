package eInvoice.dewdrops.invoice_resource_endpoint;
/**
 * Get the Audit trail for EINVOICE based on the parameters and tenantId passed.
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

public class EINVOICE_12338_InvoiceAuditTrail extends TestBase {
	@Test()
	public void testgetAuditTrailInvoiceValidData() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		//String entityid=db.getInvoiceDetails("invoice_id", tenantid, userId);
		String entityid=reader.getCellData("AuditTrail", "EntityId_Invoice",3 );
		int trackingNumber=TestUtil.randomTrackingNumber();
		String url=URL.getEndPoint(dewdrops_APIList.Get_Audittrail_Invoice_Api, entityid, "/auditTrail/EINVOICE");
		Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
		TestUtil.verifyResponse(res);
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.jsonPath().get("businessEntity.entityData[0].entityId[0]"), entityid);
		assertEquals(res.jsonPath().get("businessEntity.entityData[0].entityType[0]"),"EINVOICE");
		
		
	
	}
    @Test()
	public void testgetAuditTrailInvoiceInvalidData() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		String entityid=TestUtil.randomentityId();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String url=URL.getEndPoint(dewdrops_APIList.Get_Audittrail_Invoice_Api, entityid, "/auditTrail/EINVOICE");
		Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
		TestUtil.verifyResponse(res);
		Reporter.log("Response "+res.asString(),true);
		assertNotEquals(res.jsonPath().get("businessEntity.entityData[0].entityId[0]"), entityid);
		assertNotEquals(res.jsonPath().get("businessEntity.entityData[0].entityType[0]"),"EINVOICE");
	
	}

}
