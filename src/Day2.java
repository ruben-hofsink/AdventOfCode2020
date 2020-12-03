import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        //ArrayList<String> data = readTxt("resources/Day2input.txt");
        int value1 = 0;
        int value2 = 0;
        String filename = "resources/Day2input.txt";
        Scanner myReader = new Scanner(new File(filename));
        String line, password;
        int n1, n2, n3;
        char req;
        
        while (myReader.hasNextLine()) {
            line = myReader.nextLine();
            n1 = Integer.parseInt(line.split("-")[0]);
            n2 = Integer.parseInt(line.split("-")[1].split(" ")[0]);
            req = line.split(" ")[1].charAt(0);
            password = line.split(" ")[2];
            n3 = 0;

            //Star 1
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == req) {
                    n3++;
                }
            }
            if (n3 >= n1 && n3 <= n2) {
                value1++;
            }

            //Star 2
            if (password.length() >= n2) {
                if (!((password.charAt(n1 - 1) == req) == (password.charAt(n2 - 1) == req))) {
                    value2++;
                }
            } else {
                if (password.charAt(n1 - 1) == req) {
                    value2++;
                }
            }
        }
        System.out.println("1: " + value1 + "\n2: " + value2);


    }


    public static ArrayList<String> readTxt(String filename) throws FileNotFoundException {
        Scanner myReader = new Scanner(new File(filename));
        ArrayList<String> returnFile = new ArrayList<>();
        while (myReader.hasNextLine()) {
            returnFile.add(myReader.nextLine());
        }
        return returnFile;
    }
}
