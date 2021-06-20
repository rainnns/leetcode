/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/6/20 10:45
 */
public class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        int duringTime = 15;
        int startMinutes = time2MinutesInt(startTime);
        if (startMinutes % duringTime > 0) {
            startMinutes += (duringTime - startMinutes % duringTime);
        }
        int finishMinutes = time2MinutesInt(finishTime);
        int intervals = 0;
        //通宵了
        if (finishMinutes < startMinutes) {
            intervals = 24 * 60 - startMinutes + finishMinutes;
        } else {
            intervals = finishMinutes - startMinutes;
        }
        return intervals / 15;
    }

    public int time2MinutesInt(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfRounds("00:00","23:59"));
    }

}
