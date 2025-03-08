import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> res = fourSum(nums, target);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).get(0)  + "," + res.get(i).get(1) + "," + res.get(i).get(2) + "," + res.get(i).get(3));
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        int num1,num2,left,right;
        long sum;
        if (nums.length >= 4) {
            for (int i = 0; i < nums.length - 3; i++) {
                num1 = nums[i];
                for (int j = i + 1; j < nums.length - 2; j++) {
                    num2 = nums[j];
                    left = j + 1;
                    right = nums.length - 1;
                    while (left < right) {
                        sum = (long) num1 + num2 + nums[left] + nums[right];
                        if (sum == target) {
                            List<Integer> newSetOfResult = new ArrayList<>();
                            newSetOfResult.add(num1);
                            newSetOfResult.add(num2);
                            newSetOfResult.add(nums[left]);
                            newSetOfResult.add(nums[right]);
                            Collections.sort(newSetOfResult);
                            res.add(newSetOfResult);
                            right--;
                            left++;
                        }
                        else if (sum < target) left++;
                        else right--;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}
