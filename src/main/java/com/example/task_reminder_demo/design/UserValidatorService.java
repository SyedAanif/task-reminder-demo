package com.example.task_reminder_demo.design;

import java.time.LocalDate;
import java.time.Period;

public class UserValidatorService {

    public boolean isUserValid(User usr) {
        return isEmailValid(usr.email()) &&
                isPhoneValid(usr.phone()) &&
                isAdult(usr.dob());
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPhoneValid(String phone) {
        return phone.startsWith("+91");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 18;
    }
}
