/**
 * #201. 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，
 * 返回此范围内所有数字的按位与（包含 m, n 两端点）。*/

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        // 1. 移位
//        int shift = 0;
//        while (m < n) {
//            m >>= 1;
//            n >>= 1;
//            shift ++;
//        }
//
//        return m << shift;

        // 2. Brian Kernighan 算法
        while (m < n) {
            n = n & (n-1);
        }
        return n;

    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(5, 7));
    }
}
