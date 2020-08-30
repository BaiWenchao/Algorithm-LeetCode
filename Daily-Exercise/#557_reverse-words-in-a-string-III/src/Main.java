/**
 * #557. 反转字符串中的单词 III：
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。*/

class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String str : ss) {
            str = new StringBuffer(str).reverse().toString();
            sb.append(str+" ");
        }
        return sb.delete(sb.length()-1, sb.length()).toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "Let's take LeetCode contest";
        System.out.println(s.reverseWords(str));
    }
}
