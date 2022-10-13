package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minAscii = 97;
        int maxAscii = 122;

        System.out.println("Enter your message: ");
        String userInput = scanner.nextLine();
        userInput = userInput.toLowerCase();

        char[] inputCharacters = userInput.toCharArray();
        char[] encryptedCharacters = new char[userInput.length()];

        for (int i = 0; i < userInput.length(); i++) {
            int ascii = inputCharacters[i];
            int encryptedAscii = ascii;

            if ((ascii >= minAscii) && (ascii <= maxAscii)) {
                encryptedAscii = maxAscii - ascii + minAscii;
            }
            encryptedCharacters[i] = (char) encryptedAscii;
        }
        System.out.println(String.valueOf(encryptedCharacters));

    }
}