package day2;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        String s = CodeConundrum.readFile();
        String[] strArr = CodeConundrum.createStringArr(s);

        for (String str : strArr) {
            if (CodeConundrum.checkBlue(str) && CodeConundrum.checkRed(str) && CodeConundrum.checkGreen(str)) {
                sum += CodeConundrum.findID(str);
            }
        }
        System.out.println(sum);
    }
}
