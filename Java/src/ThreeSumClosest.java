import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println("The closest sum is " + threeSumClosest(nums,target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left,right,currentSum,closestSum,signedCurrentDifference,unsignedCurrentDifference;
        int minDifference = Integer.MAX_VALUE;
        closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                currentSum = nums[i] + nums[left] + nums[right];
                signedCurrentDifference = target - currentSum;
                unsignedCurrentDifference = Math.abs(signedCurrentDifference);
                if (signedCurrentDifference == 0) {
                    return currentSum;
                }
                else {
                    closestSum = unsignedCurrentDifference<minDifference ? currentSum : closestSum;
                    minDifference = Math.min(unsignedCurrentDifference,minDifference);
                    if (signedCurrentDifference < 0) right--;
                    else left++;
                }
            }
        }
        return closestSum;
    }
}
