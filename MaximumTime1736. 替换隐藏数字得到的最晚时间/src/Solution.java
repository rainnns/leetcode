/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/24 15:53
 */
public class Solution {
    public String maximumTime1(String time) {
        String hourStr = time.substring(0,2);
        char shiHour = hourStr.charAt(0);
        char geHour = hourStr.charAt(1);
        if (shiHour == '?'){
            if (geHour >= '4' && geHour != '?'){
                shiHour = '1';
            }
            else {
                shiHour = '2';
            }

        }
        if (geHour == '?'){
            if (shiHour == '2'){
                geHour = '3';
            }
            else {
                geHour = '9';
            }
        }

        String minStr = time.substring(3);
        char shiMin = minStr.charAt(0);
        char geMin = minStr.charAt(1);
        if (shiMin == '?'){
            shiMin = '5';
        }
        if (geMin == '?'){
            geMin = '9';
        }

        return "" + shiHour + geHour + ":" + shiMin + geMin;
    }

    public String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            arr[0] = ('4' <= arr[1] && arr[1] <= '9') ? '1' : '2';
        }
        if (arr[1] == '?') {
            arr[1] = (arr[0] == '2') ? '3' : '9';
        }
        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maximumTime("?4:03"));
    }
}
