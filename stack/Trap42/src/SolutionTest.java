import org.junit.jupiter.api.Test;

/**
 * @author wwx-sys
 * @time 2020-08-26-16:06
 * @description
 */
class SolutionTest {
    Solution solution = new Solution();

    @Test
    void trap1() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap1(height));
    }

    @Test
    void trap2() {
        int[] height = new int[]{1};
        System.out.println(solution.trap2(height));
    }

    @Test
    void trap3() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap4(height));
    }
}