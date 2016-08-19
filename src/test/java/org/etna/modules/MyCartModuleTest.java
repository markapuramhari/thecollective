package org.etna.modules;
import org.testng.annotations.Test;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.PropertyFileReader;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.SkipException;

import ru.yandex.qatools.allure.annotations.Features;

public class MyCartModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	@Features("My Cart Module")
	@Test(alwaysRun=true,groups={"MyCartModule","smoke","regression"})
	public void TC_MyCart_001() throws Exception{
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		String searchText = data.getSearchTextForEnlargeImageTest();
		String myCartBreadcrump = data.getMyCartBreadcrump();
		loginModule.loginAsASuperUser();
		myCartPage().clearCart();
		String productName = homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.getProductName();
		productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.verifyMyCartTitle(myCartBreadcrump)
		.verifyMyCartPagename(myCartBreadcrump)
		.verifyMyCartBreadcrump(myCartBreadcrump)
		.verifyCartPageInstructions()
		.verifyNameOfTheProductInMyCartPage(productName)
		.verifyButtonsAvailableForSuperUserInMyCart();
	}
	
	
	  
	  
	@Features("My Cart Module")
	@Test(groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_012_saveCart_ClickOnCofirmationPopup() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		  		String searchText = data.getSearchTextForEnlargeImageTest();
		  		String saveCartName = data.getSaveCartName();
		  		loginModule.loginAsASuperUser();
				myCartPage().clearCart();
				Thread.sleep(1500);
				 homePage()
					.searchText(searchText)
					.clickOnSearch()
					.productDetailsPage()
					.clickOnAddToCartButton()
				.myCartPage()
				.clickOnCheckoutInMyCartPopup()
				.clickOnSaveCart()
				.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
				.hitEnterForSaveCartCreation();
				Thread.sleep(1000);
				myCartPage()
				.verifySaveCartCreationMessage(saveCartName)
				.clickOnTheConfirmationMessage(saveCartName)
				.saveCartPage()
				.verifyPageName(saveCartName)
				.verifyBreadCrumps(saveCartName)
				.verifyTitleAfterClickingOnTheCartCreated()
				.deleteSaveCart();
				TestUtility.alertAccept();
				homePage()
				.clickOnUserAccountDropdown()
				.clickOnMySaveCart()
				.saveCartPage()
				.verifyDeletionOfSaveCart(saveCartName);
	  }
	  
  
	@Features("My Cart Module")
	@Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_014_signedUser_ShoppingCartUpdateToolTip() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		String searchText = data.getSearchTextForEnlargeImageTest();
		  	loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch()
			.productDetailsPage()
			.clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup()
			 .myCartPage()
			 .hoverOverUpdateLink()
			 .verifyRefreshToolTip();
	  }
	  
	@Features("My Cart Module")
	@Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_015_updateLinkFunctionality() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();

				String searchText = data.getSearchTextForEnlargeImageTest();
		  		String quantity = data.getQuantityForShoppingCartPageVerification();
		  		loginModule.loginAsASuperUser();
		  		myCartPage()
				 .clearCart();
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productDetailsPage()
				.clickOnAddToCartButton()
				.myCartPage()
				.clickOnCheckoutInMyCartPopup();
				 Number currentExtnPrice = myCartPage().getExtensionPrice();
				 Number currentTotalPrice = myCartPage().getTotalPrice();
				 myCartPage()
				 .enterQuantityInShoppingCart(quantity)
				 .clickOnUpdateLink()
				 .verifyUpdateOfQuantityInShoppingCart(quantity)
				 .verifyExtPrice(quantity,currentExtnPrice)
				 .verifyTotalPrice(quantity,currentTotalPrice);
	  }
  
	@Features("My Cart Module")
	@Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_016_emptyCartFunctionality() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
				String searchText = data.getSearchTextForEnlargeImageTest();
		  		loginModule.loginAsASuperUser();
				myCartPage()
				.clearCart();
				Thread.sleep(1500);
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productDetailsPage()
				.clickOnAddToCartButton()
				.myCartPage()
				.clickOnCheckoutInMyCartPopup();
				myCartPage()
				.clickOnEmptyCartButton();
				TestUtility.alertAccept();
				myCartPage()
				.verifyEmptyCart();
	  }
	  
	  
	  
	@Features("My Cart Module")
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_018_sortByDropdownListValues() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		String searchText = data.getSearchTextForEnlargeImageTest();
		  loginModule.loginAsASuperUser();
		  myCartPage()
		  .clearCart();
		  Thread.sleep(1500);
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.verifySortByDropdownValues();
	  }
	  
	@Features("My Cart Module")
	  @Test(alwaysRun=true,groups={"MyCartModule","smoke","regression"})
	  public void TC_ShoppingCart_002_TC_ShoppingCart_019_TC_ShoppingCart_020_TC_ShoppingCart_021_signedUserAddingItemToCart() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		String searchText = data.getSearchTextForEnlargeImageTest();
		  String quantity = data.getQuantityForShoppingCartPageVerification();
		  loginModule.loginAsASuperUser();
		  myCartPage()
		 .clearCart();
		  Thread.sleep(1500);
		  homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.enterQuanityInProductDetailsPage(quantity)
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
		 .checkWhetherItIsTheSameQuantity(quantity);
	}
	  
	@Features("My Cart Module")
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TS_ShoppingCart_001_TC_ShoppingCart_001_guestUserAddingItemToCart() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		String searchText = data.getSearchTextForEnlargeImageTest();
		  String quantity = data.getQuantityForShoppingCartPageVerification();
		  	myCartPage()
			.clearCart();
		  Thread.sleep(1500);
		  homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.enterQuanityInProductDetailsPage(quantity)
			.clickOnAddToCartButton()
			.loginPopUp()
			.verifyLoginPopUp();
	  }
	  
	@Features("My Cart Module")
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_003_signedUser_ShoppingCartQuanitityUpdateCartButton() throws Exception
	  {
			loginModule.loginAsASuperUser(); 
			homePage().clickOnUserAccountDropdown().logout();
			String searchText = data.getSearchTextForEnlargeImageTest();
	  		String quantity = data.getQuantityForShoppingCartPageVerification();
	  		loginModule.loginAsASuperUser();
	  		myCartPage()
			 .clearCart();
	  		homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup();
			 Number currentExtnPrice = myCartPage().getExtensionPrice();
			 Number currentTotalPrice = myCartPage().getTotalPrice();
			 myCartPage()
			 .enterQuantityInShoppingCart(quantity)
			 .clickOnUpdateButton()
			 .verifyUpdateOfQuantityInShoppingCart(quantity)
			 .verifyExtPrice(quantity,currentExtnPrice)
			 .verifyTotalPrice(quantity,currentTotalPrice);
	  }
	  
	@Features("My Cart Module")
	  @Test(groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_004_signedUser_ShoppingCartQuanitityUpdateWithZero() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		String searchText = data.getSearchTextForEnlargeImageTest();
		  	 myCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
		  	homePage()
			.searchText(searchText)
			.clickOnSearch()
			 .productDetailsPage()
			 .clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			 .enterQuantityInShoppingCart("0")
			.clickOnUpdateButton()
			.myProductGroupsPage()
			.verifyAlertText("Invalid Number");
	  }
	  
	@Features("My Cart Module")
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_005_signedUser_ShoppingCartDeleteToolTip() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
			String searchText = data.getSearchTextForEnlargeImageTest();
		  	loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
		  	homePage()
			.searchText(searchText)
			.clickOnSearch()
			 .productDetailsPage()
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup()
			 .myCartPage()
			 .hoverOverDeleteButton()
			 .verifyDeleteToolTip();
	  }
	  
	@Features("My Cart Module")
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_006_signedUser_DeleteLinkForDeletingTheItem() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		
		  if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").equalsIgnoreCase("safari"))
		  {
			  throw new SkipException("Unfortunately safari browser does not handle alerts.");
			  
		  }
		  else
		  {
			 String searchText = data.getSearchTextForEnlargeImageTest();
		  	loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	 Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch();
			 String productName = productDetailsPage().getProductName();
			 String PN = productDetailsPage().getPartNumber();
			 String MPN = productDetailsPage().getMPN();
			 productDetailsPage()
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup();
			 myCartPage()
			 .verifyNameOfTheProductInMyCartPage(productName)
			 .verifyMPN(MPN)
			 .clickOnDeleteLink()
			 .verifyDeleteAlertText(PN);
			 myCartPage()
			 .verifyEmptyCart();
	  }
	  }
	  
	@Features("My Cart Module")
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_007_signedUser_CancellingOfDeletingTheItemThroughDeleteLink() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		  if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").equalsIgnoreCase("safari"))
		  {
			  throw new SkipException("Code does not work in IE.Problem with IE driver server in handling alerts.Need to do this manually");
			  
		  }
		  else
		  {
			  String searchText = data.getSearchTextForEnlargeImageTest();
			loginModule.loginAsASuperUser();
		  	 myCartPage()
		  	.clearCart();
		  	Thread.sleep(1500);
		  	homePage()
		  	.searchText(searchText)
			.clickOnSearch();
			 String productName = productDetailsPage().getProductName();
			 String PN = productDetailsPage().getPartNumber();
			 productDetailsPage()
			 .clickOnAddToCartButton()
			 .myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.verifyNameOfTheProductInMyCartPage(productName)
			.clickOnDeleteLink();
			 TestUtility.alertDismiss();
			 myCartPage()
			 .clickOnDeleteLink()
			 .verifyDeleteAlertText(PN)
			 .verifyEmptyCart();
		  }
	  }
	  
	@Features("My Cart Module")
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_008_signedUser_clickOnImageNavigateBackToPDP() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
			String searchText = data.getSearchTextForEnlargeImageTest();
		  	loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch()
			 .productDetailsPage()
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup();
		  	 String productNameFromShoppingCart = myCartPage().getProductNameInShoppingCart();
		  	 myCartPage()
			.clickOnImageIfTheProduct()
			.productDetailsPage()
			.verifyProductName(productNameFromShoppingCart);
	  }
	  
	@Features("My Cart Module")
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_010_signedUser_verifyContinueShoppingButton() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
			String searchText = data.getSearchTextForEnlargeImageTest();
		  	 String productsPageBreadCrump = data.getProductsPageBreadCrump();
		  	loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	 Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch()
			 .productDetailsPage() 
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup()
			 .clickOnContinueShopping()
			 .productsPage()
			 .verifyBreadcrump(productsPageBreadCrump)
			 .verifyPageTitle(productsPageBreadCrump);

	  }
	  
	@Features("My Cart Module")
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_008_signedUser_clickOnProductName() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		String searchText = data.getSearchTextForEnlargeImageTest();
		  loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch()
			 .productDetailsPage()
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup();
		  	 String productNameFromShoppingCart = myCartPage().getProductNameInShoppingCart();
		  	 myCartPage()
			.clickOnProductName()
			.productDetailsPage()
			.verifyProductName(productNameFromShoppingCart);
	  }

	  
}