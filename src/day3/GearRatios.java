package day3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GearRatios {
    protected static String readFile() throws IOException {
        FileInputStream file = new FileInputStream("src/day3/input");
        StringBuilder stringBuilder = new StringBuilder();
        int readByte;

        while ((readByte = file.read()) != -1) {
            stringBuilder.append((char) readByte);
        }
        return stringBuilder.toString();
    }

    protected static List<Number> findNumbers(String s) {
        List<Number> numbers = new ArrayList<>();
        Pattern p = Pattern.compile("\\d+"); // matches all digits
        Matcher matcher = p.matcher(s);

        while (matcher.find()) {
            int n = Integer.parseInt(matcher.group()); // Int of match
            int startIdx = matcher.start() % 141; // Start index of match
            int endIdx = (matcher.end() % 141) - 1; // End index of match
            int lineNum = matcher.end() / 141; // Line number of match
            numbers.add(new Number(n, startIdx, endIdx, lineNum));
            System.out.println("Found: " + matcher.group() + " Start index: " + startIdx + ", End index: " + endIdx + " Line: " + lineNum); // Outputs result
        }
        return numbers;
    }

    protected static String[] createStringArr(String s) {
        return s.split("\\n");
    }

    // Idea: Get the line, the one above and below from the String-array. We have to search on the same startIdx, endIdx for each line to find adjacent characters.
    protected static boolean findAdjacent(int startIdx, int endIdx, String line, String above, String under) {
        // check sides
        if (startIdx > 0 && endIdx < line.length() - 1) {
            if ((!Character.isDigit(line.charAt(startIdx - 1)) && line.charAt(startIdx - 1) != '.') || (!Character.isDigit(line.charAt(endIdx + 1)) && line.charAt(endIdx + 1) != '.')) {
                return true;
            }

            // check line above (if not first line)
            if (above != null) {
                for (int i = startIdx - 1; i <= endIdx + 1; i++) {
                    if (i >= 0 && i < above.length() && !Character.isDigit(above.charAt(i)) && above.charAt(i) != '.') {
                        return true;
                    }
                }
            }

            // check line under (if not last line)
            if (under != null) {
                for (int i = startIdx - 1; i <= endIdx + 1; i++) {
                    if (i >= 0 && i < under.length() && !Character.isDigit(under.charAt(i)) && under.charAt(i) != '.') {
                        return true;
                    }
                }
            }

        }

        // check when number is on far left
        else if (startIdx == 0) {
            if ((!Character.isDigit(line.charAt(endIdx + 1)) && line.charAt(endIdx + 1) != '.')) {
                return true;
            }
            if (above != null) {
                for (int i = startIdx; i <= endIdx + 1; i++) {
                    if (i >= 0 && i < above.length() && !Character.isDigit(above.charAt(i)) && above.charAt(i) != '.') {
                        return true;
                    }
                }
            }

            // check line under (if not last line)
            if (under != null) {
                for (int i = startIdx; i <= endIdx + 1; i++) {
                    if (i >= 0 && i < under.length() && !Character.isDigit(under.charAt(i)) && under.charAt(i) != '.') {
                        return true;
                    }
                }
            }
        }

        // check when number is on far right
        else if (endIdx == line.length()-1) {
            if ((!Character.isDigit(line.charAt(startIdx - 1)) && line.charAt(startIdx - 1) != '.')) {
                return true;
            }

            // check line above (if not first line)
            if (above != null) {
                for (int i = startIdx - 1; i <= endIdx; i++) {
                    if (i >= 0 && i < above.length() && !Character.isDigit(above.charAt(i)) && above.charAt(i) != '.') {
                        return true;
                    }
                }
            }

            // check line under (if not last line)
            if (under != null) {
                for (int i = startIdx - 1; i <= endIdx; i++) {
                    if (i >= 0 && i < under.length() && !Character.isDigit(under.charAt(i)) && under.charAt(i) != '.') {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
