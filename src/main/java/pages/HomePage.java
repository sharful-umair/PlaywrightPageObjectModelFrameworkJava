package pages;

import com.microsoft.playwright.Page;

import base.BasePage;

public class HomePage extends BasePage {
	

	public HomePage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}


	public void findNewCars() {
		
		mouseHover("newCarsMenu_XPATH");
		click("findNewCars_XPATH");
		//page.hover("//div[normalize-space()='NEW CARS']");
		//page.click("//div[contains(text(),'Find New Cars')]");
		
	}
	
	
	public void searchCars() {
		
		
	}
	
	
	public void validateFeaturedCars() {
		
		
		
	}

}
