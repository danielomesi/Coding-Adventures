import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        int half = nums.length / 2;
        Map<Integer,Integer> number2Count = new HashMap<>();
        int res = 0;

        for (int num: nums) {
            number2Count.merge(num, 1, Integer::sum);
            if (number2Count.get(num) > half) res = num;
        }

        return res;

    }
}
