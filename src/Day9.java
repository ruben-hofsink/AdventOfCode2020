import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Day9 {
    public static void main(String[] args) {
        String input = "resources/Day9Input.txt";
        ArrayList<String> data = Utils.txtToArrayList(input);
        ArrayList<Long> dataAsInteger = new ArrayList<>();
        for (String line : data) {
            dataAsInteger.add(Long.parseLong(line));
        }

        long nextNumber = solvePart1(dataAsInteger);
        System.out.println("The answer to part 1 is: " + nextNumber);

        ArrayList<Long> contingentSet = getContingentSet(dataAsInteger, nextNumber);

        long min = contingentSet.get(0);
        long max = contingentSet.get(0);
        for (int i = 1; i < contingentSet.size(); i++) {
            if (contingentSet.get(i) > max) {
                max = contingentSet.get(i);
            } else if (contingentSet.get(i) < min) {
                min = contingentSet.get(i);
            }
        }

        System.out.println("The answer to part 2 is: " + (min + max));
    }

    private static long solvePart1(ArrayList<Long> dataAsInteger) {
        boolean containsSum = true;
        int index = 25;
        long nextNumber = -1;
        while (containsSum && index < dataAsInteger.size()) {
            containsSum = false;
            nextNumber = dataAsInteger.get(index);
            for (int i = index - 25; i < (index - 1); i ++) {
                for (int j = i + 1; j < index; j++) {
                    if (nextNumber == dataAsInteger.get(i) + dataAsInteger.get(j)) {
                        //System.out.println(new long[] {i, dataAsInteger.get(i), j, dataAsInteger.get(j), nextNumber});
                        containsSum = true;
                    }
                }
            }
            index++;
        }
        return nextNumber;
    }

    private static ArrayList<Long> getContingentSet(ArrayList<Long> dataAsLong, long targetSum) {
        long sum = 0;
        int startIndex = -1;
        int index = -1;
        while (sum != targetSum && startIndex < dataAsLong.size()) {
            startIndex++;
            index = startIndex;
            sum = 0;
            while (sum < targetSum) {
                sum += dataAsLong.get(index);
                index++;
            }
        }
        ArrayList<Long> contingentSet = new ArrayList<>();
        for (int i = startIndex; i < index; i++) {
            contingentSet.add(dataAsLong.get(i));
        }
        return contingentSet;
    }

}
