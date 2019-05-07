package demo.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{
    private String url = "/";

    //selectors
    private By trainsLnk = By.xpath("//nav//a[contains(@href,'/railways')]");
    //private By
    public MainPage(WebDriver driver){
        super(driver);
    }

    @Step("Select Trains within the navigation panel")
    public RailwaysPage selectTrains() {
        waitOnElementToBeClickable(trainsLnk).click();
        return new RailwaysPage(driver);
    }


}
