package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinitionsCreateUser {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	@Given("create employee data")
	public void create_employee_data() throws IOException {
		TestDataBuild testDataBuild = new TestDataBuild();
		res = given().spec(Utils.requestSpecification()).body(testDataBuild.employeeData());
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		APIResources apiResource =APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		//response = res.when().post(apiResource.getResouce()).then().spec(resspec).extract().response();
		if(method.equalsIgnoreCase("post"))
			response = res.when().post(apiResource.getResouce());
			else if(method.equalsIgnoreCase("get"))
			response = res.when().get(apiResource.getResouce());
			else if(method.equalsIgnoreCase("delete"))
				response = res.when().delete(apiResource.getResouce());
			else response = res.when().put(apiResource.getResouce());
		}
	

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		
		//  String responseString = response.asString(); 
		//  JsonPath jsonPath = new JsonPath(responseString); 
		 // assertEquals(jsonPath.get(keyValue).toString(), expectedValue); 
		//  System.out.println("responseString : " + responseString);
		 
	}

}
