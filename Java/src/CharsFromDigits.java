public class CharsFromDigits {
    private static final char[][] digitsToChars;

    static {
        digitsToChars = new char[8][4];
        setRowOfChars(0,'a',3);
        setRowOfChars(1,'d',3);
        setRowOfChars(2,'g',3);
        setRowOfChars(3,'j',3);
        setRowOfChars(4,'m',3);
        setRowOfChars(5,'p',4);
        setRowOfChars(6,'t',3);
        setRowOfChars(7,'w',4);
    }

    private static void setRowOfChars(int rowNum0Indexed, int firstChar, int numOfCharsInRow) {
        for (int i = 0; i < numOfCharsInRow; i++) {
            digitsToChars[rowNum0Indexed][i] = (char) (i + firstChar);
        }
        if (numOfCharsInRow == 3) digitsToChars[rowNum0Indexed][3] = '-';
    }

    public static void printAllChars() {
        for (char[] chars : digitsToChars) {
            for (char ch : chars) {
                System.out.print(ch);
            }
        }
    }

    //receiving real phone index between 2 and 9
    public static char[] getPossibleCharsOfPhoneDigit(int phoneIndex) {
        return digitsToChars[phoneIndex - 2];
    }
}
