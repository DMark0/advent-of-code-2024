import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class day1 {
    public static void main(String[] args) throws IOException {
        //part 1
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        String line = null;

        while (!(line = bufferedReader.readLine()).isEmpty()){
            String[] numbers = line.split("\\s+");
            left.add(Integer.parseInt(numbers[0]));
            right.add(Integer.parseInt(numbers[1]));
        }

        left.sort(Integer::compareTo);
        right.sort(Integer::compareTo);

        int distanceSum = 0;
        for (int i = 0; i < left.size(); i++) {
            distanceSum += Math.abs(left.get(i) - right.get(i));
        }

        System.out.println(distanceSum);

        //part2
        int similarityScore = 0;
        for (int i = 0; i < left.size(); i++) {
            int count = 0;
            for (int j = 0; j < right.size(); j++) {
                if (Objects.equals(left.get(i), right.get(j)))
                    count++;
            }
            similarityScore +=  left.get(i) * count;
        }

        System.out.println(similarityScore);
    }
}
