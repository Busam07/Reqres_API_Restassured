package testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.baseclass;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class TC003_Add_customer extends baseclass{

	@BeforeClass
	void add_New_customer() throws InterruptedException {
		RestAssured.baseURI="https://reqres.in/api";
		RequestSpecification httpRequest=RestAssured.given()
													.header("x-api-key","reqres-free-v1");
		
		JSONObject reqparams=new JSONObject();
		reqparams.put("email","simplyclassic.gmail");
		reqparams.put("first_name", "simply");
		reqparams.put("last_name", "classic");
		reqparams.put("avatar", "superman");
		
		httpRequest.header("Content-Type","application/json; charset=utf-8");
		httpRequest.body(reqparams.toJSONString());
		response=httpRequest.request(Method.POST,"/api/users");
		Thread.sleep(2000);
	}
	
	@Test
	void check_response() {
		String resbody=response.getBody().asString();
		String id = response.jsonPath().getString("data.id");
		System.out.println(resbody);
		}
	@AfterClass
	void Teardown() {
		logger.info("*******successfully testd the TC003********");
	}
	
}
