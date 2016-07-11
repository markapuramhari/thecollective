package org.etna.modules;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class CompareModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_001")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies the alert text when no items are selected and the compare link is clicked.")
	  public void alert_Text_When_No_Item_Is_Selected() throws Exception
	  {
		  		
		  		homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnCompareLink()
		  		.verifyAlertMessage(data.getSelectForThanOneItemToCompareText());
				
	}		
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_002")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies the alert text when one item is selected and the compare link is clicked.")
	  public void alert_Text_When_One_Item_Is_Selected() throws Exception
	  {
		  		
		  		homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificMoreChoices(1)
		  		.clickOnCompareCheckboxesUnderMoreChoices(1)
		  		.clickOnCompareLink()
		  		.verifyAlertMessage(data.getSelectForThanOneItemToCompareText());
				
	}
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_003,TC_COMPARE_012")
	@Test(groups={"CompareModule","smoke","regression"})
	@Description("This is a test case which verifies the compare link text when two items are chosen.")
	  public void verifyCompareLinkText() throws Exception
	  {  		
				 homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificMoreChoices(1)
		  		.clickOnCompareCheckboxesUnderMoreChoices(2)
		  		.verifyCompareText(2);
		  		
	}	
	
	

	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_004,TC_COMPARE_015")
	@Test( groups={"CompareModule","regression"})
	@Description("This is a test case which verifies the compare page when two items are selected.")
	  public void compare_Two_Items() throws Exception
	  {  		
				String partNumbers [] = homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificMoreChoices(1)
		  		.clickOnCompareCheckboxesUnderMoreChoices(2)
		  		.getItemIds(2);
		  		productListPage()
		  		.clickOnCompareLink()
		  		.comparePage()
		  		.verifyPartNumbers(partNumbers);
	}	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_005")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies the alert text when more than five items are selected.")
	  public void alertMessageWhenMoreThanFiveItemsAreSelectedForCompare() throws Exception 
	  {  		
		homePage()
  		.searchText(data.getCategoryWithPagination())
  		.clickOnSearch()
  		.productListPage()
  		.clickOnSpecificMoreChoices(1)
  		.clickOnCompareCheckboxesUnderMoreChoices(2)
		.clickOnSpecificMoreChoices(2)
  		.clickOnCompareCheckboxesUnderMoreChoices(2)
		.clickOnSpecificMoreChoices(3)
  		.clickOnCompareCheckboxesUnderMoreChoices(2)
  		.verifyAlertMessage(data.getAlertTextForMoreThanFiveItems());
	}	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_006")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies that on clicking highlight similar,all the attributes that are similar should show up in green.")
	  public void highlightSimilarButtonVerification() throws Exception
	  {  		
		compare_Two_Items();
		comparePage()
		.clickOnHighLightSimilar()
		.verifyColourOfHighlightSimilarButton(data.getColourOfHighlightSimilarButtonAfterClicking())
		.verifyHighlightSimilarFunctionality();
		
	}	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_007")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies that on clicking highlight different,all the attributes that are different should show up in red.")
	  public void highlightDifferentButtonVerification() throws Exception
	  {  		
		compare_Two_Items();
		comparePage()
		.clickOnHighlightDifferent()
		.verifyColourOfHighlightDifferentButton(data.getColourOfHighlightSimilarButtonAfterClicking())
		.verifyHighLightDifferentFunctionality();
		
	}	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_008")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies that on clicking highlight off,all the attributes that were highlighted should show revert back.")
	  public void highlightOffButtonVerification() throws Exception
	  {  		
		compare_Two_Items();
		String colourOfHighlightDifferentAttributes  = comparePage()
		.clickOnHighlightDifferent()
		.verifyColourOfHighlightDifferentButton(data.getColourOfHighlightSimilarButtonAfterClicking())
		.getColourOfHighlightDifferentAttributes();
		comparePage()
		.clickOnHighlightOffButton()
		.verifyHighlightOff(colourOfHighlightDifferentAttributes);
	}	
	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_010,TC_COMPARE_011")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies that add to cart button is disabled for call for price items.")
	  public void addToCartButtonCallForPriceDisable() throws Exception
	  {  		
		compare_Two_Items();	
		comparePage()
		.verifyAddToCartbuttonIsDisabled();
	}	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_013")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies close/clear icon with compare link in Products list Page")
	  public void verifyCompareLinkText_clear() throws Exception
	  {  		
		 homePage()
	  		.searchText(data.getSearchText())
	  		.clickOnSearch()
	  		.productListPage()
	  		.clickOnSpecificMoreChoices(1)
	  		.clickOnCompareCheckboxesUnderMoreChoices(2)
	  		.verifyCompareText(2)
	  		.clickOnClearCompareButton()
	  		.verifyAlertMessage(data.getItemsRemovedFromComparedList())
	  		.verifyClearFunctionality(0);
		  		
	}	
	
	

	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_023")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies compare page.")
	  public void verifyComparePage_ProductMode() throws Exception
	  {  		
		 homePage()
	  		.searchText(data.getSearchText())
	  		.clickOnSearch()
	  		.productListPage()
	  		.clickOnSpecificMoreChoices(1)
	  		.clickOnCompareCheckboxesUnderMoreChoices(2)
	  		.clickOnCompareLink()
	  		.comparePage()
	  		.verifyCompareHeaderAndBreampCrumpAndTitle(data.getComparePageName(),setUp.getProductName())
	  		.verifyDisplayOfCompareTable();
		  		
	}	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_014")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies comparision of products that are from different category.")
	  public void comparisionOfProductsWhichAreFromDifferentCategory() throws Exception
	  {  		
			String partNumbers1 = 	homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificMoreChoices(1)
		  		.clickOnCompareCheckboxesUnderMoreChoices(1)
		  		.getItemId(1);
		 
		
		String partNumbers2 = homePage()
  		.searchText(data.getSearchTextForProductListPage())
  		.clickOnSearch()
  		.productListPage()
  		.clickOnSpecificMoreChoices(1)
  		.clickOnCompareCheckboxesUnderMoreChoices(1)
  		.getItemId(1);
		productListPage()
  		.clickOnCompareLink()
  		.comparePage()
  		.verifyPartNumbers(partNumbers1,partNumbers2);	
	}	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_009")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies adding an item to cart from compare page.")
	  public void addingAnItemToCartFromComparePage() throws Exception
	  {  		
		LoginModuleTest login = new LoginModuleTest();
		login.loginAsASuperUser();
		homePage()
  		.searchText(data.getSearchText())
  		.clickOnSearch()
  		.productListPage()
  		.clickOnAddToCompareCheckboxWhichIsInSKUMode(1)
  		.clickOnSpecificMoreChoices(1)
  		.clickOnCompareCheckboxesUnderMoreChoices(1)
  		.verifyCompareText(2)
  		.clickOnCompareLink()
  		.comparePage()
  		.clickOnSpecificAddToCartButton(1)
  		.myCartPage()
  		.clickOnCheckoutInMyCartPopup()
  		.verifyMyCartBreadcrump(data.getMyCartBreadcrump())
  		.verifyMyCartPagename(data.getMyCartBreadcrump())
  		.verifyDisplayOfCartSection();
	}	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_022")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies the compare count text after deselecting the checkboxes.")
	  public void verifyingOfCountAfterDeselectingTheCheckboxes() throws Exception
	  {  		
		homePage()
  		.searchText(data.getSearchText())
  		.clickOnSearch()
  		.productListPage()
  		.clickOnSpecificMoreChoices(1)
  		.clickOnCompareCheckboxesUnderMoreChoices(2)
  		.verifyCompareText(2)
  		.clickOnCompareCheckboxesUnderMoreChoices(1)
  		.verifyCompareText(1);
	}
	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_021")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies the alert text when we are trying to remove an item when there are only two items while comparing.")
	  public void verify_AlertText_Remove_WhenTwoItemsArePresent() throws Exception
	  {  		
		compare_Two_Items();
		comparePage()
		.clickOnSpecficRemoveCheckbox(1)
		.clickOnRemoveLink()
		.productListPage()
		.verifyAlertMessage(data.getAlertTextWhenRemoveLinkIsClickedWhenThereIsOnlyTwoItemsLeft());
	}	
	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_020")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies the deleted of an item from compare page.")
	  public void deletionOfAnItemFromComparePage() throws Exception
	  {  		
		 	homePage()
	  		.searchText(data.getCategoryWithPagination())
	  		.clickOnSearch()
	  		.productListPage()
	  		.clickOnSpecificMoreChoicesAndTheCompareCheckboxesWhereMoreChoicesIsGreaterThan3(3)
	  		.clickOnCompareLink()
	  		.comparePage()
	  		.clickOnSpecficRemoveCheckbox(1)
	  		.clickOnRemoveLink()
	  		.comparePage()
	  		.verifyNumberOfRemoveCheckboxes(2);
	}	
	
	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_016")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies the display of compare page when one product is selected in list view and the other is selected in grid view.")
	  public void verifyCompareItems_OneItemInListView_OneItemInGridView() throws Exception
	  {  		
		
		String partNumbers1 = 	homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificMoreChoices(1)
		  		.clickOnCompareCheckboxesUnderMoreChoices(1)
		  		.getItemId(1);
		
		
		String partNumbers2 = productListPage()
				.clickOnChangeView()
				.clickOnSpecificMoreChoicesInGridView(3)
		  		.clickOnCompareCheckboxesUnderMoreChoices(1)
		  		.productListPage()
		  		.getItemId(1);
		
	  		productDetailsPage()
	  		.clickOnCompareLink()
	  		.comparePage()
	  		.verifyPartNumbers(partNumbers1,partNumbers2);	
	}	
	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_017")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies the comparision of two products which have the same brand.")
	  public void verifyCompare_SameBrand() throws Exception
	  {  		
		
		String partNumbers [] = homePage()
		  		.searchText(data.getSearchBrandForCompare())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificMoreChoices(1)
		  		.clickOnCompareCheckboxesUnderMoreChoices(2)
		  		.getItemIds(2);
		  		productListPage()
		  		.clickOnCompareLink()
		  		.comparePage()
		  		.verifyProductNames(data.getSearchBrandForCompare())
		  		.verifyPartNumbers(partNumbers);
	}	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_018")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies comparision of products from the same brand which are in different pages items display.")
	  public void verifyCompare_Brands_DifferentPages() throws Exception
	  {  		
		
		String partNumbers1 = 	homePage()
		  		.searchText(data.getCategoryWithPagination())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificMoreChoices(1)
		  		.clickOnCompareCheckboxesUnderMoreChoices(1)
		  		.getItemId(1);
		
		
		String partNumbers2 = productListPage()
				.clickOnSpecificPage(2)
				.clickOnSpecificMoreChoices(1)
		  		.clickOnCompareCheckboxesUnderMoreChoices(1)
		  		.getItemId(1);
		
		productListPage()
		.verifyCompareText(2)
  		.clickOnCompareLink()
  		.comparePage()
  		.verifyPartNumbers(partNumbers1,partNumbers2);	
		
		
	}	
	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_019")
	@Test(groups={"CompareModule","regression"})
	@Description("This is a test case which verifies that on clicking an image in the compare page, opens the details of the particular product.")
	  public void verifyCompare_ClickingOnImage_NavigateToDetailsPage() throws Exception
	  {  		
		
		String productNameWhoseImageIsClicked = homePage()
		  		.searchText(data.getSearchBrandForCompare())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificMoreChoices(1)
		  		.clickOnCompareCheckboxesUnderMoreChoices(2)
		  		.clickOnCompareLink()
		  		.comparePage()
		  		.getProductName(1);	
				comparePage()
				.clickOnSpecficImage(1)
				.verifyProductName(productNameWhoseImageIsClicked);
	}	
	
	@Features("Compare Module")
	@TestCaseId("TC_COMPARE_023")
	@Test(groups={"CompareModule","smoke","regression"})
	@Description("This is a test case which verifies compare page having products in SKU mode.")
	  public void verifyComparePage_SKUMode() throws Exception
	  {  		
		homePage()
  		.searchText(data.getSearchBrand())
  		.clickOnSearch()
  		.productListPage()
  		.clickOnAddToCompareCheckboxWhichIsInSKUModeCallForPrice(1)
  		.clickOnAddToCompareCheckboxWhichIsInSKUModeCallForPrice(2)
  		.clickOnCompareLink()
  		.comparePage()
  		.verifyCompareHeaderAndBreampCrumpAndTitle(data.getComparePageName(),setUp.getProductName())
  		.verifyDisplayOfCompareTable();		
	}	
}
