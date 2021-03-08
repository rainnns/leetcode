import org.junit.jupiter.api.Test;

/**
 * @author wwx-sys
 * @time 2020-11-24-19:41
 * @description
 */
class SolutionTest {

    @Test
    public void maximalRectangle() {
        Solution solution = new Solution();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(solution.maximalRectangle2(matrix));
    }
}