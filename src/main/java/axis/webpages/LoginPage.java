package axis.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = "input#username")
    WebElement username_input;

    @FindBy(how = How.CSS, using = "input#password")
    WebElement password_input;

    @FindBy(how = How.CSS, using = "input#Login")
    WebElement login_button;

    public LoginPage (WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void setUsername(String name) {
        username_input.clear();
        username_input.sendKeys(name);
    }

    public void setPassword(String password) {
        password_input.clear();
        password_input.sendKeys(password);
    }

    public void clickLogin() {
        login_button.click();
    }
}
