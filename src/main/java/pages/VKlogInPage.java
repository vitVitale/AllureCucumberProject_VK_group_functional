package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

/**
 * Created by VITALIY on 07.11.2017.
 */
public class VKlogInPage extends BasePage {

    @FindBy(id = "index_email")
    private WebElement index_emailFLD;

    @FindBy(id = "index_pass")
    private WebElement index_passFLD;

    @FindBy(id = "index_login_button")
    private WebElement index_login_buttonBTN;

    public WebElement getIndex_emailFLD() {
        return index_emailFLD;
    }

    public WebElement getIndex_passFLD() {
        return index_passFLD;
    }

    public WebElement getIndex_login_buttonBTN() {
        return index_login_buttonBTN;
    }

    public VKlogInPage(){
        driver = BaseSteps.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void fillFieldOfLogInVK(String element, String value) {
        switch (element) {
            case "Телефон или email":
                fillField(getIndex_emailFLD(), value);
                break;
            case "Пароль":
                fillField(getIndex_passFLD(), value);
                break;
        }
    }
    public void buttonPusher(){
        getIndex_login_buttonBTN().click();
    }
}
