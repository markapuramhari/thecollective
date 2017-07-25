package org.thecollective.modules;

import java.util.List;

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
	public void verifyProductsForMeCategory() throws Exception{
		homePage()
		.clickOnViewAllBrandsLink("Men")
		.brandsPage()
		.verifyBrandDirectoryPage();
		String selectedGenderId=brandsPage().selectGender("Men");
		List<String> selectedCategoryCode=brandsPage().selectCategory(selectedGenderId,"Men");
				
	}
	@Test
	public void restCallForBrandDirectory() throws Exception{
		verifyProductsForMeCategory();
		verifyProductsForWomenCategory();
	
		
	}
	
	

}
