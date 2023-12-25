package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

public class TC_VideoGameApiTest {

	@Test(priority = 1)

	public void GetallVideoGame() {

		RequestSpecification reqsep = RestAssured.given();

		reqsep.baseUri("http://localhost:8080/app/videogames");

		Response response = reqsep.get();

		response.statusCode();

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void PostRequest() {

		HashMap data = new HashMap();

		data.put("id", 6);
		data.put("name", "Lokesh");
		data.put("releaseDate", "2023-12-24T14:05:32.779Z");
		data.put("reviewScore", 4);
		data.put("category", "String");
		data.put("rating", "string");

		RequestSpecification reqsep = RestAssured.given();
		reqsep.baseUri("http://localhost:8080/app/videogames");
		reqsep.body(data);
		reqsep.contentType(ContentType.JSON);

		Response response = reqsep.post();

		response.prettyPrint();
		response.statusCode();

		Assert.assertEquals(response.getStatusCode(), 200, "check for statuscode");
		Assert.assertEquals(response.asString().contains("Record Added Successfully"), true);

	}

	@Test(priority = 3)
	public void singlegetRequest() {

		RequestSpecification reqsep = RestAssured.given();
		reqsep.baseUri("http://localhost:8080/app/videogames/6");
		reqsep.contentType(ContentType.JSON);

		Response response = reqsep.get();
		response.statusCode();
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 4)

	public void putRequest() {

		HashMap data = new HashMap();

		data.put("id", 6);
		data.put("name", "prajval");
		data.put("releaseDate", "2023-12-24T14:05:32.779Z");
		data.put("reviewScore", 4);
		data.put("category", "String");
		data.put("rating", "string");

		RequestSpecification reqsep = RestAssured.given();
		reqsep.baseUri("http://localhost:8080/app/videogames/6");
		reqsep.contentType(ContentType.JSON);
		reqsep.body(data);

		Response response = reqsep.put();
		response.statusCode();
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 5)
	public void DeleteRequest() {

		RequestSpecification reqsep = RestAssured.given();
		reqsep.baseUri("http://localhost:8080/app/videogames/6");
		reqsep.contentType(ContentType.JSON);
		Response response = reqsep.delete();
		response.statusCode();
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.asString().contains("Record Deleted Successfully"), true);

	}
}
