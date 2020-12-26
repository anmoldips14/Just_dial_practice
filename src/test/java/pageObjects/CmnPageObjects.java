package pageObjects;

import com.google.common.base.Function;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class CmnPageObjects {
    private static final Logger logger= LogManager.getLogger(CmnPageObjects.class);
    WebDriver driver;



    private  By search_txt_box=By.id("srchbx");
    private By search_btn=By.xpath("//span[@id='srIconwpr']");
    private By nav_logo=By.xpath("//a[@class='pull-left logo']//img[@alt='Justdial']");
    private By search_city=By.xpath("//div[@class='search-city mnsrchwpr']");
    private By side_menu_link_list=By.xpath("//ul[@class='hotkeys-list ']//li//a");///span[@class='hotkeys-text']
    private By customer_care_btn=By.xpath("//div[@class='rightfixed']//a[@class='cscare ']");
    private By sautosearch_suggestion_drpdwn_search_btn=By.xpath("//div[@class='sautoM']//ul[@id='auto']//a");

    public CmnPageObjects(WebDriver driver)
    {
        this.driver=driver;
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
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        WebElement elementSearchBtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(search_btn));
        elementSearchBtn.click();
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
        boolean result=false;
        List<WebElement> menuLink = driver.findElements(sautosearch_suggestion_drpdwn_search_btn);
        for (int i = 0; i < menuLink.size(); i++) {
            WebElement element = menuLink.get(i);
            String innerHtml = element.getText();
            System.out.println(innerHtml);
            if (innerHtml.contains(serchName))
            {
                result=true;
                break;
            }

        }
        if(result=true)
        {
            Assert.assertTrue(true);
            logger.info("Search result is displayed");
            //System.out.println("serach result dispaly :" );
        }
        else
        {
            logger.fatal("Search result is not displayed");
            Assert.fail("Search result is not displayed");

        }

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
                logger.info("Clicked on the link"+ clickLink );
                break;
            }
            // System.out.println(innerHtml);

        }
    }
    public void UserNavigatedToSearchRelatedResult(String search)
    {
        String searchtxtContain=driver.findElement(search_txt_box).getText();
        boolean b=searchtxtContain.equalsIgnoreCase(search);
        Assert.assertEquals("User navigated to corr page",true,b);
    }


    public void NavigatedToCorrLinkAfterClick(String LinkName)
    {   boolean result=false;
        String pageTitle=driver.getTitle();
        logger.info("Page Title is:" +pageTitle);
       if(pageTitle.contains(LinkName))
        {
           result=true;
           Assert.assertTrue(true);
           logger.info("User is navigated to corr link:" +LinkName);

        }
       else
       {
           logger.fatal("User is not navigated to corr link:" +LinkName);
           Assert.fail("User is not navigated to corr link:" +LinkName);

       }

    }

/*for(WebElement element:menuLink)

            String innerHtml=element.getAttribute("innerHTML");
            if(innerHtml.contains(clickLink))
            {
                element.click();
                break;
            }

        }*/



}
