package APIBookStore.APIBookStore;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BookstoreRequest {
	@Test
	public void getBooks()
	{
		RestAssured.baseURI = "https://bookstore.toolsqa.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "/BookStore/v1/Books");
		
		int statusCode = response.getStatusCode();
		//Assert.assertEquals(200, statusCode);
		//System.out.println("Response status code is "+statusCode);
		
		
		Headers header = response.getHeaders();
		//System.out.println("Headers of the response body are "+header);
		
		ResponseBody body = response.getBody();
		body.prettyPrint();
	}
	

}
