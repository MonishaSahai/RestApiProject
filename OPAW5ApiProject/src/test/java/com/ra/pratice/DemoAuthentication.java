package com.ra.pratice;

import org.testng.annotations.Test;

import com.api.genericLib.IConstantParameters;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class DemoAuthentication {

	@Test
	public void checkBasicAuth()
	{
		// store login credentials in rest assured
		AuthenticationScheme scheme = basic("postman", "password"); 
		
		// create customized specification for request
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setAuth(scheme);
		builder.setContentType(ContentType.JSON);
		RequestSpecification specification = builder.build();
		
		// send the request with customized specification & get the response
		given()
			.spec(specification)
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.log().all();
	}
	
	@Test
	public void checkBasicAuth1()
	{
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.log().all();  // 401 Unauthorized
	}
	
	@Test
	public void accessAuthorisedTokenBasedApi()
	{
		String token = getToken();
		given()
			.auth().oauth2(token)
		.when()
			.post("http://coop.apps.symfonycasts.com/api/1301/eggs-count")
		.then()
			.log().all();
	}
	
	public String getToken()
	{
		Response resp = given()
							.param(IConstantParameters.AUTH_CLIENT_ID, IConstantParameters.AUTH_CLIENT_ID_VALUE)
							.param(IConstantParameters.AUTH_CLIENT_SECRET, IConstantParameters.AUTH_CLIENT_SECRET_VALUE)
							.param(IConstantParameters.AUTH_GRANT_TYPE, IConstantParameters.AUTH_GRANT_TYPE_VALUE)
						.when()
							.post("http://coop.apps.symfonycasts.com/token");
		
		Object token = resp.jsonPath().get("access_token");
		System.out.println("Token is : " + token);
		return token.toString();
	}
}
//ef4700312a8041b7a2a6a969501aca87461935d5
//a42e61458014b51f32a57162543bbb58760eb769
































