/**
 * #169. 多数元素：
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。*/

// 方法可以用：1. 哈希表， 2. 排序， 3. 随机化， 4。 摩尔投票法

// Boyer-Moore 投票算法:
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int score = 0;
        for (int i=0; i<nums.length; i++) {
            if (score == 0) candidate = nums[i];
            if (nums[i] == candidate) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        return candidate;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 7, 5, 7, 5, 1 , 5, 7 , 5, 5, 7, 7 , 7, 7, 7, 7};

        System.out.println(solution.majorityElement(nums));
    }
}
