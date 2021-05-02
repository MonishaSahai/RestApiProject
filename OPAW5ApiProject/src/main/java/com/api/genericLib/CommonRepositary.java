package com.api.genericLib;

import java.io.File;

import io.restassured.response.Response;

public class CommonRepositary {

	public Object getJsonPathValue(Response resp , String jsonPath)
	{
		Object obj = resp.jsonPath().get(jsonPath);
		return obj;
	}
	
	public File getDataFromJsonFile(String fileName)
	{
		String filePath = "./src/main/resources/JsonDataContainer/";
		String completePath = filePath + fileName;
		File jsonData = new File(completePath);
		return jsonData;
	}
}
