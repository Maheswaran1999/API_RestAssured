import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoForGET {
	@Test
	public void getApiCall() {

		// Set BaseURI
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";

		// Request Object
		RequestSpecification requestSpecification = RestAssured.given();

		// Response Object
		Response response = requestSpecification.request(Method.GET, "/1");

		// Print Response
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		int statusCode = response.getStatusCode();
		System.out.println("statuscode is:" + statusCode);
		Assert.assertEquals(statusCode, 200);

	}
}
