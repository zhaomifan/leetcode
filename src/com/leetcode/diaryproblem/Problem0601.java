package com.leetcode.diaryproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem0601 {
    public static void main(String[] args) {
        int[] candies = new int[]{2, 3, 5, 1, 3};
        int extraCandies = 3;
        Solution solution = new Solution();
        List result = solution.kidsWithCandies(candies, extraCandies);
        System.out.println(result);
//        List result = Arrays.asList(true, true, false, true);
    }
}

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = candies[0];
        List result = new ArrayList<Boolean>();
        for (int candy : candies) {
            maxCandy = candy > maxCandy ? candy : maxCandy;
        }
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}