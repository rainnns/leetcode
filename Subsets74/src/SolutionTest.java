import org.junit.jupiter.api.Test;

/**
 * @author wwx-sys
 * @time 2021-03-08-20:34
 * @description
 */
class SolutionTest {

    @Test
    void subsets() {
        int[] nums = new int[]{1, 2, 3};
//        System.out.println(new Solution().subsets(nums));
        System.out.println(new Solution().subsets2(nums));
    }
}