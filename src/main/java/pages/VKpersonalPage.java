package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

/**
 * Created by VITALIY on 07.11.2017.
 */
public class VKpersonalPage extends BasePage{

    @FindBy(id = "l_gr")
    private WebElement l_groupsBTN;

    @FindBy(id = "groups_create_btn")
    private WebElement groups_create_btn;

    @FindBy(id = "group_create_title")
    private WebElement group_create_titleFLD;

    @FindBy(id = "groups_create_group")
    private WebElement groups_create_groupCHBX;

    @FindBy(xpath = "(//INPUT[@type='text'])[2]")
    private WebElement dropdown1SLT;

    @FindBy(xpath = "(//INPUT[@type='text'])[3]")
    private WebElement dropdown2SLT;

    @FindBy(xpath = "(//BUTTON[@class='flat_button'][text()='Создать сообщество'][text()='Создать сообщество'])[1]")
    private WebElement createGroupBTN;

    @FindBy(xpath = "(//BUTTON[@class='flat_button group_save_button'])[1]")
    private WebElement saveGroupBTN;

    public WebElement getL_groupsBTN() {
        return l_groupsBTN;
    }

    public WebElement getGroups_create_btn() {
        return groups_create_btn;
    }

    public WebElement getGroup_create_titleFLD() {
        return group_create_titleFLD;
    }

    public WebElement getGroups_create_groupCHBX() {
        return groups_create_groupCHBX;
    }

    public WebElement getDropdown1SLT() {
        return dropdown1SLT;
    }

    public WebElement getDropdown2SLT() {
        return dropdown2SLT;
    }

    public WebElement getCreateGroupBTN() {
        return createGroupBTN;
    }

    public WebElement getSaveGroupBTN() {
        return saveGroupBTN;
    }

    public VKpersonalPage(){
        driver = BaseSteps.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void groupsClick(){
        clicker(getL_groupsBTN());
        clicker(getGroups_create_btn());
    }

    public void creatorGroup(String element, String value)  {
        switch (element) {
            case "Название":
                fillField(getGroup_create_titleFLD(), value);
                clickForCheckBox(getGroups_create_groupCHBX());
                break;
            case "Выберите тематику":
                fillField(getDropdown1SLT(), value);
                getDropdown1SLT().sendKeys(Keys.ENTER);
                break;
            case "Уточните тематику":
                fillField(getDropdown2SLT(), value);
                getDropdown2SLT().sendKeys(Keys.ENTER);
                clicker(getCreateGroupBTN());
                clicker(getSaveGroupBTN());
                break;
        }
    }
}
