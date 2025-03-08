import java.util.ArrayList;
import java.util.List;

public class Zigzag {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }


    //PAYPALISHIRING
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder>  listOfStringBuilders = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            listOfStringBuilders.add(new StringBuilder());
        }
        int currentRow = 0;
        int dir = 0; //if 1 going down, if -1 going up

        for (int i = 0; i < s.length(); i++) {
            listOfStringBuilders.get(currentRow).append(s.charAt(i));
            if (currentRow == 0) dir = 1;
            else if (currentRow == numRows - 1) dir = -1;

            currentRow+=dir;
        }

        return listOfStringBuilderToSimpleString(listOfStringBuilders);

    }

    public static String listOfStringBuilderToSimpleString(List<StringBuilder> listOfStringBuilders) {
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : listOfStringBuilders) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }
}
