package cn.itlemon.leetcode.recursion;

/**
 * No.695 岛屿的最大面积 https://leetcode-cn.com/problems/max-area-of-island/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-26
 */
public class No695MaxAreaOfIsland {

    /**
     * DFS求取最大岛屿面积
     *
     * @param grid 网格
     * @return 最大面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        // 定义结果集
        int result = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c);
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }

    /**
     * DFS求取岛屿面积
     *
     * @param grid 网格
     * @param r 行坐标
     * @param c 列坐标
     * @return 面积
     */
    private int dfs(int[][] grid, int r, int c) {
        // 终止条件：遍历到网格外，遍历到海洋或者已经遍历过都直接返回0
        if (!isInGrid(grid, r, c) || grid[r][c] != 1) {
            return 0;
        }

        // 做本层要做的事情
        // 遍历过的陆地部分标记为2
        grid[r][c] = 2;

        // 递归访问上、下、左、右四个相邻格子
        return 1 + dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
    }

    /**
     * 判断指定坐标是否在网格内
     *
     * @param grid 表示网格的二维数组
     * @param r 行坐标
     * @param c 列坐标
     * @return 是否在网格内
     */
    private boolean isInGrid(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length

                && c >= 0 && c < grid[0].length;
    }

}
