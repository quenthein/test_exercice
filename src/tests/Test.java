package tests;

import java.time.LocalTime;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Scénario 1: Automatique, palindrome, anglais, soir.
        String language = "en";
        String period = "soirée";
        String input = "racecar";

        if (isPalindrome(input)) {
            String bienDit = getBienDit(language);
            System.out.println(input);
            System.out.println(bienDit);
        } else {
            String bonjour = getBonjour(language, period);
            System.out.println(bonjour);
            System.out.println(reverse(input));
            String auRevoir = getAuRevoir(language, period);
            System.out.println(auRevoir);
        }

        // Scénario 2: Automatique, non-palindrome, français, matin.
        language = "fr";
        period = "matin";
        input = "hello";

        if (isPalindrome(input)) {
            String bienDit = getBienDit(language);
            System.out.println(input);
            System.out.println(bienDit);
        } else {
            String bonjour = getBonjour(language, period);
            System.out.println(bonjour);
            System.out.println(reverse(input));
            String auRevoir = getAuRevoir(language, period);
            System.out.println(auRevoir);
        }

        // Scénario 3: Saisie libre du client, langue et moment actuels du système.
        Scanner scanner = new Scanner(System.in);
        language = "fr";
        period = getPeriod(LocalTime.now());

        System.out.println("Veuillez saisir une chaîne :");
        input = scanner.nextLine();

        if (isPalindrome(input)) {
            String bienDit = getBienDit(language);
            System.out.println(input);
            System.out.println(bienDit);
        } else {
            String bonjour = getBonjour(language, period);
            System.out.println(bonjour);
            System.out.println(reverse(input));
            String auRevoir = getAuRevoir(language, period);
            System.out.println(auRevoir);
        }
    }

    public static String getPeriod(LocalTime time) {
        if (time.isAfter(LocalTime.of(6, 0)) && time.isBefore(LocalTime.of(12, 0))) {
            return "matin";
        } else if (time.isAfter(LocalTime.of(12, 0)) && time.isBefore(LocalTime.of(18, 0))) {
            return "après-midi";
        } else if (time.isAfter(LocalTime.of(18, 0)) && time.isBefore(LocalTime.of(22, 0))) {
            return "soirée";
        } else {
            return "nuit";
        }
    }

    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static boolean isPalindrome(String input) {
        String reversed = reverse(input);
        return input.equals(reversed);
    }

    public static String getBienDit(String language) {
        switch (language) {
            case "fr":
                return "Bien dit";
            case "en":
                return "Well said";
            case "es":
                return "Bien dicho";
            default:
                return "";
        }
    }
}