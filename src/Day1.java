import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File textFile = new File("resources/Day1Input.txt");
        Scanner myReader = new Scanner(textFile);

        ArrayList<Integer> data = new ArrayList<>();
        while (myReader.hasNextLine()) {
            String newLine = myReader.nextLine();
            data.add(Integer.parseInt(newLine));
        }

        for (int i = 0; i < data.size() - 2; i++) {
            int n1 = data.get(i);
            for (int j = i + 1; j < data.size() - 1; j++) {
                int n2 = data.get(j);
                for (int k = j + 1; k < data.size(); k++) {
                    int n3 = data.get(k);
                    if (n1 + n2 + n3 == 2020) {
                        System.out.print("" + n1 + " + " + n2 + " + " + n3 + " = 2020 and multiplies to " + (n1 * n2 * n3));
                    }
                }
            }
        }
    }
}
