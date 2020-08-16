/**
 * #136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？*/

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3};
        Solution s = new Solution();
        System.out.println(s.singleNumber(a));
    }
}
