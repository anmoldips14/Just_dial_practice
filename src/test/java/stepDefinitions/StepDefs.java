package stepDefinitions;

import core.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageObjects.CmnPageObjects;
import pageObjects.CustomerCarePageObjects;
import pageObjects.SearchDescriptionPageObjects;
import pageObjects.SignUpPageObjects;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class StepDefs {
    private static final Logger logger= LogManager.getLogger(StepDefs.class);


    WebDriver driver;
    String base_url="https://www.justdial.com/";
    int implicit_wait_timeout_in_sec=20;
    Scenario scn;

    CmnPageObjects cmnpageobjects;
    SignUpPageObjects signuppageobjects;
    SearchDescriptionPageObjects searchdescriptionpageobjects;
    CustomerCarePageObjects customercarepageobjects;

    @Before
    public void setUp(Scenario scn)throws Exception{
        this.scn=scn;

        String browserName= WebDriverFactory.getBrowserName();
        driver=WebDriverFactory.getWebDriverForBrowser(browserName);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //System.setProperty("webdriver.chrome.driver","JustDial_Project/chromedriver.exe");
        scn.log("Browser invoked");

        cmnpageobjects=new CmnPageObjects(driver);
        signuppageobjects=new SignUpPageObjects(driver);
        searchdescriptionpageobjects=new SearchDescriptionPageObjects(driver);
        customercarepageobjects=new CustomerCarePageObjects(driver);
    }

    @After
    public void cleanUp()
    {
        WebDriverFactory.quitDriver();
        scn.log("Brower closed");
    }
    @After(order=2)
    public void takeScreenShot(Scenario s)
    {
        if (s.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }




    @Given("User navigates to the application url")
    public void user_navigates_to_the_application_url()
    {
        WebDriverFactory.navigateToTheUrl(base_url);
        //WebDriverFactory.alertHandlingDismiss();
        scn.log("Browser navigated to home url:" +base_url);
        String expected="Justdial - Local Search, Social, News, Videos, Shopping";
        cmnpageobjects.validatePageTitleMatch(expected);

    }

    @When("User clicks on Sign up link at the top right corner of the application")
    public void user_clicks_on_sign_up_link_at_the_top_right_corner_of_the_application()
    {
        signuppageobjects.ClickOnLoginLink();
    }

    @When("User enters name as {string} and Phone number as {string} and clicks on Submit Button")
    public void user_enters_name_as_and_phone_number_as_and_clicks_on_submit_button(String name, String phoneNo)
    {
        signuppageobjects.EnterUnameAndNoAndSubmit(name,phoneNo);
        scn.log("Name " +name + "and phoneNo "+phoneNo +" entered and click on submit button");
    }

    @Then("User is displayed with the message as {string}")
    public void user_is_displayed_with_the_message_as(String msg)
    {
        signuppageobjects.OTP_SendValidation(msg);
        scn.log("" +msg);
    }

    @When("User clicks on Login-in link at the top right corner of the application")
    public void user_clicks_on_login_in_link_at_the_top_right_corner_of_the_application()
    {
        signuppageobjects.ClickOnLoginLink();
    }

    @Then("User gets error message as {string}")
    public void user_gets_error_message_as(String msg)
    {
        signuppageobjects.WrongMobileNoValidation(msg);
    }

    @When("User do not enter any name and phone number but clicks on Submit Button")
    public void user_do_not_enter_any_name_and_phone_number_but_clicks_on_submit_button()
    {
        signuppageobjects.EmptyNameAndMobileNoANdSubmit();
    }

    @Then("User is able to enter only {string} digits in the Mobile text field")
    public void user_is_able_to_enter_only_digits_in_the_mobile_text_field(String phoneNo)
    {
        signuppageobjects.CheckMobileNoLengthIsTenDigitUserCanEnter(phoneNo);
    }



//****************Search****************

    @When("User enters {string} in search text box")
    public void user_enters_in_search_text_box(String searchproduct)
    {
        cmnpageobjects.SetSearchTextBox(searchproduct);
    }

    @When("User clicks search button")
    public void user_clicks_search_button()
    {
        cmnpageobjects.ClickOnSearchButton();
    }

    @Then("User is able to see search result related to {string}")
    public void user_is_able_to_see_search_result_related_to(String searchstring)
    {
       // WebDriverFactory.switchBrowserToTab();
       // searchdescriptionpageobjects.ValidateResultPageIsDisplayedSuccessfully(searchstring);
        //expected="Best Restaurants in Mumbai - Top Veg & Non Veg Restaurants - Order Food Online - Justdial";
        //cmnpageobjects.validatePageTitleMatch(expected);
    }

    @Then("User is able to see the drop down under search text box with all the items with text {string}")
    public void user_is_able_to_see_the_drop_down_under_search_text_box_with_all_the_items_with_text(String partstring)
    {
        cmnpageobjects.UserCanSeeAllItemsUnderSearchDrpDwn(partstring);
    }

//***********************Menu***************************

    @When("User clicks on {string}")
    public void user_clicks_on(String linkName)
    {

        cmnpageobjects.ClickOnHSideMenuLink(linkName);
    }



    @Then("User is navigates to the corresponding link realted to {string}")
    public void user_is_navigates_to_the_corresponding_link_realted_to(String string)
    {
       // WebDriverFactory.switchBrowserToTab();
    }


    //********************Customer_care Feature************

    @Given("User navigates to Customer care page by clicking on Customer Care tab at the right-mid of the page")
    public void user_navigates_to_customer_care_page_by_clicking_on_customer_care_tab_at_the_right_mid_of_the_page()
    {
        cmnpageobjects.CustomerCareBtnClick();
        //WebDriverFactory.switchBrowserToTab();
    }

    @When("User enter {string} in the Text box")
    public void user_enter_in_the_text_box(String name) {
        //WebDriverFactory.switchBrowserToTab();
        cmnpageobjects.SetSearchTextBox(name);
        //customercarepageobjects.TxtEnterInTxtBtn(name);

    }

    @Then("User is able to see the drop down and all the items in the list must have text as {string}")
    public void user_is_able_to_see_the_drop_down_and_all_the_items_in_the_list_must_have_text_as(String name)
    {
      customercarepageobjects.InsertTextInSearchBtnAndCheckDrpDwn(name);
    }


}
