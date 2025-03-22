import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculate1MaxQualityScore {
    public static void main(String[] args) {
        List<Integer> ratings = new ArrayList<Integer>(Arrays.asList(5, -3, -3, 2, 4));
        int impactFactor = 3;
        System.out.println("The max quality score is " + calculateMaxQualityScore(impactFactor,ratings));
    }

    public static long calculateMaxQualityScore(int impactFactor, List<Integer> ratings) {
        int n = ratings.size();
        long maxScore = Long.MIN_VALUE;
        maxScore = Math.max(maxScore, kadane(ratings));

        List<Integer> amplifiedRatings = new ArrayList<>(ratings);
        for (int i = 0; i < n; i++) {
            amplifiedRatings.set(i, ratings.get(i) * impactFactor);
        }
        maxScore = Math.max(maxScore, kadane(amplifiedRatings));

        List<Integer> adjustedRatings = new ArrayList<>(ratings);
        for (int i = 0; i < n; i++) {
            int value = ratings.get(i);
            if (value >= 0) {
                adjustedRatings.set(i, value / impactFactor);
            } else {
                adjustedRatings.set(i, (int) Math.ceil((double) value / impactFactor));
            }
        }
        maxScore = Math.max(maxScore, kadane(adjustedRatings));

        return maxScore;
    }

    private static long kadane(List<Integer> arr) {
        long maxSoFar = Long.MIN_VALUE;
        long maxEndingHere = 0;
        for (int x : arr) {
            maxEndingHere = Math.max(x, maxEndingHere + x);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

}


