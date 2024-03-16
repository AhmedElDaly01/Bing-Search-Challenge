package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P01_Search {

    //Non-PageFactory
    public WebElement SearchBar() {
        return driver.findElement(By.id("sb_form_q"));
    }

    public WebElement SearchClick() {
        return driver.findElement(By.id("search_icon"));
    }

    public WebElement PageTwo() {
        return driver.findElement(By.cssSelector("a[aria-label=\"Page 2\"]"));
    }

    public List<WebElement> SecondPageResults() {
        return driver.findElements(By.cssSelector("ol>li[class=\"b_algo b_ccontain\"]"));
    }


    public WebElement PageThree() {
        return driver.findElement(By.cssSelector("a[aria-label=\"Page 3\"]"));
    }

    public List<WebElement> ThirdPageResults() {
        return driver.findElements(By.cssSelector("ol>li[class=\"b_algo b_ccontain\"]"));
    }


    //PageFactory
    /*
    public P01_Search(){PageFactory.initElements(driver, this);}

    @FindBy(id = "sb_form_q")
    public WebElement SearchBar;


    @FindBy(id = "search_icon")
    public WebElement SearchClick;

    @FindBy(css = "a[aria-label=\"Page 2\"]")
    public WebElement PageTwo;


    @FindBy(css = "ol>li[class=\"b_algo b_ccontain\"]")
    public List<WebElement> SecondPageResults;


    @FindBy(css = "a[aria-label=\"Page 3\"]")
    public WebElement PageThree;


    @FindBy(css = "ol>li[class=\"b_algo b_ccontain\"]")
    public List<WebElement> ThirdPageResults;
     */


}
