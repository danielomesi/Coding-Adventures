import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        System.out.println("before: " + Arrays.toString(chars));
        int length = compress(chars);
        System.out.println("after: " + Arrays.toString(chars));
        System.out.println("returned: " + length);
    }

    public static int compress(char[] chars) {
        int j;
        int consecutiveAppearances;
        int charsLength = chars.length;


        for (int i = 0; i < charsLength; i++) {
            consecutiveAppearances = 1;
            j = i+1;
            while (j<charsLength && chars[j]==chars[i]) {
                consecutiveAppearances++;
                j++;
            }
            if (consecutiveAppearances == 1) continue;
            else {
                String appearancesCountAsStr = String.valueOf(consecutiveAppearances);
                int lengthOfAppearancesAsStr = appearancesCountAsStr.length();
                for (int k = 0; k < lengthOfAppearancesAsStr; k++) {
                    chars[i+k+1] = appearancesCountAsStr.charAt(k);
                }
                int numOfStepsBack = consecutiveAppearances-lengthOfAppearancesAsStr-1;
                if (j<charsLength) shiftArrayBackNSteps(chars,j,numOfStepsBack,charsLength);

                charsLength-=numOfStepsBack;
                i = i+lengthOfAppearancesAsStr;
            }
        }
        return charsLength;
    }

    public static void shiftArrayBackNSteps(char[] chars,int startPoint, int n, int length) {
        while (startPoint < length) {
            if ((startPoint-n)>=0) chars[startPoint-n] = chars[startPoint];
            startPoint++;
        }
    }
}
