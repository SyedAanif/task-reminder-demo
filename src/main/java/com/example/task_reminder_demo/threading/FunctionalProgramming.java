package com.example.task_reminder_demo.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalProgramming {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7);

        // Imperative
        List<Integer> evenNumbers = new ArrayList<>();
        for (int i : list) {
            if (i % 2 == 0) { // i & 1 == 0
               evenNumbers.add(i);
            }
        }

        for (int even : evenNumbers) {
            System.out.print(even + " ");
        }

        System.out.println();

//         Functional/Declarative
        Predicate<Integer> evenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return (i & 1) == 0;
            }
        };

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer even) {
                System.out.print(even + " ");
            }
        };
        list.stream().filter(evenPredicate).forEach(consumer);

//         using lambdas
        list.stream()
                .filter(i -> (i & 1) == 0)
                .forEach(even -> System.out.print(even + " "));

        // first class citizen, higher order lang
        // callbacks
        // stream
        // Combinator Pattern
//        Person -> name, email, phone, fax, pager;
        // validations
//        Person().isValidEmail


        // Function<T,R>
        // imperative
        System.out.println(imIncrement(2));
        int inc = imIncrement(3);
        int mul = imMultiply(inc);
        System.out.println(mul);

        // declarative
        System.out.println(increment.apply(2));
        System.out.println(increment.andThen(multiply).apply(3));


//                new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer integer) {
//                return 0;
//            }
//        };

        // BiFunction<T,U,R>
        BiFunction<Integer, Boolean, String> messaging = (amt, showAmt) -> {
            if (showAmt) {
                return String.format("Amount: %d", amt);
            }
            return "Amount: ********";
        };
        System.out.println(messaging.apply(10, true));
        System.out.println(messaging.apply(10000000, false));

        // Consumer<T>
        Consumer<String> con = s -> System.out.println("Hello "+ s);
        con.accept("Spring");


        // BiConsumer<T,U>
        // Predicate<T>
        Predicate<Integer> pred = i -> i > 18;
        System.out.println(pred.test(20));
        // phone validator
        // email validator
        Predicate<String> phoneVal = phone -> phone.length() == 10;
        Predicate<String> phoneStartVal = phone -> phone.startsWith("91") ;
        Predicate<String> emailVal = email -> email != null && email.contains("@");
        System.out.println(phoneVal.test("1234567890"));
        System.out.println(emailVal.test("a@b.com"));
        System.out.println(phoneVal.and(phoneStartVal).test("912345678"));


        // Supplier
        Supplier<String> constructUrl = () -> "https://";
        System.out.println(constructUrl.get());

        // Stream APIs
//        list.stream().filter(i -> {
//            System.out.println("in");
//            //
//            return true;
//        }).forEach();

        // combinator pattern

        // callbacks
//        function myFunc(i, j, callback) {
//            console.log(i)
//                    if(j) {
//                        console.log(j)
//                    } else {
//                        callback()
//                    }
//        }

        Consumer<String> callback = s -> System.out.println(String.format("Valid: %s", s));

        myFunc(18, "1234567890", phoneVal, callback);

        myFunc(18, "ab.com", emailVal, callback);

        myFuncRun(18, "1234567890", phoneVal, () -> System.out.println("Inside runnable"));

    }

    static void myFunc(Integer i, String s, Predicate<String> pred, Consumer<String> callback) {
        System.out.println(i);
        if (pred.test(s)) {
            callback.accept(s);
        }
    }

    static void myFuncRun(Integer i, String s, Predicate<String> pred, Runnable r) {
        System.out.println(i);
        if (pred.test(s)) {
            r.run();
        }
    }

    static Function<Integer, Integer> increment = i ->  i + 1;

    static Function<Integer, Integer> multiply = i -> i * 100;

    public static Integer imIncrement(Integer i) {
        return i+1;
    }

    public static Integer imMultiply(Integer i) {
        return i*100;
    }


}
