package org.etna.utils;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class RestCustomMethods {

	
	public static String getRequestTestURLs(String [] url,int status){
		String s = "";
	
		for(int i=0;i<url.length;i++)
		{
			int tempStatus  = getRequestUrl(url[i]);
			if( tempStatus != status){
				s += url[i] + " failed  with status " +  tempStatus + "\n"; 
			}
		}
		return s;
	}
	
	public static int getRequestUrl(String url){
		 Response res = RestAssured.when().get(url);
		 return res.statusCode();
	}

	public static int getRequestTestURLsForProd(String url) {
		RestAssured.useRelaxedHTTPSValidation();
		Response res =   RestAssured.given().relaxedHTTPSValidation().when().get(url);
		return res.statusCode();
	}

	public static String getRequestTestURLsForProduction(String[] url, int status) {
		
		String s = "";
		
		for(int i=0;i<url.length;i++)
		{
			int tempStatus  = getRequestTestURLsForProd(url[i]);
			if( tempStatus != status){
				s += url[i] + " failed  with status " +  tempStatus + "\n"; 
			}
		}
		return s;
	}
}
