package org.thecollective.modules;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;
import org.thecollective.maincontroller.PageFactoryInitializer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;

public class APICallForTC extends PageFactoryInitializer{
	
	@Test()
	@Features("APICall")
	@Description("test product mrp price")
	public void fetchProductPrice() throws IOException, Exception {
		
		
	}
	
	public static void readDataFromJsonFile(String path, String userName) throws  IOException, ParseException{
	
		 JSONParser parser = new JSONParser();
	        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));

			        for (Object o : jsonArray) {
			            JSONObject person = (JSONObject) o;
		
			            String strName = (String) person.get(userName);
			            System.out.println("Name::::" + strName);
		
			            String strCity = (String) person.get("city");
			            System.out.println("City::::" + strCity);
		
			            JSONArray arrays = (JSONArray) person.get("cars");
			            for (Object object : arrays) {
			                System.out.println("cars::::" + object);
			            }
			            String strJob = (String) person.get("job");
			            System.out.println("Job::::" + strJob);
			            System.out.println();
		
			        }

		
		
		System.out.println("ends");
		
	}
	

}
