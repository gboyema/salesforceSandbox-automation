package axis;

import axis.configuration.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class Index {
    public WebDriver driver;
    public ConfigFileReader configFileReader;

    @BeforeMethod
    public void setup() {
        configFileReader = new ConfigFileReader();
        String userProfile= "C:\\Users\\soyoolag\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir="+userProfile);
        File file = new File(System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("Setup Done");
    }

    @Test
    public void tests () throws InterruptedException {
        driver.get(configFileReader.getappURL());
        Thread.sleep(5000);
        System.out.println("Done");
    }

    @AfterMethod
    public void endSession() {
        driver.quit();
        System.out.println("Test complete");

    }
}
