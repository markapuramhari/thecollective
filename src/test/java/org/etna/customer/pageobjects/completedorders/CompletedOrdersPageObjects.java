package org.etna.customer.pageobjects.completedorders;
import java.util.List;

import org.etna.customer.pageobjects.orderconfirmation.OrderConfirmationPageObjects;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class CompletedOrdersPageObjects extends PageFactoryInitializer{
		
		Actions action = new Actions(driver);
		
		
		@FindBy(xpath="//h2[text()='Completed Orders']")
		private WebElement completedOrdersPageName;
		
		public CompletedOrdersPageObjects verifyCompletedOrdersPagename() {
			Assert.assertTrue(completedOrdersPageName.isDisplayed(),"Completed Order Page Name is not displayed.");
			return this;
		}

}
