package cn.itlemon.leetcode.recursion.backtracking;

import java.util.Arrays;

/**
 * No.52 N皇后 II https://leetcode-cn.com/problems/n-queens-ii/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-10
 */
public class No52NQueens2 {

    private int result = 0;

    /**
     * 回溯
     *
     * @param n n，棋盘大小
     * @return 符合要求的个数
     */
    public int totalNQueens(int n) {
        // 定义路径
        char[][] chessboard = new char[n][n];
        for (char[] rows : chessboard) {
            Arrays.fill(rows, '.');
        }
        backtracking(n, 0, chessboard);
        return result;
    }

    private void backtracking(int n, int row, char[][] chessboard) {
        // 触发终止条件
        if (row == n) {
            result++;
            return;
        }

        // 回溯核心部分
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                // 做选择
                chessboard[row][col] = 'Q';
                // 递归
                backtracking(n, row + 1, chessboard);
                // 撤销选择
                chessboard[row][col] = '.';
            }
        }
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
