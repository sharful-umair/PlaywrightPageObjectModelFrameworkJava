package pages;

import com.microsoft.playwright.Page;

import base.BasePage;

public class NewCarsPage  extends BasePage{

	

	public NewCarsPage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

	public void gotoHonda() {

		page.click("//div[normalize-space()='Honda']");
	}

	public void gotoToyota() {

		page.click("//div[normalize-space()='Toyota']");
	}

	public void gotoKia() {

		page.click("//div[normalize-space()='Kia']");
	}

	public void gotoBMW() {

		page.click("//div[normalize-space()='BMW']");
	}
}
