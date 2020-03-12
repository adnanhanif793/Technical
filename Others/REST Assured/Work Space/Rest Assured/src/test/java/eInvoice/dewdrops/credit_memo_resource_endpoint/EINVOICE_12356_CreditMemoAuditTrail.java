package eInvoice.dewdrops.credit_memo_resource_endpoint;
/**
 * Get the Audit trail for credit memo based on the parameters and tenantId passed.
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

public class EINVOICE_12356_CreditMemoAuditTrail extends TestBase {
	@Test()
	public void testgetAuditTrailCreditMemoValidData()  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		//String entityid=db.getCreditMemoDetails("invoice_id", tenantid, userId);
		String entityid=reader.getCellData("AuditTrail", "EntityId_Credit_Memo",2 );
		String url=URL.getEndPoint(dewdrops_APIList.Get_Audittrail_CreditMemo_Api, entityid, "/auditTrail/CREDIT_MEMO");
		Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
		TestUtil.verifyResponse(res);
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.jsonPath().get("businessEntity.entityData[0].entityId[0]"), entityid);
		assertEquals(res.jsonPath().get("businessEntity.entityData[0].entityType[0]"),"CREDIT_MEMO");
			
	}
	
    @Test()
	public void testgetAuditTrailCreditMemoInValidData() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String entityid=TestUtil.randomentityId();
		String url=URL.getEndPoint(dewdrops_APIList.Get_Audittrail_CreditMemo_Api,entityid,"/auditTrail/CREDIT_MEMO");
		Response res=Webservices.GETRequestWithHeader(url, userId, tenantid, trackingNumber);
		TestUtil.verifyResponse(res);
		Reporter.log("Response "+res.asString(),true);
		assertNotEquals(res.jsonPath().get("businessEntity.entityData[0].entityId[0]"), entityid);
		assertNotEquals(res.jsonPath().get("businessEntity.entityData[0].entityType[0]"),"CREDIT_MEMO");
	}
	

}
