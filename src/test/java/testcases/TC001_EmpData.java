package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.baseclass;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_EmpData extends baseclass{
	
	@BeforeClass
	void get_all_employees_data() throws InterruptedException {
		logger.info("*****Stated TC001****");
		RestAssured.baseURI="https://reqres.in";
		//RestAssured.baseURI="https://automationexercise.com/api";
		httpRequest= RestAssured.given()
								.header("x-api-key","reqres-free-v1");
		response=httpRequest.request(Method.GET,"/api/users?page=2");
		Thread.sleep(3000);
				
	}
	
	@Test
	void checkResponseBody() {
		logger.info("*****Checking Response Body*****");
		String resbody=response.getBody().asString();
		logger.info("Resposnse Body"+resbody);
		Assert.assertTrue(resbody!=null);
	}
	
	@Test
	void check_Response_Time() {
		logger.info("*****Checking Response Time*****");
		long responsetime=response.getTime();
		logger.info("Response Time"+ responsetime);
		Assert.assertTrue(responsetime<5000);
		
	}
	
	@Test
	void chech_status_code() {
		logger.info("*******Checking Status Code******");
		int statuscode=response.getStatusCode();
		logger.info("Status code"+ statuscode);
		Assert.assertEquals(statuscode, 200);
		
	}
	
	@AfterClass
	void TearDown() {
		logger.info("*****Finished****");
	}
}
