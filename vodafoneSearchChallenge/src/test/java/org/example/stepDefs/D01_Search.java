package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Search;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D01_Search {
    P01_Search BingSearch = new P01_Search();

    @When("user searches for {string} on Bing")
    public void userSearchesForOnBing(String Vodafone) {

        BingSearch.SearchBar().sendKeys(Vodafone);

        //BingSearch.SearchBar.sendKeys(Keys.ENTER);
        BingSearch.SearchClick().click();
    }

    @And("user scroll down and click on the second page of search")
    public void userScrollDownAndClickOnTheSecondPageOfSearch() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 4000)");

        Thread.sleep(1000);
        BingSearch.PageTwo().click();

    }

    @And("the second page results are counted")
    public void theSecondPageResultsAreCounted() throws InterruptedException {

        Thread.sleep(1000);

        int NumberOfResults = BingSearch.SecondPageResults().size();

//        System.out.println(NumberOfResults);
//        Assert.assertEquals(NumberOfResults, 10);

    }

    @And("user moves to the third page")
    public void userMovesToTheThirdPage() {


        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 4000)");

        BingSearch.PageThree().click();

    }

    @Then("the number of search results on the second page should be equal to the number on the third page")
    public void theNumberOfSearchResultsOnTheSecondPageShouldBeEqualToTheNumberOnTheThirdPage() {

        SoftAssert soft = new SoftAssert();

        int secondResults = BingSearch.SecondPageResults().size();
        int thirdResults = BingSearch.ThirdPageResults().size();

        soft.assertEquals(secondResults, thirdResults);


        soft.assertAll();
    }

}
