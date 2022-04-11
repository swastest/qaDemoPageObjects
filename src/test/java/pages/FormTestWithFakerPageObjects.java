package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTestWithFakerPageObjects {

    CalendarComponent calendar = new CalendarComponent();
    //locators
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput= $("#lastName"),
            userEmailInput =$("#userEmail"),
            phoneNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput =  $("#subjectsInput"),
            genderRadio = $("#genterWrapper"),
            hobbyCheck =  $("#hobbiesWrapper"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            uploadFileInput = $("input#uploadPicture"),
            submitID = $("#submit"),
            headerTableResponse= $("#example-modal-sizes-title-lg"),
            tableContent =$(".table-responsive")
                    ;

    //actions
    public FormTestWithFakerPageObjects openPage (){
        open("/automation-practice-form");

        return this;
    }

    public FormTestWithFakerPageObjects setFirstname (String firstName){

        firstNameInput.setValue(firstName);
        return this;
    }

    public FormTestWithFakerPageObjects setLastname (String lastName){
        lastNameInput.setValue(lastName);
        return this;
    }

    public FormTestWithFakerPageObjects setEmail (String email) {
        userEmailInput.setValue(email);
        return this;
    }


    public FormTestWithFakerPageObjects setPhoneNumber (String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public FormTestWithFakerPageObjects setCurrentAddress (String currentAddress){

        currentAddressInput.setValue(currentAddress);
        return this;
    }
    public FormTestWithFakerPageObjects setBirthDate (String day, String month, String year){
        dateOfBirthInput.click();
        calendar.setData(day, month, year);

        return this;
    }
    public FormTestWithFakerPageObjects setSubjects (String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public FormTestWithFakerPageObjects setGender (String gender) {
        genderRadio.$(byText(gender)).click();

        return this;
    }

    public FormTestWithFakerPageObjects setCheckbox (String hobby) {
        hobbyCheck.$(byText(hobby)).click();

        return this;
    }

    public FormTestWithFakerPageObjects setState (String state) {

        stateInput.setValue(state).pressEnter();
        return this;
    }

    public FormTestWithFakerPageObjects setCity (String city) {

        cityInput.setValue(city).pressEnter();
        return this;
    }

    public FormTestWithFakerPageObjects setFile (String file) {
        uploadFileInput.uploadFromClasspath(file);
        return this;

    }

    public FormTestWithFakerPageObjects submitKlik (){
        submitID.click();
        return this;
    }

    public FormTestWithFakerPageObjects checkTableHeaderResponse (String text) {
        headerTableResponse.shouldHave(text("Thanks for submitting the form"));
        return this;

    }

    public FormTestWithFakerPageObjects checkTableContent (String key, String value){
        tableContent.$(byText(key)).parent().shouldHave(text(value));
        return this;

    }
}
