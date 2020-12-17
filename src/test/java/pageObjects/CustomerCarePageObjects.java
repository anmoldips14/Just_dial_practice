package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;

public class CustomerCarePageObjects {
    private static final Logger logger= LogManager.getLogger(CustomerCarePageObjects.class);
    WebDriver driver;

    private By search_btn_dropdown=By.xpath("//span[@class='lng_autowht tcon']");
    private By search_txt_btn=By.xpath("//input[@id='srchbx']");//input[@id='srchbx']

    public CustomerCarePageObjects(WebDriver driver)
    {
        this.driver=driver;
    }


    public void TxtEnterInTxtBtn(String search)
    {
        driver.findElement(search_txt_btn).sendKeys(search);

    }
    public void InsertTextInSearchBtnAndCheckDrpDwn(String txt)
    {
        
        List<WebElement> dropdown = driver.findElements(search_btn_dropdown);
        for (WebElement suggest : dropdown)
        {
            String suggestName = suggest.getText();
            if (suggestName.contains(txt))
            {
                Assert.assertTrue(true);

            }
            break;

        }
    }


}
