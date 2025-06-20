package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.HomePage;
import pages.NewCarsPage;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;

public class CarNamesAndPriceTest extends BaseTest{
	
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "dp")
	public void carNamesAndPrices(Hashtable<String,String> data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("CarWaleSuite", "carNamesAndPrices", data.get("Runmode"), excel);
		browser = getBrowser(data.get("browser"));
		navigate(browser,Constants.URL);

		HomePage home = new HomePage(page);
		home.findNewCars();
		NewCarsPage cars = new NewCarsPage(page);
		
		if(data.get("carBrand").equals("kia")) {
			
			cars.gotoKia();
		}else if(data.get("carBrand").equals("toyota")) {
			
			cars.gotoToyota();
		}else if(data.get("carBrand").equals("honda")) {
			
			cars.gotoHonda();
		}else if(data.get("carBrand").equals("bmw")) {
			
			cars.gotoBMW();
		}
		
		System.out.println(BasePage.carBase.getCarTitle(data.get("carTitle")));

		BasePage.carBase.getCarBrandNameAndPrices();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
