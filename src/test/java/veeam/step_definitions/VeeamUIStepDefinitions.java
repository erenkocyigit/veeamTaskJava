package veeam.step_definitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.support.ui.WebDriverWait;
import veeam.pages.SearchPage;
import veeam.utilities.BrowserUtils;
import veeam.utilities.ConfigurationReader;
import veeam.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VeeamUIStepDefinitions {
    SearchPage searchPage = new SearchPage();

    int countOfJobs;
    int expectCountOfJobs;

    @Given("user is on careers page")
    public void user_is_on_careers_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user selects {string} in All Departments dropdown")
    public void userChooseInAllDepartmentsSelectButton(String department) {
        searchPage.acceptCookies.click();
        searchPage.allDepartmentsSelect.click();
        BrowserUtils.clickNonSelectDropdown(searchPage.allDepartments, department);
    }

    @And("user selects {string} language in All Languages list")
    public void userChooseLanguageInAllLanguagesList(String selectedDepartment) {
        searchPage.allLanguagesButton.click();
        BrowserUtils.clickNonSelectDropdown(searchPage.allLanguages, selectedDepartment);

    }

    @Then("assert that number of jobs found will match expected result")
    public void assertThatNumberOfJobsFoundWillMatchExpectedResult() {
        countOfJobs = Integer.parseInt(searchPage.countOfExpectedJobs.getText());
        expectCountOfJobs = searchPage.jobs.size();
        Assert.assertNotEquals("Expected value is not equal actual value", expectCountOfJobs, countOfJobs);
    }
}
