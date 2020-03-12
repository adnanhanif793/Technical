package eInvoice.dewdrops.supplier_resource_endpoint;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestBase;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

public class EINVOICE_13379_getSupplierContact extends TestBase {
	 @Test()
		public void getSupplierContact() {
			String userId=TestUtil.getUserid();
			String tenantid=TestUtil.getTenantid();
			int trackingNumber=TestUtil.randomTrackingNumber();
			//String SupplierId=reader.getCellData("Filters","SupplierId",2 );
			//String LocationCode=reader.getCellData("Filters","LocationCode",2 );
			String Jsonbody = JsonPath.getCellData("JsonBody", "JsonData",21);
			String url=URL.getEndPoint(dewdrops_APIList.getSupplierContact);
			Response res=Webservices.POSTRequestWithHeader(url,Jsonbody,userId, tenantid, trackingNumber);
			assertTrue(TestUtil.verifyResponse(res));
			Reporter.log("Response "+res.asString(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
			assertEquals(res.jsonPath().get("businessEntity.entityData[0].tenantId[0]"), tenantid);
		}
	 @Test()
		public void getSupplierContact_InvalidAddressId() throws JSONException {
			String userId=TestUtil.getUserid();
			String tenantid=TestUtil.getTenantid();
			int trackingNumber=TestUtil.randomTrackingNumber();
			//String SupplierId=reader.getCellData("Filters","SupplierId",2 );
			//String LocationCode=reader.getCellData("Filters","LocationCode",2 );
			String Jsonbody = JsonPath.getCellData("JsonBody", "JsonData",21);
			String url=URL.getEndPoint(dewdrops_APIList.getSupplierContact);
			JSONObject js = new JSONObject(Jsonbody);
			JSONArray js1 = js.getJSONArray("businessEntity");
			JSONObject js2 = js1.getJSONObject(0);
			JSONObject js3 = js2.getJSONObject("entityData");
			js3.put("addressId", trackingNumber);
			String finalJson = ((Object) js).toString();
			Response res=Webservices.POSTRequestWithHeader(url,finalJson,userId, tenantid, trackingNumber);
			assertTrue(TestUtil.verifyResponse(res));
			Reporter.log("Response "+res.asString(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
			assertNotEquals(res.jsonPath().get("businessEntity.entityData[0].tenantId[0]"), tenantid);
		}
	 @Test()
		public void getSupplierContact_InvalidSupplierId() throws JSONException {
			String userId=TestUtil.getUserid();
			String tenantid=TestUtil.getTenantid();
			int trackingNumber=TestUtil.randomTrackingNumber();
			//String SupplierId=reader.getCellData("Filters","SupplierId",2 );
			//String LocationCode=reader.getCellData("Filters","LocationCode",2 );
			String Jsonbody = JsonPath.getCellData("JsonBody", "JsonData",21);
			String url=URL.getEndPoint(dewdrops_APIList.getSupplierContact);
			JSONObject js = new JSONObject(Jsonbody);
			JSONArray js1 = js.getJSONArray("businessEntity");
			JSONObject js2 = js1.getJSONObject(0);
			JSONObject js3 = js2.getJSONObject("entityData");
			js3.put("supplierId", trackingNumber);
			String finalJson = ((Object) js).toString();
			Response res=Webservices.POSTRequestWithHeader(url,finalJson,userId, tenantid, trackingNumber);
			assertTrue(TestUtil.verifyResponse(res));
			Reporter.log("Response "+res.asString(),true);
			assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
			assertNotEquals(res.jsonPath().get("businessEntity.entityData[0].tenantId[0]"), tenantid);
		}
}
