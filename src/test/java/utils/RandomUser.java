package utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class RandomUser {
    @FindBy(id = "id_gender1")
    WebElement CustomerGender1;

    @FindBy(id = "id_gender2")
    WebElement CustomerGender2;

    // we create pools we need to registration
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String address1;
    public String phoneNumber;
    public String city;
    public String zipCode;
    public int dayOfBirth;
    public int monthOfBirth;
    public int yearOfBirth;

    public RandomUser() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        yearOfBirth = faker.random().nextInt(1910, 2020);
        email = firstName + lastName + yearOfBirth + "@gmail.com";
        zipCode = faker.random().nextInt(10000, 99999).toString();
        password = faker.pokemon().name() + yearOfBirth;
        phoneNumber = faker.numerify("#########");
        city = faker.address().city();
    }

    @Override
    public String toString() {
        return "RandomUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address1='" + address1 + '\'' +
                ", zipCode=" + zipCode +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    public static void main(String[] args) {
        RandomUser user = new RandomUser();
        System.out.println(user);
    }
}