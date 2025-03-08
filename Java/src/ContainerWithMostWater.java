public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
       int left = 0;
       int right = height.length - 1;
       int max = 0;
       int square_height, square_width;
       while (left < right) {
           square_width = right-left;
           square_height = Math.min(height[left], height[right]);
           max = Math.max(max, square_height*square_width);
           if (height[left] < height[right]) left++;
           else right--;
       }
       return max;
    }
}
