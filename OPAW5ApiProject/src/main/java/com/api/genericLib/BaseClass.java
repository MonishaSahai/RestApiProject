package com.api.genericLib;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseClass {

	@BeforeSuite
	public void configBS()
	{
		baseURI = "https://jsonplaceholder.typicode.com/";
	}
}
