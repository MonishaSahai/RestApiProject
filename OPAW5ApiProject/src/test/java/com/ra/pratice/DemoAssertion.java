package com.ra.pratice;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DemoAssertion {

	// Assertions by TestNG
	@Test
	public void checkAssertion()
	{
		Response resp = given()
							.param("userId", "2")
							.and()
							.param("id", "35")
							.and()
							.pathParam("x", "todos")
						.when()
							.get("https://jsonplaceholder.typicode.com/{x}");
		
		// capture title from response
		Object actTitle = resp.jsonPath().get("title[0]");
		System.out.println(actTitle);
		
		// validate title from response body
		Assert.assertEquals(actTitle, "repellendus veritatis molestias dicta incidunt");
		resp.then().log().all();
				
	}
	
	// import org.hamcrest.Matchers;
	@Test
	public void checkAssertionByRA()
	{
		given()
			.param("userId", "2").and().param("id", "35").and().pathParam("x", "todos")
		.when()
			.get("https://jsonplaceholder.typicode.com/{x}")
		.then().assertThat()
			.statusCode(200).and().contentType(ContentType.JSON).and().time(Matchers.lessThan(2000l)).and()
			.body("userId[0]", Matchers.equalTo(2)).and()
			.body("id[0]", Matchers.equalTo(35)).and()
			.body("title[0]", Matchers.equalTo("repellendus veritatis molestias dicta incidunt")).and()
			.body("completed[0]", Matchers.equalTo(true)).and()
			.log().all();
		
		
	}
}










