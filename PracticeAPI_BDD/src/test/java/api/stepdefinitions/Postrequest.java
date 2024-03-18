package api.stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.LocationPojo;
import pojo.MainPojo;
import resourses.TestDataBuild;
import utils.RestUtils;

public class Postrequest extends RestUtils {
	//String baseURI ;
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response ;
	TestDataBuild  data=new TestDataBuild ();
	
	
	@Given("AddPlace Payload")
	public void addplace_Payload() throws FileNotFoundException {
		
	  resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json;charset=UTF-8").build();
		
	   res=given().spec(requestSpecification()).body( data.addplacepayload());
		
	}

	@When("user calls {string} with post https request")
	public void user_calls_with_post_https_request(String string) {
		//String BaseURI = routes.getString("base_url");
		//baseURI = BaseURI;
		
		response = res
				.when().post(routes.getString("Post_url"))
				.then().spec(resspec).log().all().extract().response();
	}
	

	@Then("the Api call got success with status code {int}")
	public void the_Api_call_got_success_with_status_code(Integer int1) {
	  assertEquals( response.getStatusCode(),200);
	}

	
	

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String Key, String value) {
	    String resp=response.asString();
	    JsonPath js=new JsonPath(resp);
	    assertEquals(js.get(Key).toString(),value);
	}

	


}
