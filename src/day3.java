import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class day3 {

    public static long lineMultiplierSum(String line) {
        int sum = 0;
        String[] multipliers = line.split("mul\\(");
        for (String multiplier : multipliers) {
            String[] numbers = multiplier.split("\\)")[0].split(",");
            if (numbers.length == 2) {
                long x, y;
                try {
                    x = Integer.parseInt(numbers[0]);
                    try {
                        y = Integer.parseInt(numbers[1]);
                        long xy = x * y;
                        sum += xy;

                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long sum1 = 0;
        long sum2 = 0;

        String line = null;
        StringBuilder allLines = new StringBuilder();
        while (!(line = bufferedReader.readLine()).isEmpty()) {
            sum1 += lineMultiplierSum(line);
            allLines.append(line);
        }

        sum2 = sum1;
        String[] donts = allLines.toString().split("don't\\(\\)");
        for (String nono : donts) {
            nono = nono.split("do\\(\\)")[0];
            sum2 -= lineMultiplierSum(nono);
        }

        System.out.println(sum1);
        System.out.println(sum2);
    }
}
