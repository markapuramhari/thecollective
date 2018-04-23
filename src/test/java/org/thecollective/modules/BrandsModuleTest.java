package org.thecollective.modules;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.thecollective.maincontroller.PageFactoryInitializer;

import com.jayway.restassured.response.Response;

import ru.yandex.qatools.allure.annotations.Description;

public class BrandsModuleTest extends PageFactoryInitializer{
	
	@Description("verify view all brands link")
	@Test
	public void verifyViewAllBrandsLinkforMen() throws InterruptedException{
		
		homePage()
		.clickOnViewAllBrandsLink("Men")
		.brandsPage().verifyBrandDirectoryPage();
		}
	@Description("verify view all brands link for women's category")
	@Test
	public void verifyViewAllBrandsLinkforWomen() throws InterruptedException{
		homePage()
		.clickOnViewAllBrandsLink("Women")
		.brandsPage().verifyBrandDirectoryPage();
				
	}
	@Description("verify view all brands link for women's category")
	@Test
	public void verifyProductsForWomenCategory() throws Exception{
		homePage()
		.clickOnViewAllBrandsLink("Women")
		.brandsPage()
		.verifyBrandDirectoryPage();
		String selectedGenderId=brandsPage().selectGender("Women");
		List<String> selectedCategoryCode=brandsPage().selectCategory(selectedGenderId,"Women");
		
		//System.out.println(selectedGenderId + selectedCategoryCode.toString());
				
	}
	@Description("verify view all brands link for men's category")
	@Test
	public void verifyProductsForMenCategory() throws Exception{
		homePage()
		.clickOnViewAllBrandsLink("Men");
		//driver.get("https://preprod.thecollective.in/brandautomation");
		brandsPage()		
		.verifyBrandDirectoryPage();
		String selectedGenderId=brandsPage().selectGender("Men");
		List<String> selectedCategoryCode=brandsPage().selectCategory(selectedGenderId,"Men");
				
	}
	@Test
	public void restCallForBrandDirectory() throws Exception
	{
		verifyProductsForMenCategory();
		verifyProductsForWomenCategory();
	
		
	}
	@Test
	public void checkAllStaticBrandsMen() throws InterruptedException
	{
	homePage()
	.clickOnMenBrandLinks();
	
	}
	@Test
	public void checkAllStaticBrandsWomen() throws InterruptedException
	{
	homePage()
	.clickOnWomenBrandLinks();
	
	}
	
	
	
	

}
