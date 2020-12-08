import java.util.ArrayList;

public class Day6 {
    public static void main(String[] args) {
        String input = "resources/Day6Input.txt";
        ArrayList<String> data = Utils.txtToArrayList(input);

        String answers = "";
        int count1 = 0;
        for (String datum : data) {
            if (datum.isEmpty()) {
                count1 += answers.length();
                answers = "";
            } else {
                for (int i = 0; i < datum.length(); i++) {
                    if (!answers.contains("" + datum.charAt(i))) {
                        answers += datum.charAt(i);
                    }
                }
            }
        }
        count1 += answers.length();

        StringBuilder answers2 = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        int count2 = 0;
        for (String datum : data) {
            if (datum.isEmpty()) {
                System.out.println(answers2.length());
                count2 += answers2.length();
                answers2 = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
            } else {
                StringBuilder newAnswers2 = new StringBuilder();
                for (int i = 0; i < answers2.length(); i++) {
                    if (datum.contains("" + answers2.charAt(i))) {
                        newAnswers2.append(answers2.charAt(i));
                    }
                }
                answers2 = new StringBuilder(newAnswers2);
            }
        }
        count2 += answers2.length();

        System.out.println("Part 1 answer: " + count1);
        System.out.println("Part 2 answer: " + count2);
    }
}
