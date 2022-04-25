package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public void openBrowser(String baseUrl){
        //set the property of chrome driver
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        //create the object of chorme driver
        driver = new ChromeDriver();
        //lounch the Url
        driver.get(baseUrl);
        //set the implicit wait 20 secound
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //maximize the browser window
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        //close the browser
        driver.quit();
    }
}
