package org.etna.customer.pageobjects.compare;
import java.util.List;

import org.etna.customer.pageobjects.mycart.MyCartPageObjects;
import org.etna.customer.pageobjects.productdetails.ProductsDetailsPageObjects;
import org.etna.customer.pageobjects.productlist.ProductsListPageObjects;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class ComparePageObjects extends PageFactoryInitializer
{
 
   Actions action = new Actions(driver);

	
	@FindBy(xpath="//table")
	private WebElement compareTable;
	
	@FindBy(xpath="//h2[text()='Compare']")
	private WebElement compareHeader;
	
	@FindBy(xpath="//li[contains(text(),'Compare')]")
	private WebElement compareBreadCrump;

	@FindBy(id="showSimilar")
	private WebElement highLightSimilarButtonLocator;
	
	@FindBy(xpath="//td[@class='similar active']")
	private WebElement similarAttributeLocator;
	
	@FindBy(id="showDifferent")
	private WebElement highLinkDifferentLocator;
	
	@FindBy(css="td[class='different active']")
	private WebElement differentAttributeLocator;
	
	@FindBy(xpath="//a[contains(text(),'Highlight Off')]")
	private WebElement highlightOffButton;
	
	@FindAll(value={@FindBy(xpath="//td/descendant::a[@class='log-addTocart-btn addToCart']")})
	private List<WebElement> addToCartButtonLocator;
	
	@FindBy(xpath="(//b[contains(.,'Details')]/ancestor::td/following-sibling::td/b/descendant::span)[1]")
	private WebElement getFirstProductName;
	
	@FindBy(xpath="(//span[contains(text(),'Call for Price')]/ancestor::tr[contains(.,'Price')]/following-sibling::tr/descendant::a[contains(.,'Add to Cart')])[1]")
	private WebElement callForPriceAddToCartButton;
	
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'siteTableEnclosure')]/descendant::b[contains(text(),'PN') and not(contains(text(),'MPN'))]/ancestor::td/following-sibling::td/descendant::span")})
	private List<WebElement> partNumberValuesLocator;
	
	@FindAll(value={@FindBy(xpath="//a[contains(text(),'Add To Cart') and not(contains(@class,'disable'))]")})
	private List<WebElement> addToCartButtonsLocator;
	
	@FindAll(value={@FindBy(xpath="//label[@class='customCheckBox2']")})
	private List<WebElement> removeCheckboxesLocator;
	
	@FindBy(xpath="//a[@onclick='removeItems();']")
	private WebElement removeItemLocator;
	
	@FindAll(value={@FindBy(xpath="//a[@class='comprProdTitle']/span")})
	private List<WebElement> productNameLocator;
	
	
	@FindAll(value={@FindBy(xpath="//table/descendant::a/img")})
	private List<WebElement> imagesLocator;
	
	@Step("verify display of compare table")
	public ComparePageObjects verifyDisplayOfCompareTable() {
		Assert.assertTrue(compareTable.isDisplayed(),"compare table is not displayed");
		return this;
	}


	@Step("click on highlight similar")
	public ComparePageObjects clickOnHighLightSimilar() {
		
		Waiting.explicitWaitVisibilityOfElement(highLightSimilarButtonLocator, 20);
		highLightSimilarButtonLocator.click();
		return this;
}


	@Step("verify activation of similar properties")
	public ComparePageObjects verifyActivationOfSimilarProperties() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		Assert.assertTrue(similarAttributeLocator.isDisplayed(),"similar attribute is not enabled");
		Assert.assertEquals(similarAttributeLocator.getCssValue("background-color").trim(),"rgba(253, 253, 207, 1)");
		return this;
	}

	
	@Step("click on highlight different")
	public ComparePageObjects clickOnHighlightDifferent() {
		Waiting.explicitWaitVisibilityOfElement(highLinkDifferentLocator, 20);
		highLinkDifferentLocator.click();
		return this;
	}

	@Step("verify activation of different properties")
	public ComparePageObjects verifyActivationOfDifferentProperties() {
		Waiting.explicitWaitVisibilityOfElement(differentAttributeLocator, 10);
		Assert.assertTrue(differentAttributeLocator.isDisplayed(),"different attribute is not enabled");
		Assert.assertEquals(differentAttributeLocator.getCssValue("background-color").trim(),"rgba(250, 232, 226, 1)");
		return this;
	}

	@Step("click on highlight off button")
	public ComparePageObjects clickOnHighlightOffButton() {
		highlightOffButton.click();
		return this;
	}

	@Step("verify color of highlight similar button")
	public ComparePageObjects verifyColourOfHighlightSimilarButton(String colourOfHighlightSimilarButton) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Assert.assertEquals(highLightSimilarButtonLocator.getCssValue("background-color").trim(),colourOfHighlightSimilarButton);
		return this;
	}

	public boolean verifyActivationOfSimilarPropertiesIsPresent() {
		try
		{
		Assert.assertTrue(similarAttributeLocator.isDisplayed(),"similar attribute is still enabled");
		return false;
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
	}

	@Step("verify color of show different button")
	public ComparePageObjects verifyColourOfShowDifferentButton() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Assert.assertEquals(highLinkDifferentLocator.getCssValue("background-color").trim(),"rgba(207, 139, 45, 1)");
		return this;
	}

	public boolean verifyActivationOfDifferentPropertiesIsPresent() {
		try
		{
		Assert.assertTrue(differentAttributeLocator.isDisplayed(),"different attribute is still enabled");
		return false;
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
		
	}



	public String getFirstProductName() {
		String productName = getFirstProductName.getText().trim();
		return productName;
	}

	@Step("verify disable of add to cart button")
	public ComparePageObjects checkDisableOfAddToCartButton() {
		Waiting.explicitWaitVisibilityOfElement(callForPriceAddToCartButton, 20);
		Assert.assertEquals(callForPriceAddToCartButton.getAttribute("class"),"log-addTocart-btn btns-disable");
		return this;
	}

	@Step("verify whether thw products are {0} {1} {2}")
	public ComparePageObjects verifyWhetherAllTheProductsAreDisplayed(String productTitle1,String productTitle2, String productTitle3) {
		String productTitle1Name = "//td[contains(.,'Details')]/following-sibling::td/descendant::span[contains(.,'"+productTitle1+"')]";
		String productTitle2Name = "//td[contains(.,'Details')]/following-sibling::td/descendant::span[contains(.,'"+productTitle2+"')]";
		String productTitle3Name = "//td[contains(.,'Details')]/following-sibling::td/descendant::span[contains(.,'"+productTitle3+"')]";
		Assert.assertTrue(driver.findElement(By.xpath(productTitle1Name)).isDisplayed(),"First product is not getting displayed. Getting productTitle : "+productTitle1);
		Assert.assertTrue(driver.findElement(By.xpath(productTitle2Name)).isDisplayed(),"Second product is not getting displayed. Getting productTitle : "+productTitle2);
		Assert.assertTrue(driver.findElement(By.xpath(productTitle3Name)).isDisplayed(),"Third product is not getting displayed. Getting productTitle : "+productTitle3);
	return this;
	}

	public ComparePageObjects verifyPartNumbers(String[] partNumbers) {
		Waiting.explicitWaitVisibilityOfElements(partNumberValuesLocator, 10);
		for(int i=0; i<partNumberValuesLocator.size() ;i++)
		{
			Assert.assertEquals(partNumberValuesLocator.get(i).getText().trim(), partNumbers[i]);
		}
		return this;
	}

	public ComparePageObjects verifyHighlightSimilarFunctionality() {
		List<WebElement> firstColumn = driver.findElements(By.xpath("//td[@class='similar active'][1]"));
		List<WebElement> secondColumn = driver.findElements(By.xpath("//td[@class='similar active'][2]"));
		
		for(int i = 0 ; i< firstColumn.size() ; i++)
		{
			Assert.assertEquals(firstColumn.get(i).getText().trim(), secondColumn.get(i).getText().trim());
		}
		return this;
	}

	public ComparePageObjects verifyColourOfHighlightDifferentButton(String colourOfHightlightDifferentButton) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Assert.assertEquals(highLinkDifferentLocator.getCssValue("background-color").trim(),colourOfHightlightDifferentButton);
		return this;

	}

	public ComparePageObjects verifyHighLightDifferentFunctionality() {
		List<WebElement> firstColumn = driver.findElements(By.xpath("//td[@class='different active'][1]"));
		List<WebElement> secondColumn = driver.findElements(By.xpath("//td[@class='different active'][2]"));
		
		for(int i = 0 ; i< firstColumn.size() ; i++)
		{
			Assert.assertNotEquals(firstColumn.get(i).getText().trim(), secondColumn.get(i).getText().trim());
		}
		return this;
		
	}

	public String getColourOfHighlightDifferentAttributes() {
		
		return differentAttributeLocator.getCssValue("background-color").trim();
	}

	public boolean assertHighlightOff(String colourOfHighlightDifferentAttributes)
	{
		try
		{
		if(differentAttributeLocator.getCssValue("background-color").trim().equals(colourOfHighlightDifferentAttributes))
			{
			return false;
			}
		else
		{
			return true;
		}
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
	
	}
	public ComparePageObjects verifyHighlightOff(String colourOfHighlightDifferentAttributes) {
		
		Assert.assertTrue(assertHighlightOff(colourOfHighlightDifferentAttributes));
		
		return this;
	}

	public ComparePageObjects verifyAddToCartbuttonIsDisabled() {
		for(int i = 0 ; i<addToCartButtonsLocator.size() ; i++)
		{
			Assert.assertTrue(addToCartButtonsLocator.get(i).getAttribute("class").contains("disable"));
		}
		return this;
	}

	public ComparePageObjects verifyCompareHeaderAndBreampCrumpAndTitle(String comparePageName,String companyName) {
		Assert.assertTrue(compareBreadCrump.isDisplayed(),"compare bread crump is not displayed");
		Assert.assertTrue(compareHeader.isDisplayed(),"compare header is not displayed");
		Assert.assertEquals(driver.getTitle().trim(),comparePageName+" | "+companyName);
		return this;
	}



	public ComparePageObjects verifyPartNumbers(String partNumbers1, String partNumbers2) {
		
		String[] partNumbers = {partNumbers1,partNumbers2};
		Waiting.explicitWaitVisibilityOfElements(partNumberValuesLocator, 10);
		for(int i=0; i<partNumberValuesLocator.size() ;i++)
		{
			Assert.assertEquals(partNumberValuesLocator.get(i).getText().trim(), partNumbers[i]);
		}
		return this;
		
	}



	public ComparePageObjects clickOnSpecificAddToCartButton(int specificAddToCartButton) {
		addToCartButtonLocator.get(specificAddToCartButton-1).click();
		return this;
	}



	public ComparePageObjects clickOnSpecficRemoveCheckbox(int specificRemoveCheckbox) {
		removeCheckboxesLocator.get(specificRemoveCheckbox-1).click();
		return this;
	}



	public ComparePageObjects clickOnRemoveLink() {
	((JavascriptExecutor) driver).executeScript("arguments[0].click();",removeItemLocator);
		return this;
	}



		public ComparePageObjects verifyNumberOfRemoveCheckboxes(int expectedNumberOfCheckboxes) {
		Assert.assertEquals(removeCheckboxesLocator.size(), expectedNumberOfCheckboxes);
		return this;
	}



		public ComparePageObjects verifyProductNames(String searchBrand) {
			for(WebElement productName : productNameLocator)
			{
				Assert.assertTrue(productName.getText().trim().contains(searchBrand), "Product name does not contain the brand name. The name of the product is "+ productName.getText().trim());
			}
		
			return this;
		}



		public String getProductName(int specificProductName) {
			
			return productNameLocator.get(specificProductName-1).getText().trim();
		}



		public ProductsDetailsPageObjects clickOnSpecficImage(int specificImage) {
			imagesLocator.get(specificImage-1).click();
			return productDetailsPage();
		}		
	
}
	
	
