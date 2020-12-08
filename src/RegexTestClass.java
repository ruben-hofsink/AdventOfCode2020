import java.util.regex.Pattern;

public class RegexTestClass {
    public static void main(String[] args) {
        String byd = "19951";
        boolean result = Pattern.matches("\\d{4}", byd);
        System.out.println(result);
    }
}
