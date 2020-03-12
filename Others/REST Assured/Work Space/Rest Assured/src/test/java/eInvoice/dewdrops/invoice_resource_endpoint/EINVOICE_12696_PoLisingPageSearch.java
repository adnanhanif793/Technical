package eInvoice.dewdrops.invoice_resource_endpoint;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestBase;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

public class EINVOICE_12696_PoLisingPageSearch extends TestBase {
	@Test
	public void poListingPage() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String url=URL.getEndPoint(dewdrops_APIList.getPOListing);
	  String s1 = JsonPath.getCellData("JsonBody", "JsonData",20);
	  Response res=Webservices.POSTRequestWithHeader(url, s1, userId, tenantid, trackingNumber);
	  System.out.println(res);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.modifiedBy[0]"), userId);
	  }
	//To Be developed--
	@Test
	public void poListingPage_pageCountChange() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String url=URL.getEndPoint(dewdrops_APIList.getPOListing);
	  String s1 = JsonPath.getCellData("JsonBody", "JsonData",20);
	  Response res=Webservices.POSTRequestWithHeader(url, s1, userId, tenantid, trackingNumber);
	  System.out.println(res);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.modifiedBy[0]"), userId);
	  }
}
