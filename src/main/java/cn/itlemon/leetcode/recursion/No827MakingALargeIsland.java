package cn.itlemon.leetcode.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * No.827 最大人工岛 https://leetcode-cn.com/problems/making-a-large-island/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-26
 */
public class No827MakingALargeIsland {

    /**
     * 两遍DFS求解最大人工岛
     *
     * @param grid 网格
     * @return 最大人工岛
     */
    public int largestIsland(int[][] grid) {
        // 定义结果
        int result = 0;
        // 定义岛屿编号，从2开始，0和1分别是海洋和岛屿，防止混淆
        int index = 2;
        // 定义一个Map，用于存储键为岛屿编号，值为岛屿面积
        Map<Integer, Integer> islandAreaMap = new HashMap<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c, index);
                    islandAreaMap.put(index, area);
                    index++;
                    result = Math.max(result, area);
                }
            }
        }

        // 如果这个时候result还是0，那么认为没有岛屿，所以这里随便填一个网格就形成了岛屿
        if (result == 0) {
            return 1;
        }

        // dfs遍历海洋网格，求取海洋网格相邻的陆地
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    // 遍历海洋网格，获取与海洋网格相邻的陆地
                    Set<Integer> islandIndexSet = findNeighbourIsland(grid, r, c);
                    // 如果海洋网格没有相邻的岛屿
                    if (islandIndexSet.size() == 0) {
                        continue;
                    }
                    // 填充这个海洋网格，将该网格相邻的岛屿连接起来
                    // 该海洋网格面积为1
                    int tempArea = 1;
                    for (Integer islandIndex : islandIndexSet) {
                        tempArea += islandAreaMap.get(islandIndex);
                    }
                    // 获取最大面积
                    result = Math.max(result, tempArea);
                }
            }
        }
        return result;
    }

    /**
     * 获取海洋网格周边(上下左右)的相邻岛屿编号
     *
     * @param grid 网格
     * @param r 行坐标
     * @param c 列坐标
     * @return 岛屿编号Set集合
     */
    private Set<Integer> findNeighbourIsland(int[][] grid, int r, int c) {
        Set<Integer> islandIndexSet = new HashSet<>();
        // 在网格内，且为陆地，只要不为0就是陆地，因为岛屿之前被遍历过，都被修改为了大于等于2以上的数值
        if (isInGrid(grid, r - 1, c) && grid[r - 1][c] != 0) {
            islandIndexSet.add(grid[r - 1][c]);
        }
        if (isInGrid(grid, r + 1, c) && grid[r + 1][c] != 0) {
            islandIndexSet.add(grid[r + 1][c]);
        }
        if (isInGrid(grid, r, c - 1) && grid[r][c - 1] != 0) {
            islandIndexSet.add(grid[r][c - 1]);
        }
        if (isInGrid(grid, r, c + 1) && grid[r][c + 1] != 0) {
            islandIndexSet.add(grid[r][c + 1]);
        }
        return islandIndexSet;
    }

    /**
     * 求取岛屿面积且标记遍历过的网格
     *
     * @param grid 网格
     * @param r 行坐标
     * @param c 列坐标
     * @param index 岛屿编号，将岛屿标记为该值
     * @return 岛屿面积
     */
    private int dfs(int[][] grid, int r, int c, int index) {
        // 超出网格返回或者遍历到海洋，即0，或者已经遍历过的陆地网格（已经被标记为index）
        if (!isInGrid(grid, r, c) || grid[r][c] != 1) {
            return 0;
        }

        // 本层要做的事情：标记
        grid[r][c] = index;

        // 递归计算上下左右网格，求取面积
        return 1 + dfs(grid, r - 1, c, index)
                + dfs(grid, r + 1, c, index)
                + dfs(grid, r, c - 1, index)
                + dfs(grid, r, c + 1, index);
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
