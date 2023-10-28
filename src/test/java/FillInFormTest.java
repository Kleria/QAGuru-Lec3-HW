import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class FillInFormTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void FillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Jane");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("janedoe@test.com");
        $("#gender-radio-2 + label").click();
        /*
        пыталась выбрать радиокнопку через такой метод:
        $(By.name("#gender")).selectRadio("Female");
        но не отработало. в чем может быть проблема? неправильно прописала селекторы?
         */
        $("#userNumber").setValue("8800555353");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--009").click();
        $("#hobbies-checkbox-2 + label").click();
        $("#hobbies-checkbox-3 + label").click();
        $("#uploadPicture").uploadFile(new File("scr\\test\\Cat.jpg"));

    }
}

