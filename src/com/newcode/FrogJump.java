package com.newcode;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class FrogJump {
    public static void main(String[] args) {
//        System.out.println(jump(10));
        System.out.println(jumpFloor(10));;
    }

    public static int jumpFloor(int target) {
        int res=0;
        for (int i = 0; i <target/2; i++) {
            int temp = selectNum(target - i, i);
            res+=temp;
        }
        return res;
    }
    public static int jumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor2(target-1)+jumpFloor2(target-2);
    }

    public static int jumpFloor3(int target) {
        int d1=1,d2=2;
        while (target-- > 1) {
            d2=d1+d2;
            d1=d2-d1;
        }
        return d2;
    }
    public static int selectNum(int n, int m) {
        int res = 1;
        for (int i = 0; m>0; i++) {
            res=res*n/m;
            n--;
            m--;
        }
        return res;
    }
}
