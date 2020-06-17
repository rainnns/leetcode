import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 描述:
 *
 * @author black-leaves
 * @createTime 2020-06-17  17:01
 */

class SolutionTest {

    @Test
    void maxScoreSightseeingPair() {
        Solution solution = new Solution();
        int[] A = new int[]{8, 1, 5, 2, 6};
        System.out.println(solution.maxScoreSightseeingPair(A));
    }
}