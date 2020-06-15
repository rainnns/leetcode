import java.util.ArrayList;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void maxProduct() {
        Solution solution = new Solution();
        String[] data = new String[]{"abc","baz","foo","bar","xtfn","abcdef"};
        int result = solution.maxProduct(data);
        System.out.println(result);
    }
}