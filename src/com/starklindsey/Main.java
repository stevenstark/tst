package com.starklindsey;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
//        Integer tempInCentigrade = 32;
//        System.out.println("Oh my it is early");
//        Function<Integer, Double> centigradeToFahrentheitInt = centigrade -> new Double((centigrade * 9/5) + 32);
//        Function<String, Integer> stringToInt = intAsString -> Integer.valueOf(intAsString);
//        System.out.println("Centigrade to Fahrenheit:" + centigradeToFahrentheitInt.apply(tempInCentigrade));
//        System.out.println("String to Integer: " + stringToInt.apply("4"));
        tstCarrierFlight();
        tstDepartureLine();
    }

    private static void tstCarrierFlight() {
        String starter = "3M0064";
        Pattern pattern = Pattern.compile("([A-Z][0-9]|[0-9][A-Z]|[A-Z][A-Z][A-Z]?)(\\d+[A-Z]?)$");
        Matcher matcher = pattern.matcher(starter);
        System.out.println("matcher.matches()?: " + matcher.matches());
        if (matcher.matches()) {
            System.out.println("group 1: " + matcher.group(1));
            System.out.println("group 2: " + matcher.group(2));
            System.out.println("\n\n");
        }
    }

    private static void tstDepartureLine() {
        String starter = "PNS                    1015A A   11   ";

        Pattern pattern = Pattern.compile("(^\\D{3})(\\s++)(\\d{4})(\\D)(\\s)(\\D)(\\s++)(\\d{0,5})(\\s++)");
        Matcher matcher = pattern.matcher(starter);
        System.out.println("matcher.matches()?: " + matcher.matches());
        System.out.println("count of groups: " + matcher.groupCount());
        if (matcher.matches()) {
            System.out.println("group 1: " + matcher.group(1)); // dep airport
            System.out.println("group 2: " + matcher.group(2)); // space
            System.out.println("group 3: " + matcher.group(3)); // hh:mm
            System.out.println("group 4: " + matcher.group(4)); // A or P
            System.out.println("group 5: " + matcher.group(5)); // space
            System.out.println("group 6: " + matcher.group(6)); // terminal
            System.out.println("group 7: " + matcher.group(7)); // space
            System.out.println("group 8: " + matcher.group(8)); // gate
            System.out.println("group 9: " + matcher.group(9)); // space
        }
    }
}
