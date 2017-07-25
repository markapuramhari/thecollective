package org.thecollective.pageobjects.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.thecollective.maincontroller.PageFactoryInitializer;

import ru.yandex.qatools.allure.annotations.Step;

public class CardDetailsPageObjects extends PageFactoryInitializer{

	@FindBy(id="ccard_number")
	private WebElement cardNumberField;
	
	@FindBy(id="cname_on_card")
	private WebElement cardNameField;
	
	@FindBy(id="ccvv_number")
	private WebElement cardCVVField;
	
	@FindBy(id="cexpiry_date_month")
	private WebElement cardExpDateField;
	
	@FindBy(id="cexpiry_date_year")
	private WebElement cardexpYearField;
	
	@FindBy(id="pay_button")
	private WebElement paynowButton;
	
	
	
	@Step("enter card details for {0} payment")
	public CardDetailsPageObjects enterCardDetails(String cardNumber) throws InterruptedException {
		String cardOption[]=cardNumber.split(",");
		
		
		enterCardNumber(cardOption[0]);
		enterNameOnTheCard(cardOption[1]);
		enterCVVNumber(cardOption[2]);
		enterExpiryDate(cardOption[3],cardOption[4]);
		clickOnPayNowButton();

		return this;
	}

	public CardDetailsPageObjects clickOnPayNowButton() {
		paynowButton.click();

		return this;
	}

	public CardDetailsPageObjects enterExpiryDate(String expiryDate, String expiryYear) throws InterruptedException {
		new Select(cardExpDateField).selectByValue(expiryDate);
		Thread.sleep(1000);
		new Select(cardexpYearField).selectByVisibleText(expiryYear);
		return this;
	}

	public CardDetailsPageObjects enterCVVNumber(String cVVNum) {
		cardCVVField.clear();
		cardCVVField.sendKeys(cVVNum);

		return this;
	}

	public CardDetailsPageObjects enterNameOnTheCard(String cardName) {
		cardNameField.clear();
		cardCVVField.sendKeys(cardName);

		return this;
	}
	@Step("enter card number {0}")
	private CardDetailsPageObjects enterCardNumber(String cardNumber) {
		cardNumberField.clear();
		cardNumberField.sendKeys(cardNumber);

		return this;
	}
}
