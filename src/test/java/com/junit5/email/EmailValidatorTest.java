package com.junit5.email;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmailValidatorTest {

    EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    // TODO Write test for EmailValidator
    // The names of the methods should give you a pointer what to test for

    @Test
    void shouldReturnTrueIfMatchPattern() {
        String email = "thien@gmail.com";
        Assertions.assertTrue(EmailValidator.isValidEmail(email));
    }

    @Test
    @DisplayName("Ensure that the usage of a subdomain is still valid, see https://en.wikipedia.org/wiki/Subdomain")
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        Assertions.assertFalse(EmailValidator.isValidEmail("lars.vogel@analytics.gmail.com"));
        String email = "thien@test.gmail.com";
        Assertions.assertFalse(EmailValidator.isValidEmail(email));
    }

}