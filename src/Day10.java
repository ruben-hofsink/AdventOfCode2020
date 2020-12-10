import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Day10 {
    public static void main(String[] args) {
        String input = "resources/Day10Input.txt";
        ArrayList<String> data = Utils.txtToArrayList(input);

        TreeSet<Integer> sortedList = new TreeSet<>();
        for (String line : data) {
            sortedList.add(Integer.parseInt(line));
        }

        int startJolt = 0;
        int oneJoltDifferences = 0;
        int threeJoltDifferences = 0;
        int currentJolt = 0;
        for (int element : sortedList) {
            int difference  = element - currentJolt;
            if (difference == 3) {
                threeJoltDifferences++;
                currentJolt = element;
            } else if (difference == 1) {
                oneJoltDifferences++;
                currentJolt = element;
            } else if (difference == 2) {
                currentJolt = element;
            } else {
                System.out.println("Error: " + currentJolt + " and " + "element");
            }
        }
        currentJolt += 3;
        threeJoltDifferences++;

        System.out.printf("1 jolt: %d, 3 jolt: %d, final jolts: %d, answer: %d", oneJoltDifferences, threeJoltDifferences, currentJolt, threeJoltDifferences * oneJoltDifferences);
    }
}
