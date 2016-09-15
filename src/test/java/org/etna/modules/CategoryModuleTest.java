package org.etna.modules;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.SkipException;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class CategoryModuleTest extends PageFactoryInitializer{


	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@Features("Category Module")
	@Test( groups={"CategoryModule","regression"})
	@Description("Verify the functionality of Products link,Verify the functionality of breadsrumbs in category page,Verify the title of products page")
	@TestCaseId("TC_Product_List_Grid_Page_001,TC_categories_001,TC_categories_009,TC_categories_011")
	  public void productPageVerification() throws Exception
	  {
		  		
		  		String productsPageBreadCrump = data.getProductsPageBreadCrump();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.verifyBreadcrump(productsPageBreadCrump)
				.verifyPageTitle(productsPageBreadCrump)
				.verifyNamesOfAllTheCategoriesInListAndInPage();
				
	}
	
	@Features("Category Module")
	@Test( groups={"CategoryModule","regression"})
	@Description("Verification of level 1 category link.")
	@TestCaseId("TC_categories_003")
	  public void verifyLevel1CategoryPage() throws Exception
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
		@TestCaseId("TC_categories_003,TC_categories_005,TC_categories_006")
		public void navigateProductListPage() throws Exception
		{
		  		data.setSpecificCategory("Plumbing");
		  		String getSpecificCategory1 = data.getSpecificCategory();
		  		data.setSpecificCategory("Fasteners & Hardwa...");
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
		@Test(enabled=false, groups={"CategoryModule","regression"})
		@Description("Verification of last level category link for Product Details Page.")
		@TestCaseId("TC_categories_006")
		public void navigateProductDetailsPage() throws Exception
		{
		  		data.setSpecificCategory("Plumbing");
		  		String getSpecificCategory1 = data.getSpecificCategory();
		  		data.setSpecificCategory("Clothing - Workwea...");
		  		String getSpecificCategory2 = data.getSpecificCategory();
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
		@Test(enabled=false,groups={"CategoryModule","regression"})
		@Description("Verify whether category banners and descriptions are present or not")
		@TestCaseId("TC_categories_007")
		public void verifyBanners() throws Exception
			{
		  		data.setSpecificCategory("Plumbing");
		  		data.setCategoryDescription("Category Description test");
		  		String getSpecificCategory = data.getSpecificCategory();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.clickOnSpecificCategoryImage(getSpecificCategory)
				.verifyBannerImages()
				.verifyCategoryDescription(data.getCategoryDescription());
			}
		
			@Features("Category Module")
			@Test( groups={"CategoryModule","regression"})
			@Description("Verify whether category banners and descriptions are present or not after clicking on the image of the category")
			@TestCaseId("TC_categories_008")
			public void clickingOnImages() throws Exception
				{
			  		data.setSpecificCategory("Plumbing");
			  		data.setCategoryDescription("Category Description test");
			  		String getSpecificCategory = data.getSpecificCategory();
					homePage()
					.clickOnProductsLink()
					.productsPage()
					.clickOnSpecificCategoryImage(getSpecificCategory);
					String lastBreadcrump = productsPage().getLastBreadCrump();
					String lastButOneBreadcrump = productsPage().getLastButOneBreadCrump();
					productsPage().verifyPageTitle(lastButOneBreadcrump,lastBreadcrump);
					productsPage().verifyCategoryDescription(data.getCategoryDescription());
				}
			
			
			@Features("Category Module")
			@Test( groups={"regression"})
			@Description("Verify the functionality of 'PRODUCTS' link while mouse hover")
			@TestCaseId("TC_categories_001")
			public void verifyProductsLinkOfL1CategoryOnMouseHover() throws Exception
				{
			  		String productNames[] = homePage().clickOnProductsLink().productsPage().getProductNames();
			  		homePage().hoverProductsLink().verifyFirstLevelCategories(productNames);
			  		
				}
			
			
			@Features("Category Module")
			@Test( groups={"regression"})
			@Description("Verify the functionality of level 1 category link given in left panel")
			@TestCaseId("TC_categories_004")
			public void verifyL1CategoryInTheLeftPanel() throws Exception
				{
				data.setSpecificCategory("Plumbing");
				homePage().clickOnProductsLink().clickOnSpecificCategoryInTheLeftPanel(data.getSpecificCategory());
				String lastBreadcrump = productsPage().getLastBreadCrump();
				String lastButOneBreadcrump = productsPage().getLastButOneBreadCrump();
				productsPage().verifyPageTitle(lastButOneBreadcrump,lastBreadcrump);
				}
}
