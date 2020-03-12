package eInvoice.dewdrops.supplier_resource_endpoint;

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

public class EINVOICE_12346_GetSupplierPaymentTerm extends TestBase {
	  @Test()
		public void getSupplierPaymentTerm() {
			String userId=TestUtil.getUserid();
			String tenantid=TestUtil.getTenantid();
			int trackingNumber=TestUtil.randomTrackingNumber();
			String SupplierId=reader.getCellData("Filters","SupplierId",2 ).substring(0,reader.getCellData("Filters","SupplierId",2 ).length()-2);
			String LocationCode=reader.getCellData("Filters","LocationCode",2 );
			String url=URL.getEndPoint(dewdrops_APIList.getSupplierPaymentTerm);
			String FinalUrl = url+"/"+SupplierId+"/"+LocationCode+"/paymentTerm";
			Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid, trackingNumber);
			assertTrue(TestUtil.verifyResponse(res));
			Reporter.log("Response "+res.asString(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
			assertEquals(res.jsonPath().get("businessEntity.header.trackingNumber[0]"), Integer.toString(trackingNumber));
		}
	  @Test()
		public void getSupplierPaymentTerm_InvalidUserId() {
			String userId="Invalid_UserId";
			String tenantid=TestUtil.getTenantid();
			int trackingNumber=TestUtil.randomTrackingNumber();
			String SupplierId=reader.getCellData("Filters","SupplierId",2 ).substring(0,reader.getCellData("Filters","SupplierId",2 ).length()-2);
			String LocationCode=reader.getCellData("Filters","LocationCode",2 );
			String url=URL.getEndPoint(dewdrops_APIList.getSupplierPaymentTerm);
			String FinalUrl = url+"/"+SupplierId+"/"+LocationCode+"/paymentTerm";
			Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid, trackingNumber);
			assertFalse(TestUtil.verifyResponse(res));
			Reporter.log("Response "+res.asString(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
			assertEquals(res.jsonPath().get("errors.errorCode[0]"), TestUtil.Invalid_User);
			
		}
	  @Test()
			public void getSupplierPaymentTerm_Invalid_SupplierId() {
				String userId=TestUtil.getUserid();
				String tenantid=TestUtil.getTenantid();
				int trackingNumber=TestUtil.randomTrackingNumber();
				String SupplierId=reader.getCellData("Filters","SupplierId",5);
				String LocationCode=reader.getCellData("Filters","LocationCode",2 );
				String url=URL.getEndPoint(dewdrops_APIList.getSupplierPaymentTerm);
				String FinalUrl = url+"/"+SupplierId+"/"+LocationCode+"/paymentTerm";
				Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid, trackingNumber);
				Reporter.log("Response "+res.asString(),true);
				assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_500);
				assertEquals(res.jsonPath().get("trackingNumber"), Integer.toString(trackingNumber));
			}
	  
	  @Test()
		public void getSupplierPaymentTerm_Invalid_LocationId() {
			String userId=TestUtil.getUserid();
			String tenantid=TestUtil.getTenantid();
			int trackingNumber=TestUtil.randomTrackingNumber();
			String SupplierId=reader.getCellData("Filters","SupplierId",3);
			String LocationCode=reader.getCellData("Filters","LocationCode",3);
			String url=URL.getEndPoint(dewdrops_APIList.getSupplierPaymentTerm);
			String FinalUrl = url+"/"+SupplierId+"/"+LocationCode+"/paymentTerm";
			Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid, trackingNumber);
			Reporter.log("Response "+res.asString(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
		}
	  
	  @Test()
	  public void getSuppierPaymentTerm_Invalid_TrackingNumber() {
				String userId=TestUtil.getUserid();
				String tenantid=TestUtil.getTenantid();
				String SupplierId=reader.getCellData("Filters","SupplierId",2 ).substring(0,reader.getCellData("Filters","SupplierId",2 ).length()-2);
				String LocationCode=reader.getCellData("Filters","LocationCode",2 );
				String url=URL.getEndPoint(dewdrops_APIList.getSupplierPaymentTerm);
				String FinalUrl = url+"/"+SupplierId+"/"+LocationCode+"/paymentTerm";
				Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid);
				assertFalse(TestUtil.verifyResponse(res));
				Reporter.log("Response "+res.asString(),true);
				assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
				assertEquals(res.jsonPath().get("errors.errorCode[0]"), TestUtil.ERR_TRACKING_NUMBER_MISSING);
	  }
}
