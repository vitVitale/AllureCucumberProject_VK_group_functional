package steps;

import cucumber.api.DataTable;
import pages.VKlogInPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by VITALIY on 07.11.2017.
 */
public class VKlogInSteps {

    VKlogInPage page = new VKlogInPage();

    @Step("Вводим емаил и пароль")
    public void fillFields(DataTable table){
        table.asMap(String.class, String.class)
                .forEach((field, value) -> page.fillFieldOfLogInVK(field, value));
    }

    @Step("Подтверждаем вход")
    public void sumbitLogIn(){
        page.buttonPusher();
    }
}
