package pageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPageObjects {
    private static final Logger logger= LogManager.getLogger(SignUpPageObjects.class);
    WebDriver driver;

    private By login_link=By.xpath("//li[@class='login']");
    private By txt_btn_user_name=By.xpath("//input[@id='lgn_name']");
    private By txt_btn_phone_no=By.xpath("//input[@id='lgn_mob']");
    private By btn_send_otp=By.xpath("//button[@id='lgn_smtn']");
    private By OTP_modal_window=By.xpath("//section[@id='OTPmodal']//span[@id='lgn_lg']");
    private By OTP_send_msg=By.xpath("//div[@class='otp-text wrapper pb-10']");
    private By wrong_or_missing_credentials_msg=By.xpath("//div[@id='iup']");

            //private By sign_up = By.id("h_sin_up");
    //private By log_in=By.id("h_login");

public SignUpPageObjects(WebDriver driver)
{
    this.driver=driver;
}


public void ClickOnLoginLink()
{
   driver.findElement(login_link).click();
   logger.info("Clicked on login link");
}

public void EnterUnameAndNoAndSubmit(String name, String no)
{
   WebDriverWait wait=new WebDriverWait(driver,30);
    WebElement nameTxtBox=wait.until(ExpectedConditions.elementToBeClickable(txt_btn_user_name));
    nameTxtBox.clear();
    nameTxtBox.sendKeys(name);

    //driver.findElement(txt_btn_user_name).sendKeys(name);
    logger.info("Name Entered");
    //driver.findElement(txt_btn_phone_no).sendKeys(no);
    WebDriverWait wait1=new WebDriverWait(driver,30);
    WebElement phoneNoTxtBox=wait1.until(ExpectedConditions.elementToBeClickable(txt_btn_phone_no));
    phoneNoTxtBox.clear();
    phoneNoTxtBox.sendKeys(no);
    logger.info("PhoneNo entered");

    driver.findElement(btn_send_otp).click();
    logger.info("SendOtp clicked");
    //driver.findElement(OTP_modal_window).isDisplayed()

}
public void EmptyNameAndMobileNoANdSubmit()
{
    driver.findElement(txt_btn_user_name).sendKeys("");
    logger.info("Name not Entered");
    driver.findElement(txt_btn_phone_no).sendKeys("");
    logger.info("PhoneNo not entered");
    driver.findElement(btn_send_otp).click();
    logger.info("SendOtp clicked");

}

public void WrongMobileNoValidation(String message)
{
    String actualmsg=driver.findElement(wrong_or_missing_credentials_msg).getText();
    if(actualmsg.equalsIgnoreCase(message))
        {
            logger.info(message + " validate successfully");
        }
    else
    {
        logger.info(message +"not validate successfully");
    }
}

public void OTP_SendValidation(String message)
{
      String actualmsg=driver.findElement(OTP_send_msg).getText();
      //System.out.println(txt);
    //WebDriverWait wait3=new WebDriverWait(driver,20);
    //WebElement OTPWindow=wait3.until(ExpectedConditions.visibilityOf(driver.findElement(OTP_modal_window)));
    //OTPWindow.isDisplayed();
    if( actualmsg.equalsIgnoreCase(message))
    {
        Assert.assertTrue(true);
        logger.info("OTP modal window displayed and OTP send successfully");
    }
    else
    {
        logger.fatal(" OTP not send successfully");
        Assert.fail(" OTP not send successfully");
    }
}


public void CheckMobileNoLengthIsTenDigitUserCanEnter(String no)
{
    String maxLength=driver.findElement(txt_btn_phone_no).getAttribute("maxlength");
    if(maxLength.equals(no))
    {
        Assert.assertTrue(true);
        logger.info("Max length of mobile no is 10");
    }
    else
    {
        logger.fatal("Max length of mobile no is not set to 10");
        Assert.fail("Max length of mobile no is not set to 10");
    }
}


}
