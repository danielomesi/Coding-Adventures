class RemoveElementFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println("The length of the output array is " + removeDuplicates(nums));

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int end = nums.length - 1;
        int currentNumber = nums[0];
        int previousNumber;
        int strike = 0;

        for (int i = 0; i <= end; i++) {
            previousNumber = currentNumber;
            currentNumber = nums[i];
            if (i == 0) {
                strike++;
            }
            else {
                if (currentNumber == previousNumber) {
                    if (++strike > 2) {
                        shiftElements1StepBack(nums, i, end);
                        end--;
                        i--;
                    }
                }
                else {
                    strike = 1;
                }
            }

        }

        return end + 1;
    }

    private static void shiftElements1StepBack(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (i+1 < nums.length) nums[i] = nums[i+1];
        }
    }
}

