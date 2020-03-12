package eInvoice.dewdrops.invoice_resource_endpoint;

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

public class EINVOICE_12166_CreateFilterApi extends TestBase{
	public String res1="";
	public String entityid="";
	@Test()
	public  void Filter_Creation() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		entityid=TestUtil.randomentityId();
	    String url=URL.getEndPoint(dewdrops_APIList.CreateFilter_Api);
	    String s1 = JsonPath.getCellData("JsonBody", "JsonData",10);
	    System.out.println(s1);
	    //String createIssuePayLaod = TestUtil.generatePayLoadString("FilterCreation");
	    JSONObject existingPreferenceObject = new JSONObject(s1);
		JSONArray result = existingPreferenceObject.getJSONArray("businessEntity");
		JSONObject result1 = result.getJSONObject(0);
		JSONObject result2 = result1.getJSONObject("entityData");
		System.out.println(result2);
		result2.put("filterName", entityid);
	    String finalJson = ((Object) existingPreferenceObject).toString();
	    System.out.println("finalJson1 --> : " + finalJson);
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    //System.out.println("Response"+" "+res);
	    assertTrue(TestUtil.verifyResponse(res));
	    Reporter.log("Response "+res.asString(),true);
		//Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.entityData.modifiedBy"), Arrays.asList(userId));
        res1=res.jsonPath().getString("businessEntity.entityData.id").substring(1,res.jsonPath().getString("businessEntity.entityData.id").length()-1);
	}
	


}
