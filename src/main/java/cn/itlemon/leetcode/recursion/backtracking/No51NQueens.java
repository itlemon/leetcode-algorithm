package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.51 N皇后 https://leetcode-cn.com/problems/n-queens/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-08
 */
public class No51NQueens {

    /**
     * 回溯算法
     *
     * @param n n，棋盘大小
     * @return 符合要求的结果集
     */
    public List<List<String>> solveNQueens(int n) {
        // 定义结果集
        List<List<String>> result = new ArrayList<>();
        // 定义棋盘（路径）
        char[][] chessboard = new char[n][n];
        for (char[] rows : chessboard) {
            Arrays.fill(rows, '.');
        }
        backtracking(n, 0, chessboard, result);
        return result;
    }

    private void backtracking(int n, int row, char[][] chessboard, List<List<String>> result) {
        // 触发终止条件
        if (row == n) {
            // 说明到达了最后一行
            result.add(array2List(chessboard));
            return;
        }

        // 回溯核心部分
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                // 做选择
                chessboard[row][col] = 'Q';
                backtracking(n, row + 1, chessboard, result);
                // 撤销选择
                chessboard[row][col] = '.';
            }
        }
    }

    /**
     * 将字符数组转化为字符串列表
     *
     * @param chessboard 棋盘（路径）
     * @return 字符串列表
     */
    private List<String> array2List(char[][] chessboard) {
        List<String> item = new ArrayList<>();
        for (char[] rows : chessboard) {
            item.add(new String(rows));
        }
        return item;
    }

    /**
     * 检查放的位置是否符合要求：这里只需要检查当前准备放的位置的左上角，正上方，右上角即可，因为皇后是一行一行放下来的
     *
     * @param row 行
     * @param col 列
     * @param n 棋盘大小
     * @param chessboard 棋盘（路径）
     * @return 是否合法
     */
    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查正上方是否已经有皇后
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上角是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上角是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
