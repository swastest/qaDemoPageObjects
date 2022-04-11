package qaDemo;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.FormTestWithFakerPageObjects;
import utils.enums.Gender;
import utils.enums.Hobbies;
import utils.enums.Subjects;
import utils.enums.randoming.Randoming;

import java.util.Random;

import static java.lang.String.format;

public class FormTestWithFaker {
    FormTestWithFakerPageObjects formPO = new FormTestWithFakerPageObjects();
    Randoming randoming = new Randoming();
    // CalendarComponent calendar = new CalendarComponent();


    Faker faker = new Faker(); //https://github.com/DiUS/java-faker

//    Calendar calendar = Calendar.getInstance();  //get day, month etc from date  https://www.baeldung.com/java-year-month-day
//    Date dateOfBirth = faker.date().birthday();
//        calendar.setTime(dateOfBirth);

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            tel = faker.numerify("##########"),
//    String phone = faker.number().digits(10), - еще вариант
            subjectsInput = Subjects.values()[new Random().nextInt(Subjects.values().length)].toString(),
            gender = Gender.values()[new Random().nextInt(Gender.values().length)].toString(),
            hobby = Hobbies.values()[new Random().nextInt(Hobbies.values().length)].toString(),
            currentAddress = faker.address().fullAddress(),
            state = randoming.getState(),
            file = "123.jpg",
            city = randoming.getCity(state),
            responseHeader = "Thanks for submitting the form",

      //  dateOfBirthDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)),
    //birthDay = faker.date().birthday().toString(). - не работает
            expectedFullName = format("%s %s", firstName, lastName),
            fullStateCity = format("%s %s", state, city);

    // String dataBirth

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void Test1() {

        formPO.openPage()
                .setFirstname(firstName)
                .setLastname(lastName)
                .setEmail(email)
                .setPhoneNumber(tel)
                .setCurrentAddress(currentAddress)
                .setBirthDate("04", "May", "1991")
                .setSubjects(subjectsInput)
                .setGender(gender)
                .setCheckbox(hobby)
                .setState(state)
                .setCity(city)
                .setFile(file)
                .submitKlik()
                .checkTableHeaderResponse(responseHeader)
                .checkTableContent("Student Name", expectedFullName)
                .checkTableContent("Student Email", email)
                .checkTableContent("Gender", gender)
                .checkTableContent("Mobile", tel)
                .checkTableContent("Date of Birth", "04 May,1991")
                .checkTableContent("Subjects", subjectsInput)
                .checkTableContent("Hobbies", hobby)
                .checkTableContent("Picture", file)
                .checkTableContent("Address", currentAddress)
                .checkTableContent("State and City", fullStateCity);

    }
}
