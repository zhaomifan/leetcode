package com.newcode.ProblemNC1;

import com.leetcode.diaryproblem.SolutionList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 */


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("aaaa");

        Solution solution = new Solution();
        System.out.println(solution.solve("9", "99"));;
    }
    public String solve(String s, String t) {
        // write code here
        int add = 0;
        int max = Integer.max(s.length(), t.length());
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            int head=max-i-1;
            if (i < s.length()) {
                res[head] += s.charAt(s.length()-i-1)-48;
            }
            if (i < t.length()) {
                res[head] += t.charAt(t.length()-i-1)-48;
            }
            res[head] += add;
            add = 0;
            if (res[head] > 9) {
                add = res[head] / 10;
                res[head] = res[head] % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r:
             res) {
            sb.append(r);
        }
        if (add > 0) {
            sb.insert(0,add);
        }
        return sb.toString();
    }

    public ArrayList<Integer> stringToIntArray(String string) {
        ArrayList<Integer> integers = new ArrayList<>(string.length());
        for (int i = 0; i < string.length(); i++) {
            integers.set(i, Integer.valueOf(string.substring(i, i + 1)));
        }
        return integers;
    }

}