package org.etna.customer.pageobjects.loginpopup;
import org.etna.customer.pageobjects.signup.SignUpPageObjects;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class LoginPopUpPageObjects extends PageFactoryInitializer {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();

	@FindBy(id="pLoginErr")
	private WebElement errorMsgLocator;
	
	@FindBy(xpath="//h2")
	public WebElement pageName;
	
	@FindBy(id="rememberMe")
	private WebElement rememberMeCheckbox;
	
	@FindBy(xpath="//input[@id='popLoginBtn']")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@id='popUserName']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='popPassword']")
	private WebElement password;
	
	@FindBy(xpath="//a[contains(.,'Forgot your Password?')]")
	private WebElement forgotYourPassword;
	
	@FindBy(xpath="//h3[contains(.,'Login')]/a[contains(.,'Sign Up')]")
	private WebElement signUp;
	
	@FindBy(xpath="//div[contains(@id,'loginPop')]/descendant::a[@class='closeBtn']")
	private WebElement closeButton;
	
	@FindBy(xpath="//h3[contains(.,'Login')]")
	private WebElement loginPageName;
	
	@FindBy(xpath="//label[contains(.,'Remember me')]")
	private WebElement rememberMeText;

	@Step("click on remember me checkbox")
	public LoginPopUpPageObjects clickOnRememberMe(){
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",rememberMeCheckbox);
		return this;
	}
	
	@Step("click on sign up link")
	public SignUpPageObjects clickOnSignUp(){
		Waiting.explicitWaitVisibilityOfElement(signUp, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",signUp);
		return new SignUpPageObjects();
	}
	
	
	@Step("click on close button")
	public LoginPopUpPageObjects clickCloseButton(){
		Waiting.explicitWaitVisibilityOfElement(closeButton, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",closeButton);
		return this;
	}
	
	@Step("click on forgot your password link")
	public ForgotPasswordPageObjects clickOnForgotYourPassword(){
		Waiting.explicitWaitVisibilityOfElement(forgotYourPassword, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",forgotYourPassword);
		return forgotPasswordPage();
	}
	
	@Step("click on login button")
	public LoginPopUpPageObjects clickOnLoginButton(){
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",loginButton);
		return this;
	}

	@Step("enter super user username")
	public LoginPopUpPageObjects enterUserName() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(userName, 10);
		userName.click();
		userName.clear();
		userName.sendKeys(data.getUserName());
		return this;
	}
	
	@Step("enter super user password")
	public LoginPopUpPageObjects enterPassword() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(password, 10);
		password.click();
		password.clear();
		password.sendKeys(data.getPassword());
		return this;
	}
	
	@Step("enter user name {0}")
	public LoginPopUpPageObjects enterUsernameRegression(String userName) {
		Waiting.explicitWaitVisibilityOfElement(this.userName, 20);
		this.userName.click();
		this.userName.clear();
		this.userName.sendKeys(userName);
		return this;
		
	}
	
	@Step("enter password {0}")
	public LoginPopUpPageObjects enterPasswordRegression(String password) {
		Waiting.explicitWaitVisibilityOfElement(this.password, 20);
		this.password.click();
		this.password.clear();
		this.password.sendKeys(password);
		return this;
		
	}

	@Step("enter login pop up")
	public LoginPopUpPageObjects verifyLoginPopUp() {
		Waiting.explicitWaitVisibilityOfElement(loginPageName, 20);
		Assert.assertTrue(loginPageName.isDisplayed(), "Login page name is not displayed");
		//Assert.assertTrue(rememberMeCheckbox.isDisplayed(),"Remember me checkbox is not displayed");
		Assert.assertTrue(loginButton.isDisplayed(),"login button is not displayed");
		Assert.assertTrue(password.isDisplayed(),"password textbox is not displayed");
		Assert.assertTrue(forgotYourPassword.isDisplayed(),"forgot your password link is not displayed");
		Assert.assertTrue(signUp.isDisplayed(),"Sign up link is not displayed");
		Assert.assertTrue(closeButton.isDisplayed(),"close button is not displayed");
		return this;
	}

	@Step("verify auto fill of user name and password")
	public LoginPopUpPageObjects verifyAutofillOfUserNameAndPassword() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(userName, 10);
		Assert.assertEquals(userName.getAttribute("value"), data.getUserName());
		Assert.assertEquals(password.getAttribute("value"), data.getPassword());
		return this;
}

	@Step("verify whether username and password textboxes are empty")
	public LoginPopUpPageObjects verifyEmptyUserNameAndPasswordTextbox() {
			
			Waiting.explicitWaitVisibilityOfElement(userName, 20);
			Assert.assertEquals(userName.getAttribute("value"), "");
			Assert.assertEquals(password.getAttribute("value"), "");
			return this;
		}

	@Step("click on remember me link")
	public LoginPopUpPageObjects clickOnRememberText() {
		rememberMeText.click();
		return this;
	}
	
	@Step("verify whether remember me checkbox is selected")
	public LoginPopUpPageObjects verifyRememberMeCheckBoxSelected() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return $('#rememberMe').attr('checked');"),"checked","remember me checkbox is not checked");
		return this;
	}

	@Step("click on remember me checkbox")
	public LoginPopUpPageObjects clickOnRemeberMe() throws InterruptedException {
		Thread.sleep(1500);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",rememberMeCheckbox);
		return this;
	}
	
	@Step("verify whether remember me checkbox is not selected.")
	public LoginPopUpPageObjects verifyRememberMeCheckboxNotSelected() throws InterruptedException {
		Thread.sleep(1500);
		Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return $('#rememberMe').attr('checked')",rememberMeCheckbox),null,"remember me checkbox is selected");
		return this;
	}


	public LoginPopUpPageObjects verifyDefaultTabFocus(String userNameId) {
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"), userNameId);
		return this;
	}

	public LoginPopUpPageObjects verifyTabFocusTopToBottom(String userNameId,String passwordId,String forgotYourPasswordId,String rememberMeClassName, String loginButtonId) {
		
		
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),userNameId);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),passwordId);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Assert.assertTrue(driver.switchTo().activeElement().getText().trim().contains(rememberMeClassName),"Remember Me class name is not "+rememberMeClassName+" .It is "+driver.switchTo().activeElement().getText().trim());
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Assert.assertEquals(driver.switchTo().activeElement().getText().trim(),forgotYourPasswordId);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),loginButtonId);
		return this;
	}
	
	
	public LoginPopUpPageObjects verifyTabFocusBottomToTop(String userNameHTMLId, String passwordHTMLId,
			String forgotYourPasswordHTMLText, String rememberMeHTMLClassName, String loginButtonHTMLId) {
		
		String tabBehind = Keys.chord(Keys.SHIFT,Keys.TAB);
		
		verifyTabFocusTopToBottom(userNameHTMLId,passwordHTMLId,forgotYourPasswordHTMLText,rememberMeHTMLClassName,loginButtonHTMLId);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),loginButtonHTMLId);
		driver.switchTo().activeElement().sendKeys(tabBehind);
		Assert.assertEquals(driver.switchTo().activeElement().getText().trim(),forgotYourPasswordHTMLText);
		driver.switchTo().activeElement().sendKeys(tabBehind);
		Assert.assertTrue(driver.switchTo().activeElement().getText().trim().contains(rememberMeHTMLClassName),"Remember Me class name is not "+rememberMeHTMLClassName+" .It is "+driver.switchTo().activeElement().getAttribute("class"));
		driver.switchTo().activeElement().sendKeys(tabBehind);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),passwordHTMLId);
		driver.switchTo().activeElement().sendKeys(tabBehind);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),userNameHTMLId);
		return this;
	}
}
