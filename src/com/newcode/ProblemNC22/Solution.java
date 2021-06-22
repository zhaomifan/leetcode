package com.newcode.ProblemNC22;

import java.util.Arrays;

/**
 * 给出一个整数数组 和有序的整数数组 ，请将数组 合并到数组 中，变成一个有序的升序数组
 * 注意：
 * 1.可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和 ，的数组空间大小为 +
 * 2.不要返回合并的数组，返回是空的，将数组 的数据合并到里面就好了
 * 3.数组在[0,m-1]的范围也是有序的
 * <p>
 * 例1:
 * A: [1,2,3,0,0,0]，m=3
 * B: [2,5,6]，n=3
 * 合并过后A为:
 * A: [1,2,2,3,5,6]
 */
public class Solution {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        Solution solution = new Solution();
        solution.merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index] = A[i];
                i--;
            } else {
                A[index] = B[j];
                j--;
            }
            index--;
        }
        while (j >= 0) {
            A[index] = B[j];
            index--;
            j--;
        }
    }
}
