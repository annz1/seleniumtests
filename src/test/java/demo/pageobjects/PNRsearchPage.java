package demo.pageobjects;

import org.openqa.selenium.WebDriver;

public class PNRsearchPage extends BasePage {
    private String url;

    PNRsearchPage(WebDriver driver){
        super(driver);
        this.url = BASEURL + "/railways/pnrsearch";
    }

}
