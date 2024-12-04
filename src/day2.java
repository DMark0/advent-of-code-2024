import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class day2 {

    public static boolean safetyChecker(ArrayList<Integer> report) {
        boolean monotony = report.get(1) > report.get(0);
        boolean isSafe = true;

        for (int i = 1; i < report.size(); i++) {
            if ((report.get(i) > report.get(i - 1)) != monotony) {
                isSafe = false;
                break;
            }
            monotony = report.get(i) > report.get(i - 1);
            if (Math.abs(report.get(i) - report.get(i - 1)) < 1 || Math.abs(report.get(i) - report.get(i - 1)) > 3) {
                isSafe = false;
                break;
            }
        }
        return isSafe;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        int count1 = 0;
        int count2 = 0;
        while (!(line = bufferedReader.readLine()).isEmpty()) {
            ArrayList<Integer> report = new ArrayList<>();
            String[] levels = line.split("\\s+");
            for (String level : levels) {
                report.add(Integer.parseInt(level));
            }

            if (safetyChecker(report)) {
                count1++;
                count2++;
            } else {
                for (int i = 0; i < report.size(); i++) {
                    ArrayList<Integer> tempReport = (ArrayList<Integer>) report.clone();
                    tempReport.remove(i);

                    if (safetyChecker(tempReport)) {
                        count2++;
                        break;
                    }
                }
            }
        }
        System.out.println(count1);
        System.out.println(count2);
    }
}
