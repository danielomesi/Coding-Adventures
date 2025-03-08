public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = removeElement(arr,val);
        System.out.println("k is " + k);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int mainRunner = 0, searcher = 0;
        int k = 0;

        while (mainRunner < nums.length) {
            if (nums[mainRunner] == val) {
                searcher = Math.max(searcher + 1, mainRunner + 1);
                searcher = searchForNextValueWhichIsNotVal(nums,searcher,val);
                if (searcher == -1) break;
                else {
                    k++;
                    int temp = nums[mainRunner];
                    nums[mainRunner] = nums[searcher];
                    nums[searcher] = temp;
                }
            }
            else {
                k++;
            }
            mainRunner++;
        }
        return k;
    }

    public static int searchForNextValueWhichIsNotVal(int[] nums, int start, int val) {
        int index = -1;
        while (start<nums.length) {
            if (nums[start] != val) {
                index = start;
                break;
            }
            start++;
        }
        return index;
    }
}
