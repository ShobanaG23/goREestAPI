package goRestApi;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC001_GetCommands {
	@Test
	public void getCustomerDetails() {
		
		//Behavioral driven development
		
		/*given---path, query parameter, authorization
		when---get, post, put/patch, delete
		then----assertions, validations, logs
		*/
		//Method 1
		given()
		.when()
			.get("https://gorest.co.in/public/v2/users")
		.then()
			.statusCode(200)
		.and()
			.contentType("application/json; charset=utf-8")
		.and()
			.log().all();
		
		
		/*//method 2
		Response resp = given().when().get("https://gorest.co.in/public/v2/posts");
		System.out.println(resp.prettyPrint());*/
		
		//method 3 pass url from some command
		
	
		/*given()
		.when()
			.get()
		.then()
			.assertThat()
				//.body("id", equalTo("3612")) //validate my response for 3612
				.body(hasItem("6637"))
			//.statusCode(200)
		.and()
			.contentType("application/json; charset=utf-8")
		.and()
			.log().all();
		*/
		
}
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users";//get details of single customer
	}
}