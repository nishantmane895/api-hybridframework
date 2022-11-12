package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.pages.APIPage;
import com.vtiger.tests.BaseTest;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

import io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITest extends BaseTest {
	
	@Test
	public void ListUsers_TC01()
	{		
		String TCName = "ListUsers_TC01";
		logger = extent.createTest(TCName);
		APIPage api = new APIPage(logger);
		String Endpoint = prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
		
		Response resp = RestAssured.get(Endpoint);
		api.writeRequestResponseinReport(Endpoint, resp.body().asPrettyString());		
		api.verifyStatusLine(TestData.get(TCName).get("StatusLine"), resp.getStatusLine());
		String json = resp.body().asPrettyString();
		JsonPath jsonPath = new JsonPath(json);
		String page	 = jsonPath.getString("page");
		System.out.println(page);
		api.verifyJsonResponse(TestData.get(TCName).get("page"),page);
		api.verifyJsonResponse(TestData.get(TCName).get("email"),jsonPath.getString("data[0].email"));
		
		extent.flush();
	}
	
	@Test
	public void SingleUser_TC02()
	{		
		String TCName = "SingleUser_TC02";
		logger = extent.createTest(TCName);
		APIPage api = new APIPage(logger);
		String Endpoint = prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
		
		Response resp = RestAssured.get(Endpoint);
		api.writeRequestResponseinReport(Endpoint, resp.body().asPrettyString());		
		api.verifyStatusLine(TestData.get(TCName).get("StatusLine"), resp.getStatusLine());
		String json = resp.body().asPrettyString();
		JsonPath jsonPath = new JsonPath(json);
		String id	 = jsonPath.getString("data.id");		
		api.verifyJsonResponse(TestData.get(TCName).get("id"),id);
		api.verifyJsonResponse(TestData.get(TCName).get("email"),jsonPath.getString("data.email"));
		api.verifyJsonResponse(TestData.get(TCName).get("first_name"),jsonPath.getString("data.first_name"));
		api.verifyJsonResponse(TestData.get(TCName).get("last_name"),jsonPath.getString("data.last_name"));
		
		
		extent.flush();
	}
	
	
	@Test
	public void CreateUser_TC03()
	{		
		String TCName = "CreateUser_TC03";
		logger = extent.createTest(TCName);
		APIPage api = new APIPage(logger);
		String Endpoint = prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", TestData.get(TCName).get("name"));
		map.put("job", TestData.get(TCName).get("job"));
		
		JSONObject json = new JSONObject(map);
		RequestSpecification rs = RestAssured.given();
		rs.header("Content-Type","application/json");	
		rs.body(json.toString());
		logger.info("Request="+json.toString());
		
		Response resp = rs.post(Endpoint);
		logger.info("Post Url:"+ Endpoint);
		String body = resp.getBody().asString();		
		
		
		api.writeRequestResponseinReport(Endpoint, body);		
		api.verifyStatusLine(TestData.get(TCName).get("StatusLine"), resp.getStatusLine());
		String jsn = resp.body().asPrettyString();
		JsonPath jsonPath = new JsonPath(jsn);
		
		api.verifyJsonResponse(TestData.get(TCName).get("name"),jsonPath.getString("name"));
		api.verifyJsonResponse(TestData.get(TCName).get("job"),jsonPath.getString("job"));
		extent.flush();
	}
	
	
	@Test
	public void UpdateUser_TC04()
	{		
		String TCName = "UpdateUser_TC04";
		logger = extent.createTest(TCName);
		APIPage api = new APIPage(logger);
		String Endpoint = prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", TestData.get(TCName).get("name"));
		map.put("job", TestData.get(TCName).get("job"));
		
		JSONObject json = new JSONObject(map);
		RequestSpecification rs = RestAssured.given();
		rs.header("Content-Type","application/json");	
		rs.body(json.toString());
		logger.info("Request="+json.toString());
		
		Response resp = rs.put(Endpoint);
		logger.info("Put Url:"+ Endpoint);
		String body = resp.getBody().asString();		
		
		
		api.writeRequestResponseinReport(Endpoint, body);		
		api.verifyStatusLine(TestData.get(TCName).get("StatusLine"), resp.getStatusLine());
		String jsn = resp.body().asPrettyString();
		JsonPath jsonPath = new JsonPath(jsn);					
		api.verifyJsonResponse(TestData.get(TCName).get("name"),jsonPath.getString("name"));
		api.verifyJsonResponse(TestData.get(TCName).get("job"),jsonPath.getString("job"));
		extent.flush();
	}
	
	
	@Test
	public void DeleteUser_TC05()
	{		
		String TCName = "DeleteUser_TC05";
		logger = extent.createTest(TCName);
		APIPage api = new APIPage(logger);
		String Endpoint = prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
		
		Response resp = RestAssured.delete(Endpoint);
		api.writeRequestResponseinReport(Endpoint, resp.body().asPrettyString());		
		api.verifyStatusLine(TestData.get(TCName).get("StatusLine"), resp.getStatusLine());
		System.out.println(resp.getStatusLine());
		String json = resp.body().asPrettyString();
		System.out.println(json);
		extent.flush();
	}

}
