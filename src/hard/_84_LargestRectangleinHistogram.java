package hard;

public class _84_LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0){
            return 0;
        }
        int res = 0;
        int[] lessFromLeft = new int[len], lessFromRight = new int[len];
        lessFromLeft[0] = -1;
        lessFromRight[len - 1] = len;
        for (int i = 1; i < len; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]){
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        for (int i = len - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < len && heights[p] >= heights[i]){
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        for (int i = 0; i < len; i++) {
            res = Math.max(res, (lessFromRight[i] - lessFromLeft[i] - 1) * heights[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        _84_LargestRectangleinHistogram lrh = new _84_LargestRectangleinHistogram();
        int[] heights1 = {2,1,5,6,2,3};

        System.out.println(lrh.largestRectangleArea(heights1));
    }
}
