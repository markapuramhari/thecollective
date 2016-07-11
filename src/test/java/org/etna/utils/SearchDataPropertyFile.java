package org.etna.utils;

import org.etna.maincontroller.MainController;

public class SearchDataPropertyFile extends MainController{

	private int numberOfCheckboxesToBeClicked;

	private int numberOfItemsPerPage;
	
	private String specificBrandName;
	
	private String specificManufacturerName;
	
	private String specificCategory;
	
	private String userName = PropertyFileReader.propertiesReader(searchData, "userName");
	
	private String password = PropertyFileReader.propertiesReader(searchData, "password");
	
	private String searchText = PropertyFileReader.propertiesReader(searchData, "searchText.generalSearch");
	
	private String groupName = PropertyFileReader.propertiesReader(searchData, "groupName");
	
	private String saveCartName = PropertyFileReader.propertiesReader(searchData, "saveCartName");
	
	private String quantityForShoppingCart = PropertyFileReader.propertiesReader(searchData, "quantityForShoppingCart");
	
	private String nameOfShoppingCartButtons = PropertyFileReader.propertiesReader(searchData, "nameOfShoppingCartButtons");
	
	private String footerHeadings = PropertyFileReader.propertiesReader(searchData, "footerHeadings");
	
	private String taxonomies = PropertyFileReader.propertiesReader(searchData, "taxonomies");
	
	private String fileUploadPath = PropertyFileReader.propertiesReader(searchData, "cartFileUploadPath");
	
	private String myAccountTabs = PropertyFileReader.propertiesReader(searchData, "myAccountTabs");
	
	private  String phoneNumber = PropertyFileReader.propertiesReader(searchData, "phoneNumber");
	
	private String mpn = PropertyFileReader.propertiesReader(searchData, "MPN");
	
	private String brandNameForRequestQuote = PropertyFileReader.propertiesReader(searchData, "brandNameRequestQuote");
	
	private String quantityForRequestQuote = PropertyFileReader.propertiesReader(searchData, "quantityRequestQuote");
	
	private String commentForRequestQuote = PropertyFileReader.propertiesReader(searchData, "commentsForRequestQuote");
	
	private String loginPageTitle = PropertyFileReader.propertiesReader(searchData, "loginPageTitle");
	
	private String faviconURL = PropertyFileReader.propertiesReader(searchData, "faviconURL");
	
	private String anotherSearchText =PropertyFileReader.propertiesReader(searchData, "searchText.anotherSearch");
	
	private String expectedAlertMessageForComaringMoreThan3Items =PropertyFileReader.propertiesReader(searchData, "expectedAlertMessageForComaringMoreThan3Items");
	
	private String orderConfirmationText = PropertyFileReader.propertiesReader(searchData, "orderConfirmationText");
	
	private String productDetailsTabs = PropertyFileReader.propertiesReader(searchData, "productDetailsTabs");
	
	private String year = PropertyFileReader.propertiesReader(searchData, "year");
	
	private String month = PropertyFileReader.propertiesReader(searchData, "month");
	
	private String cardNumber = PropertyFileReader.propertiesReader(searchData, "cardNumber");
	
	private String welcomeMessageInAddNewCreditCardPage = PropertyFileReader.propertiesReader(searchData, "welcomeMessageInAddNewCreditCardPage");
	
	private String postalCode = PropertyFileReader.propertiesReader(searchData, "postalCode");
	
	private String streetAddress = PropertyFileReader.propertiesReader(searchData, "streetAddress");
	
	private String shoppingCartInstructions = PropertyFileReader.propertiesReader(searchData, "shoppingCartInstructions");
	
	private String cardHolder = PropertyFileReader.propertiesReader(searchData, "cardHolder");
	
	private String nickName = PropertyFileReader.propertiesReader(searchData, "nickName");
	
	private String sortByShoppingCartDropdownValues = PropertyFileReader.propertiesReader(searchData, "sortByShoppingCartDropdownValues");
	
	private String emptyCartText = PropertyFileReader.propertiesReader(searchData, "emptyCartText");
	
	private String forgotYourPasswordInstructions = PropertyFileReader.propertiesReader(searchData, "forgotYourPasswordInstructions");
	
	private String logo = PropertyFileReader.propertiesReader(searchData, "logo");
	
	private String copyRightsOfUnilog = PropertyFileReader.propertiesReader(searchData, "copyRightsOfUnilogText");

	private String carouselImages = PropertyFileReader.propertiesReader(searchData, "carouselImages");
	
	private String mainSectionOptions = PropertyFileReader.propertiesReader(searchData, "mainSectionOptions");
	
	private String allSectionsText = PropertyFileReader.propertiesReader(searchData, "allSectionsText");
	
	private String footerLinksText = PropertyFileReader.propertiesReader(searchData, "allFooterLinksText");
	
	private String expectedSortByOptions = PropertyFileReader.propertiesReader(searchData, "expectedSortByOptions");
	
	private String expectedResultsPerPageOptions = PropertyFileReader.propertiesReader(searchData, "expectedResultsPerPageOptions");
	
	private String searchTextForUPCLabelTest = PropertyFileReader.propertiesReader(searchData, "searchTextForUPCLabelTest");
	
	private String productGroupName = PropertyFileReader.propertiesReader(searchData, "productGroupName");
	
	private String deleteGroupAlertText = PropertyFileReader.propertiesReader(searchData, "deleteGroupAlertText");
	
	private String myProductGroupsPageName = PropertyFileReader.propertiesReader(searchData, "myProductGroupsPageName");
	
	private String customerPartNumber = PropertyFileReader.propertiesReader(searchData, "customerPartNumber");
	
	private String filterNamesInPDPAfterLogin = PropertyFileReader.propertiesReader(searchData, "filterNamesInPDPAfterLogin");
	
	private String filterNamesInPDPNotLogin = PropertyFileReader.propertiesReader(searchData, "filterNamesInPDPNotLogin");
	
	private String shopByBrandsBreadcrump = PropertyFileReader.propertiesReader(searchData, "shopByBrandsBreadcrump");
	
	private String shopByManufacturersBreadcrump = PropertyFileReader.propertiesReader(searchData, "shopByManufacturersBreadcrump");
	
	private String searchTextForEnlargeImageTest = PropertyFileReader.propertiesReader(searchData, "searchTextForEnlargeImageTest");
	
	private String addNewPurchasingAgentInstructions = PropertyFileReader.propertiesReader(searchData, "addNewPurchasingAgentInstructions");

	private String expectedMandatoryFieldsInAddNewPurchasingAgent = PropertyFileReader.propertiesReader(searchData, "expectedMandatoryFieldsInAddNewPurchasingAgent");
	
	private String emailAddressInstruction = PropertyFileReader.propertiesReader(searchData, "emailAddressInstruction");
	
	private String addNewPurchasingAgentBreadcrump = PropertyFileReader.propertiesReader(searchData, "addNewPurchasingAgentBreadcrump");
	
	private String expectedRoleAssignmentDropdownOptions = PropertyFileReader.propertiesReader(searchData, "expectedRoleAssignmentDropdownOptions");
	
	private String generalUserEmailID = PropertyFileReader.propertiesReader(searchData, "generalUserEmailID");
	
	private String generalUserPassword = PropertyFileReader.propertiesReader(searchData, "generalUserPassword");
	
	private String myCartBreadcrump = PropertyFileReader.propertiesReader(searchData, "myCartBreadcrump");
	
	private String expectedButtonsInMyCartForGeneralUser = PropertyFileReader.propertiesReader(searchData, "expectedButtonsInMyCartForGeneralUser");
	
	private String productsPageBreadcrump = PropertyFileReader.propertiesReader(searchData, "productsPageBreadcrump");
	
	private String expectedBannerImagesInLevelOne = PropertyFileReader.propertiesReader(searchData, "expectedBannerImagesInLevelOne");
	
	private String expectedButtonsInMyCartForSuperUser = PropertyFileReader.propertiesReader(searchData, "expectedButtonsInMyCartForSuperUser");
	
	private String expectedCartInstructions = PropertyFileReader.propertiesReader(searchData, "expectedCartInstructions");
	
	private String saveCartBreadcrump = PropertyFileReader.propertiesReader(searchData, "saveCartBreadcrump");
	
	private String registrationBreadCrump = PropertyFileReader.propertiesReader(searchData, "registrationBreadCrump");
	
	private String editContactInfoTitle = PropertyFileReader.propertiesReader(searchData, "editContactInfoTitle");
	
	private String searchTextForGeneralSearchTest = PropertyFileReader.propertiesReader(searchData, "searchTextForGeneralSearchTest");
	
	private String searchTextForProductListPage = PropertyFileReader.propertiesReader(searchData, "searchTextForProductListPage");
	
	private String imagePathForProfilePic = PropertyFileReader.propertiesReader(searchData, "imagePath");
	
	private String cartFileUploadPath = PropertyFileReader.propertiesReader(searchData, "cartFileUploadPath");
	
	private String csvFilePath = PropertyFileReader.propertiesReader(searchData, "csvFilePath");
	
	private String tabDelimitedFilePath = PropertyFileReader.propertiesReader(searchData, "tabDelimitedFilePath");
	
	private String partNumberOrUPC = PropertyFileReader.propertiesReader(searchData, "partNumberOrUPC");
	
	private String speedEntryEmptyValuesAlertMessage = PropertyFileReader.propertiesReader(searchData, "speedEntryEmptyValuesAlertMessage");
	
	private String copyPasteInvalidFormatAlertMessage = PropertyFileReader.propertiesReader(searchData, "copyPasteInvalidFormatAlertMessage");
	
	private String selectFileToUploadAlertMessage = PropertyFileReader.propertiesReader(searchData, "selectFileToUploadAlertMessage");
	
	private String selectXLSXFileToUploadAlertMessage = PropertyFileReader.propertiesReader(searchData, "selectXLSXFileToUploadAlertMessage");

	public String cartFileUploadInstructions = PropertyFileReader.propertiesReader(searchData, "cartFileUploadInstructions");;
	
	public String expectedSearchTexboxPlaceholder = PropertyFileReader.propertiesReader(searchData, "expectedSearchTexboxPlaceholder");;
	
	private String searchTextForInvalidTestData = PropertyFileReader.propertiesReader(searchData, "searchTextForInvalidTestData");;
	
	private String alertMessageWhenGoButtonIsClickedWithProvidingSearchText = PropertyFileReader.propertiesReader(searchData, "alertMessageWhenGoButtonIsClickedWithProvidingSearchText");;
	
	private String searchTextKeyword = PropertyFileReader.propertiesReader(searchData, "searchTextKeyword");
	
	private String productCategory = PropertyFileReader.propertiesReader(searchData, "productCategory");
	
	private String searchTextForMPNTest = PropertyFileReader.propertiesReader(searchData, "searchTextForMPNTest");
	
	private String expectedAlertMessageForBlankData = PropertyFileReader.propertiesReader(searchData, "expectedAlertMessageForBlankData");
	
	private String myProductGroupLandingPageTitle = PropertyFileReader.propertiesReader(searchData, "myProductGroupLandingPageTitle");
	
	private String bulkOption;
	
	private int numberOfRowsToEnter;
	
	private String deleteItemFromProductGroupAlertText = PropertyFileReader.propertiesReader(searchData, "deleteItemFromProductGroupAlertText");
	
	private String expectedEmptyProductGroupMessage = PropertyFileReader.propertiesReader(searchData, "expectedEmptyProductGroupMessage");
	
	private String pleaseEnterGroupNameALertText = PropertyFileReader.propertiesReader(searchData, "pleaseEnterGroupNameALertText");
	
	private String editGroupNameSuccessAlertText = PropertyFileReader.propertiesReader(searchData, "editGroupNameSuccessAlertText");
	
	private String groupNameAlreadyExistsAlertText = PropertyFileReader.propertiesReader(searchData, "groupNameAlreadyExistsAlertText");
	
	
	private String noChangesToGroupNameAlertText = PropertyFileReader.propertiesReader(searchData, "noChangesToGroupNameAlertText");
	
	private String expectedSortByOptionsInMyProductGroups = PropertyFileReader.propertiesReader(searchData, "expectedSortByOptionsInMyProductGroups");
	
	private String searchTextForAnotherItem = PropertyFileReader.propertiesReader(searchData, "searchTextForAnotherItem");
	
	private String selectForThanOneItemToCompareText = PropertyFileReader.propertiesReader(searchData, "selectForThanOneItemToCompareText");
	
	private String itemsRemovedFromComparedListAlertText = PropertyFileReader.propertiesReader(searchData, "itemsRemovedFromComparedListAlertText");
	
	private String comparePageName = PropertyFileReader.propertiesReader(searchData, "comparePageName");
	
	private String alertTextForMoreThanFiveItems = PropertyFileReader.propertiesReader(searchData, "alertTextForMoreThanFiveItems");
	
	private String alertTextWhenRemoveLinkIsClickedWhenThereIsOnlyTwoItemsLeft = PropertyFileReader.propertiesReader(searchData, "alertTextWhenRemoveLinkIsClickedWhenThereIsOnlyTwoItemsLeft");
	
	private String searchBrand = PropertyFileReader.propertiesReader(searchData, "searchBrand");
	
	private String xlsxFileForDifferentCartFileUploadScenarios = PropertyFileReader.propertiesReader(searchData, "xlsxFileForDifferentCartFileUploadScenarios");
	
	private String firstNameForRegistration = PropertyFileReader.propertiesReader(searchData, "firstNameForRegistration");
	
	private String lastNameForRegistration = PropertyFileReader.propertiesReader(searchData, "lastNameForRegistration");
	
	private String companyNameForRegistration = PropertyFileReader.propertiesReader(searchData, "companyNameForRegistration");

	private String emailIdForRegistration = PropertyFileReader.propertiesReader(searchData, "emailIdForRegistration");
	
	private String passwordForRegistration = PropertyFileReader.propertiesReader(searchData, "passwordForRegistration");
	
	private String address1ForRegistration = PropertyFileReader.propertiesReader(searchData, "address1ForRegistration");
	
	private String address2ForRegistration = PropertyFileReader.propertiesReader(searchData, "address2ForRegistration");
	
	private String cityForRegistration = PropertyFileReader.propertiesReader(searchData, "cityForRegistration");
	
	private String stateForRegistration = PropertyFileReader.propertiesReader(searchData, "stateForRegistration");
	
	private String zipCodeForRegistration = PropertyFileReader.propertiesReader(searchData, "zipCodeForRegistration");
	
	private String phoneNumberForRegistration = PropertyFileReader.propertiesReader(searchData, "phoneNumberForRegistration");
	
	private String retailUserRegistrationSuccessMsg = PropertyFileReader.propertiesReader(searchData, "retailUserRegistrationSuccessMsg");
	
	private String alertTextForDisableOfUser = PropertyFileReader.propertiesReader(searchData, "alertTextForDisableOfUser");
	
	private String partNumberOrUPCForSpeedEntry = PropertyFileReader.propertiesReader(searchData, "partNumberOrUPCForSpeedEntry");
	
	private String orderType = PropertyFileReader.propertiesReader(searchData, "orderType");

	private String shipVia = PropertyFileReader.propertiesReader(searchData, "shipVia");
	
	private String shippingInstructions = PropertyFileReader.propertiesReader(searchData, "shippingInstructions");
	
	private String orderNote = PropertyFileReader.propertiesReader(searchData, "orderNote");
	
	private String orderInfoLabelsInOrderConfirmationPage = PropertyFileReader.propertiesReader(searchData, "orderInfoLabelsInOrderConfirmationPage");
	
	private String numberOfTextboxesToDisplayForMPNQtyShortDescriptionBrOrManfrNameEach = PropertyFileReader.propertiesReader(searchData, "numberOfTextboxesToDisplayForMPNQtyShortDescriptionBrOrManfrNameEach");
	
	private String apaDisableAlertText = PropertyFileReader.propertiesReader(searchData, "apaDisableAlertText");
	
	private String alertTextForSubmitCartForApproval = PropertyFileReader.propertiesReader(searchData, "alertTextForSubmitCartForApproval");
	
	private String aPAUserID = PropertyFileReader.propertiesReader(searchData, "aPAUserID");
	
	private String aPAPassword = PropertyFileReader.propertiesReader(searchData, "aPAPassword");
	
	private String expectedAlertTextCPNForAddButton = PropertyFileReader.propertiesReader(searchData, "expectedAlertTextCPNForAddButton");
	
	private String expectedAlertTextCPNForRemoveButton = PropertyFileReader.propertiesReader(searchData, "expectedAlertTextCPNForRemoveButton");
	
	private String alertTextForCPNAlreadyExists = PropertyFileReader.propertiesReader(searchData, "alertTextForCPNAlreadyExists");
	
	private String invalidQuantityForSpeedEntry = PropertyFileReader.propertiesReader(searchData, "invalidQuantityForSpeedEntry");
	
	private String invalidQuantityColour = PropertyFileReader.propertiesReader(searchData, "invalidQuantityColour");
	
	private String showSimilarButtonAfterClick = PropertyFileReader.propertiesReader(searchData, "showSimilarButtonAfterClick");
	
	private String colourOfHighlightSimilarButtonAfterClicking = PropertyFileReader.propertiesReader(searchData, "colourOfHighlightSimilarButtonAfterClicking");
	

	private String deleteSaveCartAlertText = PropertyFileReader.propertiesReader(searchData, "deleteSaveCartAlertText");
	
	
	private String reasonForRejectCart = PropertyFileReader.propertiesReader(searchData, "reasonForRejectCart");
	
	private String alertTextForApprovalCartReject = PropertyFileReader.propertiesReader(searchData, "alertTextForApprovalCartReject");
	
	private String alertTextForClickingOnUpdateSelectedItemsWithoutSelectingAnyItem = PropertyFileReader.propertiesReader(searchData, "alertTextForClickingOnUpdateSelectedItemsWithoutSelectingAnyItem");
	
	private String categoryWithPagination = PropertyFileReader.propertiesReader(searchData, "categoryWithPagination");
	
	
	private String searchBrandForCompare = PropertyFileReader.propertiesReader(searchData, "searchBrandForCompare");
	
	private String commercialUserRegistrationSuccessMsg = PropertyFileReader.propertiesReader(searchData, "commercialUserRegistrationSuccessMsg");
	
	public String getCopyRightsOfUnilogText() {
		return copyRightsOfUnilog;
	}
	
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

	public String getSearchText()     {
		
		return searchText;
	}

	public String getGroupName()     {
		
		return groupName;
	}
	
	public String getSaveCartName()    {
		
		return saveCartName;
	}
	
	public String getQuantityForShoppingCartPageVerification()    {
		
		return quantityForShoppingCart;
	}
	
	public String getNameOfShoppingCartButtons()    {
		
		return nameOfShoppingCartButtons;
	}
	
	public String getFooterHeadings()    {
		
		return footerHeadings;
	}

	public String getTaxonomies()     {
		
		return taxonomies;
	}

	public String getFileUploadPath()     {
		
		return fileUploadPath;
	}
	
	public String getMyAccountTabs()    
	{
		
		return myAccountTabs;
	}

	public String getPhoneNumber()     {
		
		return phoneNumber;
	}

	public String getMPN()     {
		
		return mpn;
	}

	public void setNumberOfRowsToEnter(int numberOfRowsToEnter)
	{
		this.numberOfRowsToEnter = numberOfRowsToEnter;
	}

	public int getNumberOfRowsToEnter()
	{
		return numberOfRowsToEnter;
	}

	public String getBrandNameForRequestQuote()     {
		
		return brandNameForRequestQuote;
	}

	public String getQunatityForRequestQuote()     {
		
		return quantityForRequestQuote;
	}

	public String getCommentForRequestQuote()  {
		
		return commentForRequestQuote;
	}

	public String getLoginPageTitle(){
		
		return loginPageTitle;
	}

	public String getFaviconURL()  {
		
		return faviconURL;
	}

	public String getShoppingCartInstructions()     {
		
		return shoppingCartInstructions;
	}

	public String getEmptyCartText()     {
		
		return emptyCartText;
	}

	public String getSortByShoppingCartDropdownValues()     {
	
		return sortByShoppingCartDropdownValues;
	}

	public String getNickName()     {
		
		return nickName;
		
	}

	public String getCardHolder()     {
		
		return cardHolder;
	}

	public String getStreetAddress()     {
		
		return streetAddress;
	}

	public String getPostalCode()     {
	
		return postalCode;
	}

	public String welcomeMessageInAddNewCreditCardPage()     {
		
		return welcomeMessageInAddNewCreditCardPage;
	}

	public String getCardNumber()     {
		
		return cardNumber;
	}

	public String getMonth()     {
		
		return month;
	}

	public String getYear()     {
	
		return year;
	}

	public String getProductDetailsTabs()     {
		
		return productDetailsTabs;
	}

	public String getOrderConfirmationText()     {
		
		return orderConfirmationText;
	}
	
	public String expectedAlertMessageForComaringMoreThan3Items()     {
		
		return expectedAlertMessageForComaringMoreThan3Items;
	}
	
	
	public String getAnotherSearchText()     {
		
		return anotherSearchText;
	}

	public String getForgotYourPasswordInstructions() {
		
		return forgotYourPasswordInstructions;
	}

	public String getLogo() {
		
		return logo;
	}

	public String getCarouselImages() {

		return carouselImages;
	}

	public String getMainSectionOptions() {
	
		return mainSectionOptions;
	}

	public String getAllSectionsText() {
		
		return allSectionsText;
	}

	public String getFooterLinksText() {
		
		return footerLinksText;
	}

	public String getExpectedSortByOptions() {
		
		return expectedSortByOptions;
	}

	public String getExpectedResultsPerPageOptions() {
		
		return expectedResultsPerPageOptions;
	}

	public void setShowItemsPerPage(int numberOfItemsPerPage) {
		
		this.numberOfItemsPerPage = numberOfItemsPerPage;
	}

	public int getShowItemsPerPage() {
		
		return numberOfItemsPerPage;
	}

	public String getSearchTextForUPCLabelTest() {
		
		return searchTextForUPCLabelTest;
	}

	public String getMyProductGroupName() {
		
		return productGroupName;
	}

	public String getDeleteGroupAlertText() {
		
		return deleteGroupAlertText;
	}

	public String getMyProductGroupsPageName() {
		
		return myProductGroupsPageName;
	}

	public String getCustomerPartNumber() {
		
		return customerPartNumber;
	}

	public String getFilterNamesInPDPAfterLogin() {
		
		return filterNamesInPDPAfterLogin;
	}

	public String getFilterNamesInPDPNOTLogin() {
		
		return filterNamesInPDPNotLogin;
	}

	public String getShopByBrandsBreadcrump() {
		
		return shopByBrandsBreadcrump;
	}

	public String getShopByManufacturersBreadcrump() {

		return shopByManufacturersBreadcrump;
	}

	public void setSpecificManufacturerName(String specificManufacturerName) {
		
		this.specificManufacturerName = specificManufacturerName;
	}

	public String getSpecificManufacturerName() {
		
		return specificManufacturerName;
	}

	public void setSpecificBrandName(String specificBrandName) {
		this.specificBrandName = specificBrandName;
		
	}
	
public String getSpecificBrandname() {
		
		return specificBrandName;
	}

public String getSearchTextForEnlargeImageTest() {

	return searchTextForEnlargeImageTest;
}

public String getAddNewPurchasingAgentInstructions() {
	
	return addNewPurchasingAgentInstructions;
}

public String getExpectedMandatoryFieldsInAddNewPurchasingAgent() {
	
	return expectedMandatoryFieldsInAddNewPurchasingAgent;
}

public String getEmailAddressInstruction() {
	
	return emailAddressInstruction;
}

public String getAddNewPurchasingAgentBreadcrump() {
	
	return addNewPurchasingAgentBreadcrump;
}

public String getExpectedRoleAssignmentDropdownOptions() {
	
	return expectedRoleAssignmentDropdownOptions;
}

public String getGeneralUserEmailID() {
	
	return generalUserEmailID;
}

public String getGeneralUserPassword() {
	
	return generalUserPassword;
}

public String getMyCartBreadcrump() {
	
	return myCartBreadcrump;
}

public String getExpectedButtonsInMyCartForGeneralUser() {

	return expectedButtonsInMyCartForGeneralUser;
}

public String getProductsPageBreadCrump() {
	
	return productsPageBreadcrump;
}

public void setSpecificCategory(String specificCategory) {
	
	this.specificCategory = specificCategory;
}

public String getSpecificCategory() {
	
	return specificCategory;
}

public String getBannerImagesInLevelOne() {
	
	return expectedBannerImagesInLevelOne;
}

public String getExpectedButtonsInMyCartForSuperUser() {

	return expectedButtonsInMyCartForSuperUser;
}

public String getExpectedCartInstructions() {
	
	return expectedCartInstructions;
}

public String getSaveCartBreadcrump() {
	
	return saveCartBreadcrump;
}

public String getRegistrationBreadCrump() {

	return registrationBreadCrump;
}


public String getSearchTextForGeneralSearch() {

	return searchTextForGeneralSearchTest;
}

public String getEditContactInfoTitle() {
	
	return editContactInfoTitle;
}

public String getSearchTextForProductListPage() {

	return searchTextForProductListPage;
}


public String getImagePath() {
	return imagePathForProfilePic;
}

public String getCartFileUploadPath() {
	
	return cartFileUploadPath;
}

public String getCSVFilePath() {
	
	return csvFilePath;
}

public String getTabDelimitedFilePath() {
	
	return tabDelimitedFilePath;
}

public String getPartNumberOrUPC() {
	
	return partNumberOrUPC;
}

public String getSpeedEntryEmptyValuesAlertMessage() {
	
	return speedEntryEmptyValuesAlertMessage;
}

public String getCopyPasteInvalidFormatAlertMessage() {

	return copyPasteInvalidFormatAlertMessage;
}

public String getSelectFileToUploadAlertMessage() {
	
	return selectFileToUploadAlertMessage;
}

public String getSelectXLSXFileToUploadAlertMessage() {
	
	return selectXLSXFileToUploadAlertMessage;
}

public String getCartFileUploadInstructions() {
	
	return cartFileUploadInstructions;
}

public String getExpectedSearchTexboxPlaceholder() {

	return expectedSearchTexboxPlaceholder;
}

public String getSearchTextForInvalidTestData() {

	return searchTextForInvalidTestData;
}

public String getAlertMessageWhenGoButtonIsClickedWithProvidingSearchText() {

	return alertMessageWhenGoButtonIsClickedWithProvidingSearchText;
}

public String getSearchTextKeyword() {
	
	return searchTextKeyword;
}

public String getProductCategory() {
	
	return productCategory;
}


public String getSearchTextForMPNTest() {
	
	return searchTextForMPNTest;
}

public String getExpectedAlertMessageForBlankData() {
	
	return expectedAlertMessageForBlankData;
}

public String getMyProductGroupLandingPageTitle() {
	
	return myProductGroupLandingPageTitle;
}


public String getBulkOption() {

	return bulkOption;
}

public void setBulkOption(String bulkOption) {
	this.bulkOption=bulkOption;
	
}

public String getDeleteItemFromProductGroupAlertText() {
	
	return deleteItemFromProductGroupAlertText;
}

public String getExpectedEmptyProductGroupMessage() {

	return expectedEmptyProductGroupMessage;
}

public String getPleaseEnterGroupNameALertText() {
	
	return pleaseEnterGroupNameALertText;
}

public String getEditGroupNameSuccessAlertText() {

	return editGroupNameSuccessAlertText;
}

public String getGroupNameAlreadyExistsAlertText() {
	
	return groupNameAlreadyExistsAlertText;
}

public String getNoChangesToGroupNameAlertText() {
	
	return noChangesToGroupNameAlertText;
}

public String getExpectedSortByOptionsInMyProductGroups() {

	return expectedSortByOptionsInMyProductGroups;
}

public String getSearchTextForAnotherItem() {
	
	return searchTextForAnotherItem;
}

public String getSelectForThanOneItemToCompareText() {
	
	return selectForThanOneItemToCompareText;
}

public String getItemsRemovedFromComparedList() {

	return itemsRemovedFromComparedListAlertText;
}

public String getComparePageName() {
	
	return comparePageName;
}

public String getAlertTextForMoreThanFiveItems() {
	
	return alertTextForMoreThanFiveItems;
}

public String getAlertTextWhenRemoveLinkIsClickedWhenThereIsOnlyTwoItemsLeft() {
	
	return alertTextWhenRemoveLinkIsClickedWhenThereIsOnlyTwoItemsLeft;
}



public String getSearchBrand() {

	return searchBrand;
}


public String getXlsxFileForDifferentCartFileUploadScenarios() {
	
	return xlsxFileForDifferentCartFileUploadScenarios;
}

public String getfirstNameForRegistration() {
	
	return firstNameForRegistration;
}

public String getLastNameForRegistration() {

	return lastNameForRegistration;
}

public String getCompanyNameForRegistration() {
	
	return companyNameForRegistration;
}

public String getEmailIdForRegistration() {
	 
	return emailIdForRegistration;
}

public String getPasswordForRegistration() {
	 
	return passwordForRegistration;
}

public String getAddress1ForRegistration() {
	 
	return address1ForRegistration;
}

public String getAddress2ForRegistration() {
	 
	return address2ForRegistration;
}

public String getCityForRegistration() {
	 
	return cityForRegistration;
}

public String getStateForRegistration() {
	 
	return stateForRegistration;
}

public String getZipCodeForRegistration() {
	 
	return zipCodeForRegistration;
}

public String getPhoneNumberForRegistration() {
	 
	return phoneNumberForRegistration;
}

public String getRetailUserRegistrationSuccessMsg() {
	
	return retailUserRegistrationSuccessMsg;
}

public String getAlertTextForDisableOfUser() {
	 
	return alertTextForDisableOfUser;
}


public String getPartNumberOrUPCForSpeedEntry() {
	 
	return partNumberOrUPCForSpeedEntry;
}

public String getOrderType() {
	 
	return orderType;
}

public String getShipVia() {
	 
	return shipVia;
}

public String getShippingInstructions() {
	 
	return shippingInstructions;
}


public String getOrderNote() {
	 
	return orderNote;
}

public String getOrderInfoLabelsInOrderConfirmationPage() {
	 
	return orderInfoLabelsInOrderConfirmationPage;
}

public int getNumberOfTextboxesToDisplayForMPNQtyShortDescriptionBrOrManfrNameEach() {
	 
	return Integer.parseInt(numberOfTextboxesToDisplayForMPNQtyShortDescriptionBrOrManfrNameEach);
}

public String getAlertTextForDisableOfAPA() {
	 
	return apaDisableAlertText;
}

public String getAlertTextForSubmitCartForApproval() {
	 
	return alertTextForSubmitCartForApproval;
}

public String getAPAUserID() {
	 
	return aPAUserID;
}

public String getAPAPassword() {
	 
	return aPAPassword;
}

public String getExpectedAlertTextCPNForAddButton() {
	 
	return expectedAlertTextCPNForAddButton;
}

public String getExpectedAlertTextCPNForRemoveButton() {
	 
	return expectedAlertTextCPNForRemoveButton;
}

public String getAlertTextForCPNAlreadyExists() {
	 
	return alertTextForCPNAlreadyExists;
}

public String getInvalidQuantityForSpeedEntry() {
	 
	return invalidQuantityForSpeedEntry;
}

public String getSpeedEntryInvalidQuantityColour() {
	 
	return invalidQuantityColour;
}

public String getShowSimilarButtonAfterClick() {
	 
	return showSimilarButtonAfterClick;
}

public String getColourOfHighlightSimilarButtonAfterClicking() {
	 
	return colourOfHighlightSimilarButtonAfterClicking;
}

public String getDeleteSaveCartAlertText() {
	 
	return deleteSaveCartAlertText;
}

public String getReasonForRejectCart() {
	 
	return reasonForRejectCart;
}

public String getAlertTextForApprovalCartReject() {
	 
	return alertTextForApprovalCartReject;
}

public String getAlertTextForClickingOnUpdateSelectedItemsWithoutSelectingAnyItem() {
	 
	return alertTextForClickingOnUpdateSelectedItemsWithoutSelectingAnyItem;
}

public String getCategoryWithPagination() {
	 
	return categoryWithPagination;
}

public String getSearchBrandForCompare() {
	 
	return searchBrandForCompare;
}

public String getCommercialUserRegistrationSuccessMsg() {
	
	return commercialUserRegistrationSuccessMsg;
}

}
