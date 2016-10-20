package org.etna.customer.pageobjects.orderhistory;
import java.util.ArrayList;
import java.util.List;
import org.etna.customer.pageobjects.myaccount.MyAccountsPageObjects;
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


public class OrderHistoryPageObjects extends PageFactoryInitializer{
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@FindBy(xpath="//h2[text()='Completed Orders']")
	private WebElement orderHistoryPageName;
	
	@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/descendant::li[contains(text(),'Completed Orders')]")
	private WebElement orderBreadcrump;
	
	@FindBy(xpath="//input[@id='startDate']")
	private WebElement startDate;
	
	@FindBy(xpath="//input[@id='endDate']")
	private WebElement endDate;
	
	@FindBy(xpath="//div[@id='orderCategory_chosen']/a")
	private WebElement selectCategoryDropdown;
	
	@FindBy(xpath="//input[@id='orderHistorySearchBox']")
	private WebElement searchBoxForOrderNo;
	
	@FindBy(xpath="//div[@id='orderHistoryShipTable _length']/label/select")
	private WebElement itemPerPage;
	
	@FindBy(xpath="//div[@id='orderHistoryShipTable _wrapper']")
	private WebElement completedOrderTable;
	
	@FindBy(xpath="//a[@id='orderHistoryShipTable _previous']")
	private WebElement paginationPrev;
	
	@FindBy(xpath="//a[@id='orderHistoryShipTable _next']")
	private WebElement paginationNext;
	
	@FindAll(value={@FindBy(xpath="//table[@id='orderHistoryShipTable ']/thead/tr/th")})
	private List<WebElement> completedOrderTableHeaderLocator;
	
	@FindBy(xpath="//div[@id='orderCategory_chosen']/descendant::li[contains(text(),'PO #')]")
	private WebElement selectByPOLocator;
	
	@FindBy(xpath="//div[@id='orderCategory_chosen']/descendant::li[contains(text(),'Order #')]")
	private WebElement selectByOrderLocator;
	
	@FindBy(xpath="//a[@id='searchBtn']")
	private WebElement searchIconLocator;
	
	@FindBy(xpath="//table[@id='orderHistoryShipTable ']/tbody/tr/td[@data-th='Description']")
	private WebElement noLocator;
	
	@FindBy(xpath="//table[@id='orderHistoryShipTable ']/tbody/tr/td")
	private WebElement noDataAvailableLocator;
	
	public OrderHistoryPageObjects verifyOrderHistoryPage() {
		Assert.assertTrue(orderHistoryPageName.isDisplayed(),"Completed Order page name is not displayed.");
		Assert.assertTrue(orderBreadcrump.isDisplayed(),"Completed Order breadcrump name is not displayed.");
		Assert.assertTrue(startDate.isDisplayed(),"Start Date is not displayed.");
		Assert.assertTrue(endDate.isDisplayed(),"End Date is not displayed.");
		Waiting.explicitWaitVisibilityOfElement(selectCategoryDropdown, 10);
		Assert.assertTrue(selectCategoryDropdown.isDisplayed(),"Select Category Dropdown is not displayed.");
		Assert.assertTrue(searchBoxForOrderNo.isDisplayed(),"Search Box is not displayed.");
		Assert.assertTrue(itemPerPage.isDisplayed(),"Item Per Page is not displayed.");
		Assert.assertTrue(completedOrderTable.isDisplayed(),"Completed Order Table is not displayed.");
		Assert.assertTrue(paginationPrev.isDisplayed(),"Pagination Prev is not displayed.");
		Assert.assertTrue(paginationNext.isDisplayed(),"Pagination Next is not displayed.");
		return this;
	}
	public OrderHistoryPageObjects verifyCompletedOrderTable(String[] completedOrderTableHeaders) {
		Assert.assertTrue(completedOrderTable.isDisplayed(),"Completed Order Table is not displayed.");
		Waiting.explicitWaitVisibilityOfElements(completedOrderTableHeaderLocator, 4);
		for(int i = 0 ; i< completedOrderTableHeaderLocator.size()-1;i++)
		{
			Assert.assertEquals(completedOrderTableHeaderLocator.get(i).getText().trim(), completedOrderTableHeaders[i],"Table header is wrong");
		}
		return this;
	}
	public OrderHistoryPageObjects clickOnSelectDropdown() {
		Waiting.explicitWaitVisibilityOfElement(selectCategoryDropdown, 10);
		selectCategoryDropdown.click();
		return this;
	}
	public OrderHistoryPageObjects selectPoNoInDropdown() {
		Waiting.explicitWaitVisibilityOfElement(selectByPOLocator, 10);
		selectByPOLocator.click();
		return this;
	}
	public OrderHistoryPageObjects selectOrderNoInDropdown() {
		Waiting.explicitWaitVisibilityOfElement(selectByOrderLocator, 10);
		selectByOrderLocator.click();
		return this;
	}
	public OrderHistoryPageObjects clickOnSearchIcon() {
		Waiting.explicitWaitVisibilityOfElement(searchIconLocator, 10);
		searchIconLocator.click();
		return this;
	}
	public boolean assertAlertText(String expectedAlertText) throws Exception
	{
		boolean t = TestUtility.getAlertText().trim().equals(expectedAlertText.trim());
		TestUtility.alertAccept();
		return t;
	}
	public OrderHistoryPageObjects verifyAlertText(String alertText) throws Exception {
		Assert.assertTrue(assertAlertText(alertText),"Alert text is invalid");
		return this;
	}
	public OrderHistoryPageObjects enterTextInSearchBox(String text) {
		Waiting.explicitWaitVisibilityOfElement(searchBoxForOrderNo, 10);
		searchBoxForOrderNo.sendKeys(text);
		return this;
	}
	public OrderHistoryPageObjects verifyDisplayOfPOnoOrOrderNo(String text) {
		int i = noLocator.getText().trim().lastIndexOf(" ");
		String[] a =  {noLocator.getText().trim().substring(0, i), noLocator.getText().trim().substring(i+1)};
		Assert.assertEquals(a[1], text,"PO# or Order# is different");
		return this;
	}
	public void verifyNoDataText(String textForInvalidPoNo) {
		Assert.assertEquals(noDataAvailableLocator.getText().trim(), textForInvalidPoNo) ;
	}
}