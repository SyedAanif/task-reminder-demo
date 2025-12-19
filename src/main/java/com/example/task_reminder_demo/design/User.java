package com.example.task_reminder_demo.design;


import java.time.LocalDate;


public record User(String name, String email, String phone, LocalDate dob) {
//    public User {
//        if (!email.contains("@")) {
//            throw new IllegalArgumentException("EmailInvalid");
//        }
//
//        if (!phone.startsWith("+91")) {
//            throw new IllegalArgumentException("PhoneInvalid");
//        }
//    }
}

