package org.etna.customer.pageobjects.approvalcartlist;
import java.util.List;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ApprovalCartListPageObjects extends PageFactoryInitializer{
	
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();

	@Step("click on the latest submit for approval link by the user id {0}")
	public ApprovedCartPageObjects clickOnLatestGeneralUserAccountLinkWhileSubmmitedCartForApproval(String generalUserEmailID) {
		List <WebElement> generalUserEmailIDs = driver.findElements(By.xpath("//a[contains(text(),'"+generalUserEmailID+"')]"));
		generalUserEmailIDs.get(0).click();
		return approvedCartPage();
	}

	public String getSpecificNameOfTheApprovalCartToBeClicked(String generalUserEmailID, int specificApprovalCart) {
		List <WebElement> generalUserEmailIDs = driver.findElements(By.xpath("//a[contains(text(),'"+generalUserEmailID+"')]"));
		return generalUserEmailIDs.get(specificApprovalCart-1).getText().replace("\n", "").trim();
	}

	public ApprovalCartListPageObjects verifyDeletionOfApprovalCart(String cartToBeRejected) {
		Assert.assertTrue(assertRejectCart(cartToBeRejected),"Cart is not rejected.");
		return this;
	}

	private boolean assertRejectCart(String cartToBeRejected) {
		try
		{
		if(driver.findElement(By.xpath("//a[text()='"+cartToBeRejected+"']")).isDisplayed())
				
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
}