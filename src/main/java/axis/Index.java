package axis;

import axis.configuration.ConfigFileReader;
import axis.webpages.LoginPage;
import axis.webpages.PhoneRegPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class Index {
    public WebDriver driver;
    public ConfigFileReader configFileReader;

    @BeforeMethod
    public void setup() {
        configFileReader = new ConfigFileReader();
        String userProfile = "C:\\Users\\soyoolag\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("Setup Done");
    }

    @Test(dataProvider = "allTests")
    public void allTests(TestData data) throws Exception {
        driver.get(configFileReader.getappURL());
        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(data.get(0));
        loginPage.setPassword(data.get(1));
        loginPage.clickLogin();
        Thread.sleep(7000);

        PhoneRegPage phoneRegPage = new PhoneRegPage(driver);
        Thread.sleep(3000);
        phoneRegPage.setEmail();

        System.out.println("Done");
    }

    @DataProvider(name = "allTests")
    public Object[][] allTests_data() {
        return new Object[][]{

                {new TestData("soyoolag@axis.com", "love2936.")}
        };
    }

    static class TestData {
        public String[] items;

        public TestData(String... items) {
            this.items = items; // should probably make a defensive copy
        }

        public String get(int x) {
            return items[x];
        }
    }

    @AfterMethod
    public void endSession() {
//        driver.quit();
        System.out.println("Test complete");

    }
}
