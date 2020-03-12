package eInvoice.dewdrops.invoice_resource_endpoint;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public class EINVOICE_12167_UpdateFilterWithCreateFilterInput extends EINVOICE_12166_CreateFilterApi {
	public String entityId = "";
	@Test()
	public  void Filter_Updation() throws JSONException   {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String entityid=TestUtil.randomentityId();
	    String url=URL.getEndPoint(dewdrops_APIList.Update_Filter_Api);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",17 );
	    System.out.println("Failing"+s1);
	  //  String createIssuePayLaod = TestUtil.generatePayLoadString("Update_Filter");
	    JSONObject existingPreferenceObject = new JSONObject(s1);
		JSONArray result = existingPreferenceObject.getJSONArray("businessEntity");
		JSONObject result1 = result.getJSONObject(0);
		JSONObject result2 = (JSONObject) result1.get("entityData");
		result2.put("filterId",res1);
		result2.put("filterName",entityid);
	    String finalJson = ((Object) existingPreferenceObject).toString();
	    System.out.println("finalJson2 --> : " + finalJson);
	    Response res2=Webservices.POSTRequestWithHeader(url,finalJson,userId, tenantid, trackingNumber);
	    assertTrue(TestUtil.verifyResponse(res2));
	    Reporter.log("Response "+res2.asString(),true);
		Reporter.log("Status Code "+res2.statusCode(),true);
		assertEquals(res2.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res2.jsonPath().get("businessEntity.entityData.modifiedBy"), Arrays.asList(userId));
}
	
	
}