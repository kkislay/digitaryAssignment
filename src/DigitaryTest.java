/**
 * Author - Kulin Kislay
 * Project - Digitary assignment
 * GitHubURL - https://github.com/kkislay/digitaryAssignment
 * Date - 24th October 2018
 * Contact - 0899791389 / kulin.kislay@gmail.com
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;
import org.openqa.selenium.Alert;

public class DigitaryTest {
    // Initialize all the xPaths and variables
    WebDriver driver = new FirefoxDriver();
    String homePageUrl = "http://a.testaddressbook.com";
    String xPathSignin = "//*[@id='sign-in']";
    String validEmail = "Kulin.kislay@gmail.com";
    String validPassword = "Digit@123";
    String webPageTitle = "Address Book";
    String signinUrl = "http://a.testaddressbook.com/sign_in";
    String xPathWelcomeToAddressBopkText = "//html/body/div/div/h1";
    String welcomeToAddressBookText = "Welcome to Address Book";
    String signinText= "Sign in";
    String invalidEmail = "test@gmail.com";
    String invalidPassword = "password123";
    String xPathInvalidLogin = "/html/body/div/div[1]";
    String invalidLoginMessage = "Bad email or password.";
    String xPathEmailHolder = "//*[@id=\"navbar\"]/div[2]/span";
    String xPathSignOut = "//*[@id=\"navbar\"]/div[1]/a[3]";
    String signOutText = "Sign out";
    String xPathAddresses = "//*[@id=\"navbar\"]/div[1]/a[2]";
    String addressesText = "Addresses";
    String xPathNewAddress = "/html/body/div/a";
    String xPathFirstName = "//*[@id=\"address_first_name\"]";
    String xPathLastName = "//*[@id=\"address_last_name\"]";
    String xPathStreetAddress = "//*[@id=\"address_street_address\"]";
    String xPathSecAddress = "//*[@id=\"address_secondary_address\"]";
    String xPathCity = "//*[@id=\"address_city\"]";
    String xPathState ="//*[@id=\"address_state\"]";
    String xPathZipCode = "//*[@id=\"address_zip_code\"]";
    String xPathCountryUS = "//*[@id=\"address_country_true\"]";
    String xPathCountryCanada = "//*[@id=\"address_country_false\"]";
    String xPathBirthday = "//*[@id=\"address_birthday\"]";
    String xPathColor = "//*[@id=\"address_color\"]";
    String xPathAge = "//*[@id=\"address_age\"]";
    String xPathWebsite = "//*[@id=\"address_website\"]";
    String xPathPhone = "//*[@id=\"address_phone\"]";
    String xPathClimb = "//*[@id=\"address_interest_climb\"]";
    String xPathdance = "//*[@id=\"address_interest_dance\"]";
    String xPathRead = "//*[@id=\"address_interest_read\"]";
    String xPathNote= "//*[@id=\"address_note\"]";
    String xPathCreateAddress = "//*[@id=\"new_address\"]/div[17]/input";
    String xPathList = "/html/body/div/a";
    String xPathAddressesTable = "html/body/div/table";
    String xPathEmail = "//*[@id='session_email']";
    String xPathPassword = "//*[@id='session_password']";
    String xPatherrorHeader = "//*[@id=\"error_explanation\"]/h4";
    String xPathDestroyMessage = "/html/body/div/div";
    String xPathSigninButton = "//*[@id=\"clearance\"]/div/div/form/div[3]/input";
    String getxPathSignOut="//*[@id=\"navbar\"]/div[1]/a[3]";
    String signupURL= "http://a.testaddressbook.com/sign_up";
    String xPathSignUp = "//*[@id=\"clearance\"]/div/div/form/div[4]/a";

    WebDriverWait wait = new WebDriverWait(driver, 5);
    private static final Logger LOGGER = Logger.getLogger(DigitaryTest.class.getName());

    int errorCount, index, rows_count, rows_count_after_deletion, older_rows_count;
    private Object SetdriverTest;

    @Before
    public void setUp()  {
        //System.setProperty("webdriver.gecko.driver", "/home/local/CORVIL/kkislay/Downloads/geckodriver");
        System.setProperty("webdriver.gecko.driver", "../geckodriver/geckodriver");
    }

    @After
    public void tearDown() {
        this.driver.close();
    }
    @Test
    public void test_01_SignInPageValid()  {

        // Testcase :- This test is to check for valid sign in the application and verifies that correct user is logged in into the system
        // Testdata :- Valid email and password.

        LOGGER.info("This test is to check for valid sign in the application and verifies that correct user is logged in into the system");
        signIn(validEmail, validPassword);
        LOGGER.info("Validating if correct user has logged into the application");
        Assert.assertEquals(validEmail.toLowerCase(), this.driver.findElement(By.xpath(xPathEmailHolder)).getText());
        Assert.assertEquals(signOutText, this.driver.findElement(By.xpath(xPathSignOut)).getText());
        Assert.assertEquals(addressesText, this.driver.findElement(By.xpath(xPathAddresses)).getText());

    }
    @Test
    public void test_02_HomePagePresent ()
    {
        // Testcase :- This test is to verify the content present on the home page
        // Testdata :- Home page URL

        LOGGER.info("This test is to verify the content present on the home page");
        this.driver.get(homePageUrl);
        this.driver.manage().window().maximize();
        Assert.assertEquals(welcomeToAddressBookText, this.driver.findElement(By.xpath(xPathWelcomeToAddressBopkText)).getText());
        Assert.assertEquals(signinText, this.driver.findElement(By.xpath(xPathSignin)).getText());
    }

    @Test
    public void test_03_SignInPageinvalid() {

        // Testcase :- This test is to check for Invalid sign in the application and verifies that correct user is logged in into the system
        // Testdata :- Invalid email and password.

        LOGGER.info("This test is for invalid sign in message");
        signIn(invalidEmail,invalidPassword);
        LOGGER.info("verifying the message");
        Assert.assertEquals(invalidLoginMessage, this.driver.findElement(By.xpath(xPathInvalidLogin)).getText());
    }
    @Test
    public void test_04_Addresses () {

        //Testcase :- This test is to verify if address is added correctly into the system or not
        //Testdata :- Data needed for an address.

        LOGGER.info("This test is to verify if address is added correctly into the system or not");
        signIn(validEmail, validPassword);
        addNewAddress ("test", "123","santry", "", "Dublin", "California", "D9", "", "", "", "", "","" +
                "", "", "", "");
        this.driver.close();

        }
    @Test
     public void test_05_incomplete_details_error_message () {

        // Testcase :- Test the error message when entered address is incomplete
        // Testdata :- values to fill in incomplete record

        LOGGER.info("Test the error message when entered address is incomplete");
        signIn(validEmail, validPassword);
        LOGGER.info("Trying to add two records with incomplete values and verifying the errors");
         addNewAddress ("", "","santry", "", "Dublin", "California", "D9", "", "", "", "", "","" +
               "", "", "", "");
         addNewAddress ("", "","23", "wgf", "dubv", "Alabama", "Dub 9", "", "", "", "", "","" +
                "", "", "", "");
     }


     @Test
    public void test_06_open_list () {
        //Testcase:- This test logs into the application and Checks if the List link on New Address page displays list or not
        //Testdata:- Valid email and password.

        LOGGER.info("This test logs into the application and Checks if the List link on New Address page displays list or not");
        signIn(validEmail, validPassword);
        LOGGER.info("Click on addresses tab");
        clickOnAddresses();
        LOGGER.info("Click on new addresses link");
        clickonNewAddressesLink();
        LOGGER.info("Click on List link");
        showList();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathAddresses)));
        Assert.assertTrue(this.driver.findElement(By.xpath(xPathAddresses)).isDisplayed());

    }

    @Test
    public void test_07_show_list () {
        //Testcase:- This test goes into the list and prints the list
        //Testdata:-  Valid email and password.

        LOGGER.info("This test goes into the list and prints the list");
        signIn(validEmail, validPassword);
        clickOnAddresses();

        LOGGER.info("Get the location of address table");
        WebElement mytable = this.driver.findElement(By.xpath(xPathAddressesTable));
        //To locate rows of table.
        List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
        //To calculate no of rows In table.
        rows_count = rows_table.size();
        LOGGER.info("Printing the addresses table");
        //Loop will execute till the last row of table.
        for (int row = 0; row < rows_count; row++) {
            //To locate columns(cells) of that specific row.
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            //To calculate no of columns (cells). In that specific row.
            int columns_count = Columns_row.size();
            //Loop will execute till the last cell of that specific row.
            for (int column = 0; column < columns_count; column++) {
                // To retrieve text from that specific cell.
                String celtext = Columns_row.get(column).getText();
                System.out.print(celtext + " ");
                }

                System.out.println(" ");
            }

        }

    @Test
    public void test_08_destroy () {

        //Testcasse :- Test to destroy the row which has any entry mentioned
        //Testdata :- Value of the row to be deleted.

        signIn(validEmail, validPassword);
        destroy("test");


    }

    @Test
    public void test_09_signout(){
        //Testcasse :- Test to signout of the applicaiton
        //Testdata :- Valid email and password

        signIn(validEmail, validPassword);
        this.driver.findElement(By.xpath(xPathSignOut)).click();
        Assert.assertEquals(signinUrl, this.driver.getCurrentUrl());

    }

    @Test
    public void test_010_edit_an_address(){
        //Testcasse :- Test to edit the row which has first name mentioned
        //Testdata :- Value of the row to be edited.

        signIn(validEmail, validPassword);
        edit_address("test");


    }
    @Test
    public void test_011_show_an_address(){
        //Testcasse :- Test to check if show link is working for a first name
        //Testdata :- Value of the row to be shown

        signIn(validEmail, validPassword);
        show_address("test");


    }
    @Test
    public void test_012_SignupPageURL () {
        // Testcase :- This test is to verify clicking on sign up link takes to sign up page with URL
        // Testdata :- Home page URL

        LOGGER.info("This test is to verify the content present on the home page");
        this.driver.get(homePageUrl);
        this.driver.manage().window().maximize();
        this.driver.findElement(By.xpath(xPathSignin)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathEmail)));
        this.driver.findElement(By.xpath(xPathSignUp)).click();
        Assert.assertEquals(signupURL, this.driver.getCurrentUrl());


    }


    //*************************************************     HELPER FUNCTIONS     ****************************************************************************************************************//

    public void signIn (String email, String password)
    // This function is to Sign in into the application
    {
        LOGGER.info("Logging into the application with email " +validEmail);
        this.driver.get(homePageUrl);
        this.driver.manage().window().maximize();
        System.out.println(this.driver.getTitle());
        assertEquals (this.driver.getTitle(), webPageTitle);

        WebElement elementtobeClicked = this.driver.findElement(By.xpath(xPathSignin));

        Actions actionDriver = new Actions(this.driver);
        actionDriver.moveToElement(elementtobeClicked).click().perform();

        assertEquals(signinUrl,this.driver.getCurrentUrl());
        LOGGER.info("Enter the valid username and password and clicking the sign in button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathEmail)));
        this.driver.findElement(By.xpath(xPathEmail)).sendKeys(email);
        this.driver.findElement(By.xpath(xPathPassword)).sendKeys(password);
        this.driver.findElement(By.xpath(xPathSigninButton)).click();

    }

    public void addNewAddress (String FirstName, String LastName, String StreetAddress, String SecAddress, String City, String State, String ZipCode, String Birthday, String ColorHex, String Age, String Website, String Phone, String InterestDance, String InterestRead, String InterestClimb, String Notes)
    {
        // Method to add new address with fields.
        errorCount=0;
        this.driver.findElement(By.xpath(xPathAddresses)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathNewAddress)));

        this.driver.findElement(By.xpath(xPathNewAddress)).click();

        LOGGER.info("Entering all the details in addresses form");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathFirstName)));
        if (FirstName.equals(""))
            errorCount++;
        this.driver.findElement(By.xpath(xPathFirstName)).sendKeys(FirstName);
        if (LastName.equals(""))
            errorCount++;
        this.driver.findElement(By.xpath(xPathLastName)).sendKeys(LastName);
        if (StreetAddress.equals(""))
            errorCount++;
        this.driver.findElement(By.xpath(xPathStreetAddress)).sendKeys(StreetAddress);
        this.driver.findElement(By.xpath(xPathSecAddress)).sendKeys(SecAddress);
        if (City.equals(""))
            errorCount++;
        this.driver.findElement(By.xpath(xPathCity)).sendKeys(City);
        Select drpState = new Select(this.driver.findElement(By.xpath(xPathState)));
        drpState.selectByVisibleText(State);
        if (ZipCode.equals(""))
            errorCount++;
        this.driver.findElement(By.xpath(xPathZipCode)).sendKeys(ZipCode);
        if (!driver.findElement(By.xpath(xPathCountryUS)).isSelected()) {
            driver.findElement(By.xpath(xPathCountryUS)).click();
        }
        WebElement dateBox = driver.findElement(By.xpath(xPathBirthday));

        //Fill date as mm/dd/yyyy as 09/25/2013

        dateBox.sendKeys("09/25/2013");

        //Press tab to shift focus to time field

        dateBox.sendKeys(Keys.TAB);

        WebElement El = driver.findElement(By.xpath("//input[@id=\"address_picture\"]"));
        El.sendKeys("/home/local/CORVIL/kkislay/Downloads/dummy.png");

        this.driver.findElement(By.xpath(xPathColor)).click();


        this.driver.findElement(By.xpath(xPathAge)).sendKeys(Age);

        this.driver.findElement(By.xpath(xPathWebsite)).sendKeys(Website);

        this.driver.findElement(By.xpath(xPathPhone)).sendKeys(Phone);

        if (InterestClimb.equals("Climb"))
            this.driver.findElement(By.xpath(xPathClimb)).click();
        else if (InterestDance.equals("Dance"))
            this.driver.findElement(By.xpath(xPathdance)).click();
        else if (InterestRead.equals("Read"))
        this.driver.findElement(By.xpath(xPathRead)).click();

        this.driver.findElement(By.xpath(xPathNote)).sendKeys(Notes);

        this.driver.findElement(By.xpath(xPathCreateAddress)).click();

        if (errorCount==1)
            Assert.assertEquals(errorCount+ " error prohibited this address from being saved:"
                    , this.driver.findElement(By.xpath(xPatherrorHeader)).getText());
        else if (errorCount>1)
            Assert.assertEquals(errorCount+ " errors prohibited this address from being saved:"
                    , this.driver.findElement(By.xpath(xPatherrorHeader)).getText());
    }

    public void showList()
    {
        // Function to click on show list link
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathList)));
        this.driver.findElement(By.xpath(xPathList)).click();
    }

    public void clickOnAddresses()
    {
        // Function to click on Addresses link
        this.driver.findElement(By.xpath(xPathAddresses)).click();
    }

    public void clickonNewAddressesLink ()
    {
        // Function to click on new addresses link
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathNewAddress)));

        this.driver.findElement(By.xpath(xPathNewAddress)).click();
    }


    public void destroy(String elementTobeDeleted)
    {
        //Method to destroy a row from the list
        // Paramter - Element to be focused

        clickOnAddresses();
        older_rows_count=getRows_count();
        System.out.println("Before deletion "+rows_count);
        index=find_index(elementTobeDeleted);
        if (index==0) {
            // This is when Element is not present in list
            System.out.println("Element not found. Please check the list");
        }
        else {
            this.driver.findElement(By.xpath("/html/body/div/table/tbody/tr[" + index + "]/td[7]/a")).click();
            WebDriverWait wait = new WebDriverWait(driver, 3000);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = this.driver.switchTo().alert();
            alert.accept();


            rows_count_after_deletion = getRows_count();
            System.out.println("after deletion = " + rows_count_after_deletion);
            LOGGER.info("Verify that the row count is reduced by 1");
            Assert.assertEquals(1,older_rows_count-rows_count_after_deletion);

            Assert.assertEquals("Address was successfully destroyed.", this.driver.findElement(By.xpath(xPathDestroyMessage)).getText());
        }

    }

    public void edit_address(String elementTobeFocused)
    {
        //Method to edit a row from the list
        // Paramter - Element to be focused

        index= find_index(elementTobeFocused);
        if (index==0) {
            // This is when Element is not present in list
            System.out.println("Element not found. Please check the list");
        }
        else {
            this.driver.findElement(By.xpath("/html/body/div/table/tbody/tr[" + index + "]/td[6]/a")).click();
            WebDriverWait wait = new WebDriverWait(driver, 3000);
            Assert.assertEquals("Editing Address", this.driver.findElement(By.xpath("/html/body/div/h2")).getText());
        }

    }

    public void show_address(String elementTobeFocused)
    {
        //Method to edit an element from the list
        // Paramter - Element to be focused

        index= find_index(elementTobeFocused);
        if (index==0) {
            // This is when Element is not present in list
            System.out.println("Element not found. Please check the list");
        }
        else {
            this.driver.findElement(By.xpath("/html/body/div/table/tbody/tr[" + index + "]/td[5]/a")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/p[1]/span[2]")));
            Assert.assertEquals(elementTobeFocused, this.driver.findElement(By.xpath("/html/body/div/p[1]/span[2]")).getText());
        }

    }
    public int find_index (String elementTobeDeleted)
    {
        // This method is to find the index of the row (row number) to be focused
        // Paramter - Element to be focused

        clickOnAddresses();
        LOGGER.info("Going to look for "+elementTobeDeleted);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathAddressesTable)));
        WebElement mytable = this.driver.findElement(By.xpath(xPathAddressesTable));
        //To locate rows of table.
        List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
        //System.out.println(rows_table.get(1).);

        //To calculate no of rows In table.
        rows_count = rows_table.size();
        index=0;
        //Loop will execute till the last row of table.
            for (int row = 0; row < rows_count; row++) {
            //To locate columns(cells) of that specific row.
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            //To calculate no of columns (cells). In that specific row.
            int columns_count = Columns_row.size();
            //Loop will execute till the last cell of that specific row.
            for (int column = 0; column < columns_count; column++) {
                // To retrieve text from that specific cell.
                //System.out.println(column);
                String celtext = Columns_row.get(column).getText();
                if (celtext.equals(elementTobeDeleted)) {
                    index = row;
                    break;
                }

            }

    }
        return index;
    }

    public int getRows_count()
    {
        // This method is to get number of rows in the list
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathAddressesTable)));
        WebElement mytable = this.driver.findElement(By.xpath(xPathAddressesTable));
        //To locate rows of table.
        List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
        //System.out.println(rows_table.get(1).);

        //To calculate no of rows In table.
        rows_count = rows_table.size();
        return rows_count;
    }

}
