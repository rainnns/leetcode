import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wwx-sys
 * @time 2021-08-27-9:57
 * @description
 */
public class MedianFinder {
    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;


    public MedianFinder() {
        minQueue = new PriorityQueue<>((a, b) -> (b - a));
        maxQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    }

    public void addNum(int num) {
        if (minQueue.isEmpty() || minQueue.peek() >= num) {
            minQueue.offer(num);
            if (minQueue.size() > maxQueue.size() + 1) {
                maxQueue.offer(minQueue.poll());
            }
        } else {
            maxQueue.offer(num);
            if (maxQueue.size() > minQueue.size()) {
                minQueue.offer(maxQueue.poll());
            }
        }


    }

    public double findMedian() {
        if (minQueue.size() > maxQueue.size()) {
            return minQueue.peek();
        }
        return (minQueue.peek() + maxQueue.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }

    //进阶 1
    //
    //如果数据流中所有整数都在 0 到 100 范围内，那么我们可以利用计数排序统计每一类数的数量，并使用双指针维护中位数。
    //进阶 2
    //
    //如果数据流中 99% 的整数都在 0 到 100 范围内，那么我们依然利用计数排序统计每一类数的数量，并使用双指针维护中位数。对于超出范围的数，我们可以单独进行处理，建立两个数组，分别记录小于 0 的部分的数的数量和大于 100 的部分的数的数量即可。当小部分时间，中位数不落在区间 [0,100] 中时，我们在对应的数组中暴力检查即可。
}
