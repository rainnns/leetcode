import java.util.Arrays;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void kidsWithCandies() {
        Solution solution = new Solution();
        int[] candies = new int[]{2,8,7};
        int extraCandies = 1;
        System.out.println(solution.kidsWithCandies(candies, extraCandies));

    }
}