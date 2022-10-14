package org.example;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int minAscii = 32;
    private static int maxAscii = 126;
    private static char[] inputCharacters;
    private static int key;
    private static String userInput;

    public static void main(String[] args) {
        System.out.println("Select action:");
        System.out.println("enc - encryption");
        System.out.println("dec - decryption");
        String selection = scanner.nextLine();

        switch (selection) {
            case "enc" -> encryption();
            case "dec" -> decryption();
            default -> System.out.println("Incorrect input!");
        }
    }

    private static void encryption() {
        System.out.println("Enter your message to encrypt: ");
        userInput = scanner.nextLine();
        System.out.println("Enter your encryption key: ");
        try {
            key = scanner.nextInt();
            scanner.nextLine();
        }
        catch (Exception e) {
            System.out.println("Wrong value!");
            return;
        }

        inputCharacters = userInput.toCharArray();
        char[] encryptedCharacters = new char[userInput.length()];

        for (int i = 0; i < userInput.length(); i++) {
            int ascii = inputCharacters[i];
            int encryptedAscii;
            encryptedAscii = (ascii + key - minAscii) % 95 + minAscii;
            encryptedCharacters[i] = (char) encryptedAscii;
        }
        System.out.println(String.valueOf(encryptedCharacters));
    }

    private static void decryption() {
        System.out.println("Enter your message to decrypt: ");
        userInput = scanner.nextLine();
        System.out.println("Enter your decryption key: ");
        try {
            key = scanner.nextInt();
            scanner.nextLine();
        }
        catch (Exception e) {
            System.out.println("Wrong value!");
            return;
        }

        inputCharacters = userInput.toCharArray();
        char[] decryptedCharacters = new char[userInput.length()];

        for (int i = 0; i < userInput.length(); i++) {
            int ascii = inputCharacters[i];
            int decryptedAscii;
            decryptedAscii = (ascii - key - minAscii) % 95 + minAscii;
            decryptedCharacters[i] = (char) decryptedAscii;
        }
        System.out.println(String.valueOf(decryptedCharacters));
    }
}