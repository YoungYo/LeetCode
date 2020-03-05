package medium;

public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[j], height[i]);
                if (maxArea < area){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public int maxArea_DoublePointer(int[] height){
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
        _11_ContainerWithMostWater cwm = new _11_ContainerWithMostWater();
        int[] input1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(cwm.maxArea(input1));
        System.out.println(cwm.maxArea_DoublePointer(input1));
    }
}
