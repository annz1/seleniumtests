package demo.tests;


import demo.pageobjects.BasePage;
import demo.pageobjects.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyTripTest {
    private WebDriver driver;
    private final int IMPLICIT_WAIT = 10;
    private MainPage makeMyTrip;

    @BeforeSuite(alwaysRun=true)
    void setUp(){
        //TODO: add here check on os
        //init WD
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/v74/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        //init pages
        makeMyTrip = new MainPage(driver);

        System.out.println("SetUp");
    }

    /**
     *
     a. Open make my trip
     b. select train->select pnr status
     c.enter pnr and verify pnr number and status
     */
    @Test
    public void verifyPNRStatus(){
        makeMyTrip.open();//a
        makeMyTrip.selectTrains().
                selectPNRstatus().//b
                enterPNRnumber("8602158775").
                clickCheckStatus();
    }

    @AfterSuite(alwaysRun=true)
    void tearDown(){
        driver.quit();
    }
    }
