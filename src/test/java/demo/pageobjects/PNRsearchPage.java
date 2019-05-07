package demo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class PNRsearchPage extends BasePage {
    private String url;
    //locator pattern to find the pnr number or status text in search reults
    private String pnrCardTxt = "//div[contains(@class,'card')]//p[contains(text(),'%s')]";


    PNRsearchPage(WebDriver driver){
        super(driver);
        this.url = BASEURL + "/railways/pnrsearch";
    }


    public Boolean isTextOnPage(String text){
        By pnrCardInfo = By.xpath("".format(pnrCardTxt, text));
        try {
            waitOnElement(pnrCardInfo);
        }
        catch (WebDriverException we){
            System.out.println(we.getMessage());
            return false;
        }
        return true;
    }





}
