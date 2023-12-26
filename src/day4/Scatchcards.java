package day4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Scatchcards {
    protected static String readFile() throws IOException {
        FileInputStream file = new FileInputStream("src/day4/input");
        StringBuilder stringBuilder = new StringBuilder();
        int readByte;

        while ((readByte = file.read()) != -1) {
            stringBuilder.append((char) readByte);
        }
        return stringBuilder.toString();
    }

    protected static String[] createStringArr(String s) {
        return s.split("\\n");
    }

    protected static int[] getWinningNumbers(String s) {
        String[] strArr = s.split("[|:]");
        String[] subArr = strArr[1].trim().split("\\s+"); // use trim() to remove first and last whitespace
        System.out.println("Winning Numbers: " + Arrays.toString(subArr));
        return Stream.of(subArr).mapToInt(Integer::parseInt).toArray();
    }

    protected static int[] getScratchNumbers(String s) {
        String[] strArr = s.split("[|:]");
        String[] subArr = strArr[2].trim().split("\\s+"); // use trim() to remove first and last whitespace
        System.out.println("Scratched Numbers: " + Arrays.toString(subArr));
        return Stream.of(subArr).mapToInt(Integer::parseInt).toArray();
    }

    protected static int countMatching(int[] winningNumbers, int[] scratchNumbers) {
        int count = 0;

        for (int i=0; i<winningNumbers.length; i++) {
            for (int j=0; j<scratchNumbers.length; j++) {
                if (winningNumbers[i] == scratchNumbers[j]) {
                    count++;
                }
            }
        }
        System.out.println("Matches found: " + count);
        System.out.println("Points: " + (int) (Math.pow(2, count -1)));
        return (int) (Math.pow(2, count -1));
    }
}
