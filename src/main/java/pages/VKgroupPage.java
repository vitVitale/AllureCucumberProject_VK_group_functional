package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;
import java.util.List;

/**
 * Created by VITALIY on 08.11.2017.
 */
public class VKgroupPage extends BasePage {

    @FindBy(id = "group_albums")
    private WebElement group_albumsBTN;

    @FindBy(xpath = "//A[text()='Редактировать альбом']")
    private WebElement redact_albumsBTN;

    @FindBy(id = "album_title")
    private WebElement album_titleFLD;

    @FindBy(id = "album_description")
    private WebElement album_descriptionFLD;

    @FindBy(id = "album_only_check")
    private WebElement album_only_checkCKBX;

    @FindBy(id = "album_save_button")
    private WebElement album_save_buttonBTN;

    @FindBy(xpath = "//A[@class='ui_crumb'][text()='Основной альбом']")
    private WebElement mainAlbumBTN;

    @FindBy(id = "photos_upload_input")
    private WebElement photos_upload_inputBTN;

    @FindBy(xpath = "//div[@id='photos_add_list']/*")
    private List<WebElement> photos_add_list;

    public WebElement getGroup_albumsBTN() {
        return group_albumsBTN;
    }

    public WebElement getRedact_albumsBTN() {
        return redact_albumsBTN;
    }

    public WebElement getAlbum_titleFLD() {
        return album_titleFLD;
    }

    public WebElement getAlbum_descriptionFLD() {
        return album_descriptionFLD;
    }

    public WebElement getAlbum_only_checkCKBX() {
        return album_only_checkCKBX;
    }

    public WebElement getAlbum_save_buttonBTN() {
        return album_save_buttonBTN;
    }

    public WebElement getMainAlbumBTN() {
        return mainAlbumBTN;
    }

    public WebElement getPhotos_upload_inputBTN() {
        return photos_upload_inputBTN;
    }

    public List<WebElement> getPhotos_add_list() {
        return photos_add_list;
    }

    public VKgroupPage() {
        driver = BaseSteps.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void toAlbums() {
        clicker(getGroup_albumsBTN());
        clicker(getRedact_albumsBTN());
    }

    public void fillAlbumParams(String element, String value) {
        switch (element) {
            case "Название":
                fillField(getAlbum_titleFLD(), value);
                break;
            case "Описание":
                fillField(getAlbum_descriptionFLD(), value);
                clickForCheckBox(getAlbum_only_checkCKBX());
                clicker(getAlbum_save_buttonBTN());
                clicker(getMainAlbumBTN());
                break;
        }
    }

    private int counterUploadedPhotos = 0;

    public void photoStream(String element, String value) {

        try {
            switch (element) {
            case "Первое фото":
                Thread.sleep(1000);
                getPhotos_upload_inputBTN().sendKeys(value);
                counterUploadedPhotos++;
                break;
            case "Второе фото":
                Thread.sleep(1000);
                getPhotos_upload_inputBTN().sendKeys(value);
                counterUploadedPhotos++;
                break;
            case "Третье фото":
                Thread.sleep(1000);
                getPhotos_upload_inputBTN().sendKeys(value);
                counterUploadedPhotos++;
                break;
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkPhotoIsUploaded(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getPhotos_add_list()));

        System.out.println("-----------||--------  "+getPhotos_add_list().size()+"  --------||---------");
        System.out.println("-----------||--------  "+counterUploadedPhotos+"  --------||---------");

        Assert.assertTrue("Нет совпадения с выгруженными и отображенными фото!!", getPhotos_add_list().size() == counterUploadedPhotos);
    }
}
