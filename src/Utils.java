import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    public static @Nullable ArrayList<String> txtToArrayList(String filename) {
        @Nullable ArrayList<String> result = null;
        File textFile = new File(filename);
        Scanner myReader;
        try {
            myReader = new Scanner(textFile);
            ArrayList<String> data = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String newLine = myReader.nextLine();
                data.add(newLine);
            }
            result = data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
