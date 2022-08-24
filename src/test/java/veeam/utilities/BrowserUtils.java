package veeam.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {


    public static void sleep(int value){
        try{
            Thread.sleep(value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clickNonSelectDropdown(List<WebElement> nonSelectDropdown,String attributeValue){
        for (WebElement each : nonSelectDropdown) {
            if (each.getText().equals(attributeValue)){
                waitForElementToBeClickable(each);
                each.click();
                break;
            }
        }
    }
    public static void waitForElementToBeClickable(WebElement webElement){
     //   Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));

    }
    public static void waitForVisibilityOf(WebElement webElement) {
        // Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(webElement));

    }

}
