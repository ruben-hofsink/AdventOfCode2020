import java.util.*;

public class Day10 {
    static Map<Integer, Long> memoisationTable= new HashMap<>();
    public static void main(String[] args) {
        String input = "resources/Day10Input.txt";
        ArrayList<String> data = Utils.txtToArrayList(input);

        TreeSet<Integer> sortedList = new TreeSet<>();
        assert data != null;
        for (String line : data) {
            sortedList.add(Integer.parseInt(line));
        }
        int answer1 = solvePartOne(sortedList);

        //Add the starting node to the list
        sortedList.add(0);
        HashMap<Integer, TreeSet<Integer>> adapterOptions = new HashMap<>();
        for (int adapter : sortedList) {
            memoisationTable.put(adapter, (long) -1);
            TreeSet<Integer> options = new TreeSet<>();
            for (int difference = 1; difference < 4; difference++) {
                if (sortedList.contains(adapter + difference)) {
                    //System.out.println("" + adapter + " " + difference);
                    options.add(adapter + difference);
                }
            }
            adapterOptions.put(adapter, (TreeSet<Integer>) options.clone());
        }
        System.out.println(recursiveCounter(0, adapterOptions));
    }

    public static long recursiveCounter(int currentAdapter, HashMap<Integer, TreeSet<Integer>> adapterOptions) {
        TreeSet<Integer> currentOptions = adapterOptions.get(currentAdapter);
        long nOptions = 0;
        //System.out.println(currentAdapter);
        if (currentOptions.size() == 0) {
            return 1;
        }
        for (int option : currentOptions) {
            if (memoisationTable.get(option) == -1) {
                memoisationTable.put(option, recursiveCounter(option, adapterOptions));
            }
            nOptions += memoisationTable.get(option);
        }
        return nOptions;
    }

    public static int solvePartOne(TreeSet<Integer> sortedList) {
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
        int answer = oneJoltDifferences * threeJoltDifferences;
        System.out.printf("1 jolt: %d, 3 jolt: %d, final jolts: %d, answer: %d\n", oneJoltDifferences, threeJoltDifferences, currentJolt, answer);
        return answer;
    }
}
