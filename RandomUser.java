package utils;

import com.github.javafaker.Faker;

public class RandomUser {

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String address1;
    public int zipCode;
    public int dayOfBirth;
    public int monthOfBirth;
    public int yearOfBirth;

    public RandomUser() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        yearOfBirth = faker.random().nextInt(1910, 2020);
        email = firstName + lastName + yearOfBirth + "gmail.com";
        zipCode = faker.random().nextInt(10000, 99999);
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
}
