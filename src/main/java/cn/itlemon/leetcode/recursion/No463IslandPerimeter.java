package cn.itlemon.leetcode.recursion;

/**
 * No.463 岛屿的周长 https://leetcode-cn.com/problems/island-perimeter/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-22
 */
public class No463IslandPerimeter {

    /**
     * DFS解决岛屿周长问题
     *
     * @param grid 二维数组
     * @return 岛屿周长
     */
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 本题只有一个岛屿，所以遍历到岛屿后就直接返回即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    /**
     * DFS
     *
     * @param grid 网格
     * @param r 行坐标
     * @param c 列坐标
     * @return 岛屿周长
     */
    private int dfs(int[][] grid, int r, int c) {
        // 终止条件
        if (!isInGrid(grid, r, c)) {
            // 说明遍历到了边界，那么直接返回边界的一条边
            return 1;
        }

        if (grid[r][c] == 0) {
            // 说明遍历到了海洋，返回一条与海洋接壤的一条边
            return 1;
        }

        if (grid[r][c] == 2) {
            // 说明已经遍历过，是陆地接壤处，不能算到周长里面
            return 0;
        }

        // 本层要做的事情，将遍历过的陆地网格设置为2
        grid[r][c] = 2;

        // 递归遍历，上下左右
        return dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
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
