//Given an integer n, return the least number of perfect square numbers that sum
// to n. 
//
// A perfect square is an integer that is the square of an integer; in other wor
//ds, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 104 
// 
// Related Topics Math Dynamic Programming Breadth-First Search 
// 👍 4848 👎 250

  
package leetcode.editor.en;
public class PerfectSquares {
    public static void main(String[] args) {
         Solution solution = new PerfectSquares().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // Math O(sqrt(N))
    // This solution is based on Lagrange's four-square theorem which states that every natural number can be
    // represented as the sum of four integer (including zero) squares, and Legendre's three-square theorem which
    // says a positive integer can be expressed as the sum of three squares if and only if it is not of the form (4^k)*(8m+7) for integers k and m.
    //
    // Here is our strategy.
    // 1. check if n is a perfect square; if so, return 1;
    // 2. check if n is the sum of two squares through enumeration; if so, return 2;
    // 3. check if n is the sum of three squares using Legendre's three-square theorem;
    // 4. if none of above is true, return 4 (Lagrange's four-square theorem).
    class Solution {
        public int numSquares(int n) {
            // four-square and three-square theorems.
            while (n % 4 == 0)
                n /= 4;
            if (n % 8 == 7)
                return 4;
            if (this.isSquare(n))
                return 1;
            // enumeration to check if the number can be decomposed into sum of two squares.
            for (int i = 1; i * i <= n; ++i) {
                if (this.isSquare(n - i * i))
                    return 2;
            }
            // bottom case of three-square theorem.
            return 3;
        }
        protected boolean isSquare(int n) {
            int sq = (int) Math.sqrt(n);
            return n == sq * sq;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}