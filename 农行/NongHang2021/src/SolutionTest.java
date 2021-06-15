import org.junit.jupiter.api.Test;

/**
 * @author wwx-sys
 * @time 2020-08-29-10:32
 * @description
 */
class SolutionTest {

    Solution solution  = new Solution();
    @Test
    void huoXingWen() {
        System.out.println(solution.huoXingWen(123));
    }

    @Test
    void zhiXing() {
        System.out.println(solution.zhiXing(new String[]{"1,1","2,2","1,2","1,3"}));
    }

}