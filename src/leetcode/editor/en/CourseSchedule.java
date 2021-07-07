//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to fir
//st take course 1. 
// 
//
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you s
//hould also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Topological Sort
// 
// 👍 6347 👎 269

  
package leetcode.editor.en;

import java.net.Inet4Address;
import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
         Solution solution = new CourseSchedule().new Solution();
         int[] numCourses = {1, 20};
         int[][][] prerequisites = {
                 {},
                 {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}
         };
         int n = 1;
         boolean result = solution.canFinish(numCourses[n], prerequisites[n]);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 邻接表实现
/*
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0) {
                return true;
            }
            HashMap<Integer, Set<Integer>> graph = new HashMap<>(prerequisites.length);
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][0] == prerequisites[i][1]) {
                    return false;
                }
                graph.putIfAbsent(prerequisites[i][0], new HashSet<>());
                graph.putIfAbsent(prerequisites[i][1], new HashSet<>());
                Set<Integer> set = graph.get(prerequisites[i][1]);
                set.add(prerequisites[i][0]);
            }
            LinkedList<Integer> courses = new LinkedList<>();
            boolean coursesChanged = false;
            while (true) {
                for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                    Integer k = entry.getKey();
                    Set<Integer> v = entry.getValue();
                    if (v.size() == 0) {
                        courses.add(k);
                        coursesChanged = true;
                        break;
                    }
                }
                if (graph.size() == 0 || courses.size() == numCourses) {
                    return true;
                }
                if (!coursesChanged) {
                    return false;
                }
                coursesChanged = false;
                Integer lastCourse = courses.getLast();
                graph.remove(lastCourse);
                for (Set<Integer> v : graph.values()) {
                    v.remove(lastCourse);
                }
            }
        }
*/
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0) {
                return true;
            }
            int[][] matrix = new int[numCourses][numCourses];
            int[] inDegree = new int[numCourses];
            boolean[] hasNode = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {
                inDegree[i] = -1;
            }
            for (int[] prerequisite : prerequisites) {
                inDegree[prerequisite[1]]++;
                matrix[prerequisite[0]][prerequisite[1]] = 1;
                hasNode[prerequisite[0]] = true;
                hasNode[prerequisite[1]] = true;
                if (prerequisite[0] == prerequisite[1]) {
                    return false;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0 || hasNode[i]) {
                    queue.offer(i);
                    break;
                }
            }
            while (!queue.isEmpty()) {
                Integer course = queue.poll();
                hasNode[course] = false;
                for (int i = 0; i < numCourses; i++) {
                    if (matrix[course][i] == 1) {
                        if (--inDegree[i] == 0) {
                            queue.offer(i);
                        }
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}