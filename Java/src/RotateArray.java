public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        rotate(nums,3);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] helper = new int[nums.length];
        int firstElementIndexAfterSplit = nums.length - k;

        System.arraycopy(nums,0,helper,0,nums.length);

        System.arraycopy(helper, firstElementIndexAfterSplit, nums, 0, k);
        System.arraycopy(helper,0,nums,k,nums.length-k);

    }
}
