package org.etna.customer.pageobjects.productdetails;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.etna.customer.pageobjects.productgroups.MyProductGroupsPageObjects;
import org.etna.customer.pageobjects.productlist.ProductsListPageObjects;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

/*
 * @author Hemanth.Sridhar
 */
public class ProductsDetailsPageObjects extends PageFactoryInitializer{
   Actions action = new Actions(driver);

SearchDataPropertyFile data = new SearchDataPropertyFile();
ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();

	@FindBy(className="cimm_prodDetailTitle")
	private WebElement itemTitleLocator;

	@FindBy(xpath="//input[@class='quantity']")
	public WebElement quantityTextbox;
	
	@FindBy(xpath="//a[contains(@class,'log-addTocart-btn')]")
	private WebElement addToCartButton;
	
	@FindBy(xpath="(//a[contains(text(),'Checkout')])[2]")
	private WebElement checkoutButton;
	
	@FindBy(className="cimm_itemShortDesc")
	private WebElement shortDescriptionLocator;
	
	@FindBy(xpath="//span[contains(text(),'MPN')]/following-sibling::span")
	private WebElement mpnValue;
	
	@FindBy(xpath="//li[@id='mPartNo']/b")
	private WebElement mpnLabel;
	
	@FindBy(xpath="//div[@id='popSelector']/following-sibling::dl/descendant::span[contains(.,'My Product Group')]")
	private WebElement myProductGroupButton;
	
	@FindBy(xpath="//span[contains(text(),'Customer Part Number')]/ancestor::a")
	private WebElement addOrRemoveCustomerPartNumberButton;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='resp-tabs-list domtabs']/descendant::span")})
	private List<WebElement> productDetailsTabs;
	
	@FindBy(xpath="//a[@title='Send this Page']")
	private WebElement sendThisPageLink;
	
	@FindBy(xpath="//a[@title='Print this page']")
	private WebElement printThisPageLink;
	
	@FindBy(xpath="//li[@id='sitePartNo']/b")
	private WebElement partNumberLabel;
	
	@FindBy(xpath="//li[@id='minOrdQty']/b")
	private WebElement minimumOrderQuantityLabel;
	
	@FindBy(xpath="//li[@id='qtyInt']/b")
	private WebElement quantityIntervalLabel;
	
	@FindBy(xpath="//div[@id='ProdRating']")
	private WebElement proRatingLabel;

	@FindBy(xpath="//li[@class='hideForPrint']/b")
	private WebElement quantityLabel;
	
	@FindBy(xpath="//div[@id='yourPrices']/b")
	private WebElement yourPriceLabel;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/li")})
	public List<WebElement> breadCrumps;
	
	@FindBy(xpath="//h4[contains(text(),'Manufacturers')]/following-sibling::span")
	private WebElement filterManufactureresToggleButtonLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Manufacturers')]")
	private WebElement filterManufacturersHeading;
	
	@FindBy(xpath="//b[contains(text(),'Print')]/ancestor::a")
	private WebElement printLink;
	
	@FindBy(xpath="//b[contains(text(),'Share')]/ancestor::a")
	private WebElement shareLink;
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'Accordion')]/descendant::a/span[not(contains(text(),'Video'))]")})
	private List<WebElement> accordiansLocator;
	
	@FindBy(xpath="//span[contains(text(),'My Product Group')]")
	private WebElement addToMyProductGroupButton;
	
	@FindBy(xpath="//li[@id='shipBranchNames']/b")
	private WebElement shipBranchNameLabel;
	
	@FindBy(xpath="//li[@id='upcNo']/b")
	private WebElement upcLabel;
	
	@FindBy(xpath="//li[@id='upcNo']/b/following-sibling::span")
	private WebElement upcValueLocator;
	
	@FindBy(xpath="//a[@class='imgEnlargeIcon']")
	private WebElement enlargeIcon;
	
	@FindBy(xpath="//a[@class='imgEnlargeIcon']/preceding-sibling::a/descendant::div[@class='zoomPad']/img")
	private WebElement productImage;
	
	@FindBy(xpath="//img[@id='fullResImage']")
	private WebElement fullProductImage;
	
	@FindBy(xpath="//div[@id='drpdwnDiv']/descendant::li/input")
	private WebElement myProductGroupTextbox;
	
	@FindBy(xpath="//div[@id='popSelector']/descendant::a")
	private WebElement productGroupCreationMsg;
	
	@FindBy(xpath="//ul/descendant::a[contains(text(),'My Product Groups')]")
	private WebElement myProductGroupsUnderGroups;
	
	@FindBy(xpath="//h4[contains(text(),'Groups')]/following-sibling::span")
	private WebElement groupsToggleButton;
	
	@FindBy(xpath="//span[contains(text(),'Customer Part Number')]")
	private WebElement customerPartNumberButton;
	
	@FindBy(xpath="//input[@id='newCustomerPartNumber']")
	private WebElement customerPartNumberTextbox;
	
	@FindBy(xpath="//ul[@id='CustomerPartNoListDropDown']/descendant::input[@id='add']")
	private WebElement addButton;
	
	
	@FindBy(id="remove")
	private WebElement removeButton;
	
	@FindBy(xpath="//ul[@id='CustomerPartNoListDropDown']/descendant::input[@id='remove']")
	private WebElement cpnRemoveButton;
	
	@FindAll(value={@FindBy(xpath="//dl/descendant::h4")})
	private List <WebElement> leftPanelNames; 
	
	@FindAll(value={@FindBy(xpath="//dl/descendant::h4/following-sibling::span")})
	private List <WebElement> toggleButtons;
	
	@FindBy(xpath="//li[@id='mPartNo']/descendant::span")
	private WebElement mpnValueLocator;
	
	@FindBy(xpath="//li[@id='sitePartNo']/b/following-sibling::span")
	private WebElement partNumberValueLocator;
	
	@FindAll(value={@FindBy(xpath="//td[@title='Compare']/descendant::input")})
	private List<WebElement> compareCheckboxesUnderMoreChoicesLocator;
	
	
	@FindBy(xpath="//a[contains(@onclick,'compareItems')]")
	private WebElement compareLinkLocator;
	
	@FindBy(xpath="//div[contains(text(),'Product Choices')]")
	private WebElement productChoicesLocator;
	
	@FindAll(value={@FindBy(xpath="//td[@class='tabelImage details-control']/img")})
	private List<WebElement> productChoicesImagesLocator;
	
	@FindBy(xpath="//ul[@id='CustomerPartNoListDropDown']/descendant::input[@id='newCustomerPartNumber']")
	private WebElement cpnTextboxLocator;
	
	@FindBy(xpath="//a[@title='Send this Page']")
	private WebElement shareLocator;
	
	@FindAll(value={@FindBy(xpath="//td[contains(@class,'tabelImage')]/descendant::span[not(contains(@id,'quantityBreakPricingDetails')) and not(contains(@class,'imgForSend'))]")})
	private List<WebElement> partNumberUnderProductChoicesLocator;
	
	@Step("verify whether the item name contains {0}")
	public ProductsDetailsPageObjects verifyDisplayOfItemName(String searchText) {
		String searchTextUpperCase =searchText.toUpperCase(); 
		Waiting.explicitWaitVisibilityOfElement(itemTitleLocator, 5);
		Assert.assertTrue(itemTitleLocator.getText().trim().toUpperCase().contains(searchTextUpperCase.replace(" ", "")),"product brand name does not contain the search text. Item name from web : "+itemTitleLocator.getText().trim().toUpperCase()+". "+"Expected is : "+searchTextUpperCase);
		return this;
	}

	public String getProductName(){
	String productName = itemTitleLocator.getText().trim();
		return productName;
	}

	@Step("verify PDP section before login")
	public ProductsDetailsPageObjects verifyPDPFilterSectionNOTLoggedIn() {
		Assert.assertTrue(productListPage().filterSectionLocator.isDisplayed(), "Filter section is not displayed in the PDP page.");
		String a[] = data.getFilterNamesInPDPNOTLogin().split(",");
		for(int i = 0 ; i<leftPanelNames.size(); i++)
		{
			Assert.assertEquals(leftPanelNames.get(i).getText().trim().toLowerCase(), a[i].trim().toLowerCase(),"Getting left Panel name as "+leftPanelNames.get(i).getText().trim()+" but expected "+a[i].trim()+". ");
		}
		
		return this;
	}

	@Step("verify display of short description contains {0}")
	public ProductsDetailsPageObjects verifyDisplayOfShortDescription(String searchText)
	{
		
		Assert.assertTrue(assertDisplayOfShortDescription(searchText), "short description does not contain the search text. Actual : "+shortDescriptionLocator.getText().trim()+".");
		return this;
		
	}
	
	
	public boolean assertDisplayOfShortDescription(String searchText) {
		boolean t = shortDescriptionLocator.getText().trim().toUpperCase().contains(searchText.toUpperCase().replace(" ", ""));
		return t;
	}


	@Step("verify display of part number label")
	public ProductsDetailsPageObjects verifyDisplayOfPartNumber() {
		Assert.assertEquals(partNumberLabel.getText().replace(":","").trim(),"PN");
		return this;
	}


	@Step("verify display of MPN Label")
	public ProductsDetailsPageObjects verifyDisplayOfMPN() {
		Assert.assertEquals(mpnLabel.getText().replace(":","").trim(), "MPN");
		return this;
	}


	@Step("verify display of Minimum Order Quantity Label")
	public ProductsDetailsPageObjects verifyDisplayOfMinimumOrderQuantity() {
		Assert.assertEquals(minimumOrderQuantityLabel.getText().replace(":","").trim(), "Min. Order Qty");
		return this;
	}


	@Step("verify display of quantity interval")
	public ProductsDetailsPageObjects verifyDisplayOfQuantityInterval() {
		Assert.assertEquals(quantityIntervalLabel.getText().replace(":","").trim(), "Qty. Interval");
		return this;
	}


	@Step("verify display of your price label")
	public ProductsDetailsPageObjects verifyDisplayOfYourPrice() {
		Assert.assertEquals(yourPriceLabel.getText().replace(":","").trim(), "Your Price");
		return this;
	}


	@Step("verify display of quantity label")
	public ProductsDetailsPageObjects verifyDisplayOfQuantity() {
		Assert.assertEquals(quantityLabel.getText().replace(":","").trim(), "Qty");
		
		return this;
	}

	@Step("verify display of print link")
	public ProductsDetailsPageObjects verifyDisplayOfPrintLink() {
		Assert.assertTrue(printLink.isDisplayed());
		return this;
	}
	
	@Step("verify tool tip of print link")
	public ProductsDetailsPageObjects verifyToolTipOfPrintLink() {
	TestUtility.verifyToolTip(printLink,"Print this page");
	return this;
	}

	@Step("verify display of share link")
	public ProductsDetailsPageObjects verifyDisplayOfShare() {
		Assert.assertTrue(shareLink.isDisplayed());
		return this;
	}
	
	@Step("verify tool tip of share link")
	public ProductsDetailsPageObjects verifyToolTipOfShareLink() {
		TestUtility.verifyToolTip(shareLink,"Send this Page");
		return this;
		}

	@Step("verify accordians")
	public ProductsDetailsPageObjects verifyDisplayOfAccordians() {
		Assert.assertTrue(assertAccordiansLocator());
		return this;
		
	}


	private boolean assertAccordiansLocator() {
		if(accordiansLocator.size()>=1)
		{
			return true;
		}
		else
		{
			return false;
	}
}

	@Step("verify display of CPN Button")
	public ProductsDetailsPageObjects verifyDisplayOfCustomerPartNumberButton() {
		Assert.assertTrue(addOrRemoveCustomerPartNumberButton.isDisplayed(),"add or remove customer part number is not displayed.");
		return this;
	}


	public ProductsDetailsPageObjects verifyAddToCartButton() {
		
		return this;
	}

	@Step("verify display of Add my product group button")
	public ProductsDetailsPageObjects verifyDisplayOfAddMyProductGroupButton() {
		Assert.assertTrue(addToMyProductGroupButton.isDisplayed(),"add to my product group button is not displayed.");
		return this;
	}

	@Step("verify ship branch name")
	public ProductsDetailsPageObjects verifyDisplayOfShipBranchName() {
		Assert.assertEquals(shipBranchNameLabel.getText().replace(":","").trim(), "Ship Branch Name");
		return this;
	}


	@Step("verify display of UPC")
	public ProductsDetailsPageObjects verifyDisplayOfUPC() {
		Assert.assertEquals(upcLabel.getText().replace(":","").trim(), "UPC");
		return this;
	}

	@Step("click on enlarge icon")
	public ProductsDetailsPageObjects clickOnEnlargeIcon() {
		Waiting.explicitWaitVisibilityOfElement(enlargeIcon, 10);
		enlargeIcon.click();
		return this;
	}


	public int getHeightOfTheImage() {
		Waiting.explicitWaitVisibilityOfElement(productImage, 20);
		Integer height = Integer.parseInt(productImage.getAttribute("height"));
		int intheight = height.intValue();
		return intheight;
	}
	
	public int getWidthOfTheImage() {
		
		Integer width = Integer.parseInt(productImage.getAttribute("width"));
		int intwidth = width.intValue();
		return intwidth;
	}

	@Step("verify image height and width after enlarge is greater than {0} {1}")
	public ProductsDetailsPageObjects verifyImageHeightAndWidthAfterEnlarge(int height,int width) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Assert.assertTrue(assertImageHeight(height),"The enlarged image height is less than the image present in the PDP page.");
		Assert.assertTrue(assertImageWidth(width),"The enlarged image width is less than the image present in the PDP page.");
		return this;
		
	}


	private boolean assertImageWidth(int height) {
		Integer heightFromWeb = Integer.parseInt(fullProductImage.getAttribute("height").replace("px", "").trim());
		int actualHeight = heightFromWeb.intValue();
		if(actualHeight>=height)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	private boolean assertImageHeight(int width) {
		Integer widthFromWeb = Integer.parseInt(fullProductImage.getAttribute("width").replace("px", "").trim());
		int actualWidth = widthFromWeb.intValue();
		if(actualWidth>=width)
		{
			return true;
		}
		else
		{
		return false;
		}
	}


	@Step("verify PDP product title")
	public ProductsDetailsPageObjects verifyPDPPageTitle() throws Exception {
		if(setUp.getBrowser().equalsIgnoreCase("safari"))
		{
		Thread.sleep(3000);
		}
		String PDPTitle = driver.getTitle();
		Waiting.explicitWaitVisibilityOfElement(itemTitleLocator, 10);
		String itemName=itemTitleLocator.getText().trim();
		Assert.assertEquals(PDPTitle, itemName+" | "+setUp.getProductName());
		return this;
	}

	@Step("verify breadcrump")
	public ProductsDetailsPageObjects verifyBreadCrump() {
		String itemName = itemTitleLocator.getText().trim();
		String lastBreadCrump = breadCrumps.get(breadCrumps.size()-1).getText().trim();
		Assert.assertEquals(itemName, lastBreadCrump.replace("/", "").trim(),"item name and the last breadcrump is not the same. Item name is : "+itemName +" and the last breadcrump is : "+ lastBreadCrump);
		return this;
	}

	@Step("click on My Product Group button")
	public ProductsDetailsPageObjects clickOnMyProductGroupButton() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",myProductGroupButton);
		return this;
	}

	@Step("enter group name {0}")
	public ProductsDetailsPageObjects enterGroupName(String myProductGroupName) {
		Waiting.explicitWaitVisibilityOfElement(myProductGroupTextbox, 6);
		myProductGroupTextbox.sendKeys(myProductGroupName);
		return this;
	}

	@Step("hit enter")
	public ProductsDetailsPageObjects hitEnter() {
		myProductGroupTextbox.sendKeys(Keys.ENTER);
		return this;
	}

	@Step("verify My Product Group creation success message is {0}")
	public ProductsDetailsPageObjects verifyMyProductCreationSuccessMsg(String myProductGroupName) {
		Waiting.explicitWaitVisibilityOfElement(productGroupCreationMsg, 10);
		Assert.assertEquals(productGroupCreationMsg.getText().trim(), itemTitleLocator.getText().trim()+" Added To Group - "+myProductGroupName);
		return this;
	}

	@Step("click on My Product Groups")
	public MyProductGroupsPageObjects clickOnMyProductGroups() throws Exception {
		homePage()
		.clickOnUserAccountDropdown()
		.navigateToMyProductGroups();
		return new MyProductGroupsPageObjects();
	}

	@Step("click on add or remove CPN")
	public ProductsDetailsPageObjects clickOnAddOrRemoveCustomerPartNumber() throws Exception{
		Thread.sleep(2000);
		customerPartNumberButton.click();
		return this;
	}

	@Step("enter CPN {0}")
	public ProductsDetailsPageObjects enterCPN(String customerPartNumber) throws Exception {
		Thread.sleep(3000);
		cpnTextboxLocator.sendKeys(customerPartNumber);
	//((JavascriptExecutor) driver).executeScript("document.getElementById('newCustomerPartNumber').value='"+customerPartNumber+"'");
		return this;
	}

	@Step("click on add button")
	public ProductsDetailsPageObjects clickOnAddButton() throws InterruptedException {
		Thread.sleep(1500);
		addButton.click();
//		/((JavascriptExecutor) driver).executeScript("arguments[0].click()",addButton);
		return this;
	}

	@Step("click on {0} st/nd/rd checkbox")
	public ProductsDetailsPageObjects clickOnCheckbox(String customerPartNumber) throws Exception {
		Thread.sleep(1700);
		String customerPartNumberCheckbox = "//input[@value='"+customerPartNumber+"']";
		driver.findElement(By.xpath(customerPartNumberCheckbox)).click();
		return this;
				
	}

	@Step("click on remove button")
	public ProductsDetailsPageObjects clickOnRemove() throws Exception{
		Thread.sleep(1700);
		action.click(removeButton).build().perform();
		Thread.sleep(1700);
		return this;
	}


	public boolean verifyDeletionOfCPN(String customerPartNumber) throws Exception {
		Thread.sleep(1500);
		try
		{
		Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+customerPartNumber+"')]")).isDisplayed());
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
		return false;
	}

	@Step("verify pdp filter section when logged in")
	public ProductsDetailsPageObjects verifyPDPFilterSectionWhenLoggedIn() {
		String a[] = data.getFilterNamesInPDPAfterLogin().split(",");
		for(int i = 0 ; i<leftPanelNames.size(); i++)
		{
			Assert.assertEquals(leftPanelNames.get(i).getText().trim().toLowerCase(), a[i].trim().toLowerCase(),"Getting left Panel name as "+leftPanelNames.get(i).getText().trim()+" but expected "+a[i].trim()+". ");
		}
		return this;
	}
	
	
	@Step("verify pdp filter section toggle buttons")
	public ProductsDetailsPageObjects verifyPDPFilterSectionToggleButtons(){
		Assert.assertEquals(leftPanelNames.size(), toggleButtons.size());
		return this;
	}


	@Step("click on add to cart button")
	public ProductsDetailsPageObjects clickOnAddToCartButton() {
		Waiting.explicitWaitVisibilityOfElement(addToCartButton, 10);
		addToCartButton.click();
		return this;
	}

	@Step("Enter quantity {0}")
	public ProductsDetailsPageObjects enterQuanityInProductDetailsPage(String quantity) {
		quantityTextbox.click();
		quantityTextbox.clear();
		quantityTextbox.sendKeys(quantity);
		return this;
	}

	public String getMPN() {
		return mpnValueLocator.getText().trim();
	}

	@Step("verify product name {0}")
	public ProductsDetailsPageObjects verifyProductName(String productNameFromShoppingCart) {
		Assert.assertTrue(itemTitleLocator.getText().trim().equalsIgnoreCase(productNameFromShoppingCart),"Actual : "+itemTitleLocator.getText().trim()+" , Expected : "+productNameFromShoppingCart+".");
	return this;
	}
	
	@Step("verify part number is {0}")
	public ProductsDetailsPageObjects verifyPartNumberInProductDetailsPage(String searchPartNumber) throws Exception {
	try
	{
	Assert.assertEquals(partNumberValueLocator.getText().trim(), searchPartNumber);
	}
	catch(NoSuchElementException e)
	{
		
			Assert.assertTrue(assertPartNumberUnderProductChoices(searchPartNumber),"Searched Part Number is not displayed in product details page");
	}
	return this;	
	}

	public boolean assertPartNumberUnderProductChoices(String searchPartNumber) throws Exception
	{
		
		if(productChoicesLocator.isDisplayed())
		{
			for(WebElement partNumberUnderProductChoiceLocator : partNumberUnderProductChoicesLocator)
			{
				Waiting.explicitWaitVisibilityOfElement(partNumberUnderProductChoiceLocator, 10);
					if(partNumberUnderProductChoiceLocator.getText().trim().equals(searchPartNumber))
					{
					return true;
					}
			}
		}
		return false;
	}

	@Step("verify mpn is {0}")
	public ProductsDetailsPageObjects verifyManufacturerPartNumberInProductDetailsPage(String searchTextForMPNTest) throws Exception {
		Assert.assertTrue(itemTitleLocator.getText().trim().contains(searchTextForMPNTest),"Name of the product does not contain MPN "+searchTextForMPNTest);
		try
		{
			Assert.assertEquals(mpnValueLocator.getText().trim(), searchTextForMPNTest);
		}
		catch(NoSuchElementException e)
		{
			Assert.assertTrue(assertMPNUnderProductChoices(searchTextForMPNTest),"MPN is not presenet");
		}
		return this;
	}

	private boolean assertMPNUnderProductChoices(String searchTextForMPNTest) throws Exception
	{
		
		if(productChoicesLocator.isDisplayed())
		{
			for(WebElement productChoiceImage : productChoicesImagesLocator)
			{
				
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",productChoiceImage);
				Thread.sleep(2000);
				Waiting.explicitWaitVisibilityOfElement(mpnValueLocator, 10);
					if(mpnValueLocator.getText().trim().equals(searchTextForMPNTest))
					{
					return true;
					}
			}
		}
		return false;
	}
	
	
	
	@Step("verify UPC is {0}")
	public ProductsDetailsPageObjects verifyUPCInProductDetailsPage(String searchTextForUPCLabelTest) throws Exception {
		
		try
		{
			Assert.assertEquals(upcValueLocator.getText().trim(), searchTextForUPCLabelTest);
		}
		catch(NoSuchElementException e)
		{
			Assert.assertTrue(assertUPC(searchTextForUPCLabelTest));
		}
		return this;
	}
	
	public boolean assertUPC(String searchTextForUPCLabelTest) throws Exception
	{
		
		if(productChoicesLocator.isDisplayed())
		{
			for(WebElement productChoiceImage : productChoicesImagesLocator)
			{
				
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",productChoiceImage);
				Thread.sleep(2000);
				Waiting.explicitWaitVisibilityOfElement(upcValueLocator, 10);
					if(upcValueLocator.getText().trim().equals(searchTextForUPCLabelTest))
					{
					return true;
					}
			}
		}
		return false;
	}

	@Step("click on compare checkboxes under more choices")	
	public ProductsDetailsPageObjects clickOnCompareCheckboxesUnderMoreChoices(int numberOfCheckboxesToBeClicked) throws Exception {
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		for(int i = 0 ; i<=numberOfCheckboxesToBeClicked-1 ; i++)
		{
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",compareCheckboxesUnderMoreChoicesLocator.get(i));
		}
		return this;
	}

	@Step("click on compare link")
	public ProductsDetailsPageObjects clickOnCompareLink() {
		compareLinkLocator.click();
		return this;
	}

	public ProductsDetailsPageObjects clickSpecficButton(String buttonToClick) throws Exception {
		Thread.sleep(700);
		switch(buttonToClick)
		{
		case "Add":
			clickOnAddButton();
			break;
		case "Remove":
			clickOnRemove();
			break;
		default : throw new Exception("invalid input");	
	
	}
return this;
}

	public ProductsDetailsPageObjects clickOnRemoveCPNButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",cpnRemoveButton);
		return this;
	}

	public String getPartNumber() {
		return partNumberValueLocator.getText().trim();
	}

	public SharePageObjects clickOnShareLink() {
		Waiting.explicitWaitVisibilityOfElement(By.xpath("//a[@title='Send this Page']"), 5);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",shareLocator);
		return sharePage();
	}	
}

