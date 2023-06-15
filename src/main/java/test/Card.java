package test;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

public class Card {
    public static void main(String[] args) {
        Period period1 = Period.ofWeeks(1).ofDays(3);
        Period period2 = Period.ofDays(10);
        System.out.println(period1);
        System.out.println(period2);
    }
    }

