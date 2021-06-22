package com.leetcode.diaryproblem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明: 
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1118 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int start = 0; start < gas.length; start++) {
            for (int i = 0; i < gas.length; i++) {
                if (start + i>gas.length) {
                    i = i - start;
                }
            }
        }
        return 1;
    }

    public int getNextIdx(int start,int idx,int length) {
        return 0;
    }
}