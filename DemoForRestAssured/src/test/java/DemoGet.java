import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoGet {

	@Test
	public void demoGet() {
		RestAssured.baseURI = "https://reqres.in/api/unknown";
		RequestSpecification requestSpecification = RestAssured.given();
		Response response = requestSpecification.request(Method.GET, "");

		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		int statusCode = response.statusCode();

		System.out.println("**status code is:**" + statusCode);
		
		Assert.assertEquals(statusCode, 200);

	}

}
