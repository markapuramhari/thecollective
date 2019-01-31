package org.thecollective.modules;

import java.awt.print.Book;

import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class APITesting 
{
	@Test
	public void JsonArrayToArray()
	{

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/books/getallbooks";
		RequestSpecification request = RestAssured.given();

		Response response = request.get();
		System.out.println("Response Body -> " + response.body().asString());
		

		// We can convert the Json Response directly into a Java Array by using
		// JsonPath.getObject method. Here we have to specify that we want to
		// deserialize the Json into an Array of Book. This can be done by specifying
		// Book[].class as the second argument to the getObject method.
		Book[] books = response.jsonPath().getObject("books",Book[].class );

		for(Book book : books)
		{
			System.out.println("Book title " + book.getNumberOfPages());
		}
	}
}
