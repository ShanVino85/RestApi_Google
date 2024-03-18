package request;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.LocationPojo;
import pojo.MainPojo;
import utils.RestUtils;

public class Requestbody extends RestUtils {

	public  static Response postcreation(MainPojo pojo) {
		{
			MainPojo M=new MainPojo();
			M.setAccuracy(50);
			M.setAddress("30, side layout, cohen 09");
			M.setLanguage("French-IN");
			M.setPhone_number("(+91) 983 893 3937");
			M.setWebsite("http://google.com");
			M.setName("Frontline house");
			
			List<String> MyList=new ArrayList<String>();
			MyList.add("shoe park");
			MyList.add("shop");
			M.setTypes(MyList);
			
			LocationPojo l=new LocationPojo();
			l.setLat(-38.383494);
			l.setLng(33.427362);
			M.setLocation(l);
			
			/*Response response = given().queryParam("Key", "qaclick123")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			
			.body( M)
			.when().post(routes.getString("Post_url"))
			
			.then().assertThat().statusCode(200).contentType("application/json").extract().response();
			
			String responseString=response.asString();
			System.out.println(responseString);*/
				RequestSpecification req=new RequestSpecBuilder().addQueryParam("Key", "qaclick123")
					.setContentType(ContentType.JSON)
					.setAccept(ContentType.JSON).build();
			
		ResponseSpecification resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").build();
			
			RequestSpecification res=given().spec(req).body( M);
			
			Response response = res
					.when().post(routes.getString("Post_url"))
					.then().spec(resspec).extract().response();
			
			String responseString=response.asString();
			System.out.println(responseString);
			
			return response ;
		}
		
	
	}
	
}
