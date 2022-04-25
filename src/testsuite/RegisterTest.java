package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setupBrowser(){
        //set up the open browser
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //find the element of registration link
        clickOnElement(By.linkText("Register"));
        //click on registration link
        //expected registration text
        String expectedRegistrationText = "Signing up is easy!";
        //find the element of registration text
        String actualRegistrationText = getTextFromElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        //get the text of registration elements
        //validate the registration test
        verifyTextMessage(expectedRegistrationText,actualRegistrationText);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        verifyThatSigningUpPageDisplay();
        //find the element of firstname
        sendTextToElement(By.id("customer.firstName"),"abcdefg");
        //find the element of lastname
        sendTextToElement(By.id("customer.lastName"),"xyz");
        //find the element of addressField
        sendTextToElement(By.xpath("//input[@name='customer.address.street']"),"25,dfgs");
        //find the element of cityField
        sendTextToElement(By.id("customer.address.city"),"abcdfg");
        //find the element of stateField
        sendTextToElement(By.name("customer.address.state"),"tyuo");
        //find the element of zipCodeField
        sendTextToElement(By.name("customer.address.zipCode"),"123456");
        //find the element of ssnField
        sendTextToElement(By.id("customer.ssn"),"123456");
        //find the element of userNameField
        sendTextToElement(By.xpath("//input[@name='customer.username']"),"abcdefr");
        //find the element of passwordField
        sendTextToElement(By.xpath("//input[@name='customer.password']"),"abcdefr");
        //find the element of confirmPasswordField
        sendTextToElement(By.xpath("//input[@name='repeatedPassword']"),"abcdefr");
        //find the element of registerBtn
        clickOnElement(By.xpath("//input[@value='Register']"));
        //expected registration text
        String expectedRegistrationMessageText = "Your account was created successfully. You are now logged in.";
        //find the element of registration text
        String actualRegistrationMessageText = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]"));
        //validate the registration test
        verifyTextMessage(expectedRegistrationMessageText,actualRegistrationMessageText);

    }

    @After
    public void closeBrowserSetUp(){
        //set up for close browser
        closeBrowser();
    }
}
