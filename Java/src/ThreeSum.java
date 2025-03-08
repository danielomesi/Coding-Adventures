import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);
        int left, right, target, currentNum, numsToSkip = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            currentNum = nums[i];
            target = -nums[i];
            numsToSkip++;
            left = 0;
            right = nums.length - 1;
            while (numsToSkip + left < right) {
                int leftNum = nums[numsToSkip + left];
                int rightNum = nums[right];
                int sum = leftNum + rightNum;
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(currentNum);
                    list.add(leftNum);
                    list.add(rightNum);
                    Collections.sort(list);
                    res.add(list);
                    left++;
                    right--;
                } else if (sum > target) right--;
                else left++;
            }
        }
        return new ArrayList<>(res);
    }
}



