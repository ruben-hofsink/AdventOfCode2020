import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        File textFile = new File("resources/Day3Input.txt");
        Scanner myReader = new Scanner(textFile);
        ArrayList<String> data = new ArrayList<>();
        while (myReader.hasNextLine()) {
            String newLine = myReader.nextLine();
            data.add(newLine);
        }

        int rowLength = data.get(0).length();
        int colLength = data.size();

        int[] dRows = {1, 1, 1, 1, 2};
        int[] dCols = {1, 3, 5, 7, 1};
        int[] nTrees = new int[dRows.length];
        for (int i = 0; i < dRows.length; i++) {
            int dRow = dRows[i];
            int dCol = dCols[i];

            int row = 0;
            int col = 0;
            nTrees[i] = 0;

            while (row < colLength) {
                switch (data.get(row).charAt(col)) {
                    case '.':
                        break;
                    case '#':
                        nTrees[i]++;
                        break;
                }
                row += dRow;
                col = (col + dCol) % rowLength;
            }
            System.out.println("" + nTrees[i]);
        }
        long answer = 1;
        for (int i = 0; i < dRows.length; i++) {
            answer = answer * nTrees[i];
        }
        System.out.println("Day 3 Part 2: " + answer);
    }
}
