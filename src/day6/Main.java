package day6;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] s = RaceCalculator.createStringArr(RaceCalculator.readFile());
        List<Map<Integer, Integer>> listOfMaps = RaceCalculator.createMap(s);
        int pos = 1;

        for (Map<Integer, Integer> map : listOfMaps) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int raceLength = entry.getKey();
                int raceRecord = entry.getValue();
                pos = pos * RaceCalculator.calcPossibilities(raceLength, raceRecord);
                System.out.println("Current possibilities: " + pos);
            }
        }
        System.out.println("Number of different possibilities: " + pos);
    }
}
