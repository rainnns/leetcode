/**
 * @author wwx-sys
 * @time 2021-08-22-20:07
 * @description
 */
public class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = new int[]{0,0};
        int sourceDis = manHaTonDist(source,target);
        for (int[] ghost : ghosts) {
            if (manHaTonDist(ghost,target) <= sourceDis){
                return false;
            }
        }
        return true;
    }

    public int manHaTonDist(int[] pt1, int[] pt2){
        return Math.abs(pt1[0] - pt2[0]) + Math.abs(pt1[1]- pt2[1]);
    }
}
