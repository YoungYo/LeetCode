package medium;

public class _11_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                int area = (i - j) * Math.min(height[j], height[i]);
                if (maxArea < area){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static int maxArea_DoublePointer(int[] height){
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0, j = height.length - 1; i < j;) {
            int hi = height[i], hj = height[j];
            int area;
            if (hi >= hj){
                area = (j - i) * hj;
                j--;
            }else {
                area = (j - i) * hi;
                i++;
            }
            if (area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] input1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(input1));
        System.out.println(maxArea_DoublePointer(input1));
    }
}
