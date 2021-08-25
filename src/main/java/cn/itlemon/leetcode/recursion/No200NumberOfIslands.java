package cn.itlemon.leetcode.recursion;

/**
 * No.200 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-21
 */
public class No200NumberOfIslands {

    /**
     * DFS解决岛屿数量问题
     *
     * @param grid 二维数组
     * @return 岛屿数量
     */
    public int numIslands(char[][] grid) {
        // 定义结果
        int result = 0;
        // 循环遍历
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    traverse(grid, r, c);
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * DFS
     *
     * @param grid 网格
     * @param r 行坐标
     * @param c 列坐标
     */
    private void traverse(char[][] grid, int r, int c) {
        // 触发终止条件：判断当前遍历的格子是否在网格内
        if (!isInGrid(grid, r, c)) {
            return;
        }

        // 本层要做的事情
        // 如果格子不是岛屿，那么直接返回，相当于剪枝，防止重复操作
        if (grid[r][c] != '1') {
            return;
        }

        // 做标记，将本层遍历后的格子标记为-1
        grid[r][c] = '2';

        // 递归访问上、下、左、右四个相邻格子
        traverse(grid, r - 1, c);
        traverse(grid, r + 1, c);
        traverse(grid, r, c - 1);
        traverse(grid, r, c + 1);
    }

    /**
     * 判断指定坐标是否在网格内
     *
     * @param grid 表示网格的二维数组
     * @param r 行坐标
     * @param c 列坐标
     * @return 是否在网格内
     */
    private boolean isInGrid(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length
                && c >= 0 && c < grid[0].length;
    }

}
