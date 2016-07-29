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
public class SharePageObjects extends PageFactoryInitializer{
   Actions action = new Actions(driver);

SearchDataPropertyFile data = new SearchDataPropertyFile();
ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();

@FindBy(id="toNames")
private WebElement friendNameLocator;

@FindBy(id="toEmails")
private WebElement friendEmailAddressLocator;

@FindBy(id="fromNames")
private WebElement fromNameLocator;

@FindBy(id="fromEmails")
private WebElement fromEmailAddressLocator;

@FindBy(id="mailSubjects")
private WebElement subjectLocator;

@FindBy(id="sendBtn")
private WebElement sendButtonLocator;


@FindBy(id="errorMsg")
private WebElement errorMsgLocator;



public SharePageObjects enterFriendName(String friendName) {
	friendNameLocator.sendKeys(friendName);
	return this;
}

public SharePageObjects enterFriendEmailAddress(String friendEmailAddress) {
	friendEmailAddressLocator.sendKeys(friendEmailAddress);
	return this;
}

public SharePageObjects enterFromName(String fromName) {
	fromNameLocator.sendKeys(fromName);
	return this;
}

public SharePageObjects enterFromEmailAddress(String fromEmailAddress) {
	fromEmailAddressLocator.sendKeys(fromEmailAddress);
	return this;
}

public SharePageObjects enterSubject(String subject) {
	subjectLocator.sendKeys(subject);
	return this;
}

public SharePageObjects clickOnSend() {
	sendButtonLocator.click();
	return this;
}

public SharePageObjects verifyErrorMessage(String errorMsg) {

Assert.assertEquals(errorMsgLocator.getText().replace("\n", "").trim(),errorMsg);
return this;
}

		
}

