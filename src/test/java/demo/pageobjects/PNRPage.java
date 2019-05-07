package demo.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PNRPage extends BasePage{
    private String url;
    private By pnrInpt = By.id("pnr");
    private By checkStatusBtn = By.xpath("//a[contains(@class, 'primaryBtn')]");

    PNRPage(WebDriver driver){
        super(driver);
        this.url = BASEURL + "/railways/PNR";
    }

    public String open(){
        return openThe(url);
    }

    @Step("Enter 10 digits to the PNR NUMBER input field")
    public PNRPage enterPNRnumber(String digits){
        WebElement pnrInput = waitOnElementToBeClickable(pnrInpt);
        pnrInput.clear();
        pnrInput.sendKeys(digits);
        wait.until(ExpectedConditions.attributeToBe(pnrInput,"value", digits));
        return this;
    }

    @Step("Click on CHECK STATUS")
    public PNRsearchPage clickCheckStatus(){
        waitOnElementToBeClickable(checkStatusBtn).click();
        return new PNRsearchPage(driver);
    }


}
