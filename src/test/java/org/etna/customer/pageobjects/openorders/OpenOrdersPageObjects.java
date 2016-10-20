package org.etna.customer.pageobjects.openorders;
import java.util.ArrayList;
import java.util.List;
import org.etna.customer.pageobjects.myaccount.MyAccountsPageObjects;
import org.etna.customer.pageobjects.orderdetails.OrderDetailsPageObjects;
import org.etna.customer.pageobjects.savecart.SaveCartPageObjects;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;


public class OpenOrdersPageObjects extends PageFactoryInitializer{
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	@FindBy(xpath="//a[contains(@class,'myaccountDropDown')]/following-sibling::ul/descendant::a[contains(text(),'Open Orders')]")
	private WebElement openOrdersLinkLocator;
	@FindBy(xpath="//h2[text()='Open Orders']")
	private WebElement openOrdersPageName;
	@FindBy(xpath="//h2[text()='Re-Order Cart']")
	private WebElement reOrderCartPageName;
	@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/descendant::li[contains(text(),'Open Orders')]")
	private WebElement openOrderBreadcrump;
	@FindBy(xpath="//div[@id='openOrderTable_filter']/label/input")
	private WebElement searchTextBox;
	@FindBy(xpath="//select[@name='openOrderTable_length']")
	private WebElement countPerPageDropdown;
	@FindBy(xpath="//div[@id='openOrderTable_wrapper']")
	private WebElement openOrderTable;
	@FindAll(value={@FindBy(xpath="//table[@id='openOrderTable']/descendant::th")})
	private List<WebElement> openOrderHeadersLocator;
	@FindBy(xpath="//td[@data-th='Order#']/b")
	private WebElement eclipseOrderNumberValueLocator;
	@FindBy(xpath="//td[@data-th='PO#']")
	private WebElement poValueLocator;
	@FindBy(xpath="//td[@data-th='Order Date']")
	private WebElement orderDateValueLocator;
	@FindBy(xpath="//td[@data-th='Amount']")
	private WebElement orderTotalValueLocator;
	@FindBy(xpath="//table[@id='openOrderTable']/tbody/descendant::a")
	private WebElement orderNo;
	@FindBy(xpath="//table[@id='openOrderTable']/tbody/descendant::td[@data-th='PO#']")
	private WebElement POno;
	@FindBy(xpath="//table[@id='openOrderTable']/tbody/descendant::td[@data-th='Order Date']")
	private WebElement orderDate;
	@FindBy(xpath="//select[@name='openOrderTable_length']/option")
	private List<WebElement> itemPerPageOptionsLocator;
	@FindBy(xpath="//table[@id='openOrderTable']/tbody/tr")
	private List<WebElement> verifyItemsPerPage;
	@FindBy(xpath="//table[@id='openOrderTable']/tbody/descendant::td/a")
	private WebElement reorderButtonLocator;
	@FindBy(xpath="//input[@id='reorderBtn']")
	private WebElement reorderButtonInOrderDetailsLocator;
	@FindBy(xpath="//form[@id='reOrderForm']/descendant::tbody/tr/td/label")
	private WebElement selectCheckBoxLocator;
	@FindBy(xpath="//div[@class='cimm_cartCheckout pull-right']/descendant::a")
	private WebElement checkOutLocator;
	@FindBy(xpath="//div[@class='cimm_cartProdDescription']/descendant::strong")
	private WebElement productTitle;
	
	
	public OpenOrdersPageObjects verifyOpenOrdersPageName() {
		Assert.assertTrue(openOrdersPageName.isDisplayed(),"Open Order Page Name is not displayed.");
		return this;
	}
	public OpenOrdersPageObjects verifyOpenOrdersPage() {
		Assert.assertTrue(openOrdersPageName.isDisplayed(),"Open Order page name is not displayed.");
		Assert.assertTrue(openOrderBreadcrump.isDisplayed(),"Open Order breadcrumb is not displayed.");
		Assert.assertTrue(searchTextBox.isDisplayed(),"Search Text Box is not displayed.");
		Assert.assertTrue(countPerPageDropdown.isDisplayed(),"Count Per Page Dropdown is not displayed.");
		Assert.assertTrue(openOrderTable.isDisplayed(),"Open Order Table is not displayed.");
		return this;
	}
	public String getTitle(){
		String title = openOrdersPageName.getText().trim();
		return title;
	}
	public OpenOrdersPageObjects verifyHeaders(String[] headers) {
		Waiting.explicitWaitVisibilityOfElements(openOrderHeadersLocator, 4);
		for(int i = 0 ; i< openOrderHeadersLocator.size()-1;i++)
		{
			Assert.assertEquals(openOrderHeadersLocator.get(i).getText().trim(), headers[i],"Table header is wrong");
		}
		return this;
	}
	public OpenOrdersPageObjects verifyOrderDetails(String[] orderDetails) {
		String expectedEclipseOrderNumber = orderDetails[0];
		String expectedPoValue = orderDetails[1];
		String expectedOrderDate = orderDetails[2];
		String expectedOrderTotal = orderDetails[3];
		Assert.assertEquals(eclipseOrderNumberValueLocator.getText().trim(), expectedEclipseOrderNumber);
		Assert.assertEquals(poValueLocator.getText().trim(), expectedPoValue);
		Assert.assertEquals(orderDateValueLocator.getText().trim(), expectedOrderDate);
		Assert.assertEquals(orderTotalValueLocator.getText().trim(),expectedOrderTotal);
		return this;
	}
	public OrderDetailsPageObjects clickOnOrderNoUnderOpenOrders() throws Exception {
		Thread.sleep(2000);
		Waiting.explicitWaitVisibilityOfElement(eclipseOrderNumberValueLocator, 3);
		eclipseOrderNumberValueLocator.click();
		return orderDetailsPage();
	}
	public OpenOrdersPageObjects sendTextToSearchBox(String text) {
		Waiting.explicitWaitVisibilityOfElement(eclipseOrderNumberValueLocator, 3);
		searchTextBox.sendKeys(text);
		return this;
	}
	public void verifyTextDisplayForOrderNo(String textDisplay) {
		Assert.assertEquals(orderNo.getText().trim(), textDisplay);
	}
	public void verifyTextDisplayForPONo(String textDisplay) {
		Assert.assertEquals(POno.getText().trim(), textDisplay);
	}
	public void verifyTextDisplayForShipDate(String textDisplay) {
		Assert.assertEquals(orderDate.getText().trim(), textDisplay);
	}
	public OpenOrdersPageObjects clickOnCountPerPageDown() throws Exception {
		Thread.sleep(2000);
		Waiting.explicitWaitVisibilityOfElement(countPerPageDropdown, 3);
		countPerPageDropdown.click();
		return this;
	}
	@Step("click On Item Per Page Options in  dropdown")
	public OpenOrdersPageObjects clickOnItemPerPageOption(int option) throws Exception {
		for(int i = 0 ; i < itemPerPageOptionsLocator.size() ; i++)
		{
			if(itemPerPageOptionsLocator.get(i).getText().trim().equals(option))
			{
				itemPerPageOptionsLocator.get(i).click();
				break;
			}
		}
		return this;
	}
	@Step("verify display of items per page")
	public OpenOrdersPageObjects verifyDisplayOfItems(int items) throws Exception {
		for(int i = 0 ; i <=verifyItemsPerPage.size() ; i++)
		{
			if(verifyItemsPerPage.size()<=items)
			{
				Assert.assertTrue(true);
				break;
			}
		}
		return this;
	}
	public OpenOrdersPageObjects clickOnReorder() throws Exception {
		Thread.sleep(2000);
		Waiting.explicitWaitVisibilityOfElement(reorderButtonLocator, 3);
		reorderButtonLocator.click();
		return this;
	}
	public OpenOrdersPageObjects clickOnReorderInOrderDetailsPage() throws Exception {
		Thread.sleep(2000);
		Waiting.explicitWaitVisibilityOfElement(reorderButtonInOrderDetailsLocator, 3);
		reorderButtonInOrderDetailsLocator.click();
		return this;
	}
	public boolean assertAlertText(String expectedAlertText) throws Exception
	{
		boolean t = TestUtility.getAlertText().trim().equals(expectedAlertText.trim());
		TestUtility.alertAccept();
		return t;
	}
	public OpenOrdersPageObjects verifyAlertText(String expectedAlertText) throws Exception {
		Thread.sleep(2000);
		Assert.assertTrue(assertAlertText(expectedAlertText),"Alert text is invalid");
		return this;
	}
	public OpenOrdersPageObjects clickOnSelectItem() {
		Waiting.explicitWaitVisibilityOfElement(selectCheckBoxLocator, 3);
		selectCheckBoxLocator.click();
		return this;
	}
	@Step("verify page name  is {0} ")
	public OpenOrdersPageObjects verifyPageName() {
		Assert.assertTrue(reOrderCartPageName.isDisplayed(),"My Cart page name is not displayed.");
		return this;
	}
	public OpenOrdersPageObjects clickOnCheckout() {
		Waiting.explicitWaitVisibilityOfElement(checkOutLocator, 3);
		checkOutLocator.click();
		return this;
	}
	public String getProductName(){
		String productName = productTitle.getText().trim();
		return productName;
	}
	public OpenOrdersPageObjects verifyOpenOrdersTitle(String title) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle().trim(), title);
		return this;
	}
}
