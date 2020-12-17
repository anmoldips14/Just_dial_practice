package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageObjects {
    private static final Logger logger= LogManager.getLogger(SearchDescriptionPageObjects.class);
    WebDriver driver;

    public SearchPageObjects(WebDriver driver)
    {
        this.driver=driver;
    }

   /*public String ClickOnTheProductLink(int productIndex){
        //listOfProducts will have all the links displayed in the search box
        List<WebElement> listOfProducts = driver.findElements(product_link_list);
        logger.info("Number of products searched: " + listOfProducts.size());

        //Link on the  link with argument productIndex
        listOfProducts.get(productIndex).click();
        logger.info("Clicked on the Link in the List with index: " + productIndex +
                ". Link Text: " + listOfProducts.get(productIndex).getText());

        //return the text of the clicked link if further validation is required.
        return listOfProducts.get(productIndex).getText();

    }*/
}
