import java.util.ArrayList;
import java.util.List;

/**
 * #448_找到所有数组中消失的数字：
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int target = nums[i] > 0 ? nums[i]-1 : -nums[i]-1;
            if (nums[target] > 0) nums[target] = -nums[target];
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
        for (int i : list) {
            System.out.println(i);
        }
    }
}
