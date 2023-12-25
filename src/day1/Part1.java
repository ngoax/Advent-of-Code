package day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Part1 {
    protected static void readFile() throws IOException {
        FileInputStream file = new FileInputStream("src/day1/input");
        StringBuilder stringBuilder = new StringBuilder();
        int readByte;
        String tempValueFirst;
        String tempValueLast;
        int totalValue = 0;


        while ((readByte = file.read()) != -1) {
            stringBuilder.append((char) readByte);
        }

        String[] strArray = stringBuilder.toString().replaceAll("[^\\d\\n]", "").split("\\n");

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