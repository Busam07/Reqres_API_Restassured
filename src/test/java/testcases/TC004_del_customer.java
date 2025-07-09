package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.baseclass;
import io.restassured.RestAssured;
public class TC004_del_customer extends baseclass {
	
	@BeforeClass
	public void del_cust(){
		
		
		TC003_Add_customer ad=new TC003_Add_customer(); 
		RestAssured.baseURI="https://reqres.in/";
		httpRequest=RestAssured.given()
				.header("x-api-key","reqres-free-v1");
				response=httpRequest.delete("/api/users/2");
				
		
	}

	@Test
	void check() {
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 204);
	}
	
	@AfterClass
	void Teardown() {
		logger.info("*******successfully testd the TC004********");
	}
}
