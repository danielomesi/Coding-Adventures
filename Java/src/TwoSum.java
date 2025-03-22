import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public record MyNumber(int num,int originalIndex) implements Comparable<MyNumber> {
        @Override
        public int compareTo(MyNumber o) {
            return Integer.compare(this.num, o.num);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int[] res = twoSum2PointerApproach(nums,6);
        System.out.println("number #1: " + nums[res[0]] + " number #2: " +  nums[res[1]]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numbersMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            numbersMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numbersMap.containsKey(complement)) {
                int j = numbersMap.get(complement);
                if (j!=i) return new int[]{j, i};
            }
        }
        return null;
    }

    public static int[] twoSum2PointerApproach(int[] nums, int target) {
        MyNumber[] numbers = new MyNumber[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = new MyNumber(nums[i],i);
        }
        Arrays.sort(numbers);
        int left = 0, right = numbers.length-1,sum;
        while (left < right) {
            sum = numbers[left].num + numbers[right].num;
            if (sum == target) {
                return new int[]{numbers[left].originalIndex,numbers[right].originalIndex};
            }
            if (sum < target) left++;
            else right--;
        }
        return null;
    }
}
