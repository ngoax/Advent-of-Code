package day6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class RaceCalculator {
    protected static String readFile() throws IOException {
        FileInputStream file = new FileInputStream("src/day6/input");
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

    protected static List<Map<Integer, Integer>> createMap(String[] s) {
        String[] time = s[0].replaceAll("\\D", " ").trim().split("\\s+");
        String[] distance = s[1].replaceAll("\\D", " ").trim().split("\\s+");

        System.out.println(Arrays.toString(time));
        System.out.println(Arrays.toString(distance));

        /*
         Wrap maps separately within a list, as workaround for Maps not saving multiple values for the same key
         As seen in input file: The key-value pair "{70=1134}" exists twice, and solution does require both pairs for the calculation
        */
        List<Map<Integer,Integer>> list = new ArrayList<>();
        for (int i=0; i<time.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(Integer.parseInt(time[i]), Integer.parseInt(distance[i]));
            list.add(map);
        }
        System.out.println(Arrays.asList(list.toArray()));
        return list;
    }

    protected static int calcPossibilities(int raceLength, int raceRecord) {
        int length;
        int possibilities = 0;
        for (int secondsButtonHeld=0; secondsButtonHeld<=raceLength; secondsButtonHeld++) {
            length = (raceLength - secondsButtonHeld) * secondsButtonHeld;
            if (length > raceRecord) {
                possibilities++;
            }
        }
        return possibilities;
    }
}
