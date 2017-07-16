package com.webservice;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.webservice.responsepojo.login.CustomerWrapper;
import com.webservice.responsepojo.login.Customers;
import com.webservice.responsepojo.login.LoginResponsePojo;
import com.webservice.service.Service;

public class LoginTestApi {
    Service service;
    Response responsedata;
	
	@Test
	public void loginApitest(){
		service=new Service();
		responsedata=service.login("info.bhanupratap@gmail.com", "APP", "password");
		System.out.println(responsedata.asString());
	
		
		Gson gson=new Gson();
		LoginResponsePojo data=gson.fromJson(responsedata.asString(), LoginResponsePojo.class);
		CustomerWrapper customerWrapper=data.getCustomerWrapper();
		System.out.println(customerWrapper.getResponseCode());
		
		Customers getCustomers=customerWrapper.getCustomers();
		
		System.out.println(getCustomers.getCreateDate());
		System.out.println(getCustomers.getGender());
		System.out.println(getCustomers.getFirstName());
		System.out.println(getCustomers.getLastName());
		
		Assert.assertEquals(getCustomers.getCreateDate(), "2012-05-08T14:08:36+05:30");
		Assert.assertEquals(getCustomers.getFirstName(), "Bhanu1");
		
		
		
		
	}
	
}
