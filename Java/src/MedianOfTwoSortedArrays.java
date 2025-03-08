

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("The median is " + findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    //question conditions: nums1.length+nums2.length >= 1
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        if (n > m)
            return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = n;
        while (lo <= hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = (n + m + 1) / 2 - mid1;

            // Find elements to the left and right of partition in nums1[]
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int r1 = (mid1 == n) ? Integer.MAX_VALUE : nums1[mid1];

            // Find elements to the left and right of partition in nums2[]
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r2 = (mid2 == m) ? Integer.MAX_VALUE : nums2[mid2];

            // If it is a valid partition
            if (l1 <= r2 && l2 <= r1) {

                // If the total elements are even, then median is
                // the average of two middle elements
                if ((n + m) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;

                    // If the total elements are odd, then median is
                    // the middle element
                else
                    return Math.max(l1, l2);
            }

            // Check if we need to take fewer elements from a[]
            if (l1 > r2)
                hi = mid1 - 1;

                // Check if we need to take more elements from a[]
            else
                lo = mid1 + 1;
        }
        return 0;
    }
}
