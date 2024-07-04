package tests.web;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();
    public String randomEmail = faker.internet().emailAddress();
    public String randomPassword = faker.random().hex(9);
}
