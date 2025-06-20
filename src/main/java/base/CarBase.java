package base;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import extentlisteners.ExtentListeners;

import static base.BasePage.OR;

public class CarBase {
	
	
	public Page page;
	
	public CarBase(Page page) {
		
		this.page = page;
	}



	public String getCarTitle(String title) {
		try {
			String selector = OR.getProperty("carTitle_XPATH");
			if (selector == null) {
				//log.error("Locator not found in OR.properties: carTitle_XPATH");
				Assert.fail("Locator not found in OR.properties: carTitle_XPATH");
			}
			String carTitle = page.locator(selector).innerText();
			//log.info("Fetched Car Title for heading: " + title + " - Found: " + carTitle);
			ExtentListeners.getExtent()
					.info("Finding Car with Heading: " + title + " - Found: " + carTitle);
			return carTitle;
		} catch (Throwable t) {
			//log.error("Error while finding car with heading: " + title + " - " + t.getMessage());
			ExtentListeners.getExtent()
					.fail("Error while finding car with heading: " + title + " - " + t.getMessage());
			Assert.fail(t.getMessage());
			return null;
		}
	}



	public void getCarBrandNameAndPrices() {

		Locator carNames = page.locator(OR.getProperty("carNames_XPATH"));
		Locator carPrices = page.locator(OR.getProperty("carPrices_XPATH"));

		for(int i=0; i<carPrices.count(); i++) {
			
			System.out.println(carNames.nth(i).innerText()+"----Car price is : "+carPrices.nth(i).innerText());
			
		}
		
	}

}
