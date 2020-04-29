import java.util.ArrayList;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void maxProduct() {
        Solution solution = new Solution();
        String[] data = new String[]{"a","aa","aaa","aaaa"};
        int result = solution.maxProduct(data);
        System.out.println(result);
    }
}