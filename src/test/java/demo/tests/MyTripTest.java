package demo.tests;


import demo.pageobjects.BasePage;
import demo.pageobjects.MainPage;
import demo.pageobjects.PNRsearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class MyTripTest {
    private WebDriver driver;
    private final int IMPLICIT_WAIT = 10;
    private MainPage makeMyTrip;
    private SoftAssert softAssert;

    @BeforeSuite(alwaysRun=true)
    void setUp(){
        //TODO: add here check on os
        //init WD
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/v74/chromedriver");
        //for windows use: System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/v74/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        //init pages
        makeMyTrip = new MainPage(driver);
        softAssert = new SoftAssert();
    }

    /**
     *
     a. Open make my trip
     b. select train->select pnr status
     c.enter pnr and verify pnr number and status
     */
    @Test
    public void verifyPNRandStatus(){
        String pnrNumber = "8602158775";
        String pnrStatus = "This PNR is either not generated or flushed";
        makeMyTrip.open();//a
        PNRsearchPage searchResults = makeMyTrip.selectTrains().
                selectPNRstatus().//b
                enterPNRnumber(pnrNumber).
                clickCheckStatus();
        softAssert.assertTrue(searchResults.isTextOnPage(pnrNumber),
                "".format("The PNR NUMBER: %s was not found in the pnr search results," +
                                " \n Actual page source does not contain the number : \n%s",
                        pnrNumber, searchResults.getPageSource()));
        softAssert.assertTrue(searchResults.isTextOnPage(pnrStatus),
                "".format("The PNR STATUS: '%s'  was not found in the pnr search results," +
                        " \n Actual page source does not contain the status text : \n%s",
                pnrStatus, searchResults.getPageSource()));
        softAssert.assertAll();
    }

    @AfterSuite(alwaysRun=true)
    void tearDown(){
        driver.quit();
    }
    }
