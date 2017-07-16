package com.webservice.Utils;

public enum EndpointURL {
	
	ADD_COUNTRY("/countries/detail");
	String resourcePath;
	
	EndpointURL(String resourcePath){
		this.resourcePath=resourcePath;
	}
	public String getresourcePath(){
		return this.resourcePath;
	}
	
	public String getresourcePath(String data){
		return this.resourcePath+data;
	}
	public static void main(String[] args) {
		String data="/city/varansi";
		System.out.println(EndpointURL.ADD_COUNTRY.getresourcePath());
		System.out.println(EndpointURL.ADD_COUNTRY.getresourcePath( data));
	}
	
	

}
