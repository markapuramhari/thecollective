package org.etna.customer.pageobjects.quickorder;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import org.etna.customer.pageobjects.myaccount.MyAccountsPageObjects;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class QuickOrderPageObjects extends PageFactoryInitializer {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	 ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@FindBy(xpath="//a[contains(text(),'File Upload')]")
	private WebElement fileUploadTabLocator;

	@FindBy(xpath="//div[contains(@id,'customFileUpload')]/input")
	private WebElement chooseFileLocator;
	
	@FindBy(xpath="//a[contains(@href,'itemsInCart')]")
	private WebElement addedToCartCountInFileUploadLocator;
	
	@FindBy(xpath="//div[contains(@class,'navigationBar')]/descendant::span[contains(@id,'cartCountrefresh')]")
	private WebElement shoppingCartCountLocator;
	
	@FindBy(xpath="//input[@value='Upload']")
	private WebElement uploadButtonLocator;
	
	@FindBy(xpath="//a[contains(@href,'copyPaste')]")
	private WebElement copyPasteTabLocator;
	
	@FindBy(xpath="//textarea[@id='copyPasteText']")
	private WebElement copyPasteSectionLocator;
	
	@FindBy(xpath="//div[@id='copyPaste']/descendant::input[@value='Add to Cart']")
	private WebElement addToCartButtonInCopyPasteSectionLocator;
	
	@FindAll(value={@FindBy(xpath="//tbody/tr/td[@class='htAutocomplete']")})
	private List<WebElement> partNumberUPCTableRowsLocator;
	
	@FindBy(xpath="//a[contains(@href,'typeItems')]")
	private WebElement speedEntryTabLocator;
	
	@FindBy(xpath="//h2")
	private WebElement pageNameLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@id='fileUpload']/div[@class='cimm_quickOrderInstruction']/descendant::li")})
	private List<WebElement> cartFileUploadInstructionsLocator;
	
	@FindBy(xpath="//div[contains(@class,'uploadForm')]/descendant::span[contains(text(),'Separate')]")
	private WebElement seperateButtonLocator;
	
	@FindBy(xpath="//div[@class='quickorderTableEnclosure']/descendant::span[contains(text(),'Separate')]")
	private WebElement seperateButtonSpeedEntryLocator;
	
	@FindBy(xpath="//div[contains(@class,'uploadForm')]/descendant::span[contains(text(),'Remove')]")
	private WebElement removeButtonLocator;
	
	@FindBy(xpath="//div[contains(@class,'quickorderTableEnclosure')]/descendant::span[contains(text(),'Remove')]")
	private WebElement removeButtonSpeedEntryLocator;
	
	@FindBy(id="submitBtnPad")
	private WebElement addToCartButtonSpeedEntryLocator;
	
	@FindBy(xpath="//div[@class='quickorderTableEnclosure']/descendant::span[contains(text(),'Combine')]")
	private WebElement combineInSpeedEntryLinkLocator;
	
	@FindBy(xpath="//div[@id='typeItems']/div[@class='cimm_quickOrderInstruction']")
	private WebElement speedEntryInstructionsLocator;
	
	By tableName=By.className("htCore");
	
    By headerNameRow=By.className("colHeader");
    
    By invalidQuantityLocator = By.className("htInvalid");
    
    @FindAll(value={@FindBy(xpath="//div[@class='ht_master handsontable']/descendant::span[@class='colHeader columnSorting']")})
    private List<WebElement> speedEntryColumnsLocator;
    

    @FindAll(value={@FindBy(xpath="//div[@class='ht_master handsontable']/descendant::span[@class='rowHeader']")})
    private List<WebElement> speedEntryRowsLocator;
    
    @FindAll(value={@FindBy(xpath="//div[@class='htItemWrapper']")})
    private List<WebElement> speedEntryRightClickOptionsLocator;
    
    
    
	@Step("click on file upload tab")
	public QuickOrderPageObjects clickOnFileUploadTab() {
		Waiting.explicitWaitVisibilityOfElement(fileUploadTabLocator, 10);
		fileUploadTabLocator.click();
		return this;
	}

	@Step("upload a file with file path {0}")
	public QuickOrderPageObjects uploadFile(String cartFileUploadPath) throws InterruptedException {
		Thread.sleep(1500);
		File file = new File(cartFileUploadPath);
		chooseFileLocator.sendKeys(file.getAbsolutePath());
		return this;
	}

	@Step("click on file upload tab")
	public QuickOrderPageObjects clickOnCopyPasteTab() {
		Waiting.explicitWaitVisibilityOfElement(copyPasteTabLocator, 10);
		copyPasteTabLocator.click();
		return this;
	}

	public int getAddedToCartCount() {
		Waiting.explicitWaitVisibilityOfElement(addedToCartCountInFileUploadLocator, 20);
	 
		return Integer.parseInt(addedToCartCountInFileUploadLocator.getText().replace("ADDED TO CART", "").replace(")", "").replace("(", "").replace(" ", "").trim());
	}

	@Step("verify cart count equal to {0}")
	public QuickOrderPageObjects verifyCartCountEqualToAddedToCartCount(int addedToCartCount) {
		Waiting.explicitWaitVisibilityOfElement(shoppingCartCountLocator, 6);
		Assert.assertEquals(Integer.parseInt(shoppingCartCountLocator.getText().replace("ITEM(S)", "").replace(" ", "").replace("(", "").replace(")", "").trim()), addedToCartCount);
		return this;
	}

	@Step("click on upload")
	public QuickOrderPageObjects clickOnUpload() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",uploadButtonLocator);
		return this;
	}

	@Step("copy paste file whose file path is {0}")
	public QuickOrderPageObjects copyPasteFile(String relativeFilePath) throws Exception {
		Thread.sleep(2000);
		copyPasteSectionLocator.click();
		String line = "";
		File absolutePath = new File(relativeFilePath);
		BufferedReader br = new BufferedReader(new FileReader(absolutePath.getAbsolutePath()));
		while ((line = br.readLine()) != null) {
			copyPasteSectionLocator.sendKeys(line+"\n");
	}
		return this;
}

	@Step("copy paste file whose file path is {0}")
	public QuickOrderPageObjects copyPasteTxtFile(String relativeFilePath) throws Exception {
		Thread.sleep(1500);
		copyPasteSectionLocator.click();
		  String line = "";
		  File absolutePath = new File(relativeFilePath);
		  BufferedReader br = new BufferedReader(new FileReader(absolutePath.getAbsolutePath()));
		  while ((line = br.readLine()) != null) {
		   
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(line), null);
		  
		 copyPasteSectionLocator.sendKeys(Keys.CONTROL + "v");
		 copyPasteSectionLocator.sendKeys(Keys.ENTER);
	
		  }
		return this;
}
	
	@Step("click on add to cart button")
	public QuickOrderPageObjects clickOnAddToCartButton() {
		Waiting.explicitWaitVisibilityOfElement(shoppingCartCountLocator, 30);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",addToCartButtonInCopyPasteSectionLocator);
		return this;
	}


	@Step("click on speed entry")
	public QuickOrderPageObjects clickOnSpeedEntry() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(speedEntryTabLocator, 10);
		speedEntryTabLocator.click();
		return this;
	}

	

	public boolean verifyAlertText(String expectedAlertMessage){
		boolean t = TestUtility.getAlertText().replace("\n", "").trim().equals(expectedAlertMessage);
		TestUtility.alertAccept();
		return t;	
	}

	@Step("verify alert message is {0}")
	public QuickOrderPageObjects verifyAlertMessage(String expectedAlertMessage) throws Exception{
		Assert.assertTrue(verifyAlertText(expectedAlertMessage));
		return this;
	}
	
	@Step("upload file whose file path is {0}")
	public QuickOrderPageObjects uploadViaRobot(String filePath) throws AWTException {
		Robot robot = new Robot();
		File file = new File(filePath);
		StringSelection ss = new StringSelection(file.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		return this;
	}


	@Step("verify quick order pad page")
	public QuickOrderPageObjects verifyQuickOrderPage() {
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim().equalsIgnoreCase("Quick Order"));
		Assert.assertTrue(pageNameLocator.getText().trim().equalsIgnoreCase("Quick Order"));
		Assert.assertTrue(speedEntryTabLocator.getAttribute("class").equals("active"));
		Assert.assertTrue(copyPasteTabLocator.getAttribute("class").equals(""));
		Assert.assertTrue(fileUploadTabLocator.getAttribute("class").equals(""));
		return this;
	}

	@Step("click on seperate button")
	public QuickOrderPageObjects clickOnSeperateButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",seperateButtonLocator);
		return this;
	}

	@Step("click on remove button")
	public QuickOrderPageObjects clickOnRemoveButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",removeButtonLocator);
		return this;
	}

	@Step("Enter part number or upc {0} and the number of rows to enter is {1}")
	public QuickOrderPageObjects enterPartNumberOrUPCForSpeedEntry(String []keyword, int numberOfRowsToEnter) throws Exception {
		
	        
	        for(int i=0;i<numberOfRowsToEnter;i++)
	        {
	        String [] partNumberUPC = keyword[i].split(":");
	       TestUtility.headerindex = TestUtility.headers(tableName,headerNameRow);
	        TestUtility.enterDataInHandsOnTable(i+1,"Keyword",partNumberUPC[0]);
	        TestUtility.enterDataInHandsOnTable(i+1,"Quantity",partNumberUPC[1]); 
	        }
	        copyPasteTabLocator.click();
	        Thread.sleep(1500);
	        speedEntryTabLocator.click();
	        Thread.sleep(1500);
		return this;
	}

	@Step("click on add to cart button in speed entry")
	public QuickOrderPageObjects clickOnAddToCartButtonSpeedEntry() {
		Waiting.explicitWaitVisibilityOfElement(addToCartButtonSpeedEntryLocator, 6);
		addToCartButtonSpeedEntryLocator.click();
		return this;
	}

	public QuickOrderPageObjects clickOnCombineOptionInSpeedEntry() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",combineInSpeedEntryLinkLocator);
		return this;
	}

	public QuickOrderPageObjects enterPartNumberOrUPCForSpeedEntryForCombine(String[] partNumberOrUpc, int numberOfRowsToEnter) throws Exception {
		
        for(int i=0;i<numberOfRowsToEnter;i++)
        {
        String [] partNumberUPC = partNumberOrUpc[0].split(":");
       TestUtility.headerindex = TestUtility.headers(tableName,headerNameRow);
        TestUtility.enterDataInHandsOnTable(i+1,"Keyword",partNumberUPC[0]);
        TestUtility.enterDataInHandsOnTable(i+1,"Quantity",partNumberUPC[1]); 
        }
        copyPasteTabLocator.click();
        Thread.sleep(1500);
        speedEntryTabLocator.click();
        Thread.sleep(3000);
		return this;
	}

	public QuickOrderPageObjects clickOnSeperateButtonSpeedEntry() {
		seperateButtonSpeedEntryLocator.click();
		return this;
	}

	public QuickOrderPageObjects clickOnRemoveButtonSpeedEntry() {
		Waiting.explicitWaitVisibilityOfElement(removeButtonSpeedEntryLocator, 5);
		removeButtonSpeedEntryLocator.click();
		return this;
	}

	public QuickOrderPageObjects enterInvalidQuantityInSpeedEntry(String quantity) throws Exception{
	
        TestUtility.headerindex = TestUtility.headers(tableName,headerNameRow);
		TestUtility.enterDataInHandsOnTable(1, "Quantity", quantity);
		return this;
	}
	public QuickOrderPageObjects verifyInvalidQuantityColour(String invalidQuantityColourChrome,String invalidQuantityColourFirefox) throws InterruptedException, Exception {
		
		List<WebElement> invalidQuantity = driver.findElements(invalidQuantityLocator);
		for(int i = 0 ; i<invalidQuantity.size(); i++)
			
		{
			if(setUp.getBrowser().equals("firefox"))
			{
				Waiting.explicitWaitVisibilityOfElement(speedEntryInstructionsLocator, 3);
				Assert.assertEquals(invalidQuantity.get(i).getCssValue("background-color"),invalidQuantityColourFirefox,"Actual is "+invalidQuantity.get(i).getCssValue("background-color")+", Expecting"+invalidQuantityColourFirefox);
			}
			else
			{
			Assert.assertEquals(invalidQuantity.get(i).getCssValue("background-color"),invalidQuantityColourChrome,"Actual is "+invalidQuantity.get(i).getCssValue("background-color")+", Expecting "+invalidQuantityColourChrome);
			}
			}
		
		return this;
	}

	public QuickOrderPageObjects verifySpeedEntryTab(String speedEntryInstructions) {
		Waiting.explicitWaitVisibilityOfElement(speedEntryInstructionsLocator, 6);
		Assert.assertEquals(speedEntryInstructionsLocator.getText().replace("\n", "").trim(),speedEntryInstructions, "Speed entry instructions is wrong.");
		Assert.assertTrue(addToCartButtonSpeedEntryLocator.isDisplayed(),"Add to cart button is not displayed in speed entry tab.");
		Assert.assertEquals(speedEntryColumnsLocator.size(),2,"Number of columns is not 2. It is "+speedEntryColumnsLocator.size());
		Assert.assertEquals(speedEntryRowsLocator.size(),10,"Number of rows is not 10. It is "+speedEntryRowsLocator.size());	
		return this;
	}

	public QuickOrderPageObjects rightClickOnASpecificCell(String header, int cellNumber) throws Exception {
		  TestUtility.headerindex = TestUtility.headers(tableName,headerNameRow);
		  TestUtility.rightCickOnCell(cellNumber,header);
		 
		return this;
	}

	public QuickOrderPageObjects verifyRightClickOptions(String[] speedEntryExtensionOptions) {
		 Waiting.explicitWaitVisibilityOfElements(speedEntryRightClickOptionsLocator, 3);
		  for(int i = 0 ; i < speedEntryRightClickOptionsLocator.size() ; i++)
		  {
			  Assert.assertEquals(speedEntryRightClickOptionsLocator.get(i).getText().trim(),speedEntryExtensionOptions[i]);
		  }
		  return this;
		
	}

	public QuickOrderPageObjects enterKeywordOrQtyBut1FieldIsEmpty(String[] keyword, String header, int numberOfRowsToEnter) throws Exception {
		  TestUtility.headerindex = TestUtility.headers(tableName,headerNameRow);
		  if(header.equals("Keyword"))
		  {
		  for(int i = 0 ; i< numberOfRowsToEnter ; i++)
		  {
	        TestUtility.enterDataInHandsOnTable(i+1,header,keyword[i]);
		  }
		  }
		  else if(header.equals("Quantity"))
		  {
			  for(int i = 0 ; i< numberOfRowsToEnter ; i++)
			  {
		        TestUtility.enterDataInHandsOnTable(i+1,header,keyword[i+1]);
			  }
		  }
		return this;
	}
}
