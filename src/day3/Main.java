package day3;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        String file = GearRatios.readFile();
        List<Number> numbers = GearRatios.findNumbers(file);
        String[] strings = GearRatios.createStringArr(file);

        for (Number n : numbers) {
            if (n.lineNum >= 1 && n.lineNum < strings.length - 2) {
                if (GearRatios.findAdjacent(n.getStartIdx(), n.getEndIdx(), strings[n.getLineNum()], strings[n.getLineNum() - 1], strings[n.getLineNum() + 1])) {
                    sum += n.getN();
                }
            } else if (n.lineNum == 0) {
                // First line has no above line
                if (GearRatios.findAdjacent(n.getStartIdx(), n.getEndIdx(), strings[n.getLineNum()], null, strings[n.getLineNum() + 1])) {
                    sum += n.getN();
                }
            } else {
                // Last line has no line under
                if (GearRatios.findAdjacent(n.getStartIdx(), n.getEndIdx(), strings[n.getLineNum()], strings[n.getLineNum() - 1], null)) {
                    sum += n.getN();
                }
            }
        }

    System.out.println(sum);
    }




}
