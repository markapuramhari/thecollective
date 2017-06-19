package org.thecollective.pageobjects.login;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.Waiting;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import ru.yandex.qatools.allure.annotations.Step;

public class LoginPageObjects extends PageFactoryInitializer{

	@FindBy(xpath="//input[@id='sleCustomerMobNo']")
	private WebElement loginUserNameField;
	
	@FindBy(xpath="//input[@id='sleCustomerPassword']")
	private WebElement loginPasswordField;
	
	@FindBy(xpath="//input[@id='btnCustomerLogin']")
	private WebElement loginButton;
	
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

}
