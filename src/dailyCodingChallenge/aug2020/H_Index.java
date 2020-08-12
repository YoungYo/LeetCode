package dailyCodingChallenge.aug2020;

import java.util.Arrays;

public class H_Index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = len - 1; i >= 0; i--) {
            if (citations[i] == len - i) {
                return citations[i];
            } else if (citations[i] < len - i) {
                return len - i - 1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        H_Index h_index = new H_Index();
        int[][] test = {
                {3,0,6,1,5},
                {1,7,8,9,10},
                {7,8,9,6}
        };
        System.out.println(h_index.hIndex(test[2]));
    }
}
