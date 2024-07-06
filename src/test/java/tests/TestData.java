package tests;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();
    public String randomEmail = faker.internet().emailAddress();
    public String randomPassword = faker.random().hex(9);
    public String randomPaypalMerchantId = faker.random().hex(13);
    public Integer randomPortalId = faker.number().numberBetween(100000, 999999);
    public String randomUuid = faker.internet().uuid();
    public String randomString = faker.random().hex(6);
}
