package laybuy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestExample {
	Response response = get("https://jsonplaceholder.typicode.com/users");
	@Test
	public void test_1(){
	
		
		//Assert the call responds with a successful status code
		//System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		//System.out.println(response.getTime());
		
		//Validate 10 records are returned
		System.out.println(response.getBody().asString());
		//System.out.println(response.getHeader("content-type"));
		
		/*
		 * int statusCode = response.getStatusCode();
		 * Assert.assertEquals(statusCode,200);
		 */
	}

	//Validate you can retrieve data for a single user
	@Test
	public void test_2(){
		
	     response = get("https://jsonplaceholder.typicode.com/users?id=3");	
	     System.out.println(response.getBody().asString());
		
	}
	
	//Assert that the user “Mrs. Dennis Schulist” is contained in the list.
	@Test
	public void test_3(){
		
		baseURI ="https://jsonplaceholder.typicode.com";

		given().get("/users?id=6").then().statusCode(200).body("name",hasItems("Mrs. Dennis Schulist"));
		
	}
	
}
