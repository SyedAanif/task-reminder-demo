package com.example.task_reminder_demo.design;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import static com.example.task_reminder_demo.design.ExtendedUserValidator.*;
import static com.example.task_reminder_demo.design.ExtendedUserValidator.UserResult.*;

public interface ExtendedUserValidator extends Function<User, UserResult> {

    static ExtendedUserValidator isEmailValid() {
        return user -> {
            System.out.println("Email Validation");
            return user.email().contains("@") ? SUCCESS : EMAIL_INVALID;
        };
    }

    static ExtendedUserValidator isPhoneValid() {
        return user -> {
            System.out.println("Phone Validation");
            return user.phone().startsWith("+91") ? SUCCESS : PHONE_INVALID;};
    }

    static ExtendedUserValidator isAdult() {
        return user -> {
            System.out.println("Age Validation");
            return Period.between(user.dob(), LocalDate.now()).getYears() > 18 ? SUCCESS : UNDER_AGE;};
    }

    default ExtendedUserValidator and(ExtendedUserValidator other) {
        return user -> {
            System.out.println("Chaining Validations");
            UserResult result = this.apply(user);
            return result.equals(SUCCESS) ? other.apply(user) : result;
        };
    }

    enum UserResult {
        EMAIL_INVALID,
        PHONE_INVALID,
        UNDER_AGE,
        SUCCESS
    }
}
