import java.util.ArrayList;

public class Day8 {
    public static void main(String[] args) {
        String input = "resources/Day8Input.txt";
        ArrayList<String> data = Utils.txtToArrayList(input);

        boolean finished = false;
        int fixLine = -1;
        int accumulator = 0;

        while (!finished) {
            fixLine++;
            if (data.get(fixLine).split(" ")[0].equals("acc")) {
                continue;
            }
            accumulator = 0;
            ArrayList<Integer> linesRead = new ArrayList<>();
            int currentLine = 0;

            while (!linesRead.contains(currentLine)) {
                linesRead.add(currentLine);
                String[] newCommand = data.get(currentLine).split(" ");
                if (currentLine == fixLine) {
                    if (newCommand[0].equals("nop")) {
                        newCommand[0] = "jmp";
                    } else {
                        newCommand[0] = "nop";
                    }
                }
                switch (newCommand[0]) {
                    case "nop":
                        currentLine += 1;
                        break;
                    case "acc":
                        if (newCommand[1].charAt(0) == '+') {
                            accumulator += Integer.parseInt(newCommand[1].substring(1));
                        } else {
                            accumulator -= Integer.parseInt(newCommand[1].substring(1));
                        }
                        currentLine += 1;
                        break;
                    case "jmp":
                        if (newCommand[1].charAt(0) == '+') {
                            currentLine += Integer.parseInt(newCommand[1].substring(1));
                        } else {
                            currentLine -= Integer.parseInt(newCommand[1].substring(1));
                        }
                        break;
                    default:
                        finished = true;
                        System.out.println("Woohoo!" + newCommand[0]);
                }
            }
        }
        System.out.println("The answer is: " + accumulator);
    }
}
