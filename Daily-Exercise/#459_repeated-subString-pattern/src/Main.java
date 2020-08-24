/**
 * #459. 重复的子字符串：
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char[] ch = s.toCharArray();

        for (int i=1; i<ch.length; i++) {
            boolean flag = true;
            int begin = i;
            for (int j=0; j<ch.length && begin<ch.length; j++) {
                if (ch[begin] != ch[j]) {
                    flag = false;
                    break;
                } else {
                    begin++;
                }
            }
            if (flag) {
                // check
                boolean f = true;
                int cur = i;
                for (int l=0; l<ch.length; l++) {
                    if (ch[l] != ch[cur]) {
                        f = false;
                        break;
                    } else {
                        cur = cur+1<ch.length ? cur+1 : i;
                    }
                }

                if (f) return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.repeatedSubstringPattern("aba"));
    }
}
