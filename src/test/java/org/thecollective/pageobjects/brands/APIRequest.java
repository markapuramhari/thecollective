package org.thecollective.pageobjects.brands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class APIRequest {
	public void apiCallMethod(String[] a) throws IOException 
	{
		// HTTP POST request
		

			String url = "https://code.trendin.com/workspace/nagarajuv/bflyte/apis/branddirectoryapi";

			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);

			// add header
			//post.setHeader("User-Agent", USER_AGENT);
			//"1","55","Adriano Goldschmied","1"]
			int status=Integer.parseInt(a[3]);
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("gender", a[0]));
			urlParameters.add(new BasicNameValuePair("category", a[1]));
			urlParameters.add(new BasicNameValuePair("subbrand", a[2]));
			urlParameters.add(new BasicNameValuePair("status", a[3]));
			

			post.setEntity(new UrlEncodedFormEntity(urlParameters));

			HttpResponse response = client.execute(post);
			//System.out.println("\nSending 'POST' request to URL : " + url);
			//System.out.println("Post parameters : " + post.getEntity());
			//System.out.println("Response Code : " +response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(
	                        new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) 
			{
				result.append(line);
			}

			System.out.println(result.toString());

		}


	

}