package axis.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PhoneRegPage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@title='Phone Registration']")
    WebElement phoneReg_nav;

    @FindAll(@FindBy(how = How.XPATH, using = "//h2[text()[contains(.,'Phone Registration')]]/ancestor-or-self::app_flexipage-header/following-sibling::slot/app_flexipage-lwc-app-flexipage-internal/forcegenerated-adg-rollup_component___force-generated__flexipage_-app-page___-phone_-registration/forcegenerated-flexipage_phone_registration__js/flexipage-lwc-default-app-home-template/div/div/slot/slot/flexipage-component2/slot/flexipage-aura-wrapper/div/div/div/div/div/div/fieldset/div/div/div/div/input"))
    List<WebElement> phone_reg_inputs;

    public PhoneRegPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void setEmail() {
        phone_reg_inputs.get(0).sendKeys("Email");
        phone_reg_inputs.get(1).sendKeys("Phone");
        phone_reg_inputs.get(2).sendKeys("FirstName");
        phone_reg_inputs.get(3).sendKeys("LastName");
        phone_reg_inputs.get(4).sendKeys("Title");
        phone_reg_inputs.get(5).sendKeys("Company");
    }
}
