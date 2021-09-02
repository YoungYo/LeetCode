//You are given an array of strings equations that represent relationships 
//between variables where each string equations[i] is of length 4 and takes one of two 
//different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (
//not necessarily different) that represent one-letter variable names. 
//
// Return true if it is possible to assign integers to variable names so as to 
//satisfy all the given equations, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: equations = ["a==b","b!=a"]
//Output: false
//Explanation: If we assign say, a = 1 and b = 1, then the first equation is 
//satisfied, but not the second.
//There is no way to assign the variables to satisfy both equations.
// 
//
// Example 2: 
//
// 
//Input: equations = ["b==a","a==b"]
//Output: true
//Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
// 
//
// Example 3: 
//
// 
//Input: equations = ["a==b","b==c","a==c"]
//Output: true
// 
//
// Example 4: 
//
// 
//Input: equations = ["a==b","b!=c","c==a"]
//Output: false
// 
//
// Example 5: 
//
// 
//Input: equations = ["c==c","b==d","x!=z"]
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] is a lowercase letter. 
// equations[i][1] is either '=' or '!'. 
// equations[i][2] is '='. 
// equations[i][3] is a lowercase letter. 
// 
// Related Topics Array String Union Find Graph 👍 1042 👎 10

  
package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

public class SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
         Solution solution = new SatisfiabilityOfEqualityEquations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equationsPossible(String[] equations) {
            UF uf = new UF(26);
            List<String> notEquals = new LinkedList<>();
            for (String equation: equations) {
                if (equation.charAt(1) == '=') {
                    int p = equation.charAt(0) - 'a';
                    int q = equation.charAt(3) - 'a';
                    uf.union(p, q);
                } else {
                    notEquals.add(equation);
                }
            }
            if (!notEquals.isEmpty()) {
                for (String equation: equations) {
                    int p = equation.charAt(0) - 'a';
                    int q = equation.charAt(3) - 'a';
                    if (uf.connected(p, q)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    class UF {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private int[] parent;
        // 记录树的“重量”
        private int[] size;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}