package org.etna.modules;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;

public class CategoryModuleTest extends PageFactoryInitializer{


	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
	
	@Features("Category Module")
	@Test(alwaysRun=true,groups={"CategoryModule","regression"})
	@Description("Verification of breadcrumbs, Verification of Page Title, Verification of Page Name, Verification of categories in filter is displayed "
			+ "in the page ")
	  public void TC_categories_001_TC_categories_006_TC_categories_007_TC_categories_008() throws Exception
	  {
		  		
		  		String productsPageBreadCrump = data.getProductsPageBreadCrump();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.verifyBreadcrump(productsPageBreadCrump)
				.verifyPageTitle(productsPageBreadCrump)
				.verifyNamesOfAllTheCategoriesInListAndInPage();
				//.verifyPagename(productsPageBreadCrump);
				
	}
	
	@Features("Category Module")
	@Test(alwaysRun=true,groups={"CategoryModule","regression"})
	@Description("Verification of level 1 category link.")
	  public void TC_categories_002() throws Exception
	  {
		  		data.setSpecificCategory("Plumbing");
		  		String getSpecificCategory = data.getSpecificCategory();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.clickOnSpecificCategory(getSpecificCategory);
				String lastBreadcrump = productsPage().getLastBreadCrump();
				String lastButOneBreadcrump = productsPage().getLastButOneBreadCrump();
				productsPage().verifyPageTitle(lastButOneBreadcrump,lastBreadcrump);
	}
	
	@Features("Category Module")
		@Test(groups={"CategoryModule","regression"})
		@Description("Verification of last level category link for Product List Page.")
		public void TC_categories_003_navigateProductListPage() throws Exception
		{
		  		data.setSpecificCategory("Safety & Security");
		  		String getSpecificCategory1 = data.getSpecificCategory();
		  		data.setSpecificCategory("Clothing - Rainwea...");
		  		String getSpecificCategory2 = data.getSpecificCategory();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.clickOnSpecificCategory(getSpecificCategory1);
				String lastBreadcrump = productsPage().getLastBreadCrump();
				String lastButOneBreadcrump = productsPage().getLastButOneBreadCrump();
				productsPage().verifyPageTitle(lastButOneBreadcrump,lastBreadcrump)
				.clickOnSpecificCategory(getSpecificCategory2)
				.verifySecondBreadcrump(getSpecificCategory1);
				productListPage()
				.verifyListOfProducts();
		}
		
	@Features("Category Module")
		@Test(alwaysRun=true,groups={"CategoryModule","regression"})
		@Description("Verification of last level category link for Product Details Page.")
		public void TC_categories_003_navigateProductDetailsPage() throws Exception
		{
		  		data.setSpecificCategory("Safety & Security");
		  		String getSpecificCategory1 = data.getSpecificCategory();
		  		data.setSpecificCategory("Clothing - Workwea...");
		  		String getSpecificCategory2 = data.getSpecificCategory();
		  		//data.setSpecificCategory("MiraCool® SP-CVL-L");
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.clickOnSpecificCategory(getSpecificCategory1);
				String lastBreadcrump = productsPage().getLastBreadCrump();
				String lastButOneBreadcrump = productsPage().getLastButOneBreadCrump();
				productsPage()
				.verifyPageTitle(lastButOneBreadcrump,lastBreadcrump)
				.clickOnSpecificCategory(getSpecificCategory2)
				.verifySecondBreadcrump(getSpecificCategory1);
				String lastBreadcrump1 = productsPage().getLastBreadCrump();
				productsPage().verifyPageTitle(lastButOneBreadcrump,lastBreadcrump1)
				.productListPage()
				.clickOnSpecificItem(1)
				.productDetailsPage()
				.verifyBreadCrump()
				.verifyPDPPageTitle();
	  }
		
	@Features("Category Module")
		@Test(alwaysRun=true,groups={"CategoryModule","regression"})
		@Description("Verification of description and banners.")
		public void TC_categories_004_verifyBanners() throws Exception
			{
		  		data.setSpecificCategory("Safety & Security");
		  		String getSpecificCategory = data.getSpecificCategory();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.clickOnSpecificCategoryImage(getSpecificCategory)
				.verifyBannerImages();
			}
		
	@Features("Category Module")
			@Test(alwaysRun=true,groups={"CategoryModule","regression"})
			@Description("Verification of image link of any category")
			public void TC_categories_005_ClickingOnImages() throws Exception
				{
			  		data.setSpecificCategory("Safety & Security");
			  		String getSpecificCategory = data.getSpecificCategory();
					homePage()
					.clickOnProductsLink()
					.productsPage()
					.clickOnSpecificCategoryImage(getSpecificCategory);
					String lastBreadcrump = productsPage().getLastBreadCrump();
					String lastButOneBreadcrump = productsPage().getLastButOneBreadCrump();
					productsPage().verifyPageTitle(lastButOneBreadcrump,lastBreadcrump);
				}
			
}
