package day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Part2 {
    public static void main(String[] args) throws IOException {
        readFile();
    }
    protected static void readFile() throws IOException {
        FileInputStream file = new FileInputStream("src/day1/test");
        StringBuilder stringBuilder = new StringBuilder();
        int readByte;
        String tempValueFirst;
        String tempValueLast;
        int totalValue = 0;


        while ((readByte = file.read()) != -1) {
            stringBuilder.append((char) readByte);
        }

        String modifiedString = stringBuilder.toString().replaceAll("(?!\\\\w)one(?!\\\\w)", "1")
                .replaceAll("(?<!\\\\w)two(?!\\\\w)", "2")
                .replaceAll("(?<!\\\\w)three(?!\\\\w)", "3")
                .replaceAll("(?<!\\\\w)four(?!\\\\w)", "4")
                .replaceAll("(?<!\\\\w)five(?!\\\\w)", "5")
                .replaceAll("(?<!\\\\w)six(?!\\\\w)", "6")
                .replaceAll("(?<!\\\\w)seven(?!\\\\w)", "7")
                .replaceAll("(?<!\\\\w)eight(?!\\\\w)", "8")
                .replaceAll("(?<!\\\\w)nine(?!\\\\w)", "9");

        System.out.println(modifiedString);

        String[] strArray = modifiedString.replaceAll("[^\\d\\n]", "").split("\\n");

        for (int i=0; i<strArray.length; i++) {
            tempValueFirst = strArray[i].substring(0, 1); // Get first digit
            tempValueLast = strArray[i].substring(strArray[i].length()-1); // Get last digit
            strArray[i] = tempValueFirst + tempValueLast;
        }

        int[] intArray = new int[strArray.length];

        for (int i=0; i<strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
            totalValue += intArray[i];
        }


        System.out.println(Arrays.toString(intArray));
        System.out.println("The total sum of the calibration values is: " + totalValue);
    }

}