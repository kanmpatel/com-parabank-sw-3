package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setupBrowser(){
        //set up the open browser
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find the element of username
        sendTextToElement(By.xpath("//input[@name='username']"),"abcdefr");
        //find the element of password
        sendTextToElement(By.xpath("//input[@name='password']"),"abcdefr");
        //find the element of login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //expected login text
        String expectedLoginText = "Accounts Overview";
        //find the element of login text
        String actualLoginText = getTextFromElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        //validate the login test
        verifyTextMessage(expectedLoginText,actualLoginText);
    }

    @Test
    public void verifyTheErrorMessage(){
        //find the element of username
        sendTextToElement(By.xpath("//input[@name='username']"),"abcde");
        //find the element of password
        sendTextToElement(By.xpath("//input[@name='password']"),"12345");
        //find the element of login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //expected error text
        String expectedErrorText = "The username and password could not be verified.";
        //find the element of error text
        String actualErrorText = getTextFromElement(By.cssSelector(".error"));
        //validate the error test
        verifyTextMessage(expectedErrorText,actualErrorText);
    }

    @Test
    public void userShouldLogOutSuccessfully(){
        //find the element of username
        sendTextToElement(By.xpath("//input[@name='username']"),"abcdef");
        //find the element of password
        sendTextToElement(By.xpath("//input[@name='password']"),"123456");
        //find the element of login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //sent the value of password
        clickOnElement(By.linkText("Log Out"));
        //expected customer login ext
        String expectedLoginText = "Customer Login";
        //find the element of login text
        String actualLoginText = getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        //validate the login test
        verifyTextMessage(expectedLoginText,actualLoginText);
    }

    @After
    public void closeBrowserSetUp(){
        //set up for close browser
        closeBrowser();
    }

}
