package goRestApi;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class TC002_PostCommands {

	public HashMap map = new HashMap();
	String custName = RandomStringUtils.randomAlphabetic(8);
	//String custEmail = "spade"+RandomStringUtils.random(3)+"@gmail.com";
	
	@Test(priority =2)
	public void createUserWithoutTokenAndPayload() {
		
		given()
		.when()
			.post()
		
		.then()
			.assertThat()
				.body("message",equalTo("Authentication failed"))   //validate message Authentication failed
			.statusCode(401) //validate status code 404
			.contentType("application/json; charset=utf-8")  //validate content type
			.log().all();
		
		
	}
	
	@Test(priority =1)
	public void createUserWithPayload() {
		
		
		
		map.put("name",custName);
		map.put("email", "spade132@gmail.com");
		map.put("gender","male");
		map.put("status","active");
				
		
		given()
			.contentType("application/json")
			.headers("Authorization", "Bearer a41960017b3442e3571daaaae5e000776b336961bb9c35fe7ff9bc538c0047bc")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
			.contentType("application/json; charset=utf-8")
			.assertThat()
				.body("name",equalTo(custName))
		
			.log().all();
		
		
		
		
	}
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users";//get details of single customer
	}
}
