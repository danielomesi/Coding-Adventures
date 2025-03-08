import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> letterCombinations(String digits) {
        int dig;
        char[] possibleCharsInSpecificDigit;
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        if (digits.length() == 1) {
            dig = Integer.parseInt(digits);
            possibleCharsInSpecificDigit = CharsFromDigits.getPossibleCharsOfPhoneDigit(dig);
            for (char ch : possibleCharsInSpecificDigit) {
                if ((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')) {
                    result.add(String.valueOf(ch));
                }
            }
        }
        else {
            List<String> allCombinationsWithoutLastDigit =
                    letterCombinations( digits.substring(0,digits.length() - 1));
            dig = Integer.parseInt(String.valueOf(digits.charAt(digits.length()-1)));
            possibleCharsInSpecificDigit = CharsFromDigits.getPossibleCharsOfPhoneDigit(dig);
            for (String s : allCombinationsWithoutLastDigit) {
                for (char ch : possibleCharsInSpecificDigit) {
                    if ((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')) {
                        result.add(s + ch);
                    }
                }
            }
        }
        return result;
    }
}
