/**
 * #461. 汉明距离：
 * 两个整数之间的汉明距离指的是这两个数字对应的二进制位不同的位置的数目
 * 给出量整数x和y，计算它们之间的汉明距离。
 * 注意；0<= x, y < 2^31*/

class Solution {
    public int hammingDistance(int x, int y) {
        // 解法1. 移位：数学意义为短除法
        int distance = 0;
        int diff = x^y;
        while (diff > 0) {
            distance = (diff%2==1) ? distance+1 : distance;
            diff >>= 2;
        }
        return distance;

        // 解法2：内置计数功能：
//        return Integer.bitCount(x^y);

        // 解法3：布赖恩·克尼根算法
//        int distance = 0;
//        int diff = x^y;
//        while (diff > 0) {
//            distance++;
//            diff = diff&(diff-1);
//        }
//        return distance;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int distance = solution.hammingDistance(1, 4);
        System.out.println(distance);
    }
}
