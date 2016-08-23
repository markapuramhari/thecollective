package org.etna.maincontroller;
import org.etna.customer.pageobjects.approvalcartlist.ApprovalCartListPageObjects;
import org.etna.customer.pageobjects.approvalcartlist.ApprovedCartPageObjects;
import org.etna.customer.pageobjects.brands.ShopByBrandsPageObjects;
import org.etna.customer.pageobjects.checkout.CheckoutPageObjects;
import org.etna.customer.pageobjects.compare.ComparePageObjects;
import org.etna.customer.pageobjects.homepage.ContactUsPageObjects;
import org.etna.customer.pageobjects.homepage.HomePageObjects;
import org.etna.customer.pageobjects.loginpopup.ForgotPasswordPageObjects;
import org.etna.customer.pageobjects.loginpopup.LoginPopUpPageObjects;
import org.etna.customer.pageobjects.maunfacturers.ShopByManufacturersPageObjects;
import org.etna.customer.pageobjects.myaccount.EditContactInfoPageObjects;
import org.etna.customer.pageobjects.myaccount.MyAccountsPageObjects;
import org.etna.customer.pageobjects.mycart.MyCartPageObjects;
import org.etna.customer.pageobjects.orderconfirmation.OrderConfirmationPageObjects;
import org.etna.customer.pageobjects.productdetails.ProductsDetailsPageObjects;
import org.etna.customer.pageobjects.productdetails.SharePageObjects;
import org.etna.customer.pageobjects.productgroups.MyProductGroupsPageObjects;
import org.etna.customer.pageobjects.productlist.ProductsListPageObjects;
import org.etna.customer.pageobjects.products.ProductPageObjects;
import org.etna.customer.pageobjects.purchasingagent.AddNewPurchasingAgentPageObjects;
import org.etna.customer.pageobjects.purchasingagent.DisablePurchasingAgentPageObjects;
import org.etna.customer.pageobjects.purchasingagent.ManagePurchasingAgentPageObjects;
import org.etna.customer.pageobjects.quickorder.QuickOrderPageObjects;
import org.etna.customer.pageobjects.requestforquote.RequestForQuotePageObjects;
import org.etna.customer.pageobjects.savecart.SaveCartPageObjects;
import org.etna.customer.pageobjects.signup.SignUpPageObjects;
import org.etna.customer.pageobjects.signup.firsttimeordering.FirstTimeOrderingRegistrationPageObjects;
import org.etna.customer.pageobjects.signup.newcommercialcustomer.CommercialCustomerRegistrationPageObjects;
import org.etna.customer.pageobjects.signup.retailuser.RetailCustomerRegistrationPageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.allure.annotations.Step;

public class PageFactoryInitializer extends MainController{


	public HomePageObjects homePage()
	{
		HomePageObjects homePage = PageFactory.initElements(driver,HomePageObjects.class);
		return homePage;
	}

	public MyAccountsPageObjects myAccountsPage()
	{
		MyAccountsPageObjects myAccountsPage = PageFactory.initElements(driver,MyAccountsPageObjects.class);
		return myAccountsPage;
	}

	public ProductsDetailsPageObjects productDetailsPage()
	{
		ProductsDetailsPageObjects productDetailsPage = PageFactory.initElements(driver,ProductsDetailsPageObjects.class);
		return productDetailsPage;
	}

	public ProductsListPageObjects productListPage()
	{
		ProductsListPageObjects productListPage = PageFactory.initElements(driver,ProductsListPageObjects.class);
		return productListPage;
	}



	public MyCartPageObjects myCartPage()
	{
		MyCartPageObjects shoppingCartPage = PageFactory.initElements(driver,MyCartPageObjects.class);
		return shoppingCartPage;
	}


	public ForgotPasswordPageObjects forgotPasswordPage()
	{
		ForgotPasswordPageObjects forgotPasswordPage = PageFactory.initElements(driver,ForgotPasswordPageObjects.class);
		return forgotPasswordPage;
	}



	public LoginPopUpPageObjects loginPopUp()
	{
		LoginPopUpPageObjects loginPopUp = PageFactory.initElements(driver,LoginPopUpPageObjects.class);
		return loginPopUp;
	}



	public ComparePageObjects comparePage()
	{
		ComparePageObjects comparePage = PageFactory.initElements(driver,ComparePageObjects.class);
		return comparePage;
	}


	public MyProductGroupsPageObjects myProductGroupsPage(){
		MyProductGroupsPageObjects myProductGroupsPage = PageFactory.initElements(driver,MyProductGroupsPageObjects.class);
		return myProductGroupsPage;
	}

	public ShopByBrandsPageObjects shopByBrandsPage()
	{
		ShopByBrandsPageObjects shopByBrandsPage = PageFactory.initElements(driver,ShopByBrandsPageObjects.class);
		return shopByBrandsPage;
	}
	

	public ShopByManufacturersPageObjects shopByManufacturersPage()
	{
		ShopByManufacturersPageObjects shopByManufacturersPage = PageFactory.initElements(driver,ShopByManufacturersPageObjects.class);
		return shopByManufacturersPage;
	}

	public AddNewPurchasingAgentPageObjects addNewPurchasingAgentPage()
	{
		AddNewPurchasingAgentPageObjects addNewPurchasingAgentPage = PageFactory.initElements(driver,AddNewPurchasingAgentPageObjects.class);
		return addNewPurchasingAgentPage;
	}


	public ProductPageObjects productsPage()
	{
		ProductPageObjects productsPage = PageFactory.initElements(driver,ProductPageObjects.class);
		return productsPage;
	}


	public SaveCartPageObjects saveCartPage()
	{
		SaveCartPageObjects saveCartPage = PageFactory.initElements(driver,SaveCartPageObjects.class);
		return saveCartPage;
	}
	
	public SignUpPageObjects signUpPage()
	{
		SignUpPageObjects signUpPage = PageFactory.initElements(driver,SignUpPageObjects.class);
		return signUpPage;
	}
	
	public RetailCustomerRegistrationPageObjects retailUserRegistrationPage()
	{
		RetailCustomerRegistrationPageObjects retailUserRegistrationPage = PageFactory.initElements(driver,RetailCustomerRegistrationPageObjects.class);
		return retailUserRegistrationPage;
	}
	
	public CommercialCustomerRegistrationPageObjects newCommercialCustomerPage()
	{
		CommercialCustomerRegistrationPageObjects newCommercialCustomerPage = PageFactory.initElements(driver,CommercialCustomerRegistrationPageObjects.class);
		return newCommercialCustomerPage;
	}
	
	public FirstTimeOrderingRegistrationPageObjects firstTimeOrderingPage()
	{
		FirstTimeOrderingRegistrationPageObjects firstTimeOrderingPage = PageFactory.initElements(driver,FirstTimeOrderingRegistrationPageObjects.class);
		return firstTimeOrderingPage;
	}
	
	public EditContactInfoPageObjects editContactInfoPage()
	{
		EditContactInfoPageObjects editContactInfoPage = PageFactory.initElements(driver,EditContactInfoPageObjects.class);
		return editContactInfoPage;
	}
	
	public QuickOrderPageObjects quickOrderPadPage()
	{
		QuickOrderPageObjects quickOrderPadPage = PageFactory.initElements(driver,QuickOrderPageObjects.class);
		return quickOrderPadPage;
	}
	
	public ManagePurchasingAgentPageObjects managePurchasingAgentPage()
	{
		ManagePurchasingAgentPageObjects managePurchasingAgentPage = PageFactory.initElements(driver,ManagePurchasingAgentPageObjects.class);
		return managePurchasingAgentPage;
	}
	
	public CheckoutPageObjects checkoutPage()
	{
		CheckoutPageObjects checkoutPage = PageFactory.initElements(driver,CheckoutPageObjects.class);
		return checkoutPage;
	}
	
	public OrderConfirmationPageObjects orderConfirmationPage()
	{
		OrderConfirmationPageObjects orderConfirmationPage = PageFactory.initElements(driver,OrderConfirmationPageObjects.class);
		return orderConfirmationPage;
	}
	
	public RequestForQuotePageObjects requestForQuotePage()
	{
		RequestForQuotePageObjects requestForQuotePage = PageFactory.initElements(driver,RequestForQuotePageObjects.class);
		return requestForQuotePage;
	}
	
	public DisablePurchasingAgentPageObjects disablePurchaseAgentPage()
	{
		DisablePurchasingAgentPageObjects disablePurchaseAgentPage = PageFactory.initElements(driver,DisablePurchasingAgentPageObjects.class);
		return disablePurchaseAgentPage;
	}
	

	public ApprovalCartListPageObjects approvalCartListPage()
	{
		ApprovalCartListPageObjects approvalCartListPage = PageFactory.initElements(driver,ApprovalCartListPageObjects.class);
		return approvalCartListPage;
	}
	
	public ApprovedCartPageObjects approvedCartPage()
	{
		ApprovedCartPageObjects approvedCartPage = PageFactory.initElements(driver,ApprovedCartPageObjects.class);
		return approvedCartPage;
	}

	
	public SharePageObjects sharePage()
	{
		SharePageObjects sharePage = PageFactory.initElements(driver,SharePageObjects.class);
		return sharePage;
	}
	
	public ContactUsPageObjects contactUsPage()
	{
		ContactUsPageObjects contactUsPage = PageFactory.initElements(driver,ContactUsPageObjects.class);
		return contactUsPage;
	}


}
