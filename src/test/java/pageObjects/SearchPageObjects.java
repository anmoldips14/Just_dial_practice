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


}
