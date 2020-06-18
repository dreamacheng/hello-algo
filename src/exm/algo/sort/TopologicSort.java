package exm.algo.sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TopologicSort {

    public static void main(String[] args) {
//        int numCourses = 4;
//        int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
        int numCourses = 2;
        int[][] prerequisites = {{1,0}, {0,1}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }


    /**
     *现在你总共有 n 门课需要选，记为 0 到 n-1。
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     *
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     * 示例 1:
     * 输入: 2, [[1,0]]
     * 输出: [0,1]
     * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     *
     * 示例 2:
     * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
     * 输出: [0,1,2,3] or [0,2,1,3]
     * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
     * @param numCourses  课程数
     * @param prerequisites 课程顺序
     * @return
     *
     * BFS 使用queue完成有向无环图的遍历
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || prerequisites == null) return new int[0];
        int[] order = new int[numCourses];
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[i++] = curr;

            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == curr) {
                    indegree[prerequisite[0]]--;
                    if (indegree[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }
        return i == numCourses ? order : new int[0];
    }
}
