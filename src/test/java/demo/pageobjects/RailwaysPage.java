package demo.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RailwaysPage extends BasePage {
    private String url;
    private By pnrStatus = By.xpath("//span[contains(text(),'PNR')]");

    RailwaysPage(WebDriver driver){
        super(driver);
        this.url = BASEURL + "/railways";
    }

    public String open(){
        return openThe(url);
    }

    @Step("SELECT PNR STATUS")
    public PNRPage selectPNRstatus() {
        waitOnElementToBeClickable(pnrStatus).click();
        return new PNRPage(driver);
    }
}
