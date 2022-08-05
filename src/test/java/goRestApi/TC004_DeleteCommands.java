package goRestApi;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class TC004_DeleteCommands {

	@Test
	public void deleteUser() {
		
		given()
			.headers("Authorization", "Bearer a41960017b3442e3571daaaae5e000776b336961bb9c35fe7ff9bc538c0047bc")
		.when()
			.delete()
		.then()
			.statusCode(404)
			
			.log().all();
		
		
	}
	
	@BeforeClass
	public void setup() {
		
		int custId = 3611;
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath ="public/v2/users/"+custId;
		
	}
}
