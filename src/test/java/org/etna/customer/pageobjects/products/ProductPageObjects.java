package org.etna.customer.pageobjects.products;
import java.util.List;

import org.etna.customer.pageobjects.compare.ComparePageObjects;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

/*
 * @author Hemanth.Sridhar
 */
public class ProductPageObjects extends PageFactoryInitializer{
	
	
	 SearchDataPropertyFile data = new SearchDataPropertyFile();
	 ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
   Actions action = new Actions(driver);
  
	
	@FindBy(xpath="//h4[contains(text(),'Category')]/following-sibling::span")
	private WebElement categoryToggleButton;
	
	
	@FindAll(value={@FindBy(xpath="//dt[contains(text(),'Category')]/following-sibling::dd[1]/descendant::a[@class='active']")})
	private List<WebElement> categoriesList;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_productCategory']/descendant::h5")})
	private List<WebElement> categoryNamesInThePage;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_productCategory']/descendant::div[@class='cimm_categoryImg']")})
	private List<WebElement> categoryNamesInPageImagesLink;
	
	@FindBy(xpath="//h2")
	private WebElement pageName;
	
	@FindAll(value={@FindBy(xpath="//div[@class='slick-track']/descendant::img")})
	private List<WebElement> bannerImages;
	
	
	@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/descendant::i[contains(@class,'home')]")
	private WebElement homeIconInBreadcrumbLocator;
	
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_productCategory']/descendant::a")})
	private List<WebElement> linkForEveryCategoryLocator;
	
	
	@Step("click on category toggle button")
	public ProductPageObjects clickOnCategoryToggleButton() {
		Waiting.explicitWaitVisibilityOfElement(categoryToggleButton, 15);
		categoryToggleButton.click();
		return this;
	}
	
	@Step("verify names of the categories in the page")
	public ProductPageObjects verifyNamesOfAllTheCategoriesInListAndInPage() {
		
	Waiting.explicitWaitVisibilityOfElements(categoriesList, 15);
		for(int i=0;i<categoriesList.size(); i++)
		{
			Assert.assertTrue((categoriesList.get(i).getText().replace(".", "").trim()).equalsIgnoreCase(categoryNamesInThePage.get(i).getText().trim()),"category name is not the same as it was in the dropdown. The name in the category list is : "+categoriesList.get(i).getText().trim()+" and the name in the category page is : "+categoryNamesInThePage.get(i).getText().trim()+".");
		}
	
		return this;
	}

	
	
	@Step("verify breadcrumbs to have {0}")
	public ProductPageObjects verifyBreadcrump(String productsPageBreadCrump) {	
		Assert.assertTrue(homeIconInBreadcrumbLocator.isDisplayed(),"Home icon is not displayed in the breadcrumb.");
		Assert.assertEquals(productDetailsPage().breadCrumbs.get(productDetailsPage().breadCrumbs.size()-1).getText().replace("/", "").trim(), productsPageBreadCrump);
		return this;
	}

	@Step("verify page title to have {0}")
	public ProductPageObjects verifyPageTitle(String productsPageBreadCrump) throws Exception {
		Assert.assertEquals(driver.getTitle().trim(),productsPageBreadCrump+" | "+setUp.getProductName());
		return this;
	}

	@Step("verify page name to have {0}")
	public ProductPageObjects verifyPagename(String productsPageBreadCrump) throws Exception {
		Assert.assertEquals(pageName.getText().trim().toLowerCase(),productsPageBreadCrump.toLowerCase());
		return this;
	}

	@Step("click on {0} st/nd/rd specific category")
	public ProductPageObjects clickOnSpecificCategory(String getSpecificCategory) 
 {
		Waiting.explicitWaitVisibilityOfElement(By.xpath("//h5[text()[normalize-space() = '"+getSpecificCategory+"']]"), 5);
		driver.findElement(By.xpath("//h5[text()[normalize-space() = '"+getSpecificCategory+"']]")).click();
		return this;
 }

	@Step("verify second breadcrumb")
	public ProductPageObjects verifySecondBreadcrump(String getSpecificCategory) {
		Assert.assertEquals(productDetailsPage().breadCrumbs.get(2).getText().replace("/", "").trim(), getSpecificCategory);
		return this;
	}

	public String getLastBreadCrump() {
		String lastBreadcrump = (productDetailsPage().breadCrumbs.get(productDetailsPage().breadCrumbs.size()-1).getText().replace("/", "").trim());
		return lastBreadcrump;
	}
	
	public String getLastButOneBreadCrump() {
		String lastButOneBreadcrump = (productDetailsPage().breadCrumbs.get(productDetailsPage().breadCrumbs.size()-2).getText().replace("/", "").trim());
		return lastButOneBreadcrump;
	}

	@Step("verify page title to have {0}")
	public ProductPageObjects verifyPageTitle(String lastButOneBreadcrump, String lastBreadcrump) throws Exception {
		Thread.sleep(1500);
		String title = lastBreadcrump+" | "+setUp.getProductName();
		Assert.assertEquals(driver.getTitle().trim(), title);
		return this;
	}

	@Step("verify last breadcrumb to have {0}")
	public ProductPageObjects verifyLastButOneBreadcrump(String getSpecificCategory) {
		Assert.assertEquals(productDetailsPage().breadCrumbs.get(productDetailsPage().breadCrumbs.size()-2).getText().replace("/", "").trim(), getSpecificCategory);
		return this;
	}

	@Step("click on {0} category image")
	public ProductPageObjects clickOnSpecificCategoryImage(String getSpecificCategory) {
		String clickOnSpecificCategoryImage = "//div[@class='cimm_productCategory']/descendant::h5[contains(text(),'"+getSpecificCategory+"')]/preceding-sibling::div[@class='cimm_categoryImg']";	
		driver.findElement(By.xpath(clickOnSpecificCategoryImage)).click();
		return this;
	}

	@Step("verify banner images")
	public ProductPageObjects verifyBannerImages() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String bannerImagesInLevelOne [] = data.getBannerImagesInLevelOne().split(",");
		for(int i = 0 ; i<bannerImages.size() ; i++)
		{
		Assert.assertTrue(bannerImages.get(i).getAttribute("src").trim().equals(bannerImagesInLevelOne[i]));
		}
		return this;
	}

	public ProductPageObjects clickOnSpecificCategoryUnderTheProductsLink(String categoryNameToSearch) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[contains(text(),'"+categoryNameToSearch+"')]")));
		return this;
	}

	public String[] getNamesOfTheCategories() {
		String [] categoryNames = new String[categoryNamesInThePage.size()];
		for(int i = 0 ; i < categoryNamesInThePage.size() ; i++)
		{
			categoryNames[i] = categoryNamesInThePage.get(i).getText().trim();
		}
		return categoryNames;
	}

	public String[] getProductNames() {
		String [] productName = new String[linkForEveryCategoryLocator.size()];
		for(int i = 0 ; i < linkForEveryCategoryLocator.size() ; i++)
		{
			productName[i] = categoryNamesInThePage.get(i).getText().trim();
		}
		return productName;
	}

	public ProductPageObjects clickOnSpecificCategoryInTheLeftPanel(String specificCategory) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[contains(@class,'leftMenu')]/descendant::dt[contains(text(),'Category')]/following-sibling::dd/descendant::a[text()='"+specificCategory+"']")));
		return this;	
	}

	public ProductPageObjects verifyCategoryDescription(String categoryDescription) {
		Assert.assertTrue(false, "category description is not getting updated in ecommerce.");
		return this;
	}

	public ProductPageObjects verifyNamesOfAllCategories(String[] nameOfTheItems) {
		for(int i = 0 ; i < categoryNamesInThePage.size() ; i++)
		{
		Assert.assertEquals(categoryNamesInThePage.get(i).getText().trim(),nameOfTheItems[i]);
		}
		return this;
	}
	
}
