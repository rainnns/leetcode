import java.util.Arrays;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void allCellsDistOrder() {
        Solution solution = new Solution();
        int [][] result = solution.allCellsDistOrder(2,3,1,2);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }

    }
}