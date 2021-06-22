package com.newcode.ProblemNC41;

import java.util.*;

/**
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * 输入：
 * [2,3,4,5]
 * 返回值：
 * 4
 * 说明：
 * [2,3,4,5]是最长子数组
 */


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxLength(new int[]{6,8,9,1,9}));
        System.out.println(solution.maxLength(new int[]{1,2,3,3,8,7}));
    }

    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        // write code here
        int result = 0, start = 0;
        int[] end = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (start < end[num]) {
                start = end[num];
            }
            if (result < i - start + 1) {
                result = i - start + 1;
            }
            end[num] = i +1;
            System.out.printf("i=%d\nstart=%d\nresult=%d\nend=%s\n---------\n", i, start, result, Arrays.toString(end));
        }
        return result;
    }

    public int maxLength2(int[] arr) {
        int result = 0, start = 0;
        int[] end = new int[20];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (start < end[num]) {
                start = end[num];
            }
            if (result < i - start + 1) {
                result = i - start + 1;
            }
            end[num] = i +1;
        }
        return result;
    }
}