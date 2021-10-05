/**
 * @author wwx-sys
 * @time 2021-10-03-10:54
 * @description
 */
public class Solution {
    //对0数量为偶数还是奇数、2数量多还是1数量多，分四类讨论
    //将石子价值按照模3余数分类计数
    //一开始Alice只能选择mod1或mod2的石子
    //选择mod3可以使得选出的总数取模状态不变。
    //进入mod1状态之后不能选mod2石子；进入mod2状态之后不能选mod1石子；连续两次则一定失败。 所以只要mod1和mod2中只剩一种了，结果可以通过奇偶性直接判断出来。
    //
    //mod1,mod2 的数量可以互相抵消，因为一组mod1 mod2可以进入原来的状态。比如从mod1状态+1进入mod2，我们可以从mod2状态+2再回到mod1。 所以后手永远可以通过取mod1或mod2回到原始的状态。 除非已经没有可以抵消的选择了。
    //先手选择权在alice手上，所以不管有几个mod0，alice都可以选择让(mod1, mod2)中多的那个奇偶性改变或者不改变 通过选择进入mod1状态或者mod2状态
    //
    //但如果 abs(mod1 - mod2) < 2 则bob总可以通过抵消mod1 mod2 让游戏不用结束获得胜利
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        int n = stones.length;
        if (n == 1) return false;
        for (int stone : stones) {
            cnt[stone % 3]++;
        }
        if (cnt[0] % 2 == 0) {
            return cnt[1] != 0 && cnt[2] != 0;
        }
        return cnt[2] > cnt[1] + 2 || cnt[1] > cnt[2] + 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().stoneGameIX(new int[]{2, 2, 4}));
    }
}
