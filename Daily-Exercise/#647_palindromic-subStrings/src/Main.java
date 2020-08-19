/**
 * #647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。*/

class Solution {
    private int count = 0;
    private int size = 0;
    private char[] c = null;
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();

        count = s.length();
        size = s.length();
        c = ch;

        for (int i=0; i<ch.length-1; i++) {
            // 遍历数组中第一个到倒数第二个元素，判断其是否为回文中心
            // 1. 其右边的元素与之是否相等？
            if (ch[i] == ch[i+1]) {
                counter(i, i+1);
            }
            // 2. 其左右元素是否相等
            if (i>0 && ch[i-1]==ch[i+1]) {
                counter(i-1, i+1);
            }
        }
        return count;
    }

    public void counter(int l, int r) {
        if (l<0 || r>size-1 || c[l] != c[r]) return;
        count++;
        counter(l-1, r+1);
    }
}

public class Main {
    public static void main(String[] args) {
        String s = "aaa";
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings(s));
    }
}
