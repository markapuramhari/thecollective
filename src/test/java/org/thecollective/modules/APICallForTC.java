package org.thecollective.modules;

import java.io.IOException;

import org.testng.annotations.Test;
import org.thecollective.dataprovider.DataDrivenTestingFromExcel;
import org.thecollective.maincontroller.PageFactoryInitializer;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;

public class APICallForTC extends PageFactoryInitializer{
	
	@Test(groups = { "regression" },dataProvider="MRPDataProvider",dataProviderClass=DataDrivenTestingFromExcel.class)
	@Features("APICall")
	@Description("test product mrp price")
	public void fetchProductPrice() throws IOException, Exception {
		
		
	}

}
