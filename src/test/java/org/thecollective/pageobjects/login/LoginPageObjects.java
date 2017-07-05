package org.thecollective.pageobjects.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.Waiting;

import ru.yandex.qatools.allure.annotations.Step;

public class LoginPageObjects extends PageFactoryInitializer{

	@FindBy(xpath="//input[@id='sleCustomerMobNo']")
	private WebElement loginUserNameField;
	
	@FindBy(xpath="//input[@id='sleCustomerPassword']")
	private WebElement loginPasswordField;
	
	@FindBy(xpath="//input[@id='btnCustomerLogin']")
	private WebElement loginButton;
	
	@FindBy(tagName="h2")
	private WebElement loginPageName;
	
	@FindBy(name="remember")
	private WebElement rememberMeCheckBox;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password')]")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[contains(@href,'register')]/span[contains(text(),'Signup')]")
	private WebElement signupLink;
	
	
	
	
	//======================================================
	
	@Step("enter user name ")
	public LoginPageObjects enterUserName(String userName) {
		Waiting.explicitWaitVisibilityOfElement(loginUserNameField, 15);
		loginUserNameField.clear();
		loginUserNameField.sendKeys(userName);
		return this;
	}
	@Step("enter password ")
	public LoginPageObjects enterPassword(String password) {
		loginPasswordField.clear();
		loginPasswordField.sendKeys(password);
		return this;
	}
	@Step("click on login button")
	public LoginPageObjects clickOnLoginButton() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(loginButton, 15);
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();",loginButton);
		loginButton.click();
		
		Thread.sleep(2500);

		return this;
	}
	@Step("verify login page")
	public LoginPageObjects verifyLoginPage(String expLloginPageName) throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(loginPageName, 30);
		Assert.assertEquals(loginPageName.getText().trim(), expLloginPageName.trim());
		Assert.assertTrue(loginUserNameField.isDisplayed(), "Login user name field is not displayed");
		Assert.assertTrue(loginPasswordField.isDisplayed(), "Login password field is not displayed");
		Assert.assertTrue(rememberMeCheckBox.isDisplayed(), "remember me check box is not displayed");
		Assert.assertTrue(loginButton.isDisplayed(), "login Button is not displayed");
		Assert.assertTrue(forgotPasswordLink.isDisplayed(), "forgot Password Link is not displayed");
		Assert.assertTrue(signupLink.isDisplayed(), "signupLink is not displayed");
		
		return this;
	}

}
