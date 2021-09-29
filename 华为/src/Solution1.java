import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/29 19:28
 */
public class Solution1 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);
        String sourceStr = in.nextLine();
        String[] splits = sourceStr.split(":");
        if(splits.length != 8){
            System.out.println("error");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< splits.length; i++){
            if(splits[i].length() != 4){
                System.out.println("error");
                return;
            }
            //先把数字前面全部的0压缩
            String str = splits[i];
            int startIndex = 4;
            for(int j = 0; j < str.length(); j ++){
                if(str.charAt(j) != '0'){
                    startIndex = j;
                    break;
                }
            }

            sb.append(str.substring(startIndex));
            if(i != splits.length -1 && !sb.substring(sb.length() - 1).equals(":")){
                sb.append(":");
            }
        }
        System.out.println(sb);
    }
}
