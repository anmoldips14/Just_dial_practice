package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchDescriptionPageObjects
{
    private static final Logger logger= LogManager.getLogger(SearchDescriptionPageObjects.class);
    WebDriver driver;

    private By search_result_page=By.id("myCarousel");
    private By search_result_list=By.xpath("//span[@class='lng_cont_name']");


public SearchDescriptionPageObjects(WebDriver driver)
{
    this.driver=driver;
}



public void ValidateResultPageIsDisplayedSuccessfully(String serachProduct)
{

    if(driver.findElement(search_result_page).isDisplayed())
    {
        Assert.assertTrue(true);
        logger.info("Search" +serachProduct+ " related page is displayed");

    }
    else
    {
        logger.fatal("Search" +serachProduct+ " related page is not displayed");
        Assert.fail("Search" +serachProduct+ " related page is not displayed");
    }
}



}
