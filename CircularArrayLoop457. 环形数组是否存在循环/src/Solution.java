import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/8/7 14:48
 */
public class Solution {
    public boolean circularArrayLoop1(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        List<Integer> visited = new ArrayList<>();
        int startIndex = 0;
        while (true) {
            if (visited.contains(startIndex) || visited.size() == nums.length) {
                break;
            }
            visited.add(startIndex);
            startIndex += nums[startIndex];
            startIndex = (nums.length + startIndex) % nums.length;
        }

        int len = 0;
        for (Integer integer : visited) {
            if (integer == startIndex) {
                len += 1;
            }
            if (len > 0) {
                if (nums[startIndex] * nums[integer] < 0) {
                    return false;
                }
                len += 1;
            }
        }
        return len > 2;
    }


    //快慢指针，慢指针每次走一步，快指针每次走两步
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = next(nums, i);
            // 判断非零且方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            int add = i;
            //如果快慢指针相遇，或者移动方向改变，那我们就停止遍历，并将快慢指针经过的点均置为零
            while (nums[add] * nums[next(nums, add)] > 0) {
                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    public int next(int[] nums, int cur) {
        int n = nums.length;
        return ((cur + nums[cur]) % n + n) % n; // 保证返回值在 [0,n) 中
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -1, -2, -2};
        System.out.println(new Solution().circularArrayLoop(nums));
    }
}
