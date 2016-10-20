package org.etna.customer.pageobjects.orderdetails;
import java.util.List;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
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
public class OrderDetailsPageObjects extends PageFactoryInitializer {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	Actions action = new Actions(driver);
	@FindBy(xpath="//h2")
	private WebElement pageNameLocator;
	@FindAll(value={@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/li")})
	public List<WebElement> breadCrumbs;
	public OrderDetailsPageObjects verifyPageName(String openOrdersBreadCrumb,String[] orderDetails) {
		Assert.assertTrue(pageNameLocator.getText().trim().equalsIgnoreCase(openOrdersBreadCrumb+" "+orderDetails[0]),"Page name is not "+openOrdersBreadCrumb+" It is "+pageNameLocator.getText().trim());
		return this;
	}
	public OrderDetailsPageObjects verifyOrderDetails(String openOrdersBreadCrumb,String[] orderDetails) {
		String orderNumberBreadCrumbPlusOrderNumber =openOrdersBreadCrumb+" "+orderDetails[0];
		
		String lastBreadCrump = breadCrumbs.get(breadCrumbs.size()-1).getText().trim();
		Assert.assertEquals(lastBreadCrump.replace("/", "").trim(), orderNumberBreadCrumbPlusOrderNumber,"item name and the last breadcrump is not the same. Item name is : "+orderNumberBreadCrumbPlusOrderNumber +" and the last breadcrump is : "+ lastBreadCrump);
		return this;
	}
}
