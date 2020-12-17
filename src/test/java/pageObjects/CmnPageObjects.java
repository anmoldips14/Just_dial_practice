package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CmnPageObjects {
    private static final Logger logger= LogManager.getLogger(CmnPageObjects.class);
    WebDriver driver;



    private  By search_txt_box=By.id("srchbx");
    private By search_btn=By.xpath("//button[@class='search-button']");
    private By nav_logo=By.xpath("//a[@class='pull-left logo']//img[@alt='Justdial']");
    private By search_city=By.xpath("//div[@class='search-city mnsrchwpr']");
    private By side_menu_link_list=By.xpath("//ul[@class='hotkeys-list ']//li//a");///span[@class='hotkeys-text']
    private By customer_care_btn=By.xpath("//div[@class='rightfixed']//a[@class='cscare ']");
    private By sautosearch_suggestion_drpdwn_search_btn=By.xpath("//div[@class='sautoM']//ul[@id='auto']//a");

    public CmnPageObjects(WebDriver driver)
    {
        this.driver=driver;
    }


    public void ClickOnHSideMenuLink(String clickLink)
    {
        List<WebElement> menuLink=driver.findElements(side_menu_link_list);
        for(int i=0;i<menuLink.size();i++)
        {
            WebElement element=menuLink.get(i);
            String innerHtml=element.getText();
            //String innerHtml=element.getAttribute("innerHTML");
            if(innerHtml.equalsIgnoreCase(clickLink))
            {
                element.click();
                System.out.println(clickLink);
                break;
            }
           // System.out.println(innerHtml);
            logger.info("Clicked on the link"+ clickLink );

        }


    }
    public void validatePageTitleMatch(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
        Assert.assertEquals("Title Validation",true, b);
        logger.info("Page title matched: " + expectedTitle );
    }


    public void SetSearchTextBox(String text) {
        WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(search_txt_box));
        elementSearchBox.clear();
        elementSearchBox.sendKeys(text);
        logger.info("Value entered in search box: " + text);
    }

    public void ClickOnSearchButton() {
        driver.findElement(search_btn).click();
        logger.info("Clicked on Search Button");
    }

    public void CustomerCarebtnIsDispalyed()
    {
        boolean b = driver.findElement(customer_care_btn).isDisplayed();
        Assert.assertEquals("Customer care button", true, b);
    }
    public void CustomerCareBtnClick()
    {
        driver.findElement(customer_care_btn).click();
        logger.info("Clicked on Customer Cre button");

    }

    public void UserCanSeeAllItemsUnderSearchDrpDwn(String serchName) {
        List<WebElement> menuLink = driver.findElements(sautosearch_suggestion_drpdwn_search_btn);
        for (int i = 0; i < menuLink.size(); i++) {
            WebElement element = menuLink.get(i);
            //String innerHtml=element.getAttribute("innerHTML");
            String innerHtml = element.getText();
            //String innerHtml=element.getAttribute("innerHTML");
            if (innerHtml.contains(serchName)) {
               logger.info("Result option get in dropdown related to:" + serchName);
            }
        }
    }

/*for(WebElement element:menuLink)
        {
            String innerHtml=element.getAttribute("innerHTML");
            if(innerHtml.contains(clickLink))
            {
                element.click();
                break;
            }

        }*/



}
