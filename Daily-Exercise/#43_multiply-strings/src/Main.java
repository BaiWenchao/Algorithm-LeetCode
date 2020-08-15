import java.util.regex.Pattern;

/**
 * #43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数num1和num2，返回
 * num1和num2的乘积，它们的乘积也表示为字符串形式。*/

class Solution {
    public String multiply(String num1, String num2) {
        // 匹配有效输入：0或1~9打头的数字串
        String pattern = "^[1-9]\\d*|0";
        if (!Pattern.matches(pattern, num1) || !Pattern.matches(pattern, num2)) {
            System.out.println("Illegal input!");
            return null;
        }
        // 两个输入中如果存在0，直接返回0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int l1 = num1.length(), l2 = num2.length();
        int ansArr[] = new int[l1 + l2];
        StringBuilder ans = new StringBuilder();

        for (int i=l1; i>0; i--) {
            for (int j=l2; j>0; j--) {
                int tmpVal = (num1.charAt(i-1)-48) * (num2.charAt(j-1)-48);

                ansArr[i+j-1] += tmpVal % 10;
                ansArr[i+j-2] += tmpVal / 10;
            }
        }

        for (int i=ansArr.length-1; i>0; i--) {
            ansArr[i-1] += ansArr[i] / 10;
            ansArr[i] %= 10;
            ans.append(ansArr[i]);
        }

        if (ansArr[0] > 0) {
            ans.append(ansArr[0]);
        }

        return ans.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "9";

        Solution solution = new Solution();

        System.out.println(solution.multiply(num1, num2));
    }
}
