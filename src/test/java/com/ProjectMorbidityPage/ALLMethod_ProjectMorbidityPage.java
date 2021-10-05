package com.ProjectMorbidityPage;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ALLMethod_ProjectMorbidityPage {
	
	
	
	static String accessToken;
	static String Username = "Sridevi.Gara";
	static String Password = "Qwe12345";

	@Test
	public void getAccessToken() {

		Response response =

				given()
				.auth()
				.preemptive()
				.basic(Username, Password)
				.post("https://api-id-dev-in-shv3.georgeinstitute.org/api/auth");
		

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());
		accessToken = response.getBody().path("accessToken");
		System.out.println("Access token is" + accessToken);
	}

	@Test(priority = 1, dependsOnMethods = "getAccessToken")
	public void getAll_ProjectMorbidityPage() {
		
		

		Response response =

				given().header("Authorization", "Bearer " + accessToken)
				.contentType(ContentType.JSON)
				.log().all().get("https://api-id-dev-in-shv3.georgeinstitute.org/api/ProjectMorbidityPage");

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "[E]0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");

	}
	
	@Test(priority = 2, dependsOnMethods = "getAccessToken")
	public void getFilter_ProjectMorbidityPage() {
		
		

		Response response =

				given().header("Authorization", "Bearer " + accessToken)
				.contentType(ContentType.JSON)
				.log().all().get("https://api-id-dev-in-shv3.georgeinstitute.org/api/ProjectMorbidityPage/2");

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "[E]0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");

	}
	
	
	@Test(priority = 3, dependsOnMethods = "getAccessToken")
	public void update_ProjectMorbidityPage() {
		
		
		String jsonBody = " {\r\n"
				+ "    \"project_morbidity_page_id\": 7,\r\n"
				+ "    \"project_morbidity_id\": 1,\r\n"
				+ "    \"morbidity_bank_id\": 2,\r\n"
				+ "    \"morbidity_bank_page_id\": 1,\r\n"
				+ "    \"project_morbidity_pageno\": \"2\",\r\n"
				+ "    \"project_morbidity_page\": \"kamran Patient History 7\",\r\n"
				+ "    \"project_morbidity_page_sequence\": 2,\r\n"
				+ "    \"project_morbidity_page_is_active\": false,\r\n"
				+ "    \"project_morbidity_page_created_by\": 1,\r\n"
				+ "    \"project_morbidity_page_created_on\": \"2021-09-27T19:51:00.000Z\",\r\n"
				+ "    \"project_morbidity_page_updated_by\": 41,\r\n"
				+ "    \"project_morbidity_page_updated_on\": \"2021-09-27T19:51:41.000Z\"\r\n"
				+ "}";

		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().put("https://api-id-dev-in-shv3.georgeinstitute.org/api/ProjectMorbidityPage");

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");

	}
	
	@Test(priority = 4, dependsOnMethods = "getAccessToken")
	public void delete_ProjectMorbidityPage() {
		
		
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.log().all().delete("https://api-id-dev-in-shv3.georgeinstitute.org/api/ProjectMorbidityPage/7");

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Delete Operation Successfully");

	}
	
	@Test(priority = 5, dependsOnMethods = "getAccessToken")
	public void create_ProjectMorbidityPage() {

		String jsonBody = " {\r\n"
				+ "    \"project_morbidity_page_id\": 7,\r\n"
				+ "    \"project_morbidity_id\": 1,\r\n"
				+ "    \"morbidity_bank_id\": 2,\r\n"
				+ "    \"morbidity_bank_page_id\": 1,\r\n"
				+ "    \"project_morbidity_pageno\": \"2\",\r\n"
				+ "    \"project_morbidity_page\": \"kamran Patient History 3\",\r\n"
				+ "    \"project_morbidity_page_sequence\": 2,\r\n"
				+ "    \"project_morbidity_page_is_active\": false,\r\n"
				+ "    \"project_morbidity_page_created_by\": 1,\r\n"
				+ "    \"project_morbidity_page_created_on\": \"2021-09-27T19:51:00.000Z\",\r\n"
				+ "    \"project_morbidity_page_updated_by\": 41,\r\n"
				+ "    \"project_morbidity_page_updated_on\": \"2021-09-27T19:51:41.000Z\"\r\n"
				+ "}";

		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().post("https://api-id-dev-in-shv3.georgeinstitute.org/api/ProjectMorbidityPage");

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");

	}

}
