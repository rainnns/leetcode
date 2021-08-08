import java.util.Stack;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/8/8 11:13
 */
public class Solution {
    public int minSwaps(String s) {
        Stack<Character> list = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (!list.empty() && list.peek() == '[' && t == ']') {
                list.pop();
            } else {
                list.push(t);
            }
        }
        if (list.empty()) {
            return 0;
        }
        if (list.size() % 4 == 0){
            return list.size() / 4;
        }
        return list.size() / 4 + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSwaps("]]]][[][[][[[]]][[]][[[[][]]][[]]]]]][]][[][][[]][][[]]]][[[[[[["));
    }
}
