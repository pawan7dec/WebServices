package com.webservice.service;

import org.json.JSONObject;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.webservice.requestpojo.Login;
import com.webservice.requestpojo.LoginPojo;

public class Service {
	
	public Response login(String loginId,String loginSource,String password){
		try {
			LoginPojo loginpojo=new LoginPojo();
			Login login=new Login();
			
			login.setLoginId(loginId);
			login.setLoginSource(loginSource);
			login.setPassword(password);
			
			loginpojo.setLogin(login);
			
			JSONObject jsonObject=new JSONObject(loginpojo);
			
			RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification.headers("content-type","application/json");
			//requestSpecification.body(jsonObject.toString());
			//Response response=requestSpecification.post(URLBuilder.loginurl);
			Response response=requestSpecification.get(URLBuilder.loginurl);
			
			return response;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[] args) {
		Service ser=new Service();
		Response res=ser.login("info.bhanupratap@gmail.com", "APP", "password");
		System.out.println(res.asString());
	}
	

}
