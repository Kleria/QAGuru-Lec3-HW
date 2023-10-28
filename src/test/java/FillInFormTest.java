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
        Configuration.browserSize = "2560x1440";
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
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#uploadPicture").uploadFromClasspath("Cat.jpg");
        $("#currentAddress").setValue("ul. Pushkina, d. Kolotushkina");
        $("#react-select-3-input").setValue("Haryana");
        $("#react-select-3-input").pressEnter();
        $("#react-select-4-input").setValue("Panipat");
        /*
         за счет разрешения экрана не смогла добиться появления кнопки SUBMIT, поэтому прописала так
         есть ли возможность кроме такого костыля еще как-то ее вытащить?
         */
        $("#react-select-4-input").pressEnter().pressTab().pressEnter();

        //чисто формально тест прошел, но можно ли как-то прописать, чтобы именно в таком-то столбце было такое-то решение?

        $(".table").shouldHave(text("Jane"));
        $(".table").shouldHave(text("Doe"));
        $(".table").shouldHave(text("janedoe@test.com"));
        $(".table").shouldHave(text("Female"));
        $(".table").shouldHave(text("8800555353"));
        $(".table").shouldHave(text("9 January,1994"));
        $(".table").shouldHave(text("Maths, History"));
        $(".table").shouldHave(text("Reading, Music"));
        $(".table").shouldHave(text( "Cat.jpg"));
        $(".table").shouldHave(text("ul. Pushkina, d. Kolotushkina"));
        $(".table").shouldHave(text("Haryana"));
        $(".table").shouldHave(text("Panipat"));

    }
}

