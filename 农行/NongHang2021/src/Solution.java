/**
 * @author wwx-sys
 * @time 2020-08-29-10:16
 * @description
 */
public class Solution {
    public String huoXingWen(int num) {
        StringBuilder sb = new StringBuilder();
        while (num / 3 > 0) {
            int yu_shu = num % 3;
            num = num / 3;
            switch (yu_shu) {
                case 0 -> sb.append("@");
                case 1 -> sb.append("$");
                case 2 -> sb.append("&");
            }
        }
        return sb.reverse().toString();
    }

    public int zhiXing(String[] cords) {
        double zhiXingX = 0;
        double zhiXingY = 0;
        double[] dis = new double[cords.length];
        for (String cord : cords) {
            String[] splits = cord.split(",");
            double x = Double.parseDouble(splits[0]);
            double y = Double.parseDouble(splits[1]);
            zhiXingX += x;
            zhiXingY += y;
        }
        zhiXingX = zhiXingX / cords.length;
        zhiXingY = zhiXingY / cords.length;
        for (int i = 0; i < cords.length; i++) {
            String[] splits = cords[i].split(",");
            double x = Double.parseDouble(splits[0]);
            double y = Double.parseDouble(splits[1]);
            dis[i] = Math.sqrt(Math.pow((x - zhiXingX), 2) + Math.pow((y - zhiXingY), 2));
        }

        double minDis = Double.MAX_VALUE;
        for (int i = 0; i < cords.length; i++) {
            if(minDis >= dis[i]){
                minDis = dis[i];
            }
        }
        for (int i = 0; i < cords.length; i++) {
            if (minDis == dis[i]){
                return i;
            }
        }
        return -1;
    }


}
