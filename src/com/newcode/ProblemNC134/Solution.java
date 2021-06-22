package com.newcode.ProblemNC134;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请写一个整数计算器，支持加减乘三种运算和括号。
 * "(2*(3-4))*5"
 */

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solve = solution.solve("(2*(3-4))*5");
        System.out.println(solve);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     *
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve(String s) {
        // write code here
        // 操作数栈
        Stack<Integer> opnd = new Stack<>();
        // 运算符栈
        Stack<Character> optr = new Stack<>();
        optr.push('#');
        // 添加结束符
        s += "#";

        // 扫描表达式
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果当前字符是操作数，则入栈opnd
            if (c >= '0' && c <= '9') {
                if (i == 0) {
                    int num = c - '0';
                    opnd.push(num);
                    continue;
                } else {
                    // 前一个字符是否是数字，判断是否是两位数以上
                    char pre = s.charAt(i - 1);
                    if (pre >= '0' && pre <= '9') {
                        int num = opnd.pop() * 10 + (c - '0');
                        opnd.push(num);
                    } else {
                        int num = c - '0';
                        opnd.push(num);
                    }
                    continue;
                }

            }
            // 当前字符是运算符
            else {
                // '-'、'+'、'#'
                if (c == '-' || c == '+' || c == '#') {
                    // 先处理’-‘的特殊情况(负数情况)，表达式第1个数就是负数，或者括号内第1个数是负数
                    if (c == '-' && (i == 0 || s.charAt(i - 1) == '(')) {
                        // 将0入栈opnd
                        opnd.push(0);
                        // ’-‘入栈optr
                        optr.push('-');
                        continue;
                    }

                    // 处理'+'的特殊情况
                    if (c == '+' && (i == 0 || s.charAt(i - 1) == '(')) {
                        // 该’+‘不用入栈
                        continue;
                    }

                    // 如果当前运算符比optr栈顶运算符优先级低或者相同
                    // 则opnd出栈两个操作数，optr出栈一个运算符，并将运算结果入栈opnd
                    // 继续处理当前字符c，直到找到optr栈顶不是+、-、*，才将当前字符c入栈，目的是维持optr栈优先级是低到高
                    while (optr.peek() == '*' || optr.peek() == '+' || optr.peek() == '-') {
                        int b = opnd.pop();
                        int a = opnd.pop();
                        char op = optr.pop();
                        switch (op) {
                            case '*':
                                opnd.push(a * b);
                                break;
                            case '+':
                                opnd.push(a + b);
                                break;
                            case '-':
                                opnd.push(a - b);
                                break;
                        }
                    }

                    // 最后，将该运算符入栈
                    optr.push(c);
                }

                // '('
                if (c == '(') {
                    optr.push(c);
                }

                // ')'，计算括号里的值
                if (c == ')') {
                    // optr栈内一般是从栈底到栈顶为优先级低到高，所以使用while循环
                    while (optr.peek() != '(') {
                        int b = opnd.pop();
                        int a = opnd.pop();
                        char op = optr.pop();
                        switch (op) {
                            case '*':
                                opnd.push(a * b);
                                break;
                            case '+':
                                opnd.push(a + b);
                                break;
                            case '-':
                                opnd.push(a - b);
                                break;
                        }
                    }

                    // '('出栈
                    optr.pop();
                }

                // '*'优先级最高，直接入栈
                if (c == '*') {
                    optr.push(c);
                }
            }
        }

        // 最后，opnd栈只剩下最后的结果，optr栈只剩两个'#'
        return opnd.peek();
    }
}