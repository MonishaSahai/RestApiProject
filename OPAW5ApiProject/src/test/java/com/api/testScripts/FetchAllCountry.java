package com.api.testScripts;

import org.testng.annotations.Test;

import com.api.genericLib.BaseClass;
import com.api.genericLib.IEndPoints;

import static io.restassured.RestAssured.*;

public class FetchAllCountry extends BaseClass{

	@Test
	public void getAllCountries()
	{
		given()
		.when()
			.get(IEndPoints.FETCHALLCOUNTRY)
		.then()
			.log().all();
	}
}
