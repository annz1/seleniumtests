package demo.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final String BASEURL = "https://www.makemytrip.com";

    protected WebDriver driver;
    protected WebDriverWait wait;

    BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    /*
    open the base page
     */
    @Step("Open the page: " + BASEURL)
    public String open(){
        driver.get(BASEURL);
        return driver.getCurrentUrl();
    }

    @Step("Open the page: ")
    public String openThe(String url){
        driver.get(url);
        return driver.getCurrentUrl();
    }

    public WebElement waitOnElementToBeClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }



}
