package demo.tests;


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
    private WebDriverWait wait;
    @BeforeSuite(alwaysRun=true)
    void setUp(){
        //TODO: add here check on os
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/v74/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(driver, 15);
        System.out.println("SetUp");
    }

    /**
     *
     a. Open make my trip
     b. select train->select pnr status
     c.enter pnr and verify pnr number and status
     */
    @Test
    public void verifyPnrStatus(){

        System.out.println("Open make my trip");
        driver.get("https://www.makemytrip.com/");//a
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//nav//a[contains(@href,'/railways')]")))).click();//b
        WebElement pnr_status = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'PNR')]"))));
        pnr_status.click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("pnr")))).sendKeys("8602158775");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(@class, 'primaryBtn')]")))).click();
    }

    @AfterSuite(alwaysRun=true)
    void tearDown(){
        driver.quit();
    }
    }
