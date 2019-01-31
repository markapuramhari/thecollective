package org.thecollective.pageobjects.homepage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.SearchDataPropertyFile;
import org.thecollective.utils.Waiting;

import ru.yandex.qatools.allure.annotations.Step;

public class StoresPageObjects extends PageFactoryInitializer{
	SearchDataPropertyFile data=new SearchDataPropertyFile();

	@FindAll(value={@FindBy(xpath="//h4[contains(@class,'city-heading')]")})
	private List<WebElement> storeBranchesNames;
	
	
	
	
	@Step("verify stores page Title")
	public StoresPageObjects verifyPageTitle() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Assert.assertEquals(driver.getTitle(),"Stores"+" | "+data.getProductName(),"Stores page title is worng");

		return this;
	}

	@Step("verify available store branches")
	public StoresPageObjects verifyAvailableStores(String storeBanches) {
		String expStoreBranch[]=storeBanches.split(",");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Waiting.explicitWaitVisibilityOfElements(storeBranchesNames, 15);
		for(int i=0;i<storeBranchesNames.size();i++)
		{
			
			//System.out.println(storeBranchesNames.get(i).getText().trim());
		Assert.assertEquals(storeBranchesNames.get(i).getText().trim(), expStoreBranch[i].trim());
		}
		return this;
	}

}
