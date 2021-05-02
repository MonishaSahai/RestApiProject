package com.api.testScripts;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.api.genericLib.BaseClass;
import com.api.genericLib.IEndPoints;

import io.restassured.http.ContentType;

public class FetchAllUsersTest extends BaseClass{

	@Test
	public void getAllUsers()
	{
		given()
		.when()
			.get(IEndPoints.FETCHALLUSERS)
		.then()
			.assertThat().statusCode(200).and().contentType(ContentType.JSON)
			.and().log().all();
	}
}
