import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void new21Game() {
        Solution solution = new Solution();
        int N = 10;
        int K = 1;
        int W = 10;
        System.out.println(solution.new21Game(N, K, W));

    }
}