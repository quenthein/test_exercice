import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String language = "en";
        String period = getPeriod(LocalTime.now());

        while (true) {
            System.out.println("Veuillez saisir une chaîne :");
            String input = scanner.nextLine();

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

    public static String getBonjour(String language, String period) {
        String salutation = "";
        switch (period) {
            case "matin":
                salutation = "_AM";
                break;
            case "après-midi":
                salutation = "_PM";
                break;
            case "soirée":
                salutation = "_SOIR";
                break;
            case "nuit":
                salutation = "_NUIT";
                break;
        }

        switch (language) {
            case "fr":
                return "Bonjour " + salutation;
            case "en":
                return "Hello " + salutation;
            case "es":
                return "Hola " + salutation;
            default:
                return "";
        }
    }

    public static String getAuRevoir(String language, String period) {
        String salutation = "";
        switch (period) {
            case "matin":
                salutation = "_AM";
                break;
            case "après-midi":
                salutation = "_PM";
                break;
            case "soirée":
                salutation = "_SOIR";
                break;
            case "nuit":
                salutation = "_NUIT";
                break;
        }

        switch (language) {
            case "fr":
                return "Au revoir " + salutation;
            case "en":
                return "Goodbye " + salutation;
            case "es":
                return "Adiós " + salutation;
            default:
                return "";
        }
    }
}
