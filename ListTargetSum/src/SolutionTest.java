import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wwx-sys
 * @time 2020-12-11-10:12
 * @description
 */
class SolutionTest {

    @Test
    void listTargetSum() {
        int[] arr = new int[]{3,34,4,12,5,2};
        System.out.println(new Solution().ListTargetSum(arr,9));
    }
}