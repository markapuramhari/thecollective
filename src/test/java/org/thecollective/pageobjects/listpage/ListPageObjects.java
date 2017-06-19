package org.thecollective.pageobjects.listpage;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.pageobjects.homepage.StoresPageObjects;
import org.thecollective.utils.SearchDataPropertyFile;
import org.thecollective.utils.Waiting;

import ru.yandex.qatools.allure.annotations.Step;

public class ListPageObjects extends PageFactoryInitializer{

	SearchDataPropertyFile data=new SearchDataPropertyFile();
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'category__breadcrumbs')]/a")})
	private  List<WebElement> breadCrumbs;
	
	@FindBy(xpath="//h1[contains(@class,'brand-title')]")
	private WebElement brandTitle;
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'products_list_item')]")})
	private List<WebElement> listedItems;
	
	
	@Step("verify product list page")
	public ListPageObjects verifyListedProducts() {
		

		return this;
	}

	public ListPageObjects verifyBreadcrumbs(String brandName)
	{
		Assert.assertTrue(verifyBreadcrumb(brandName),"breadcrumbs were not same");
		Assert.assertEquals(driver.getTitle(),""+brandName+" | "+data.getProductName(),"page title is not correct");

		return this;
	}

	private boolean verifyBreadcrumb(String brandName) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try{
			if(breadCrumbs.get(breadCrumbs.size()-1).getText().replace(">", "").trim().toLowerCase().contains(brandName))
		{
			return true;
		}
			else 
		{
			Assert.assertTrue(brandTitle.getText().toLowerCase().contains(brandName));
			return true;
		}
	}catch(Exception e)
		{
		return false;
	}
	}
	@Step("verify search results page")
	public ListPageObjects verifySearchResultsPage() {
		Waiting.explicitWaitVisibilityOfElements(listedItems, 15);
		Assert.assertTrue(listedItems.get(0).isDisplayed(), "search results not found");
		return this;
	}
	@Step("verify search results page title")
	public ListPageObjects verifyPageTitle() 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), data.getSearchResultsPageTitle()+" | "+data.getProductName().trim());

		return this;
	}
	@Step("verify invalid search results")
	public ListPageObjects verifyInvalidSearchResultsPage() throws Exception {
		 throw new  Exception("needs to write code for invalid search results");
	}
	@Step("click on specific product {0} in list page")
	public ListPageObjects clickOnSpecificProduct() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElements(listedItems, 30);
		listedItems.get(0).click();
		Thread.sleep(3000);

		return this;
	}
	
	

}
