package org.etna.customer.pageobjects.mycart;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

import org.etna.customer.pageobjects.checkout.CheckoutPageObjects;
import org.etna.customer.pageobjects.productdetails.ProductsDetailsPageObjects;
import org.etna.customer.pageobjects.productgroups.MyProductGroupsPageObjects;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


/*
 * @author Hemanth.Sridhar
 */
public class MyCartPageObjects extends PageFactoryInitializer {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	public ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	Actions action = new Actions(driver);

	
	@FindBy(xpath="//div[contains(@class,'popCheckout')]/a[@href='/Cart']")
	private WebElement checkoutButtonInMyCartPopUp;
	
	@FindBy(xpath="//h2")
	private WebElement pageName;
	
	@FindBy(xpath="//li/a[contains(text(),'Checkout')]")
	private WebElement checkoutButtonInMyCartPage;

	@FindBy(xpath="//a[contains(text(),'Empty Cart')]")
	private WebElement emptyCartButton;

	@FindBy(xpath="//li/a[@title='View cart']")
	private WebElement cartButtonInTopNavigationMenu;
	
	@FindBy(xpath="//h4[text()='No items in your shopping cart']")
	private WebElement checkForEmptyCart; 
	
	@FindBy(xpath="//div[@class='cimm_mainContentEnclosure']/descendant::a[contains(text(),'Continue Shopping')]")
	private WebElement continueShoppingButtonInMyCartPage;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_btnGroupEnclosure']/descendant::a")})
	private List<WebElement> buttonsInMyCart;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_instructions']/descendant::li")})
	private List<WebElement> cartInstructions;
	
	@FindBy(xpath="//h6[contains(text(),'Cart Tips')]")
	private WebElement cartInstructionsHeader;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_cartProdDescription']/descendant::a")})
	private List<WebElement> myCartProductName;
	
	@FindBy(xpath="//span[contains(text(),'Save Cart')]")
	private WebElement saveCartButton;
	
	@FindBy(xpath="//dl[@class='dropdown saveCart_dropdown']/descendant::input[@type='text']")
	private WebElement saveCartTextbox;

	@FindBy(xpath="//a[contains(@onclick,'refreshShoppingCart')]")
	private WebElement updateShoppingCartLink;
	
	@FindBy(xpath="//td[@data-th='Ext Price']/strong")
	private WebElement extPrice;
	
	@FindBy(xpath="//span[@class='priceValue']")
	private WebElement currentTotalPriceInShoppingCart;
	
	@FindAll(value={@FindBy(xpath="//input[@class='quantity']")})
	private List<WebElement> quantityInShoppingCartPage;
	

	@FindBy(xpath="//a[@class='button' and contains(text(),'Update Cart')]")
	private WebElement updateCartButton;
	
	@FindAll(value={@FindBy(xpath="//a[@title='Delete']/i")})
	private List<WebElement> deleteItemLink;
	
	@FindAll(value={@FindBy(xpath="//div/a[contains(@onclick,'deleteItem')]")})
	private List<WebElement> deleteItemLinkForTooltip;
	
	@FindBy(xpath="//li/b[contains(text(),'MPN')]/following-sibling::span")
	private WebElement mpnValue;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_cartProdImg']/a")})
	private List<WebElement> productImages; 
	
	@FindBy(xpath="//table")
	public WebElement myProductGroupCartSection;

	@FindBy(id="sendApproval")
	private WebElement submitCartForApprovalButtonLocator;
	

	
	@Step("Click on checkout in my cart pop up")
	public MyCartPageObjects clickOnCheckoutInMyCartPopup() throws Exception {
		Thread.sleep(1500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",checkoutButtonInMyCartPopUp);
		return this;
		
	}

	@Step("Click on checkout in my cart page title contains {0}")
	public MyCartPageObjects verifyMyCartTitle(String myCartBreadcrump) throws Exception {
		Assert.assertEquals(driver.getTitle().trim(), myCartBreadcrump+" | "+setUp.getProductName());
		return this;
	}

	@Step("Click on checkout in my cart breadcrumb contains {0}")
	public MyCartPageObjects verifyMyCartBreadcrump(String myCartBreadcrump) throws Exception {
		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		Assert.assertEquals(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim(),myCartBreadcrump);
		return this;
	}

	@Step("Click on checkout in my cart page name contains {0}")
	public MyCartPageObjects verifyMyCartPagename(String myCartBreadcrump) {
		Assert.assertEquals(pageName.getText().trim(),myCartBreadcrump.toUpperCase());
		return this;
	}

	public boolean assertCheckoutButtonInMyCartPage(){
		try
		{
		if(checkoutButtonInMyCartPage.isDisplayed())
		{
			return false;
		}
		
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
		return false;


	}

	@Step("Verify checkout out button is not displayed in my cart page")
	public MyCartPageObjects verifyCheckoutButtonNotDisplayedInMyCartPage() {
		Assert.assertTrue(assertCheckoutButtonInMyCartPage(), "checkout button is displayed in my cart page for general user.");
		return this;
	}



		public boolean clearCart() throws InterruptedException {
			navigateToShoppingCart();
			try
			{
				if(checkForEmptyCart.isDisplayed())
				{
					clickOnContinueShopping();
				}
			}
			catch(NoSuchElementException e)
			{
				clickOnEmptyCartButton();
				Waiting.explicitWaitForAlert(5);
				TestUtility.alertAccept();
				clickOnContinueShopping();
				return true;
			}
			return true;
		}
		
		@Step("Click on continue shopping")
		public MyCartPageObjects clickOnContinueShopping() {
			Waiting.explicitWaitVisibilityOfElement(continueShoppingButtonInMyCartPage, 5);
			continueShoppingButtonInMyCartPage.click();
			return this;
		}


		@Step("Click on empty cart button")
	public MyCartPageObjects clickOnEmptyCartButton() {
		Waiting.explicitWaitVisibilityOfElement(emptyCartButton, 7);
		emptyCartButton.click();
			return this;
		}
	

		@Step("Click on cart icon")
	public MyCartPageObjects navigateToShoppingCart() throws InterruptedException {
		clickOnCartIcon();
		return this;
	}

	public MyCartPageObjects clickOnCartIcon() throws InterruptedException {
		Thread.sleep(4000);
		cartButtonInTopNavigationMenu.click();
		return this;
	}
	
	@Step("verify buttons available for general user in my cart")
	public MyCartPageObjects verifyButtonsAvailableForGeneralUserInMyCart() throws Exception {
		String expectedButtonsInMyCartForGeneralUser[] = data.getExpectedButtonsInMyCartForGeneralUser().split(",");
		for(int i = 0; i < buttonsInMyCart.size() ; i++)
		{
		Assert.assertTrue(buttonsInMyCart.get(i).getText().trim().equalsIgnoreCase(expectedButtonsInMyCartForGeneralUser[i]),"Button actual is "+buttonsInMyCart.get(i).getText().trim()+"Button expected is : "+expectedButtonsInMyCartForGeneralUser[i] );
		}
		return this;
	}


	@Step("verify buttons that are available in my cart")
	public MyCartPageObjects verifyButtonsAvailableForSuperUserInMyCart() throws Exception {
		String expectedButtonsInMyCartForSuperUser[] = data.getExpectedButtonsInMyCartForSuperUser().split(",");
		for(int i = 0; i < buttonsInMyCart.size() ; i++)
		{
		Assert.assertTrue(buttonsInMyCart.get(i).getText().trim().equalsIgnoreCase(expectedButtonsInMyCartForSuperUser[i]),"Button actual is "+buttonsInMyCart.get(i).getText().trim()+"Button expected is : "+expectedButtonsInMyCartForSuperUser[i] );
		}
		return this;
	}

	@Step("verify cart page instructions")
	public MyCartPageObjects verifyCartPageInstructions() {
		Assert.assertTrue(cartInstructionsHeader.isDisplayed(),"Cart tips heading is not displayed in the instructions.");
		String expectedCartInstructions [] = data.getExpectedCartInstructions().split(":");
		for(int i = 0 ; i<cartInstructions.size() ; i++)
		{
			Assert.assertEquals(cartInstructions.get(i).getText().trim(), expectedCartInstructions[i]);
		}
		
		return this;
	}


	@Step("verify name of the product in my cart page is {0}")
	public MyCartPageObjects verifyNameOfTheProductInMyCartPage(String productName) throws Exception {
		Thread.sleep(1500);
		Assert.assertTrue(myCartProductName.get(0).getText().trim().equalsIgnoreCase(productName),"Product name in my cart page is not similar to what it was in product details page. Product name is : "+myCartProductName.get(0).getText().trim()+". Asserting it with : "+productName+".");
		return this;
	}

	@Step("Click on save cart button")
	public MyCartPageObjects clickOnSaveCart() {
		Waiting.explicitWaitVisibilityOfElement(saveCartButton, 6);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",saveCartButton);
		
		return this;
	}


	@Step("enter {0} as save cart name")
	public MyCartPageObjects enterNameOfSaveCartAndAddTheProductToSaveCart(String saveCartName) {
		Waiting.explicitWaitVisibilityOfElement(saveCartTextbox, 6);
		saveCartTextbox.sendKeys(saveCartName);
		return this;
	}

	@Step("hit enter for save cart creation")
	public MyCartPageObjects hitEnterForSaveCartCreation() {
		saveCartTextbox.sendKeys(Keys.ENTER);
		return this;
		
	}

	@Step("verify save cart creation success message is {0}")
	public MyCartPageObjects verifySaveCartCreationMessage(String saveCartName) {
		String saveCartSuccessMessage = driver.findElement(By.xpath("//div[@id='popSelector']/descendant::a")).getText().trim();
		Assert.assertEquals(saveCartSuccessMessage, "Cart Saved Successfully - "+saveCartName);
		return this;
	}


	@Step("click on confirmation message")
	public MyCartPageObjects clickOnTheConfirmationMessage(String saveCartName) {
		driver.findElement(By.xpath("//div[@id='popSelector']/descendant::a")).click();
		return this;
	}

	@Step("hover over update link")
	public MyCartPageObjects hoverOverUpdateLink() {
	Actions action = new Actions(driver);
	action.moveToElement(updateShoppingCartLink).build().perform();
	return this;
	}


	@Step("verify refresh tooltip")
	public MyCartPageObjects verifyRefreshToolTip() {
		Assert.assertEquals(updateShoppingCartLink.getAttribute("title").trim(),"Update","Update tooltip is not Update. It is "+updateShoppingCartLink.getAttribute("title").trim()+".");
		return this;
	}

	public Number getExtensionPrice() throws ParseException {
		Waiting.explicitWaitVisibilityOfElement(extPrice, 5);
		Number price = NumberFormat.getCurrencyInstance(Locale.US).parse(extPrice.getText().replace("\n", "").replace(" ", "").trim());
		return price;
	}


	public Number getTotalPrice() throws ParseException {
		Waiting.explicitWaitVisibilityOfElement(currentTotalPriceInShoppingCart, 5);
		Number currentTotalPrice = NumberFormat.getCurrencyInstance(Locale.getDefault()).parse(currentTotalPriceInShoppingCart.getText().replace("\n", "").replace(" ", "").trim());
		return currentTotalPrice;
	}


	@Step("enter quantity {0}")
	public MyCartPageObjects enterQuantityInShoppingCart(String quantity) {
		
		Waiting.explicitWaitVisibilityOfElements(quantityInShoppingCartPage, 20);
		quantityInShoppingCartPage.get(0).click();
		quantityInShoppingCartPage.get(0).clear();
		quantityInShoppingCartPage.get(0).sendKeys(quantity);
		return this;
	}

	@Step("click on update link")
	public MyCartPageObjects clickOnUpdateLink() {
		updateShoppingCartLink.click();
		return this;
	}


	@Step("verify quantity textbox contains {0} after update")
	public MyCartPageObjects verifyUpdateOfQuantityInShoppingCart(String quantity) throws Exception {
		Thread.sleep(5000);
		Waiting.explicitWaitVisibilityOfElements(quantityInShoppingCartPage, 20);
		Assert.assertEquals(quantityInShoppingCartPage.get(0).getAttribute("value"), quantity,"Quantity in shopping cart page is not getting updated. The updated quantity is "+quantityInShoppingCartPage.get(0).getAttribute("value"));
		return this;
	}


	@Step("verify update of extension price")
	public MyCartPageObjects verifyExtPrice(String quantity, Number currentExtnPrice) throws ParseException {
		Number afterUpdateExtensionPrice = NumberFormat.getCurrencyInstance(Locale.US).parse(extPrice.getText().replace("\n", "").replace(" ", "").trim());
		int quantityValue = Integer.parseInt(quantity);
		Assert.assertTrue(checkForExtnPrice(currentExtnPrice,afterUpdateExtensionPrice,quantityValue),"extension price is not getting updated.");
		return this;
	}
	
	private boolean checkForExtnPrice(Number previousPrice,Number afterPrice,int quantityValue)
	{
		DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
		String previous = oneDigit.format(previousPrice.doubleValue()*quantityValue);
		//System.out.println(previous);
		String after = oneDigit.format(afterPrice.doubleValue());
		//System.out.println(after);
		if(previous.equals(after))
		{	
			return true;
		}
		return false;
	}

	@Step("verify update of total price")
	public MyCartPageObjects verifyTotalPrice(String quantity, Number currentTotalPrice) throws ParseException {
		Number afterUpdateTotalPrice = NumberFormat.getCurrencyInstance(Locale.US).parse(currentTotalPriceInShoppingCart.getText().replace("\n", "").replace(" ", "").trim());
		int quantityValue = Integer.parseInt(quantity);
		Assert.assertTrue(checkForExtnPrice(currentTotalPrice,afterUpdateTotalPrice,quantityValue),"total price is not getting updated");
		return this;
	}

	@Step("verify empty of cart")
	public MyCartPageObjects verifyEmptyCart() throws Exception {
		if(setUp.getBrowser().equalsIgnoreCase("safari"))
		{
		Thread.sleep(2000);
		}
		Assert.assertTrue(continueShoppingButtonInMyCartPage.isDisplayed(),"continue shopping button is not displayed. Hence shopping cart is not emptied.");
		return this;
	}


	public MyCartPageObjects verifySortByDropdownValues() {
		
		return this;
	}


	@Step("check whether it is the same quantity {0}")
	public MyCartPageObjects checkWhetherItIsTheSameQuantity(String quantity) {
		Waiting.explicitWaitVisibilityOfElements(quantityInShoppingCartPage, 8);
		Assert.assertEquals(quantityInShoppingCartPage.get(0).getAttribute("value").trim(), quantity);
		return this;
	}

	@Step("click on update button")
	public MyCartPageObjects clickOnUpdateButton() throws InterruptedException {
		Thread.sleep(3000);
		updateCartButton.click();
		return this;
	}


	@Step("hover over delete button")
	public MyCartPageObjects hoverOverDeleteButton() {
		Actions action = new Actions(driver);
		action.moveToElement(deleteItemLink.get(0)).build().perform();
		
		return this;
	}

	@Step("verify delete tool tip")
	public MyCartPageObjects verifyDeleteToolTip() {
		Assert.assertEquals(deleteItemLinkForTooltip.get(0).getAttribute("title").trim(), "Delete");
		return this;
	}

	@Step("click on delete link")
	public MyCartPageObjects clickOnDeleteLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",deleteItemLink.get(0));
		return this;
	}

	@Step("verify MPN is {0}")
	public MyCartPageObjects verifyMPN(String mpn) {
		Assert.assertEquals(mpnValue.getText().trim(),mpn);
		return this;
	}

	@Step("verify delete alert text is {0}")
	public MyCartPageObjects verifyDeleteAlertText(String mpn) {
		Assert.assertTrue(assertDeleteAlertText(mpn),"Alert text while deleting an item is not wrong.");
		return this;
	}


	
	private boolean assertDeleteAlertText(String mpn) {
		System.out.println(TestUtility.getAlertText().trim());
		boolean t = TestUtility.getAlertText().trim().equals("You want to delete item "+mpn+" from cart?");
		TestUtility.alertAccept();
		return t;
	}

	public String getProductNameInShoppingCart() {
	
		return myCartProductName.get(0).getText().trim();
	}


	@Step("click on image of the product")
	public ProductsDetailsPageObjects clickOnImageIfTheProduct() {
		productImages.get(0).click();
		return new ProductsDetailsPageObjects();
	}


	@Step("click on product name")
	public ProductsDetailsPageObjects clickOnProductName() {
		myCartProductName.get(0).click();
		return new ProductsDetailsPageObjects();
	}

	@Step("enter quantities in shopping cart as {0}")
	public MyCartPageObjects enterQuantitiesInShoppingCartForMultipleItems(String quantityForShoppingCartPageVerification) {
		
		for(int i=0; i<quantityInShoppingCartPage.size();i++)
		{
			quantityInShoppingCartPage.get(i).click();
			quantityInShoppingCartPage.get(i).clear();
			quantityInShoppingCartPage.get(i).sendKeys(quantityForShoppingCartPageVerification);
		}
		return this;
	}

	@Step("verify update quantities in shopping cart as {0}")
	public MyCartPageObjects verifyQuantitiesInShoppingCartForMultipleItems(String quantityForShoppingCartPageVerification) throws InterruptedException {
		Thread.sleep(3500);
		Waiting.explicitWaitVisibilityOfElements(quantityInShoppingCartPage, 20);
		for(int i = 0 ; i<quantityInShoppingCartPage.size() ; i++)
		{
			Assert.assertEquals(quantityInShoppingCartPage.get(i).getAttribute("value"), quantityForShoppingCartPageVerification,"Quantity in shopping cart page is not getting updated. The updated quantity is "+quantityInShoppingCartPage.get(i).getAttribute("value"));
		}
		
		return this;
		
	}

	@Step("verify display of cart section")
	public MyCartPageObjects verifyDisplayOfCartSection() {
		Assert.assertTrue(myProductGroupCartSection.isDisplayed()," cart section is not displayed.");		
		return this;
	}

	@Step("verify whether number of items in shopping cart is {0}")
	public MyCartPageObjects verifyNumberOfItemsInShoppingCart(int expectedNumberOfProducts) {
		Assert.assertEquals(productImages.size(),expectedNumberOfProducts,"Number of products in the cart is "+myCartProductName.size()+" but expecting "+expectedNumberOfProducts+".");
		return this;
		
	}

	@Step("click on checkout in my cart page")
	public CheckoutPageObjects clickOnCheckoutInMyCartPage() {
		Waiting.explicitWaitVisibilityOfElement(checkoutButtonInMyCartPage, 10);
		checkoutButtonInMyCartPage.click();
		return checkoutPage();
		
	}

	@Step("click on submit cart for approval")
	public MyCartPageObjects clickOnSubmitCartForApproval() {
		submitCartForApprovalButtonLocator.click();
		return this;
	}
	
	
}