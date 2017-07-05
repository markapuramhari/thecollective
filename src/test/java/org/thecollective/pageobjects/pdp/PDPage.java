package org.thecollective.pageobjects.pdp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.Waiting;

import ru.yandex.qatools.allure.annotations.Step;

public class PDPage extends PageFactoryInitializer{
	@FindBy(id="btnAddToBag")
	private WebElement addToBagButton;
	
	@FindBy(xpath="//a[@title='My Bag']")
	private WebElement myBagIcon;
	
	@FindBy(xpath="//h2[contains(@class,'product_title')]")
	private WebElement  productName;
	
	@FindAll(value={@FindBy(xpath="//a[@id='online-size-list']")})
	private List<WebElement> sizeOptions;
	
	@FindBy(xpath="//h1[@itemprop='price']")
	private WebElement itemPrice;
	
	
	@Step("click on add to bag button")
	public PDPage addToBageFromDetailsPage() throws InterruptedException {
		Thread.sleep(2500);
		Waiting.explicitWaitElementToBeClickable(addToBagButton, 30);
		addToBagButton.click();
		Thread.sleep(2500);
		return this;
	}
	@Step("click on my bag icon")
	public PDPage clickOnMyBag() throws InterruptedException {
		Thread.sleep(3000);
		myBagIcon.click();
		return this;
		}
	@Step("get the product name {0} from the pdp")
	public String getTheProductName() {
		Waiting.explicitWaitVisibilityOfElement(productName, 30);
		String brandName = productName.getText();
		
		return brandName;
	}
	@Step("select size from listd options")
	public PDPage selectSize() throws InterruptedException {
		//Waiting.explicitWaitVisibilityOfElements(sizeOptions, 30);
		Thread.sleep(2500);
		driver.findElement(By.xpath("//div[contains(@class,'online-size-collective')]/button")).click();
		sizeOptions.get(2).click();

		return this;
	}
	public String getProductPrice() {
		String itemPriceInPDP=itemPrice.getText().trim();
		return itemPriceInPDP;
	}

}
