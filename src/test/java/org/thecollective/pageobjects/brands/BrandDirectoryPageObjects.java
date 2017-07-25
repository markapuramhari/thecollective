package org.thecollective.pageobjects.brands;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.FileRead;
import org.thecollective.utils.TestUtility;
import org.thecollective.utils.Waiting;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class BrandDirectoryPageObjects extends PageFactoryInitializer
{
	
	
	APIRequest api=new APIRequest();
	
	static FileRead read= new FileRead(); 
	Actions action= new Actions(driver);
	TestUtility utility= new TestUtility();
	 private SoftAssert softAssert = new SoftAssert();
	
	@FindBy(xpath="//label[text()='Select Gender']/following-sibling::div[@class='dropdown']")
	private WebElement genderDropDown;

	@FindBy(xpath="//div[contains(text(),'Products are not available ')]")
	private WebElement itemsNotFoundText;
	
	@FindBy(xpath="//label[text()='Select Gender']/following-sibling::div[@class='dropdown']//ul")
	private WebElement genderDropDownLink;
	
	@FindBy(xpath="//label[text()='Select Category']/following-sibling::div[@class='dropdown']")
	private WebElement categoryDropDown;
	
	@FindBy(xpath="//label[text()='Select Category']/following-sibling::div[@class='dropdown']//ul")
	private WebElement categoryDropDownLink;
	
	@FindAll(value={@FindBy(xpath="//ul[@id='selectCategory']/li")})
	private List<WebElement> categoryOptions;
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'products_list_item')]")})
	private List<WebElement> listedItems;
	
	/*@FindAll(value={@FindBy(xpath="//ul[@class='subbrand_results']/ancestor::div[contains(@id,'brand__results__gender_women')]//a")})
	private List<WebElement> listedBrandForWomenCategory;*/
	
	@FindBy(id="btnBrandDirectory")
	private WebElement viewBrandsButton;
	
	@Step("verify brand directory page")
	public BrandDirectoryPageObjects verifyBrandDirectoryPage() {
		Waiting.explicitWaitVisibilityOfElement(genderDropDown, 30);
		Assert.assertTrue(genderDropDown.isDisplayed(),"gender dropdown is not displayed");
		Assert.assertTrue(categoryDropDown.isDisplayed(),"category dropdown is not displayed");
		Assert.assertTrue(viewBrandsButton.isDisplayed(),"viewBrandsButton dropdown is not displayed");

		return this;
	}

	public String selectGender(String gender) {
		genderDropDown.click();
		driver.findElement(By.xpath("//li[text()='"+gender+"']")).click();
		String selectedGenderId=driver.findElement(By.xpath("//li[text()='"+gender+"' and @class='selectedG']")).getAttribute("id");
		return selectedGenderId;
	}

	
	public List<String> selectCategory( String selectedGenderId,String gender) throws Exception {
		List<String> categoryId=new ArrayList<String>();
		//System.out.println(categoryOptions.size());
		for(int i=0;i<categoryOptions.size()-1;i++)
		{
			
			categoryDropDown.click();
			categoryOptions.get(i+1).click();
			viewBrandsButton.click();
			categoryId.add(driver.findElement(By.xpath("//li[@class='selectedLi']")).getAttribute("id"));
			List<String> brandName= clickOnListedBrands(selectedGenderId,gender,categoryId);
			 Thread.sleep(1500);
		}
		return categoryId;
		
	}
	@SuppressWarnings("null")
	@Step("click on listed brands{0}")
	public List<String> clickOnListedBrands(String selectedGenderId,String gender,  List<String> categoryId) throws Exception {
		
		List<String> brandName1=new ArrayList<String>();
		List<String> brandName2=new ArrayList<String>();
		List<String> BrandToMakeActive=new ArrayList<String>();
		List<String> BrandToMakeInActive=new ArrayList<String>();
		String a[]= new String[4];
		String b[]= new String[4];
		Thread.sleep(2500);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Waiting.explicitWaitVisibilityOfElements(listedBrandForWomenCategory, 30);
		List<WebElement> listedBrandForWomenCategory=driver.findElements(By.xpath("//ul[@class='subbrand_results']/ancestor::div[contains(@id,'brand__results__gender_"+gender.toLowerCase()+"')]//a"));
		for(int i=0;i<listedBrandForWomenCategory.size();i++)
		{
			String parentHandle = driver.getWindowHandle();
			action.keyDown(Keys.SHIFT).click(listedBrandForWomenCategory.get(i)).keyUp(Keys.SHIFT).build().perform();
			Set<String> s1=driver.getWindowHandles();
			Iterator<String> i1=s1.iterator();
			while(i1.hasNext())
			{
			String child_window=i1.next();
			if(!parentHandle.equalsIgnoreCase(child_window))
			{
			driver.switchTo().window(child_window);
			Thread.sleep(3000);
						try{
							if(itemsNotFoundText.isDisplayed()){
								
							driver.close();
				    		driver.switchTo().window(parentHandle);
				    		//System.out.println("fail");
				    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				    		BrandToMakeInActive.add(listedBrandForWomenCategory.get(i).getText());
				    		Thread.sleep(2000);
							}
						}
						catch(Exception e)
						{
						driver.close();
						driver.switchTo().window(parentHandle);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						BrandToMakeActive.add(listedBrandForWomenCategory.get(i).getText());
			    		
						}
			    		
			
			}
			}
		}for(int i=0;i<categoryId.size();i++)
		{
			for(int j=0;j<BrandToMakeInActive.size();j++)
			{
				//brandName2.add("{ "+selectedGenderId+","+categoryId.get(i)+","+BrandToMakeActive.get(j)+","+1+" }");
				a[0]=selectedGenderId;
				a[1]=categoryId.get(i);
				a[2]=BrandToMakeInActive.get(j);
				a[3]="0";
				api.apiCallMethod(a);
				//brandName1.add("{ "+selectedGenderId+", "+categoryId.get(i)+", "+BrandToMakeInActive.get(j)+", "+0+" }");
				
			}
		}
		
		for(int i=0;i<categoryId.size();i++)
		{
			for(int j=0;j<BrandToMakeActive.size();j++)
			{
				b[0]=selectedGenderId;
				b[1]=categoryId.get(i);
				b[2]=BrandToMakeActive.get(j);
				b[3]="1";
				api.apiCallMethod(b);
				//brandName2.add("{ "+selectedGenderId+","+categoryId.get(i)+","+BrandToMakeActive.get(j)+","+1+" }");
				
			}
		}
		
		//System.out.println("Brands to make Inactive: "+brandName1);
		//System.out.println("Brands to make Active: "+brandName2);
		
		return brandName1;
	}

	
	
}
