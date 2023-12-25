package day2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CodeConundrum {
    private final static int redMax = 12;
    private final static int greenMax = 13;
    private final static int blueMax = 14;


    protected static String readFile() throws IOException {
        FileInputStream file = new FileInputStream("src/day2/input");
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

    protected static int findID(String s) {
        Pattern pattern = Pattern.compile("Game\\s(\\d+):");
        Matcher matcher = pattern.matcher(s);

        // Check if the pattern is found and extract the number
        if (matcher.find()) {
            String numberString = matcher.group(1); // Extract the captured group
            int number = Integer.parseInt(numberString); // Convert the string to an integer
            System.out.println("Extracted number: " + number);
            return number;
        } else {
            System.out.println("No matching pattern found.");
            return -1;
        }
    }

    protected static boolean checkRed(String s) {
        return Stream.of(s.replaceAll(".*:", "").split("[;,]"))
                .filter(n -> n.endsWith("red"))
                .map(p -> p.replaceAll("[^0-9]", ""))
                .mapToInt(Integer::parseInt)
                .noneMatch(num -> num > redMax);
    }

    protected static boolean checkBlue(String s) {
        return Stream.of(s.replaceAll(".*:", "").split("[;,]"))
                .filter(n -> n.endsWith("blue"))
                .map(p -> p.replaceAll("[^0-9]", ""))
                .mapToInt(Integer::parseInt)
                .noneMatch(num -> num > blueMax);
    }

    protected static boolean checkGreen(String s) {
        return Stream.of(s.replaceAll(".*:", "").split("[;,]"))
                .filter(n -> n.endsWith("green"))
                .map(p -> p.replaceAll("[^0-9]", ""))
                .mapToInt(Integer::parseInt)
                .noneMatch(num -> num > greenMax);
    }


}


