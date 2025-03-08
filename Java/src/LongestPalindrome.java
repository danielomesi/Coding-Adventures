public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }

    public static String longestPalindrome(String s) {
        String maxString = "";

        if (s == null || s.isEmpty()) return maxString;

        for (int i=0; i<s.length(); i++) {
            for (int j=0;j<2;j++) {
                int left = i;
                int right = i+j;
                String str = getTheLongestPalindromeExpandingFromLoc(s,left,right);
                maxString = str.length() > maxString.length() ? str : maxString;
            }
        }

        return maxString;
    }

    public static String getTheLongestPalindromeExpandingFromLoc(String s, int left, int right) {
        String palindrome = "";
        if (s.isEmpty() || left > right) return palindrome;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindrome = s.substring(left, right+1);
            left--;
            right++;
        }
        return palindrome;
    }

















    public static String longestPalindrome2(String s) {
        return getLongestPalindromeRecursively(s);
    }

    public static String getLongestPalindromeRecursively(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) return s;
        System.out.println("Checking if " + s + " is the longest palindrome");
        String res;
        boolean isCurrStringPalindrome = true;
        int len = s.length();
        int leftIndex = 0;
        int rightIndex = len - 1;
        while (leftIndex < rightIndex) {
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                isCurrStringPalindrome = false;
                break;
            }
            leftIndex++;
            rightIndex--;
        }
        if (isCurrStringPalindrome) {
            res = s;
        }
        else {
            String stringWithoutFirstChar = s.substring(1, len);
            String stringWithoutLastChar = s.substring(0,len-1);
            String longestStringWithoutFirstChar = getLongestPalindromeRecursively(stringWithoutFirstChar);
            String longestStringWithoutLastChar = getLongestPalindromeRecursively(stringWithoutLastChar);
            res = longestStringWithoutFirstChar.length() > longestStringWithoutLastChar.length() ?
             longestStringWithoutFirstChar : longestStringWithoutLastChar;
        }
        return res;
    }
}
