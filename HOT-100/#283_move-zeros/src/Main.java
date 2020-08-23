/**
 * #283. 移动0：
 * 给定一个数组 nums，编写一个函数将所有 0
 * 移动到数组的末尾，同时保持非零元素的相对顺序。*/

class Solution {
    private int counter = 0;
    public void moveZeroes(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) continue;
            nums[counter++] = nums[i];
        }
        for (int i=counter; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1, 2, 0, 1, 2};
        s.moveZeroes(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
