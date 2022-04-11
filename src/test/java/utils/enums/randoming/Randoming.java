package utils.enums.randoming;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import utils.enums.*;

import java.time.LocalDate;
import java.util.Random;

import static java.time.chrono.JapaneseEra.values;

public class Randoming {

    Faker faker = new Faker();

    public LocalDate getDate() {

        return new java.sql.Date(faker.date().birthday().getTime()).toLocalDate();
    }


//    public String getGender() {
//        return StringUtils.capitalize(faker.dog().gender());
//    }

    public String getSubject() {

        return Subjects.values()[new Random().nextInt(Subjects.values().length)].toString();
    }

    public String getHobby() {

        return Hobbies.values()[new Random().nextInt(Hobbies.values().length)].toString();
    }

    public String getState() {

        return States.values()[new Random().nextInt(States.values().length)].toString();
    }

    public String getGender(){

        return Gender.values()[new Random().nextInt(Gender.values().length)].toString();
    }

    public String getCity(String state) {
        switch (state) {
            case "NCR":
                return NCRCities.values()[new Random().nextInt(NCRCities.values().length)].toString();
            case "Haryana":
                return HarCities.values()[new Random().nextInt(HarCities.values().length)].toString();
            case "Rajasthan":
                return RajCities.values()[new Random().nextInt(RajCities.values().length)].toString();
        }
        return "";  // - Что тут вернуть? не работает так
    }


}
