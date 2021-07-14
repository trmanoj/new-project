package APIBookStore.APIBookStore;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC_reqres_API {
	
	
	@Test(priority=1)
	public void test_getUsers()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.log().body();
		
	}
	
	@Test(priority=2)
	public void test_addUser()
	{
		HashMap<String,String> data= new HashMap<String,String>();
		data.put("name", "ShivaKumar");
		data.put("job", "leader");
		
		
		Response res=
				given()
					.contentType("application/json")
					.body(data)
				.when()
					.post("https://reqres.in/api/users")
				.then()
					.statusCode(201)
					.log().body()
					.extract().response();
		
		String jsonString=res.asString();
		Assert.assertEquals(jsonString.contains("id"), true);
	}
	
	@Test(priority=3)
	public void test_getUser()
	{
		Response res=
		given()
		
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		String jsonString=res.asString();
		System.out.println(jsonString);		
	}
	@Test(priority=4)
	public void test_UpdateUserDetails()
	{
		HashMap<String,String> data= new HashMap<String,String>();
		data.put("name", "ShivaKumar");
		data.put("job", "manager");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().body();
	}
	
	@Test(priority=5)
	public void test_DeleteUser()
	{
		given()
		.when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204)
			.log().body();
	}
}
