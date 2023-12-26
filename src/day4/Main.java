package day4;

import day1.Part1;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] strArr = Scatchcards.createStringArr(Scatchcards.readFile());
        int sum = 0;
        for (String s : strArr) {
            int[] winningNumbers = Scatchcards.getWinningNumbers(s);
            int[] scratchNumbers = Scatchcards.getScratchNumbers(s);
            sum += Scatchcards.countMatching(winningNumbers, scratchNumbers);
            System.out.println("------------- ");
            System.out.println("TOTAL SUM: " + sum);
            System.out.println("============= ");

        }
    }
}
