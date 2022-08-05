package goRestApi;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class TC003_PutCommands {

	HashMap map = new HashMap();
	
	
	@Test
	public void mofidyUserDetails() {
		
		map.put("name", "arcade");
		map.put("email", "aracde12@gmail.com");
		
		given()
			
			.headers("Authorization", "Bearer a41960017b3442e3571daaaae5e000776b336961bb9c35fe7ff9bc538c0047bc")
			.contentType("application/json; charset=utf-8")
			.body(map)
		.when()
			.put()
		.then()
			.log().all();
		
	}
	
	
	@BeforeClass
	public void setup() {
		int custId = 3612;
		
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users/"+custId;//get details of single customer
	}
	
}
