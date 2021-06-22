package com.leetcode.diaryproblem;

public class SolutionList {
    public static void main(String[] args) {
        //分组翻转链表
        //Problem0516.reverseKGroupRun();
        //
        Problem1118 pro1110 = new Problem1118();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int res = pro1110.canCompleteCircuit(gas, cost);
        System.out.println(res);
    }
}
