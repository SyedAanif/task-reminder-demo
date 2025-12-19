package com.example.task_reminder_demo.design;

import java.time.LocalDate;

import static com.example.task_reminder_demo.design.ExtendedUserValidator.*;

public class Testing {
    public static void main(String[] args) {
        User usr = new User("Foo",
                "a@b.com",
                "+9112345678",
                LocalDate.of(2001, 1,1));

        System.out.println(usr.name());
        System.out.println(usr.email());
        System.out.println(usr.phone());
        System.out.println(usr.dob());

        System.out.println(usr.hashCode());

        System.out.println(usr);

//        User usr2 = new User("Foo",
//                "a@b.com",
//                "9112345678",
//                LocalDate.of(2001, 1,1));
//
//        System.out.println(usr.equals(usr2));
//        System.out.println(usr2.hashCode());

        // Start Validations
//        UserValidatorService userValidatorService = new UserValidatorService();
//        System.out.println(userValidatorService.isUserValid(usr));

        // Functional Programming Combinator Pattern
//        ExtendedUserValidator
        UserResult result = isEmailValid()
                .and(isPhoneValid())
                .and(isAdult())
                .apply(usr);

        System.out.println(result);

    }
}
