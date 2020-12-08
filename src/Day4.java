import java.util.ArrayList;
import java.util.regex.*;


public class Day4 {
    public static void main(String[] args) {
        String input = "resources/Day4Input.txt";
        ArrayList<String> data = Utils.txtToArrayList(input);
        ArrayList<Passport> passports = new ArrayList<>();
        passports.add(new Day4.Passport());
        assert data != null;
        for (String datum : data) {
            if (!datum.contains(":")) {
                passports.add(new Day4.Passport());
            } else {
                String[] splitLine = datum.split(" ");
                for (String entry : splitLine) {
                    passports.get(passports.size() - 1).setData(entry);
                }
            }
        }
        int validPassportsPart1 = 0;
        int invalidPassportsPart1 = 0;
        int validPassportsPart2 = 0;
        int invalidPassportsPart2 = 0;
        for (Passport passport : passports) {
            if (passport.isValidPart1()) {
                validPassportsPart1++;
            } else {
                invalidPassportsPart1++;
            }

            if (passport.isValidPart2()) {
                validPassportsPart2++;
            } else {
                invalidPassportsPart2++;
            }
        }
        System.out.println("The number of valid passports for part 1 is: " + validPassportsPart1);
        System.out.println("The number of invalid passports for part 1 is: " + invalidPassportsPart1);

        System.out.println("The number of valid passports for part 2 is: " + validPassportsPart2);
        System.out.println("The number of invalid passports for part 2 is: " + invalidPassportsPart2);
    }

    private static class Passport {
        private String byr, iyr, eyr, hgt, hcl, ecl, pid, cid;



        /**
         *
         * @param input should be formatted with like "field:data" where type is one of the 8 passportfields.
         */
        public void setData(String input) {
            String field = input.split(":")[0];
            String data = input.split(":")[1];
            switch (field) {
                case "byr":
                    this.byr = data;
                    break;
                case "iyr":
                    this.iyr = data;
                    break;
                case "eyr":
                    this.eyr = data;
                    break;
                case "hgt":
                    this.hgt = data;
                    break;
                case "hcl":
                    this.hcl = data;
                    break;
                case "ecl":
                    this.ecl = data;
                    break;
                case "pid":
                    this.pid = data;
                    break;
                case "cid":
                    this.cid = data;
                    break;
                default:
                    break;
            }
        }

        public boolean isValidPart1() {
            boolean result = true;
            if (this.byr == null || this.eyr == null || this.ecl == null || this.hcl == null || this.hgt == null || this.iyr == null || this.pid == null) {
                result = false;
            }
            return result;
        }

        public boolean isValidPart2() {
            if (this.byr == null || this.eyr == null || this.ecl == null || this.hcl == null || this.hgt == null || this.iyr == null || this.pid == null) {
                return false;
            }
            if (!Pattern.matches("^\\d{4}$", this.byr) || Integer.parseInt(this.byr) < 1920 || Integer.parseInt(this.byr) > 2002) {
                return false;
            }
            if (!Pattern.matches("^\\d{4}$", this.iyr) || Integer.parseInt(this.iyr) < 2010 || Integer.parseInt(this.iyr) > 2020) {

                return false;
            }
            if (!Pattern.matches("^\\d{4}$", this.eyr) || Integer.parseInt(this.eyr) < 2020 || Integer.parseInt(this.eyr) > 2030) {
                return false;
            }
            System.out.println(this.hgt);
            Pattern patternHgt = Pattern.compile("^(\\d{2,3})(cm|in)$");
            Matcher m = patternHgt.matcher(this.hgt);
            if (!m.matches()) {
                System.out.println(this.hgt);
                return false;
            } else if (this.hgt.substring(this.hgt.length()-2).equals("cm") && (Integer.parseInt(m.group(1)) < 150 || Integer.parseInt(m.group(1)) > 193)) {
                System.out.println(this.hgt);
                return false;
            } else if (this.hgt.substring(this.hgt.length()-2).equals("in") && (Integer.parseInt(m.group(1)) < 59 || Integer.parseInt(m.group(1)) > 76)) {
                System.out.println(this.hgt);
                return false;
            }
            //System.out.println(this.hcl);
            if (!Pattern.matches("^#[0-9|a-f]{6}$", this.hcl)) {
                System.out.println(this.hcl);
                return false;
            }

            switch (this.ecl) {
                case "amb":
                case "blu":
                case "brn":
                case "gry":
                case "grn":
                case "hzl":
                case "oth":
                    break;
                default:
                    System.out.println(this.ecl);
                    return false;
            }
            //System.out.println(this.pid);
            if (!Pattern.matches("^\\d{9}$", this.pid)) {
                System.out.println(this.pid);
                return false;
            }
            return true;
        }
    }
}
