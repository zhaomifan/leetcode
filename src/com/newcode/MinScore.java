package com.newcode;

import java.util.ArrayList;
import java.util.Arrays;

public class MinScore {
    public static void main(String[] args) {
        int n = 7;
        int x = 3;
        int y = 6;
        int minScore = minScore(new int[]{8, 2, 3, 4, 7, 4, 3,}, n, x, y);
        System.out.println(minScore);
    }

    public static int minScore(int[] scores, int n, int x, int y) {
        if (2 * y < n || 2 * x > n) {
            return -1;
        }
        int minNums = 0;
        int total=0;
        int min = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (total == x) {
                
            }
            if (i <= min) {
                total+=1;
                if (i < min) {
                    min = i;
                    minNums = 1;
                } else {
                    minNums += 1;
                }
            }

        }
        return 0;
    }
}
