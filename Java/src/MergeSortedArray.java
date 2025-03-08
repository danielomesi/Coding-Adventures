import java.util.LinkedList;
import java.util.Queue;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        merge(nums1,1,nums2,0);
        for (int num : nums1) {
            System.out.print(num + " ");
        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> waitList = new LinkedList<Integer>();
        int runnerA = 0, runnerB = 0, elementOfB;

        while (runnerA < n+m ) {
            elementOfB = runnerB < n ? nums2[runnerB] : Integer.MAX_VALUE;
            if (runnerA>=m) {
                if (!waitList.isEmpty() && runnerB < n) {
                    if (waitList.peek() <= elementOfB) {
                        nums1[runnerA] = waitList.poll();
                    }
                    else {
                        nums1[runnerA] = elementOfB;
                        runnerB++;
                    }
                }
                else {
                    if (waitList.isEmpty()) {
                        nums1[runnerA] = elementOfB;
                        runnerB++;
                    }
                    else {
                        nums1[runnerA] = waitList.poll();
                    }
                }
            }
            else if (waitList.isEmpty()) {
                if (nums1[runnerA] > elementOfB) {
                    waitList.add(nums1[runnerA]);
                    nums1[runnerA] = elementOfB;
                    runnerB++;
                }
            }
            else {
                waitList.add(nums1[runnerA]);
                if (waitList.peek() < elementOfB) {
                    nums1[runnerA] = waitList.poll();
                }
                else {
                    nums1[runnerA] = elementOfB;
                    runnerB++;
                }
            }
            runnerA++;
        }
    }
}
