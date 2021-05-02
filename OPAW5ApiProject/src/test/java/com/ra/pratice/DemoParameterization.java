package com.ra.pratice;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DemoParameterization {

	@Test
	public void checkParameter()
	{
		given()
			.param("userId", "2")
			.and()
			.param("id", "35")
			.and()
			.pathParam("x", "todos")
		.when()
			.get("https://jsonplaceholder.typicode.com/{x}")
		.then()
			.log().all();
	}
}
