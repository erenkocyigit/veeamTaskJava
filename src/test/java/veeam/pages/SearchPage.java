package veeam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import veeam.utilities.Driver;

import java.util.List;

public class SearchPage {
    public SearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


    public static Integer countOfJobs;
    public static Integer actualCountofJobs;

    @FindBy(xpath = "//div[@id='cookiescript_accept']")
    public WebElement acceptCookies;

    @FindBy(xpath = "//button[.='All departments']")
    public WebElement allDepartmentsSelect;

    @FindBy(css = ".dropdown-menu a")
    public List<WebElement> allDepartments;

    @FindBy(xpath = "//a[.='Research & Development']")
    public WebElement researchAndDevelopment;

    @FindBy(xpath = "//button[.='All languages']")
    public WebElement allLanguagesButton;

    @FindBy(css = ".custom-control-label")
    public List<WebElement> allLanguages;

    @FindBy(xpath = "//label[@for='lang-option-0']")
    public WebElement englishLanguage;

    @FindBy(xpath = "//div[@class='card-header pb-2']")
    public List<WebElement> jobs;

    @FindBy(xpath = "//span[@class='text-secondary pl-2']")
    public WebElement countOfExpectedJobs;


    public Integer convertingofcountofJobs() {
        return countOfJobs = Integer.parseInt(countOfExpectedJobs.getText());
    }

    public Integer countOfActualJobs() {
        return actualCountofJobs = jobs.size();
    }


}
