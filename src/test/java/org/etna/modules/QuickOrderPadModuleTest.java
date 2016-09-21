package org.etna.modules;
import org.apache.commons.io.FileUtils;
import org.etna.dataprovider.SearchData;
import org.etna.utils.ExcelLibrary;
import org.etna.utils.TestUtility;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Issues;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.io.File;

public class QuickOrderPadModuleTest extends PageFactoryInitializer {


    SearchDataPropertyFile data = new SearchDataPropertyFile();
    ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
    LoginModuleTest loginModule = new LoginModuleTest();


    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_001,TC_QOP_035")
    @Description("Verification of 'Quick Order Pad' page,Verification of breadcrumbs display in Quick order page")
    public void verifyQuickOrderLandingPage() throws Exception {
        homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .verifyQuickOrderPage();
    }

    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_002")
    @Description("Verification of 'Speed Entry' tab in  'Quick Order Pad' page.")
    public void verifySpeedEntryTab() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .verifySpeedEntryTab(data.getSpeedEntryInstructions());

    }


    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_023")
    @Description("Verify whether the Items are added to cart through file upload.")
    public void cartFileUpload() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        int addedToCartCount = homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnFileUploadTab()
                .uploadFile(data.getCartFileUploadPath().trim())
                .clickOnUpload()
                .getAddedToCartCount();
        quickOrderPadPage()
                .verifyCartCountEqualToAddedToCartCount(addedToCartCount);
    }


        @Features("Quick Order Pad Module")
        @Test(groups = "regression")
        @TestCaseId("TC_QOP_031")
        @Description("Verification of uploading empty file in 'File Upload' tab")
        public void cartFileUploadEmptyTemplate() throws Exception {
            loginModule.loginAsASuperUser();
            homePage().logout();
            homePage()
                    .clickLoginLink()
                    .loginPopUp()
                    .enterUserName()
                    .enterPassword()
                    .clickOnLoginButton()
                    .homePage()
                    .verifyWelcomeMsg()
                    .clickOnUserAccountDropdown()
                    .clickOnQuickOrderPadLink()
                    .quickOrderPadPage()
                    .clickOnFileUploadTab()
                    .uploadFile(data.getCartFileUploadEmptyTemplate().trim())
                    .clickOnUpload()
                    .verifyAlertMessage(data.getAlertTextUploadFileIsNotInDesiredFormat().trim());
        }


    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_014")
    @Description("Verify whether item gets added to cart using quick order pad - 'Copy Paste' Tab")
    public void copyPasteCSVFile() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        int addedToCartCount = homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnCopyPasteTab()
                .copyPasteFile(data.getCSVFilePath().trim())
                .clickOnAddToCartButtonInCopyPaste()
                .getAddedToCartCount();
        quickOrderPadPage()
                .verifyCartCountEqualToAddedToCartCount(addedToCartCount);
    }


    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    public void copyPasteTabDelimitedFile() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        int addedToCartCount = homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnCopyPasteTab()
                .copyPasteTxtFile(data.getTabDelimitedFilePath().trim())
                .clickOnAddToCartButtonInCopyPaste()
                .getAddedToCartCount();
        quickOrderPadPage()
                .verifyCartCountEqualToAddedToCartCount(addedToCartCount);
    }


    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    public void copyPasteEmptyValues() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnCopyPasteTab()
                .clickOnAddToCartButtonInCopyPaste()
                .verifyAlertMessage(data.getSpeedEntryEmptyValuesAlertMessage());
    }

    @Features("Quick Order Pad Module")
    @Test(groups = "regression", enabled = false)
    @Issues(value = {@Issue(value = "NEST-160")})
    public void copyPasteImproperValues() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnCopyPasteTab()
                .clickOnFileUploadTab()
                .clickOnCopyPasteTab()
                .copyPasteTxtFile(data.getTabDelimitedFilePathForImproperValues().trim())
                .clickOnAddToCartButtonInCopyPaste()
                .verifyAlertMessage(data.getCopyPasteInvalidFormatAlertMessage());
    }

    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_026")
    @Description("Verification of 'Upload' button without selecting file")
    public void fileUploadNoFileSelectedAtFirst() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnFileUploadTab()
                .clickOnUpload()
                .verifyAlertMessage(data.getSelectFileToUploadAlertMessage());
        throw new SkipException("Cannot be completely automated. Automation code verifies till the alert message.");
    }





    @Features("Quick Order Pad Module")
    @Test(groups = "regression",dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass = SearchData.class)
    @TestCaseId("{0}")
    @Description("Verification of 'Upload' button if the file format is not .xlsx")
    public void cartFileUploadDifferentFormats(String testCaseId,String pathToTheInvalidFile, String selectXLSXFileToUploadAlertMessage) throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        loginModule.loginAsASuperUser();
        homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnFileUploadTab()
                .uploadFile(pathToTheInvalidFile.trim())
                .clickOnUpload()
                .verifyAlertMessage(selectXLSXFileToUploadAlertMessage.trim());
    }


    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_032")
    @Description("Verification of 'Combine' functionality in 'File Upload' tab")
    public void cartFileUploadCombine() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        int addedToCartCount = homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnFileUploadTab()
                .uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
                .clickOnUpload()
                .getAddedToCartCount();
        quickOrderPadPage()
                .verifyCartCountEqualToAddedToCartCount(addedToCartCount);
        quickOrderPadPage()
                .uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
                .clickOnUpload();
        Thread.sleep(3000);
        quickOrderPadPage()
                .verifyCartCountEqualToAddedToCartCount(1)
                .myCartPage()
                .clickOnCartIcon()
                .verifyNumberOfItemsInShoppingCart(1)
                .verifyQuantitiesInShoppingCartForMultipleItems("2");
    }

    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_033")
    @Description("Verification of 'Seperate' functionality in 'File Upload' tab")
    public void cartFileUploadSeperate() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        int addedToCartCount = homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnFileUploadTab()
                .clickOnSeperateButton()
                .uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
                .clickOnUpload()
                .getAddedToCartCount();
        quickOrderPadPage()
                .verifyCartCountEqualToAddedToCartCount(addedToCartCount);
        quickOrderPadPage()
                .uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
                .clickOnUpload();
        Thread.sleep(3000);
        quickOrderPadPage()
                .verifyCartCountEqualToAddedToCartCount(2)
                .myCartPage()
                .clickOnCartIcon()
                .verifyNumberOfItemsInShoppingCart(2)
                .verifyQuantitiesInShoppingCartForMultipleItems("1");
    }

    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_034")
    @Description("Verification of 'Remove' functionality in 'File Upload' tab")
    public void cartFileUploadRemove() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        int addedToCartCount = homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnFileUploadTab()
                .clickOnRemoveButton()
                .uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
                .clickOnUpload()
                .getAddedToCartCount();
        quickOrderPadPage()
                .verifyCartCountEqualToAddedToCartCount(addedToCartCount);
        quickOrderPadPage()
                .uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
                .clickOnUpload();
        Thread.sleep(3000);
        quickOrderPadPage()
                .verifyCartCountEqualToAddedToCartCount(1)
                .myCartPage()
                .clickOnCartIcon()
                .verifyNumberOfItemsInShoppingCart(1)
                .verifyQuantitiesInShoppingCartForMultipleItems("2");
    }

    @Features("Quick Order Pad Module")
    @Test(groups = {"smoke", "regression"})
    @Description("Verification of add to cart functionality in 'Speed Entry' tab")
    @TestCaseId("TC_QOP_003")
    public void speedEntrySmoke() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        data.setNumberOfRowsToEnter(2);
        loginModule.loginAsASuperUser();
        homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink().quickOrderPadPage()
                .enterPartNumberOrUPCForSpeedEntry(data.getPartNumberOrUPCForSpeedEntry().split(","), data.getNumberOfRowsToEnter())
                .clickOnAddToCartButtonSpeedEntry()
                .myCartPage()
                .clickOnCartIcon()
                .verifyNumberOfItemsInShoppingCart(2);
    }

    @Features("Quick Order Pad Module")
    @Test(groups = {"regression"})
    @TestCaseId("TC_QOP_004")
    @Description("Verification of 'Combine' functionality in 'Speed Entry' tab")
    public void speedEntryCombine() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        data.setNumberOfRowsToEnter(2);
        loginModule.loginAsASuperUser();
        homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink().quickOrderPadPage()
                .clickOnSpeedEntry()
                .enterPartNumberOrUPCForSpeedEntryForCombine(data.getPartNumberOrUPCForSpeedEntry().split(","), data.getNumberOfRowsToEnter())
                .clickOnAddToCartButtonSpeedEntry()
                .myCartPage()
                .clickOnCartIcon()
                .verifyNumberOfItemsInShoppingCart(1)
                .verifyQuantitiesInShoppingCartForMultipleItems("2");
    }

    @Features("Quick Order Pad Module")
    @Test(groups = {"regression"})
    @TestCaseId("TC_QOP_005")
    @Description("Verification of 'Separate' functionality in 'Speed Entry' tab")
    public void speedEntrySeperate() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        data.setNumberOfRowsToEnter(2);
        loginModule.loginAsASuperUser();
        homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink().quickOrderPadPage()
                .clickOnSpeedEntry()
                .enterPartNumberOrUPCForSpeedEntryForCombine(data.getPartNumberOrUPCForSpeedEntry().split(","), data.getNumberOfRowsToEnter())
                .clickOnSeperateButtonSpeedEntry()
                .clickOnAddToCartButtonSpeedEntry()
                .myCartPage()
                .clickOnCartIcon()
                .verifyNumberOfItemsInShoppingCart(2)
                .verifyQuantitiesInShoppingCartForMultipleItems("1");
    }

    @Features("Quick Order Pad Module")
    @Test(groups = {"regression"})
    @Description("Verification of 'Remove' functionality in 'Speed Entry' tab")
    @TestCaseId("TC_QOP_006")
    public void speedEntryRemove() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        data.setNumberOfRowsToEnter(10);
        loginModule.loginAsASuperUser();
        homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink().quickOrderPadPage()
                .clickOnSpeedEntry()
                .enterPartNumberOrUPCForSpeedEntryForCombine(data.getPartNumberOrUPCForSpeedEntry().split(","), data.getNumberOfRowsToEnter())
                .clickOnRemoveButtonSpeedEntry()
                .clickOnAddToCartButtonSpeedEntry()
                .myCartPage()
                .clickOnCartIcon()
                .verifyNumberOfItemsInShoppingCart(1)
                .verifyQuantitiesInShoppingCartForMultipleItems("1");
    }

    @Features("Quick Order Pad Module")
    @Test(groups = {"regression"})
    @TestCaseId("TC_QOP_011")
    @Description("Verification of Add to cart functionality in 'Speed Entry' tab for Invalid Quantity.")
    public void speedEntryInvalidQuantity() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        loginModule.loginAsASuperUser();
        data.setNumberOfRowsToEnter(1);
        homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink().quickOrderPadPage()
                .clickOnSpeedEntry()
                .enterPartNumberOrUPCForSpeedEntry(data.getInvalidQuantityForSpeedEntry().split(","), data.getNumberOfRowsToEnter())
                .verifyInvalidQuantityColour(data.getSpeedEntryInvalidQuantityColourChrome(), data.getSpeedEntryInvalidQuantityColourFirefox())
                .clickOnAddToCartButtonSpeedEntry()
                .verifyAlertMessage(data.getAlertTextForInvalidQuantityInSpeedEntry() + Integer.toString(data.getNumberOfRowsToEnter()));
    }

    @Features("Quick Order Pad Module")
    @Test(groups = {"regression"})
    @TestCaseId("TC_QOP_007")
    @Description("Verification of Add to cart functionality when Quantity field is left blank in speed entry tab")
    public void speedEntryQtyFieldBlank() throws Exception {
        String keyword[] = data.getPartNumberOrUPCForSpeedEntry().split(",");
        loginModule.loginAsASuperUser();
        homePage().logout();
        loginModule.loginAsASuperUser();
        data.setNumberOfRowsToEnter(1);
        homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink().quickOrderPadPage()
                .clickOnSpeedEntry()
                .enterKeywordOrQtyBut1FieldIsEmpty(keyword[0].split(":"), "Keyword", data.getNumberOfRowsToEnter())
                .clickOnAddToCartButtonSpeedEntry()
                .verifyAlertMessage(data.getAlertTextForInvalidQuantityInSpeedEntry() + Integer.toString(data.getNumberOfRowsToEnter()));
    }

    @Features("Quick Order Pad Module")
    @Test(groups = {"regression"})
    @TestCaseId("TC_QOP_008")
    @Description("Verification of Add to cart functionality when Keyword field is left blank in speed entry tab")
    public void speedEntryKeywordFieldBlank() throws Exception {
        String keyword[] = data.getPartNumberOrUPCForSpeedEntry().split(",");
        loginModule.loginAsASuperUser();
        homePage().logout();
        loginModule.loginAsASuperUser();
        data.setNumberOfRowsToEnter(1);
        homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink().quickOrderPadPage()
                .clickOnSpeedEntry()
                .enterKeywordOrQtyBut1FieldIsEmpty(keyword[0].split(":"), "Quantity", data.getNumberOfRowsToEnter())
                .clickOnAddToCartButtonSpeedEntry()
                .verifyAlertMessage(data.getAlertTextForInvalidQuantityInSpeedEntry() + Integer.toString(data.getNumberOfRowsToEnter()));
    }

    @Features("Quick Order Pad Module")
    @Test(groups = {"regression"})
    @TestCaseId("TC_QOP_009")
    @Description("Verification of 'Add to cart' functionality when item price is unavailable in speed entry tab.")
    public void speedEntryNoPriceItem() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        loginModule.loginAsASuperUser();
        data.setNumberOfRowsToEnter(2);
        int actualItemsWithException = homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink().quickOrderPadPage()
                .clickOnSpeedEntry()
                .enterPartNumberOrUPCForSpeedEntry(data.getPartNumberOrUPCForSpeedEntryWhichHasCallForPrice().split(","), data.getNumberOfRowsToEnter())
                .clickOnAddToCartButtonSpeedEntry()
                .verifyCartCountEqualToAddedToCartCount(0)
                .getItemsWithExceptions();
        quickOrderPadPage().verifyNumberOfItemsWithExceptions(actualItemsWithException, data.getNumberOfRowsToEnter())
                .verifyWhetherTheItemsAddedHaveCallForPrice(data.getNumberOfRowsToEnter());
    }

    @Features("Quick Order Pad Module")
    @Test(groups = {"regression"})
    @TestCaseId("TC_QOP_010")
    @Description("Verification of Add to cart functionality in 'Speed Entry' tab for Invalid PartNumber.")
    public void speedEntryInvalidPartNumber() throws Exception {
        String jibberishKeywords[] = {"asdajkdhsjadha:1"};
        loginModule.loginAsASuperUser();
        homePage().logout();
        loginModule.loginAsASuperUser();
        data.setNumberOfRowsToEnter(1);
        int actualItemsWithNoMatches = homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink().quickOrderPadPage()
                .clickOnSpeedEntry()
                .enterPartNumberOrUPCForSpeedEntry(jibberishKeywords, data.getNumberOfRowsToEnter())
                .clickOnAddToCartButtonSpeedEntry()
                .verifyCartCountEqualToAddedToCartCount(0)
                .getItemsWithNoMatches();
        quickOrderPadPage()
                .verifyNumberOfItemsWithNoMatches(actualItemsWithNoMatches, data.getNumberOfRowsToEnter());
    }

    @Features("Quick Order Pad Module")
    @Test(groups = {"regression"})
    @TestCaseId("TC_QOP_012")
    @Description("Verification of table cell extension in 'Speed Entry' ")
    public void speedEntryCellExtension() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        loginModule.loginAsASuperUser();
        homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink().quickOrderPadPage()
                .clickOnSpeedEntry()
                .rightClickOnASpecificCell("Keyword", 1)
                .verifyRightClickOptions(data.getSpeedEntryCellExtensionOptions().split(","));
    }

    @Features("Quick Order Pad Module")
    @Test(groups = {"regression"})
    @TestCaseId("TC_QOP_013")
    @Description("Verification of 'Copy Paste' tab fields ")
    public void verifyCopyPasteSection() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        loginModule.loginAsASuperUser();
        homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink().quickOrderPadPage()
                .clickOnCopyPasteTab()
                .verifyCopyPasteSection(data.getCopyPasteSectionInstructions());
    }


    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_015")
    @Description("Verification of 'Combine' functionality in 'Copy Paste' tab")
    public void copyPasteCSVFileCombine() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnCopyPasteTab()
                .copyPasteFile(data.getCSVFilePathForCombineSeperateRemoveTest().trim())
                .clickOnAddToCartButtonInCopyPaste()
                .myCartPage()
                .clickOnCartIcon()
                .verifyNumberOfItemsInShoppingCart(1)
                .verifyQuantitiesInShoppingCartForMultipleItems("4");
    }

    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_016")
    @Description("Verification of 'Separate' functionality in 'Copy Paste' tab")
    public void copyPasteCSVFileSeperate() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnCopyPasteTab()
                .copyPasteFile(data.getCSVFilePathForCombineSeperateRemoveTest().trim())
                .clickOnSeperateButtonInCopyPaste()
                .clickOnAddToCartButtonInCopyPaste();
        Thread.sleep(5500);
        quickOrderPadPage()
                .verifyCartCountEqualToAddedToCartCount(4)
                .myCartPage()
                .clickOnCartIcon()
                .verifyNumberOfItemsInShoppingCart(4)
                .verifyQuantitiesInShoppingCartForMultipleItems("1");
    }

    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_017")
    @Description("Verification of 'Remove' functionality in 'Copy Paste' text field")
    public void copyPasteCSVFileRemove() throws Exception {
        loginModule.loginAsASuperUser();
        homePage().logout();
        homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnCopyPasteTab()
                .copyPasteFile(data.getCSVFilePathForCombineSeperateRemoveTest().trim())
                .clickOnRemoveButtonInCopyPaste()
                .clickOnAddToCartButtonInCopyPaste();
        Thread.sleep(3000);
        quickOrderPadPage()
                .verifyCartCountEqualToAddedToCartCount(1)
                .myCartPage()
                .clickOnCartIcon()
                .verifyNumberOfItemsInShoppingCart(1)
                .verifyQuantitiesInShoppingCartForMultipleItems("1");
    }


    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_018")
    @Description("Verification of Add to cart functionality when Part number is not entered in 'Copy Paste' tab")
    public void copyPasteCSVNoPartNumber() throws Exception {

        loginModule.loginAsASuperUser();
        homePage().logout();
        homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnCopyPasteTab()
                .copyPasteFile(data.getCSVFileForNoPartNumber().trim())
                .clickOnAddToCartButtonInCopyPaste();
        quickOrderPadPage().verifyAlertMessage(data.getAlertTextForInvalidFormatInCopyPaste());


    }

    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_019")
    @Description("Verification of 'Add to cart' functionality when item price is unavailable in 'Copy Paste' tab")
    public void copyPasteCSVPriceUnavailable() throws Exception {
        data.setExpectedNumberOfRowsItemsWithExceptions(1);
        loginModule.loginAsASuperUser();
        homePage().logout();
        homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnCopyPasteTab()
                .copyPasteFile(data.getCSVFilePathForNoPriceItem().trim())
                .clickOnAddToCartButtonInCopyPaste();
        int actualItemsWithException = quickOrderPadPage()
                .getItemsWithExceptions();
        quickOrderPadPage()
                .verifyNumberOfItemsWithExceptions(actualItemsWithException, data.getExpectedNumberOfRowsItemsWithExceptions())
                .verifyWhetherTheItemsAddedHaveCallForPrice(data.getExpectedNumberOfRowsItemsWithExceptions());
    }

    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_020")
    @Description("Verification of Add to cart in 'Copy Paste' tab for Invalid PartNumber.")
    public void copyPasteCSVFileInvalidPartNumber() throws Exception {
        data.setExpectedNumberOfRowsItemsWithExceptions(1);
        loginModule.loginAsASuperUser();
        homePage().logout();
        int actualItemsWithNoMatches = homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnCopyPasteTab()
                .copyPasteFile(data.getCSVFilePathInvalidPartNumber().trim())
                .clickOnAddToCartButtonInCopyPaste()
                .verifyCartCountEqualToAddedToCartCount(0)
                .getItemsWithNoMatches();
        quickOrderPadPage()
                .verifyNumberOfItemsWithNoMatches(actualItemsWithNoMatches, 1);
    }

    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_021")
    @Description("Verification of Add to cart in 'Copy Paste' tab for Invalid Quantity.")
    public void copyPasteCSVFileInvalidQty() throws Exception {
        data.setNumberOfRowsToEnter(1);
        loginModule.loginAsASuperUser();
        homePage().logout();
        homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnCopyPasteTab()
                .copyPasteFile(data.getCSVFilePathInvalidQty().trim())
                .clickOnAddToCartButtonInCopyPaste()
                .verifyAlertMessage(data.getAlertTextForInvalidQuantityInSpeedEntry() + data.getNumberOfRowsToEnter());
    }


    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_022")
    @Description("Verification of 'File Upload' tab fields ")
    public void verifyFileUploadTab() throws Exception {

        loginModule.loginAsASuperUser();
        homePage().logout();
        loginModule.loginAsASuperUser();
        homePage()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnFileUploadTab()
                .verifyFileUploadTab(data.getCartFileUploadInstructions());
    }

    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_024,TC_QOP_025")
    @Description("Verification of downloading sample template in file upload & also Verification of  sample file Template columns in file upload.")
    public void verifySampleFileDownload() throws Exception {
        String downloadedPath = "/Users/hemanthsridhar/Downloads/QuickCartExample.xlsx";

        loginModule.loginAsASuperUser();
        homePage().logout();
        loginModule.loginAsASuperUser();
        try {
            homePage()
                    .clickOnUserAccountDropdown()
                    .clickOnQuickOrderPadLink()
                    .quickOrderPadPage()
                    .clickOnFileUploadTab()
                    .clickOnClickHereLink()
                    .verifySampleFile(downloadedPath);

        } catch (UnhandledAlertException e) {
            TestUtility.alertAccept();
            throw new Exception("unhandled alert");
        } finally {
            File file = new File(downloadedPath);
            FileUtils.forceDelete(file);
        }
    }



    @Features("Quick Order Pad Module")
    @Test(groups = "regression")
    @TestCaseId("TC_QOP_027")
    @Description("Verification of 'Add to cart' functionality when the items list in .xlsx file exceeds 800 records")
    public void cartFileUploadMoreThanNRecords() throws Exception {
        homePage()
                .clickLoginLink()
                .loginPopUp()
                .enterUserName()
                .enterPassword()
                .clickOnLoginButton()
                .homePage()
                .verifyWelcomeMsg()
                .clickOnUserAccountDropdown()
                .clickOnQuickOrderPadLink()
                .quickOrderPadPage()
                .clickOnFileUploadTab()
                .uploadFile(data.getCartFileUploadForThan800Records().trim())
                .clickOnUpload()
                .verifyAlertMessage(data.getAlertTextForCartFileUploadMoreThan800Records().trim());
    }

}