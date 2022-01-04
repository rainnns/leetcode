/**
 * @author wwx-sys
 * @time 2022-01-04-11:25
 * @description 剑指 Offer 58 - I. 翻转单词顺序
 */
public class T58 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] splits = s.strip().split(" ");
        for (int i = splits.length - 1; i >= 0; i--) {
            if (!splits[i].equals("")){
                sb.append(splits[i]).append(" ");
            }
        }
        return sb.toString().strip();
    }

    public static void main(String[] args) {
        String str = "a good   example";
        System.out.println(new T58().reverseWords(str));
    }
}
