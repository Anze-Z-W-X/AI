package com.anze.ai3.GA;

import com.anze.ai3.utils.Utils;

public class CalculateValue {
    //计算目标值，得到每个染色体的最终完工时间
    public static int calculateTime(int[][] piece) {
        int x = piece.length;
        int y = piece[0].length;
        int[][]Time = Utils.copy(piece);
        //FSP问题优化最小化整体完工时间的数学模型:
        for (int k = 1; k < y; k++) {
            Time[0][k] = Time[0][k - 1] + piece[0][k];
        }
        for (int m = 1; m < x; m++) {
            for (int n = 0; n < y; n++) {
                if (n == 0) {
                    Time[m][n] = Time[m - 1][0] + piece[m][n];
                } else {
                    Time[m][n] = Math.max(Time[m - 1][n], Time[m][n - 1]) + piece[m][n];
                }
            }
        }
        int MaxTime = Time[x-1][y-1];
        return MaxTime;
    }
}