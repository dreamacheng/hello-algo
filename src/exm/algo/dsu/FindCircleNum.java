package exm.algo.dsu;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/bLyHh0
 */
public class FindCircleNum {

    public static void main(String[] args) {
        FindCircleNum main = new FindCircleNum();
        int[][] city = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int circleNum = main.findCircleNum(city);
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] isConnected) {
        int[] cityMap = init(isConnected);
        int rest = 0;
        for (int i = 0; i < cityMap.length; i++) {
            if (cityMap[i] == i) {
                rest++;
            }
        }
        return rest;
    }


    public int[] init(int[][] isConnected) {
        int cityCnt = isConnected.length;
        int[] cityMap = new int[isConnected.length];
        for (int i = 0; i < cityCnt; i++) {
            cityMap[i] = i;
        }
        for (int i = 0; i < cityCnt; i++) {
            for (int j = i + 1; j < cityCnt; j++) {
                if (isConnected[i][j] == 1) {
                    merge(cityMap, i, j);
                }
            }
        }
        return cityMap;
    }

    public void merge(int[] cityMap, int i, int j) {
        int iCity = find(cityMap, i);
        int jCity = find(cityMap, j);
        if (jCity != iCity) {
            cityMap[jCity] = iCity;
        }
    }

    public int find(int[] cityMap, int i) {
        if (cityMap[i] == i) {
            return i;
        } else {
            return find(cityMap, cityMap[i]);
        }
    }
}
