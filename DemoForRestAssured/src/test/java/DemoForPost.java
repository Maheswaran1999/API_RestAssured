import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoForPost {
	@SuppressWarnings("unchecked")
	@Test
	public void postApi() {
		// set BaseURI
		RestAssured.baseURI = "https://reqres.in/api";

		// Request Object
		RequestSpecification requestSpecification = RestAssured.given();

		// PayLoad for Request
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "maheswaran");
		jsonObject.put("job", "SDET");
		jsonObject.put("location", "TamilNadu");

		requestSpecification.header("content-type", "application/json");

		requestSpecification.body(jsonObject.toJSONString());

		// Response
		Response response = requestSpecification.request(Method.POST, "/users");

		// validate
		String string = response.getBody().asPrettyString();
		System.out.println(string);
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 201);

	}

}
