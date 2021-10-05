package com.MorbidityBankLanguage;

import org.junit.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethod_MorbidityBankLanguage {

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
	public void getALL_MorbidityBankLanguage() {
		
		

		Response response =

				given().header("Authorization", "Bearer " + accessToken)
				.contentType(ContentType.JSON)
				.log().all().get("https://api-id-dev-in-shv3.georgeinstitute.org/api/MorbidityBankLanguage");

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "[E]0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");

	}
	
	@Test(priority = 2, dependsOnMethods = "getAccessToken")
	public void getFilter_MorbidityBankLanguage() {
		
		

		Response response =

				given().header("Authorization", "Bearer " + accessToken)
				.contentType(ContentType.JSON)
				.log().all().get("https://api-id-dev-in-shv3.georgeinstitute.org/api/MorbidityBankLanguage/2");

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "[E]0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");

	}
	
	
	@Test(priority = 3, dependsOnMethods = "getAccessToken")
	public void update_MorbidityBankLanguage() {
		
		
		String jsonBody = " {\r\n"
				+ "        \"morbidity_bank_language_id\": 2,\r\n"
				+ "        \"morbidity_bank_id\": 1,\r\n"
				+ "        \"language_id\": 1,\r\n"
				+ "        \"morbidity_bank\": \"Morbidity Test kamran QA\",\r\n"
				+ "        \"morbidity_bank_disclaimer\": \"This is test morbidity\",\r\n"
				+ "        \"morbidity_bank_language_created_by\": 1,\r\n"
				+ "        \"morbidity_bank_language_created_on\": \"2021-08-20T12:55:08\",\r\n"
				+ "        \"morbidity_bank_language_updated_by\": 1,\r\n"
				+ "        \"morbidity_bank_language_updated_on\": \"2021-08-20T12:55:08\"\r\n"
				+ " }";

		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().put("https://api-id-dev-in-shv3.georgeinstitute.org/api/MorbidityBankLanguage");

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");

	}
	
	@Test(priority = 4, dependsOnMethods = "getAccessToken")
	public void delete_MorbidityBankLanguage() {
		
		
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.log().all().delete("https://api-id-dev-in-shv3.georgeinstitute.org/api/MorbidityBankLanguage/2");

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Delete Operation Successfully");

	}
	
	@Test(priority = 5, dependsOnMethods = "getAccessToken")
	public void create_MorbidityBankLanguage() {

		String jsonBody = " {\r\n"
				+ "        \"morbidity_bank_language_id\": 2,\r\n"
				+ "        \"morbidity_bank_id\": 1,\r\n"
				+ "        \"language_id\": 1,\r\n"
				+ "        \"morbidity_bank\": \"Morbidity Test kamran\",\r\n"
				+ "        \"morbidity_bank_disclaimer\": \"This is test morbidity\",\r\n"
				+ "        \"morbidity_bank_language_created_by\": 1,\r\n"
				+ "        \"morbidity_bank_language_created_on\": \"2021-08-20T12:55:08\",\r\n"
				+ "        \"morbidity_bank_language_updated_by\": 1,\r\n"
				+ "        \"morbidity_bank_language_updated_on\": \"2021-08-20T12:55:08\"\r\n"
				+ "    }";

		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().post("https://api-id-dev-in-shv3.georgeinstitute.org/api/MorbidityBankLanguage");

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");

	}

}
