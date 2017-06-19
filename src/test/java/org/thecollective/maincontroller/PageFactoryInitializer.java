package org.thecollective.maincontroller;
import org.openqa.selenium.support.PageFactory;
import org.thecollective.pageobjects.checkout.CheckoutPaymentPageObjects;
import org.thecollective.pageobjects.checkout.CheckoutShippingPageObjects;
import org.thecollective.pageobjects.checkout.CheckoutSummaryPageObjects;
import org.thecollective.pageobjects.homepage.HomePageObjects;
import org.thecollective.pageobjects.homepage.StoresPageObjects;
import org.thecollective.pageobjects.listpage.ListPageObjects;
import org.thecollective.pageobjects.login.LoginPageObjects;
import org.thecollective.pageobjects.myaccount.MyAccountPageObjects;
import org.thecollective.pageobjects.pdp.PDPage;

public class PageFactoryInitializer extends MainController{


	public HomePageObjects homePage()
	{
		HomePageObjects homePage = PageFactory.initElements(driver,HomePageObjects.class);
		return homePage;
	}
	
	public LoginPageObjects loginPage(){
		LoginPageObjects login=PageFactory.initElements(driver, LoginPageObjects.class);
		return login;
	}
	public StoresPageObjects storesPage(){
		StoresPageObjects stores=PageFactory.initElements(driver, StoresPageObjects.class);
		return stores;
	}
	public ListPageObjects listPage(){
		ListPageObjects listpaage=PageFactory.initElements(driver, ListPageObjects.class);
		return listpaage;
	}
	public PDPage pdPage(){
		PDPage pdPage=PageFactory.initElements(driver, PDPage.class);
		return pdPage;
	}
	
	
	
	public MyAccountPageObjects myAccountPage(){
		
		MyAccountPageObjects myAccount=PageFactory.initElements(driver, MyAccountPageObjects.class);
		return myAccount;
	}
	
	public CheckoutSummaryPageObjects summaryPage(){
		
		CheckoutSummaryPageObjects summary=PageFactory.initElements(driver, CheckoutSummaryPageObjects.class);
		return summary;
	}
	public CheckoutShippingPageObjects shippingPage(){
		CheckoutShippingPageObjects shipping=PageFactory.initElements(driver, CheckoutShippingPageObjects.class);
		return shipping;
	}
	
	public CheckoutPaymentPageObjects paymentPage(){
		CheckoutPaymentPageObjects payment=PageFactory.initElements(driver, CheckoutPaymentPageObjects.class);
		
		return payment;
	}
}
