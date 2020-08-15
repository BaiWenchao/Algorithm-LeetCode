import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * #20. 有效的括号
 * 给定一个只包括'('，')'，'{'，'}'，‘[’，']'的字符串，判断
 * 字符串是否有效。
 * 有效字符串需满足：
 *  1. 左括号必须用相同类型的右括号闭合。
 *  2. 左括号必须以正确的顺序闭合。*/

class Solution {
    public boolean isValid(String s) {
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && !map.containsKey(stack.peek())) {
                return false;
            }
            if (stack.isEmpty() || c != map.get(stack.peek())) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            flag = false;
        }

        return flag;
    }
}

public class Main {

    public static void main(String[] args) {
        String s = "([)]";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }

}
