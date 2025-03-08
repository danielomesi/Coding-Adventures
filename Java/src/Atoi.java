public class Atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483648"));
    }

    //"-515"

    public static int myAtoi(String s) {
        int num;
        boolean isPositive = true;
        int i=0;
        StringBuilder numAsStr = new StringBuilder();

        //remove all the leading spaces
        while (i<s.length() && s.charAt(i) == ' ') i++;

        if (i<s.length()) {
            char firstNonSpaceChar = s.charAt(i);
            if (firstNonSpaceChar == '+' || firstNonSpaceChar == '-') {
                i++;
                if (firstNonSpaceChar == '-') isPositive = false;
            }
        }


        //separate the first seen number from the (if exists) non-number string after it
        while (i<s.length()) {
            int currentDig = (int)s.charAt(i) - (int)'0';
            if (currentDig<0 || currentDig > 9) break;
            numAsStr.append(currentDig);
            i++;
        }

        num = strToNum(numAsStr.toString(),isPositive);

        if (!isPositive) num=-num;

        return num;
    }

    private static int strToNum(String numAsStr, boolean isPositive) {
        int num = 0;

        for (int i = 0; i < numAsStr.length(); i++) {
            int digit = numAsStr.charAt(i) - '0';  // Extract digit

            // Check for overflow before performing multiplication
            if (isPositive) {
                if (num > (Integer.MAX_VALUE - digit) / 10) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (num > (Integer.MIN_VALUE + digit) / -10) {
                    return Integer.MIN_VALUE;
                }
            }

            num = num * 10 + digit;  // Update number
        }

        return num;
    }

}
