package eInvoice.dewdrops.supplier_resource_endpoint;

import static org.testng.Assert.assertEquals;
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

public class EINVOICE_12345_getSupplierBankingDetails extends TestBase {
	@Test()
	public void GetSupplierBankingDetails() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		//String FilterId=db.getFilterDetails("filter_id", tenantid, userId);
		String SupplierId=reader.getCellData("Filters","SupplierId",3);
		String url=URL.getEndPoint(dewdrops_APIList.getSupplierBankingDetails);
		String FinalUrl = url+"/"+SupplierId+"/bankingDetails";
		Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid, trackingNumber);
		assertTrue(TestUtil.verifyResponse(res));
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.header.trackingNumber[0]"), Integer.toString(trackingNumber));
	}
	@Test()
	public void GetSupplierBankingDetails_InvalidSupplierId() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		//String FilterId=db.getFilterDetails("filter_id", tenantid, userId);
		String SupplierId=reader.getCellData("Filters","SupplierId",4);
		String url=URL.getEndPoint(dewdrops_APIList.getSupplierBankingDetails);
		String FinalUrl = url+"/"+SupplierId+"/bankingDetails";
		Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid, trackingNumber);
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
		assertEquals(res.jsonPath().get("errors.errorCode"), Arrays.asList(TestUtil.InternalServerError));
	}
	@Test()
	public void GetSupplierBankingDetails_InvalidUserId() {
		String userId="Invalid_UserId";
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		//String FilterId=db.getFilterDetails("filter_id", tenantid, userId);
		String SupplierId=reader.getCellData("Filters","SupplierId",4);
		String url=URL.getEndPoint(dewdrops_APIList.getSupplierBankingDetails);
		String FinalUrl = url+"/"+SupplierId+"/bankingDetails";
		Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid, trackingNumber);
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
		assertEquals(res.jsonPath().get("errors.errorDescription"), Arrays.asList("Invalid User Id."));
	}
	@Test()
	public void GetSupplierBankingDetails_InvalidTenantId() {
		String userId=TestUtil.getUserid();
		String tenantid="TenantId_Invalid";
		int trackingNumber=TestUtil.randomTrackingNumber();
		//String FilterId=db.getFilterDetails("filter_id", tenantid, userId);
		String SupplierId=reader.getCellData("Filters","SupplierId",3);
		String url=URL.getEndPoint(dewdrops_APIList.getSupplierBankingDetails);
		String FinalUrl = url+"/"+SupplierId+"/bankingDetails";
		Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid, trackingNumber);
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
		assertEquals(res.jsonPath().get("errors.errorDescription"), Arrays.asList("Invalid User Id."));
	}
	@Test()
	public void GetSupplierBankingDetails_InvalidTrackingNumber() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		//String FilterId=db.getFilterDetails("filter_id", tenantid, userId);
		String SupplierId=reader.getCellData("Filters","SupplierId",3);
		String url=URL.getEndPoint(dewdrops_APIList.getSupplierBankingDetails);
		String FinalUrl = url+"/"+SupplierId+"/bankingDetails";
		Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid);
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
		assertEquals(res.jsonPath().get("errors.errorDescription"), Arrays.asList("ERR_TRACKING_NUMBER_MISSING"));
	}
	@Test()
	public void GetSupplierBankingDetails_SupplierIdWithNoData() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		//String FilterId=db.getFilterDetails("filter_id", tenantid, userId);
		String SupplierId=reader.getCellData("Filters","SupplierId",5);
		String url=URL.getEndPoint(dewdrops_APIList.getSupplierBankingDetails);
		String FinalUrl = url+"/"+SupplierId+"/bankingDetails";
		Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid,trackingNumber);
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertNotEquals(res.jsonPath().get("businessEntity.entityData.tenantId[0]"), Arrays.asList("null"));
	}
	@Test()
	public void GetSupplierBankingDetails_InvalidEndPointURI() {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		//String FilterId=db.getFilterDetails("filter_id", tenantid, userId);
		String SupplierId=reader.getCellData("Filters","SupplierId",3);
		String url=URL.getEndPoint(dewdrops_APIList.getSupplierBankingDetails);
		String FinalUrl = url+"/"+SupplierId;
		Response res=Webservices.GETRequestWithHeader(FinalUrl, userId, tenantid,trackingNumber);
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
		assertEquals(res.jsonPath().get("errors.errorCode"), Arrays.asList(TestUtil.InternalServerError));
	}
	@Test()
	public void GetSupplierBankingDetails_InvalidHeaders() {
		//String FilterId=db.getFilterDetails("filter_id", tenantid, userId);
		String SupplierId=reader.getCellData("Filters","SupplierId",3);
		String url=URL.getEndPoint(dewdrops_APIList.getSupplierBankingDetails);
		String FinalUrl = url+"/"+SupplierId+"/bankingDetails";
		Response res=Webservices.GETRequestWithNoHeader(FinalUrl);
		Reporter.log("Response "+res.asString(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
		assertEquals(res.jsonPath().get("errors.errorCode[0]"),TestUtil.Mandatory_Field);
		assertEquals(res.jsonPath().get("errors.errorCode[1]"),TestUtil.Mandatory_Field);
	}
}
