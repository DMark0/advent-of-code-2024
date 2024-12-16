import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day4 {

    public static int countX(char[][] puzzle, int x, int y) {

        int sum = 0;
        //east
        if (x + 3 < puzzle.length) {
            if (puzzle[x + 1][y] == 'M')
                if (puzzle[x + 2][y] == 'A')
                    if (puzzle[x + 3][y] == 'S')
                        sum += 1;
        }
        //west
        if (x >= 3) {
            if (puzzle[x - 1][y] == 'M')
                if (puzzle[x - 2][y] == 'A')
                    if (puzzle[x - 3][y] == 'S')
                        sum += 1;
        }
        //north
        if (y >= 3) {
            if (puzzle[x][y - 1] == 'M')
                if (puzzle[x][y - 2] == 'A')
                    if (puzzle[x][y - 3] == 'S')
                        sum += 1;
        }
        //south
        if (y + 3 < puzzle[0].length) {
            if (puzzle[x][y + 1] == 'M')
                if (puzzle[x][y + 2] == 'A')
                    if (puzzle[x][y + 3] == 'S')
                        sum += 1;
        }

        //northeast
        if (x + 3 < puzzle.length && y >= 3) {
            if (puzzle[x + 1][y - 1] == 'M')
                if (puzzle[x + 2][y - 2] == 'A')
                    if (puzzle[x + 3][y - 3] == 'S')
                        sum += 1;
        }
        //northwest
        if (x >= 3 && y >= 3) {
            if (puzzle[x - 1][y - 1] == 'M')
                if (puzzle[x - 2][y - 2] == 'A')
                    if (puzzle[x - 3][y - 3] == 'S')
                        sum += 1;
        }
        //southeast
        if (x + 3 < puzzle.length && y + 3 < puzzle[0].length) {
            if (puzzle[x + 1][y + 1] == 'M')
                if (puzzle[x + 2][y + 2] == 'A')
                    if (puzzle[x + 3][y + 3] == 'S')
                        sum += 1;
        }
        //southwest
        if (x >= 3 && y + 3 < puzzle[0].length) {
            if (puzzle[x - 1][y + 1] == 'M')
                if (puzzle[x - 2][y + 2] == 'A')
                    if (puzzle[x - 3][y + 3] == 'S')
                        sum += 1;
        }
        return sum;
    }

    private static int countA(char[][] puzzle, int x, int y) {
        int sum = 0;
        if (x >= 1 && x + 1 < puzzle.length && y >= 1 && y + 1 < puzzle[0].length){
            if ( (puzzle[x-1][y-1]=='M' && puzzle[x+1][y+1]=='S') || (puzzle[x-1][y-1]=='S' && puzzle[x+1][y+1]=='M'))
                if ( (puzzle[x+1][y-1]=='M' && puzzle[x-1][y+1]=='S') || (puzzle[x+1][y-1]=='S' && puzzle[x-1][y+1]=='M'))
                    sum+=1;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int y = 0;
        char[][] puzzle = new char[140][140];
        while (!(line = bufferedReader.readLine()).isEmpty()) {
            for (int i = 0; i < line.length(); i++)
                puzzle[i][y] = line.charAt(i);
            y++;
        }

        int sumX = 0;
        int sumA = 0;
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                if (puzzle[i][j] == 'X')
                    sumX += countX(puzzle, i, j);

                if (puzzle[i][j] == 'A')
                    sumA += countA(puzzle, i, j);
            }
        }
        System.out.println(sumX);
        System.out.println(sumA);
    }


}
