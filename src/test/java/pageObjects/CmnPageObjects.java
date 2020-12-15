package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CmnPageObjects {
    private static final Logger logger= LogManager.getLogger(CmnPageObjects.class);
    WebDriver driver;

    private  By search_txt_box=By.id("srchbx");
    private By search_btn=By.xpath("//button[@class='search-button']");
    private By nav_logo=By.xpath("//a[@class='pull-left logo']//img[@alt='Justdial']");
    private By search_city=By.xpath("//div[@class='search-city mnsrchwpr']");
    //private By select_city_dropdown=By.xpath("");
    private By side_menu_link=By.xpath("//ul[@id='sidebarnavleft']//span[text()='%s']");

    public CmnPageObjects(WebDriver driver)
    {
        this.driver=driver;
    }

    void ValidateClickOnHSideMenuLink(String linkText) {
        By byElement = By.xpath(String.format(side_menu_link,linkText);
        driver.findElement(byElement).click();
        logger.info("Clicked on Hside menu link: " + linkText);
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


}
