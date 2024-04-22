//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package CaesarCipher.java;

import java.util.Scanner;

public class CaesarCipher {
    //This is the string that lists the letters of the alphabet.
    static String alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

    public CaesarCipher(int key) {
    }

    //This encodes the text entered by the user.
    private static String encoding(String pText, int Key) {
        pText = pText.toLowerCase();
        String cText ="";
        for (int i = 0; i < pText.length(); i++) {
            int charIndex = alphabet.indexOf(pText.charAt(i));
            int newIndex = (charIndex + Key);
            char cipherChar = alphabet.charAt(newIndex);
            cText = cText + cipherChar;
        }
        return cText;
    }

    //This decodes the string after it is encoded.
    public static String decoding(String cText, int key) {
        cText = cText.toLowerCase();
        String pText ="";
        for (int i = 0 ; i < cText.length(); i++) {
            int charIndex = alphabet.indexOf(cText.charAt(i));
            int newIndex = (charIndex - key);
            if (newIndex <0 ) {
                newIndex = alphabet.length() + newIndex;
            }
            char plainChar = alphabet.charAt(newIndex);
            pText = pText + plainChar;
        }
        return pText;
    }

    //This prints the text so the user can enter the Plain Text and the Key.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //This asks for the Plain Text.
        System.out.print("Enter Plain Text >> ");
        String plain = scan.nextLine();

        //This asks for the key.
        System.out.print("Enter Key >> ");
        int Key = scan.nextInt();

        String cipherText = encoding(plain, Key);

        System.out.println("The cipher text: " + cipherText);

        System.out.println("The decoded message is: " + decoding(cipherText,Key));
    }
}

