package eInvoice.dewdrops.user_resource_endpoint;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;

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

public class EINVOICE_12517_SearchRoleBasedUsers extends TestBase {
	@Test()
	public void searchRoleBasedUsersBuyer() throws Exception  {
	      String userId = TestUtil.getUserid();
          String tenantid = TestUtil.getTenantid();
          int trackingNumber = TestUtil.randomTrackingNumber();
          String url = URL.getEndPoint(dewdrops_APIList.searchRoleBasedUsers_Api, "buyer");
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",15);
         // String createIssuePayLaod = TestUtil.generatePayLoadString("searchRoleBasedUsers");
          String UsersName=reader.getCellData("SearchRoleBasedUser", "FirstName",2 );
          String LastsName=reader.getCellData("SearchRoleBasedUser", "LastName",2 );
          String UserId=reader.getCellData("SearchRoleBasedUser", "userID",2 );
          JSONObject existingPreferenceObject = new JSONObject(s1);
          JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
         // System.out.println("jsonChildObject --> : " + jsonChildObject);
          JSONArray result = jsonChildObject.getJSONArray("criteria");
         // System.out.println("result --> : " + result);
          JSONObject result1 = result.getJSONObject(0);
         // System.out.println("result1 --> : " + result1);
         // System.out.println(" ");
          // JSONObject milestone1 = new JSONObject();
          result1.put("value", UsersName);
          String finalJson = ((Object) existingPreferenceObject).toString();
         // System.out.println("finalJson --> : " + finalJson);
          Response res = Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
          assertTrue(TestUtil.verifyResponse(res));
          Reporter.log("Response " + res.asString(), true);
          Reporter.log("Error " + res.jsonPath().get("processingErrors"), true);
          Reporter.log("Total User Found " + res.jsonPath().get("pagination.totalRecords"), true);
          assertEquals(res.jsonPath().get("result.firstName") ,Arrays.asList(UsersName)," First Name is not matching");
          assertEquals(res.jsonPath().get("result.lastName"), Arrays.asList(LastsName), "Last Name is not matching");
          assertEquals(res.jsonPath().get("result.userId"), Arrays.asList(UserId), "User ID is not matching");

          
}

	@Test()
	public void searchRoleBasedUsersRequester() throws Exception {
	      String userId = TestUtil.getUserid();
          String tenantid = TestUtil.getTenantid();
          int trackingNumber = TestUtil.randomTrackingNumber();
          String url = URL.getEndPoint(dewdrops_APIList.searchRoleBasedUsers_Api, "requestor");
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",15);
       //   String createIssuePayLaod = TestUtil.generatePayLoadString("searchRoleBasedUsers");
          String UsersName=reader.getCellData("SearchRoleBasedUser", "FirstName",3 );
          String LastsName=reader.getCellData("SearchRoleBasedUser", "LastName",3 );
          String UserId=reader.getCellData("SearchRoleBasedUser", "userID",3 );
          JSONObject existingPreferenceObject = new JSONObject(s1);
          JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
        //  System.out.println("jsonChildObject --> : " + jsonChildObject);
          JSONArray result = jsonChildObject.getJSONArray("criteria");
        //  System.out.println("result --> : " + result);
          JSONObject result1 = result.getJSONObject(0);
        //  System.out.println("result1 --> : " + result1);
        //  System.out.println(" ");
          // JSONObject milestone1 = new JSONObject();
          result1.put("value", UsersName);
          String finalJson = ((Object) existingPreferenceObject).toString();
       //   System.out.println("finalJson --> : " + finalJson);
          Response res = Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
          assertTrue(TestUtil.verifyResponse(res));
          Reporter.log("Response " + res.asString(), true);
          Reporter.log("Error " + res.jsonPath().get("processingErrors"), true);
          Reporter.log("Total User Found " + res.jsonPath().get("pagination.totalRecords"), true);
          assertEquals(res.jsonPath().get("result.firstName") ,Arrays.asList(UsersName)," First Name is not matching");
          assertEquals(res.jsonPath().get("result.lastName"), Arrays.asList(LastsName), "Last Name is not matching");
          assertEquals(res.jsonPath().get("result.userId"), Arrays.asList(UserId), "User ID is not matching");

}
	
	
	
	@Test()
	public void searchRoleBasedUsersBuyerWithInvalidData() throws Exception {
	      String userId = TestUtil.getUserid();
          String tenantid = TestUtil.getTenantid();
          int trackingNumber = TestUtil.randomTrackingNumber();
          String url = URL.getEndPoint(dewdrops_APIList.searchRoleBasedUsers_Api, "buyer");
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",15);
          //String createIssuePayLaod = TestUtil.generatePayLoadString("searchRoleBasedUsers");
          String UsersName=reader.getCellData("SearchRoleBasedUser", "FirstName",4 );
          String LastsName=reader.getCellData("SearchRoleBasedUser", "LastName",4 );
          String UserId=reader.getCellData("SearchRoleBasedUser", "userID",4 );
          JSONObject existingPreferenceObject = new JSONObject(s1);
          JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
        //  System.out.println("jsonChildObject --> : " + jsonChildObject);
          JSONArray result = jsonChildObject.getJSONArray("criteria");
        //  System.out.println("result --> : " + result);
          JSONObject result1 = result.getJSONObject(0);
         // System.out.println("result1 --> : " + result1);
          System.out.println(" ");
          // JSONObject milestone1 = new JSONObject();
          result1.put("value", UsersName);
          String finalJson = ((Object) existingPreferenceObject).toString();
         // System.out.println("finalJson --> : " + finalJson);
          Response res = Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
          assertTrue(TestUtil.verifyResponse(res));
          Reporter.log("Response " + res.asString(), true);
          Reporter.log("Error " + res.jsonPath().get("processingErrors"), true);
          Reporter.log("Total User Found " + res.jsonPath().get("pagination.totalRecords"), true);
          assertNotEquals(res.jsonPath().get("result.firstName") ,Arrays.asList(UsersName)," First Name is not matching");
          assertNotEquals(res.jsonPath().get("result.lastName"), Arrays.asList(LastsName), "Last Name is not matching");
          assertNotEquals(res.jsonPath().get("result.userId"), Arrays.asList(UserId), "User ID is not matching");

}
	
	
	@Test()
	public void searchRoleBasedUsersRequesterWithInvalidData() throws Exception {
	      String userId = TestUtil.getUserid();
          String tenantid = TestUtil.getTenantid();
          int trackingNumber = TestUtil.randomTrackingNumber();
          String url = URL.getEndPoint(dewdrops_APIList.searchRoleBasedUsers_Api, "requestor");
		  String s1 = JsonPath.getCellData("JsonBody", "JsonData",15);
         // String createIssuePayLaod = TestUtil.generatePayLoadString("searchRoleBasedUsers");
          String UsersName=reader.getCellData("SearchRoleBasedUser", "FirstName",5 );
          String LastsName=reader.getCellData("SearchRoleBasedUser", "LastName",5 );
          String UserId=reader.getCellData("SearchRoleBasedUser", "userID",5 );
          JSONObject existingPreferenceObject = new JSONObject(s1);
          JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
         // System.out.println("jsonChildObject --> : " + jsonChildObject);
          JSONArray result = jsonChildObject.getJSONArray("criteria");
         // System.out.println("result --> : " + result);
          JSONObject result1 = result.getJSONObject(0);
         // System.out.println("result1 --> : " + result1);
          System.out.println(" ");
          // JSONObject milestone1 = new JSONObject();
          result1.put("value", UsersName);
          String finalJson = ((Object) existingPreferenceObject).toString();
         // System.out.println("finalJson --> : " + finalJson);
          Response res = Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
          assertTrue(TestUtil.verifyResponse(res));
          Reporter.log("Response " + res.asString(), true);
          Reporter.log("Error " + res.jsonPath().get("processingErrors"), true);
          Reporter.log("Total User Found " + res.jsonPath().get("pagination.totalRecords"), true);
          assertNotEquals(res.jsonPath().get("result.firstName") ,Arrays.asList(UsersName)," First Name is not matching");
          assertNotEquals(res.jsonPath().get("result.lastName"), Arrays.asList(LastsName), "Last Name is not matching");
          assertNotEquals(res.jsonPath().get("result.userId"), Arrays.asList(UserId), "User ID is not matching");

}
	@Test()
	public void searchRoleBasedUsersBuyerWithDircetionInASC() throws Exception {
	      String userId = TestUtil.getUserid();
          String tenantid = TestUtil.getTenantid();
          int trackingNumber = TestUtil.randomTrackingNumber();
          String url = URL.getEndPoint(dewdrops_APIList.searchRoleBasedUsers_Api, "buyer");
          String s1 = JsonPath.getCellData("JsonBody", "JsonData",15);
         // String createIssuePayLaod = TestUtil.generatePayLoadString("searchRoleBasedUsers");
          String UsersName=reader.getCellData("SearchRoleBasedUser", "FirstName",6 );
          String direction=reader.getCellData("SearchRoleBasedUser", "direction",2 );
          String displayname=reader.getCellData("SearchRoleBasedUser", "displayName",2 );
          JSONObject existingPreferenceObject = new JSONObject(s1);
          JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
          JSONArray arr=(JSONArray) existingPreferenceObject.getJSONArray("sortConditions");
          JSONObject js=arr.getJSONObject(0);
          js.put("direction", direction);
        //  System.out.println("jsonChildObject --> : " + jsonChildObject);
          JSONArray result = jsonChildObject.getJSONArray("criteria");
         // System.out.println("result --> : " + result);
          JSONObject result1 = result.getJSONObject(0);
         // System.out.println("result1 --> : " + result1);
          result1.put("value", UsersName);
          String finalJson = ((Object) existingPreferenceObject).toString();
         // System.out.println("finalJson1 --> : " + finalJson);
          Response res = Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
          assertTrue(TestUtil.verifyResponse(res));
          Reporter.log("Response " + res.asString(), true);
          Reporter.log("Error " + res.jsonPath().get("processingErrors"), true);
          Reporter.log("Total User Found " + res.jsonPath().get("pagination.totalRecords"), true);
          assertNotEquals(res.jsonPath().get("result.displayName") ,Arrays.asList(displayname)," Display Name is not matching");

	
	
	}
	
	@Test()
	public void searchRoleBasedUsersBuyerWithDircetionInDESC() throws Exception {
	      String userId = TestUtil.getUserid();
          String tenantid = TestUtil.getTenantid();
          int trackingNumber = TestUtil.randomTrackingNumber();
          String url = URL.getEndPoint(dewdrops_APIList.searchRoleBasedUsers_Api, "buyer");
          String s1 = JsonPath.getCellData("JsonBody", "JsonData",15);
       //   String createIssuePayLaod = TestUtil.generatePayLoadString("searchRoleBasedUsers");
          String UsersName=reader.getCellData("SearchRoleBasedUser", "FirstName",6 );
          String direction=reader.getCellData("SearchRoleBasedUser", "direction",3 );
          String displayname=reader.getCellData("SearchRoleBasedUser", "displayName",3 );
          JSONObject existingPreferenceObject = new JSONObject(s1);
          JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
          JSONArray arr=(JSONArray) existingPreferenceObject.getJSONArray("sortConditions");
          JSONObject js=arr.getJSONObject(0);
          js.put("direction", direction);
       //   System.out.println("jsonChildObject --> : " + jsonChildObject);
          JSONArray result = jsonChildObject.getJSONArray("criteria");
       //   System.out.println("result --> : " + result);
          JSONObject result1 = result.getJSONObject(0);
       //   System.out.println("result1 --> : " + result1);
          result1.put("value", UsersName);
          String finalJson = ((Object) existingPreferenceObject).toString();
        //  System.out.println("finalJson1 --> : " + finalJson);
          Response res = Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
          assertTrue(TestUtil.verifyResponse(res));
          Reporter.log("Response " + res.asString(), true);
          Reporter.log("Error " + res.jsonPath().get("processingErrors"), true);
          Reporter.log("Total User Found " + res.jsonPath().get("pagination.totalRecords"), true);
          assertNotEquals(res.jsonPath().get("result.displayName") ,Arrays.asList(displayname)," Display Name is not matching");

	
	
	}
	
	@Test()
	public void searchRoleBasedUsersTRequesterWithDircetionInASC() throws Exception {
	      String userId = TestUtil.getUserid();
          String tenantid = TestUtil.getTenantid();
          int trackingNumber = TestUtil.randomTrackingNumber();
          String url = URL.getEndPoint(dewdrops_APIList.searchRoleBasedUsers_Api, "requestor");
          String s1 = JsonPath.getCellData("JsonBody", "JsonData",15);
        //  String createIssuePayLaod = TestUtil.generatePayLoadString("searchRoleBasedUsers");
          String UsersName=reader.getCellData("SearchRoleBasedUser", "FirstName",6 );
          String direction=reader.getCellData("SearchRoleBasedUser", "direction",2 );
          String displayname=reader.getCellData("SearchRoleBasedUser", "displayName",2 );
          JSONObject existingPreferenceObject = new JSONObject(s1);
          JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
          JSONArray arr=(JSONArray) existingPreferenceObject.getJSONArray("sortConditions");
          JSONObject js=arr.getJSONObject(0);
          js.put("direction", direction);
         // System.out.println("jsonChildObject --> : " + jsonChildObject);
          JSONArray result = jsonChildObject.getJSONArray("criteria");
         // System.out.println("result --> : " + result);
          JSONObject result1 = result.getJSONObject(0);
         // System.out.println("result1 --> : " + result1);
          result1.put("value", UsersName);
          String finalJson = ((Object) existingPreferenceObject).toString();
          // System.out.println("finalJson1 --> : " + finalJson);
          Response res = Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
          assertTrue(TestUtil.verifyResponse(res));
          Reporter.log("Response " + res.asString(), true);
          Reporter.log("Error " + res.jsonPath().get("processingErrors"), true);
          Reporter.log("Total User Found " + res.jsonPath().get("pagination.totalRecords"), true);
          assertNotEquals(res.jsonPath().get("result.displayName") ,Arrays.asList(displayname)," Display Name is not matching");

	
	
	}
	
	@Test()
	public void searchRoleBasedUsersRequesterWithDircetionInDESC() throws Exception {
	      String userId = TestUtil.getUserid();
          String tenantid = TestUtil.getTenantid();
          int trackingNumber = TestUtil.randomTrackingNumber();
          String url = URL.getEndPoint(dewdrops_APIList.searchRoleBasedUsers_Api, "requestor");
          String s1 = JsonPath.getCellData("JsonBody", "JsonData",15);
        //  String createIssuePayLaod = TestUtil.generatePayLoadString("searchRoleBasedUsers");
          String UsersName=reader.getCellData("SearchRoleBasedUser", "FirstName",6 );
          String direction=reader.getCellData("SearchRoleBasedUser", "direction",3 );
          String displayname=reader.getCellData("SearchRoleBasedUser", "displayName",3 );
          JSONObject existingPreferenceObject = new JSONObject(s1);
          JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
          JSONArray arr=(JSONArray) existingPreferenceObject.getJSONArray("sortConditions");
          JSONObject js=arr.getJSONObject(0);
          js.put("direction", direction);
          //System.out.println("jsonChildObject --> : " + jsonChildObject);
          JSONArray result = jsonChildObject.getJSONArray("criteria");
         // System.out.println("result --> : " + result);
          JSONObject result1 = result.getJSONObject(0);
         // System.out.println("result1 --> : " + result1);
          result1.put("value", UsersName);
          String finalJson = ((Object) existingPreferenceObject).toString();
         // System.out.println("finalJson1 --> : " + finalJson);
          Response res = Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
          assertTrue(TestUtil.verifyResponse(res));
          Reporter.log("Response " + res.asString(), true);
          Reporter.log("Error " + res.jsonPath().get("processingErrors"), true);
          Reporter.log("Total User Found " + res.jsonPath().get("pagination.totalRecords"), true);
          assertNotEquals(res.jsonPath().get("result.displayName") ,Arrays.asList(displayname)," Display Name is not matching");

	
	
	}
	
	
	
	}	
	