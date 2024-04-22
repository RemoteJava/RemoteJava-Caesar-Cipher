package CaesarCipher.java;

import java.util.Arrays;
import java.util.stream.IntStream;

import static jdk.internal.org.jline.utils.Log.debug;
import static sun.awt.image.MultiResolutionCachedImage.map;
import static sun.reflect.annotation.AnnotationParser.toArray;


public class BruteForceAttack{
    private static final int LETTER_A = Integer.parseInt("a");
    private static final int LETTER_Z = Integer.parseInt("z");
    //private static final ? extends Object[] ENGLISH_LETTERS_PROBABILITIES = ;

    private double[] chiSquares(String message) {
        double[] expectedLettersFrequencies = expectedLettersFrequencies(message.length());

        int ALPHABET_SIZE = 0;
        double[] chiSquares = new double[ALPHABET_SIZE];

        for (int offset = 0; offset < chiSquares.length; offset++) {
            String decipheredMessage = decipher(message, offset);
            long[] lettersFrequencies = observedLettersFrequencies(decipheredMessage);
            double chiSquare = new ChiSquareTest().chiSquare(expectedLettersFrequencies, lettersFrequencies);
            chiSquares[offset] = chiSquare;
        }

        return chiSquares;
    }

    private String decipher(String message, int offset) {
        return message;
    }

    private long[] observedLettersFrequencies(String message) {
        IntStream IntStream = null;
        return java.util.stream.IntStream.rangeClosed(LETTER_A, LETTER_Z)
                .mapToLong(letter -> countLetter((char) letter, message))
                .toArray();
    }

    private long countLetter(char letter, String message) {
        return message.chars()
                .filter(character -> character == letter)
                .count();
    }

    private double[] expectedLettersFrequencies(int messageLength) {
        //return Arrays.stream(ENGLISH_LETTERS_PROBABILITIES)
                //.map(probability -> probability * messageLength)
                //.toArray();
        return new double[0];
    }

    private int probableOffset(double[] chiSquares) {
        int probableOffset = 0;
        for (int offset = 0; offset < chiSquares.length; offset++) {
            debug(String.format("Chi-Square for offset %d: %.2f", offset, chiSquares[offset]));
            if (chiSquares[offset] < chiSquares[probableOffset]) {
                probableOffset = offset;
            }
        }

        return probableOffset;
    }

    private class ChiSquareTest {
        public double chiSquare(double[] expectedLettersFrequencies, long[] lettersFrequencies) {
            return 0;
        }
    }
}
