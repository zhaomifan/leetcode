package com.newcode.ProblemNC128;

import java.util.*;

/**
 * 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。
 * 输入：
 * [3,1,2,5,2,4]
 * 复制
 * 返回值：
 * 5
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 1, 2, 5, 2, 4};
        System.out.println(solution.maxWater(arr));
        ;
    }

    /**
     * max water
     *
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater(int[] arr) {
        // write code here
        int head=arr[0];
        for (int elm : arr) {
            System.out.println(elm);
        }
        return 10L;
    }
}