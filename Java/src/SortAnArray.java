import java.util.Random;

public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = {2,3,5,1};
        sortArray(nums);
        for (int num : nums) System.out.println(num);
    }

    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, randomIndex, right);
        int pivot = nums[right];
        int swapIndex = left;

        for (int i = left; i < right; ++i) {
            if (nums[i] <= pivot) {
                swap(nums, swapIndex++, i);
            }
        }

        swap(nums, swapIndex, right);
        return swapIndex;
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
