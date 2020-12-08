import java.util.ArrayList;

public class Day5 {
    public static void main(String[] args) {
        String input = "resources/Day5Input.txt";
        ArrayList<String> data = Utils.txtToArrayList(input);

        int highestSeatId = 0;
        assert data != null;

        ArrayList<Integer> seatIds = new ArrayList<>();
        for (String boardingPass : data) {
            int row = getRow(boardingPass.substring(0,7));
            int col = getCol(boardingPass.substring(7));
            int seatId = getSeatID(row,col);
            seatIds.add(seatId);
            highestSeatId = Math.max(highestSeatId, seatId);
        }

        System.out.println("The highest seat id is: " + highestSeatId);

        //Find my seat
        boolean found = false;
        int checkSeat = 1;
        while (!found && checkSeat < highestSeatId) {
            checkSeat++;
            if (!seatIds.contains(checkSeat) && seatIds.contains(checkSeat - 1) && seatIds.contains(checkSeat + 1)) {
                found = true;
            }
        }
        System.out.println("My seat is " + checkSeat);
    }
    public static int getSeatID(int row, int col) {
        return row * 8 + col;
    }
    public static int getRow(String code) {
        int row = 0;
        for (int i  = 0; i < code.length(); i++) {
            if (code.charAt(code.length() - i - 1) == 'B') {
                row += Math.pow(2,i);
            }
        }
        return row;
    }

    public static int getCol(String code) {
        int col = 0;
        for (int i  = 0; i < code.length(); i++) {
            if (code.charAt(code.length() - i - 1) == 'R') {
                col += Math.pow(2,i);
            }
        }
        return col;

    }
}
