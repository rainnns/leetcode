import java.util.Arrays;
import java.util.List;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void wordBreak() {
        Solution solution = new Solution();
        String s = "bb";
        List<String> wordDict = Arrays.asList("a","b","bbb","bbbb");
        System.out.println(solution.wordBreak(s,wordDict));
    }
}