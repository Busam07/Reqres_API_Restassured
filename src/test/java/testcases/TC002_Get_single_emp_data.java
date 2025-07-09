package testcases;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import base.baseclass;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
public class TC002_Get_single_emp_data extends baseclass{

	@BeforeClass
	void getempdata() throws InterruptedException {
		logger.info("********statred test case 2********");
		RestAssured.baseURI="https://reqres.in/";
		httpRequest= RestAssured.given();
		response=httpRequest.request(Method.GET,"/api/users/"+empID);
		Thread.sleep(3000);
		
	}
	@Test
	void checkResponseBody() {
		logger.info("******Checking response body*****");
		String resbody=response.getBody().asString();
		System.out.println("resonse body"+resbody);
		Assert.assertEquals(resbody.contains(empID), true);
		
	}
	
	@Test
	void check_status_code() {
		logger.info("******Checking status code*****");
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode>=200, true);
		Assert.assertEquals(statuscode, 200);
	
	}
	@Test
	void check_headers() {
		logger.info("******Checking headers *****");
		 Headers allHeaders = response.getHeaders();
		// System.out.println("All Headers: " + response.getHeaders().toString());
		 Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
		 Assert.assertEquals(response.getHeader("Server"), "cloudflare");
		 Assert.assertEquals(response.getHeader("Content-Encoding"), "gzip");

	}
	
	@AfterClass
	void Teardown() {
		logger.info("*******successfully testd the TC002********");
	}
} 
