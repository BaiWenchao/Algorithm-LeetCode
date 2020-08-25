/**
 * #491. 递增子序列：
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。*/


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// 法一：穷举
//class Solution {
//    List<Integer> temp = new ArrayList<Integer>();
//    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//    Set<Integer> set = new HashSet<Integer>();
//    int n;
//
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        n = nums.length;
//        for (int i = 0; i < (1 << n); ++i) {
//            findSubsequences(i, nums);
//            int hashValue = getHash(263, (int) 1E9 + 7);
//            if (check() && !set.contains(hashValue)) {
//                ans.add(new ArrayList<Integer>(temp));
//                set.add(hashValue);
//            }
//        }
//        return ans;
//    }
//
//    public void findSubsequences(int mask, int[] nums) {
//        temp.clear();
//        for (int i = 0; i < n; ++i) {
//            if ((mask & 1) != 0) {
//                temp.add(nums[i]);
//            }
//            mask >>= 1;
//        }
//    }
//
//    public int getHash(int base, int mod) {
//        int hashValue = 0;
//        for (int x : temp) {
//            hashValue = hashValue * base % mod + (x + 101);
//            hashValue %= mod;
//        }
//        return hashValue;
//    }
//
//    public boolean check() {
//        for (int i = 1; i < temp.size(); ++i) {
//            if (temp.get(i) < temp.get(i - 1)) {
//                return false;
//            }
//        }
//        return temp.size() >= 2;
//    }
//}

// 法二: 递归
class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
