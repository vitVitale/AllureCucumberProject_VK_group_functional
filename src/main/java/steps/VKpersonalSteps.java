package steps;

import cucumber.api.DataTable;
import pages.VKpersonalPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by VITALIY on 07.11.2017.
 */
public class VKpersonalSteps {

    VKpersonalPage page = new VKpersonalPage();

    @Step("Выбираем раздел групп и создаем")
    public void groupBtn(){
        page.groupsClick();
    }

    @Step("Создаем группу")
    public void groupCreate(DataTable table){
        table.asMap(String.class, String.class)
                .forEach((field, value) -> page.creatorGroup(field, value));
    }
}
