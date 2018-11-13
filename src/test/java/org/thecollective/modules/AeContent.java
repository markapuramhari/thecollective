package org.thecollective.modules;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.thecollective.dataprovider.DataDrivenTestingFromExcel;
import org.thecollective.maincontroller.MainController;

class AeContent extends MainController
{
	private int invalidImageCount;
	
	@Test(dataProvider="getDataFromGoogle", dataProviderClass=DataDrivenTestingFromExcel.class)
	public void getDataFromGoogle(String inputData, String city) throws InterruptedException {
		String data=inputData.replace(".0", "");
		driver.findElement(By.xpath("//input[@id='Source']")).clear();
		driver.findElement(By.xpath("//input[@id='Source']")).sendKeys(data+", "+city+", India");
		driver.findElement(By.xpath("//input[contains(@value,'Find Latitude Longitude')]")).click();
		Thread.sleep(1000);
		try
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}catch(Exception e) {
			
		}
		String lat=driver.findElement(By.xpath("//span[@itemprop='Latitude']")).getText();
		String longi=driver.findElement(By.xpath("//span[@itemprop='Longitude']")).getText();		
		/*driver.findElement(By.xpath("//input[@placeholder='Type address here to get lat long']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type address here to get lat long']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Type address here to get lat long']")).sendKeys(data+", "+city);
		driver.findElement(By.id("btnfind")).click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String latandLong=driver.findElement(By.xpath("//span[@id='latlngspan']")).getText();
		String ltLg=latandLong.replace("(", "").replace(")","");
		String[] langLat=ltLg.split(",");
		System.out.println(ltLg);
		String lat=langLat[0];
		String longi=langLat[1];*/
				
		System.out.println(lat+longi);
		
		ExcelFileReadAndWrite writeData=new ExcelFileReadAndWrite();
		writeData.writeData(data, lat, longi);
	}
	
	@Test
	public void testforWishList() throws InterruptedException {
		Thread.sleep(4500);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(@class,'wishListBtn')]")).click();
		Thread.sleep(2500);
		
		driver.findElement(By.id("loginEmailOrMobile")).isDisplayed();
		driver.findElement(By.id("loginEmailOrMobile")).sendKeys("test");
	}
	
	@Test
	public void validateInvalidImages() {
		try {
			 invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	

	public void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)
				System.out.println("failed image location: "+imgElement.getAttribute("src"));
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}