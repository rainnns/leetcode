import java.util.Arrays;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void subarraySum() {
        Solution solution = new Solution();
        int[] nums = {-19, -82, -70, -46, -29, 7, 15, -72, -7, 100, 303};
        int k = 100;
        System.out.println(solution.subarraySum(nums, k));

    }
}