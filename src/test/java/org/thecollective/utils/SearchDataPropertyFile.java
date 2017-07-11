package org.thecollective.utils;

import org.thecollective.maincontroller.MainController;

public class SearchDataPropertyFile extends MainController{

	private int numberOfCheckboxesToBeClicked;

	private int numberOfItemsPerPage;
	
	private String specificBrandName;
	
	private String specificManufacturerName;
	
	private String specificCategory;
	
	private String userName = PropertyFileReader.propertiesReader(searchData, "userName");
	
	private String password = PropertyFileReader.propertiesReader(searchData, "password");

	private String logo=PropertyFileReader.propertiesReader(searchData, "logo");

	private String expMyAccountText=PropertyFileReader.propertiesReader(searchData, "expMyAccountText");

	private String expMyAccountPageTitle=PropertyFileReader.propertiesReader(searchData, "expMyAccountPageTitle");

	private String expProductName=PropertyFileReader.propertiesReader(searchData, "expProductName");

	private String expFooterHeaders=PropertyFileReader.propertiesReader(searchData, "expFooterHeaders");

	private String expFooterLinks=PropertyFileReader.propertiesReader(searchData, "expFooterLinks");

	private String storeBranches=PropertyFileReader.propertiesReader(searchData, "storeBranches");

	private String megaMenusHeaders=PropertyFileReader.propertiesReader(searchData, "megaMenuHeaders");

	private String expSearchResultsPageTitle=PropertyFileReader.propertiesReader(searchData, "expSearchResultsPageTitle");

	private String emptyCartText=PropertyFileReader.propertiesReader(searchData, "emptyCartText");

	private String updatedQuantity=PropertyFileReader.propertiesReader(searchData, "updatedQuantity");

	private String loginPageName=PropertyFileReader.propertiesReader(searchData, "loginPageName");

	private String getMaxPriceForCod=PropertyFileReader.propertiesReader(searchData, "maxPriceForCod");

	private String getExpPaymentMethod;

	private String thankingMessage=PropertyFileReader.propertiesReader(searchData, "thankingMessage");


	private String expCouponsTabOptions=PropertyFileReader.propertiesReader(searchData, "couponsTabOptions");

	
	
	
	public int getNumberOfCheckboxesToBeClicked() {
		return numberOfCheckboxesToBeClicked;
	}

	public void setNumberOfCheckboxesToBeClicked(int numberOfCheckboxesToBeClicked) {
		this.numberOfCheckboxesToBeClicked = numberOfCheckboxesToBeClicked;
	}

	
	public String getUserName()    {
		
		return userName;
	}

	public String getPassword()     {
		
		return password;
	}

	public String getLogo() {
		
		return logo;
	}

	public String getMyAccountText() {


		return expMyAccountText;
	}

	public String getMyAccountPageTitle() {


		return expMyAccountPageTitle;
	}

	public String getProductName() {
		
		return expProductName;
	}

	public String getExpFooterHeaders() {
		return expFooterHeaders;
	}

	public String getFooterLinks() {

		return expFooterLinks;
	}

	public String getTheCollectiveBranches() {
		
		return storeBranches;
	}

	public String getMegaMenusHeaderLinks() {

		return megaMenusHeaders;
	}

	public String getSearchResultsPageTitle() {
		
		return expSearchResultsPageTitle;
	}

	public String getEmptyCartText() {
		
		return emptyCartText;
	}

	public String getUpdatedQuantity() {
		return updatedQuantity;
	}

	public String getLoginPageNameText() {
		return loginPageName;
	}

	public String getMaxAllowedPriceForCod() {
		
		return getMaxPriceForCod;
	}

	public String getPaymentMethod() {
		
		return getExpPaymentMethod;
	}

	public String setPaymentMethod(String expPaymentMethod) {
		
		return this.getExpPaymentMethod=expPaymentMethod;
	}

	public String getThankingMessage() {
		
		return thankingMessage;
	}


	public String getCouponsTabOptions() {
		
		return expCouponsTabOptions;
	}


}
