package com.leetcode.diaryproblem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Problem0910 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, new ArrayList<Integer>(), candidates, 0, target);
        return ans;
    }

    private void dfs(int start, ArrayList<Integer> temp, int[] candidates, int sum, int target) {
        if (sum == target) {
            ans.add((List<Integer>) temp.clone());
            return;
        }
        if (sum > target) return;
        if (sum < target) {
            for (int i = start; i < candidates.length; i++) {
                // 去重
                if (i - 1 >= start && candidates[i - 1] == candidates[i]) continue;
                temp.add(candidates[i]);
                // +1去同
                dfs(i + 1, temp, candidates, sum + candidates[i], target);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void solution() {
        Problem0910 problem0910 = new Problem0910();
        ArrayList<Integer> temp = (ArrayList<Integer>) Arrays.asList(1, 3);
        int[] candidates={1,2,3};
        problem0910.dfs(1,  temp,candidates,2,4);
    }
}