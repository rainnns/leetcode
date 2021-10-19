import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/19 18:49
 */
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> right = new LinkedHashSet<>();
        LinkedList<String> error = new LinkedList<>();



        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("")) {
                break;
            }
            if (right.contains(line)){
                continue;
            }
            boolean flag = false;
            for (char c : line.toCharArray()) {
                if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    flag = true;
                } else {
                    error.add(line);
                    flag = false;
                    break;
                }
            }
            if (flag){
                right.add(line);
            }
        }
        StringBuilder rightString = new StringBuilder();
        StringBuilder errorString = new StringBuilder();
        for (String s : right) {
            if (rightString.length() != 0){
                rightString.append(" ");
            }
            rightString.append(s);
        }
        for (String s : error) {
            if (errorString.length() != 0){
                errorString.append(" ");
            }
            errorString.append(s);
        }

        System.out.println(rightString);
        System.out.println(errorString);
    }
}

//    abc def acd123 44234tjg abd 123 abcdef 123456789012345678901234567890123456789012345678901234567890123 EDFG SDFG ABC DEF cccc dd asdfas 234abc35 765rgfh4sd 1231
//        == aga'-= ad--s a*b=1 87&&^ ==