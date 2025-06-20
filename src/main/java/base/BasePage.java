package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.options.SelectOption;

import extentlisteners.ExtentListeners;
import org.testng.Assert;

public class BasePage {

    public static Page page;
    public static Properties OR = new Properties();
    private static FileInputStream fis;
    public static CarBase carBase;

    public BasePage(Page page) {

        this.page = page;
        carBase = new CarBase(page);
        try {
            fis = new FileInputStream("./src/main/resources/properties/OR.properties");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            OR.load(fis);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void click(String locatorKey) {
        try {
            String selector = OR.getProperty(locatorKey);
            System.out.println(selector);
            if (selector == null) {
                //log.error("Locator not found in OR.properties: " + locatorKey);
                Assert.fail("Locator not found in OR.properties: " + locatorKey);
            }
            page.locator(selector).click();
            //log.info("Clicking on Element: " + locatorKey);
            ExtentListeners.getExtent()
                    .info("Clicking on Element: " + locatorKey);
        } catch (Throwable t) {
            //log.error("Error while clicking on Element: " + locatorKey + " - " + t.getMessage());
            ExtentListeners.getExtent()
                    .fail("Error while clicking on Element: " + locatorKey + " - " + t.getMessage());
            Assert.fail(t.getMessage());
        }
    }



    public void mouseHover(String locatorKey) {
        try {
            String selector = OR.getProperty(locatorKey);
            System.out.println(selector);
            if (selector == null) {
                //log.error("Locator not found in OR.properties: " + locatorKey);
                Assert.fail("Locator not found in OR.properties: " + locatorKey);
            }
            page.locator(selector).hover();
            //log.info("Hovering over Element: " + locatorKey);
            ExtentListeners.getExtent()
                    .info("Hovering over Element: " + locatorKey);
        } catch (Throwable t) {
            //log.error("Error while hovering over Element: " + locatorKey + " - " + t.getMessage());
            ExtentListeners.getExtent()
                    .fail("Error while hovering over Element: " + locatorKey + " - " + t.getMessage());
            Assert.fail(t.getMessage());
        }
    }


    public boolean isElementPresent(String locatorKey) {

        try {
            page.waitForSelector(OR.getProperty(locatorKey), new WaitForSelectorOptions().setTimeout(2000));

            ExtentListeners.getExtent().info("Finding an Element : " + locatorKey);
            return true;
        } catch (Throwable t) {

            ExtentListeners.getExtent().fail("Error while finding an Element : " + locatorKey);

            return false;
        }

    }

    public void type(String locatorKey, String value) {
        try {
            page.locator(OR.getProperty(locatorKey)).fill(value);
            ExtentListeners.getExtent()
                    .info("Typing in an Element : " + locatorKey + " and entered the value as :" + value);
        } catch (Throwable t) {

            ExtentListeners.getExtent().fail(
                    "Error while typing in an Element : " + t.getMessage() + " error message is :" + t.getMessage());
            Assert.fail(t.getMessage());
        }
    }


    public void select(String locatorKey, String value) {
        try {
            page.selectOption(OR.getProperty(locatorKey),new SelectOption().setLabel(value));
            ExtentListeners.getExtent()
                    .info("Selecting an Element : " + locatorKey + " and selected the value as :" + value);
        } catch (Throwable t) {

            ExtentListeners.getExtent().fail(
                    "Error while Selecting an Element : " + t.getMessage() + " error message is :" + t.getMessage());
            Assert.fail(t.getMessage());
        }
    }


}