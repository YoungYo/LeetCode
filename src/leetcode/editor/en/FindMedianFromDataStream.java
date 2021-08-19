//The median is the middle value in an ordered integer list. If the size of the 
//list is even, there is no middle value and the median is the mean of the two mid
//dle values. 
//
// 
// For example, for arr = [2,3,4], the median is 3. 
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5. 
// 
//
// Implement the MedianFinder class: 
//
// 
// MedianFinder() initializes the MedianFinder object. 
// void addNum(int num) adds the integer num from the data stream to the data st
//ructure. 
// double findMedian() returns the median of all elements so far. Answers within
// 10-5 of the actual answer will be accepted. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//Output
//[null, null, null, 1.5, null, 2.0]
//
//Explanation
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0
// 
//
// 
// Constraints: 
//
// 
// -105 <= num <= 105 
// There will be at least one element in the data structure before calling findM
//edian. 
// At most 5 * 104 calls will be made to addNum and findMedian. 
// 
//
// 
// Follow up: 
//
// 
// If all integer numbers from the stream are in the range [0, 100], how would y
//ou optimize your solution? 
// If 99% of all integer numbers from the stream are in the range [0, 100], how 
//would you optimize your solution? 
// 
// Related Topics Two Pointers Design Sorting Heap (Priority Queue) Data Stream 
//
// 👍 4971 👎 88

  
package leetcode.editor.en;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new FindMedianFromDataStream().new MedianFinder();
        medianFinder.addNum(10);
        medianFinder.addNum(5);
        medianFinder.addNum(9);
        medianFinder.addNum(3);
        medianFinder.addNum(2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        private int[] elements;
        private int size;

        /** initialize your data structure here. */
        public MedianFinder() {
            this.elements = new int[50000];
            this.size = 0;
        }

        public void addNum(int num) {
            int i = size;
            while (i > 0 && elements[i - 1] > num) {
                elements[i] = elements[i - 1];
                i--;
            }
            elements[i] = num;
            size++;
        }

        public double findMedian() {
            int mid = size / 2;
            if ((size & 1) == 1) {
                return this.elements[mid];
            } else {
                return (this.elements[mid - 1] + this.elements[mid]) / 2.0;
            }
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}