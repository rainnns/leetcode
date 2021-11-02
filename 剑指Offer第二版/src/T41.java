import java.util.PriorityQueue;

/**
 * @author wwx-sys
 * @time 2021-11-02-16:50
 * @description 剑指 Offer 41. 数据流中的中位数
 */
public class T41 {
    /**
     * initialize your data structure here.
     */

    private PriorityQueue<Double> leftQueue;
    private PriorityQueue<Double> rightQueue;

    public T41() {
        leftQueue = new PriorityQueue<>((o1, o2) -> (int) (o2 - o1));
        rightQueue = new PriorityQueue<>(Double::compareTo);
    }

    public void addNum(double num) {
        if (leftQueue.size() != rightQueue.size()){
            //同理左边数据多，往右边堆添加数据的时候，先将数据放入左边堆，选出最大值放到右边堆中。
            leftQueue.add(num);
            rightQueue.add(leftQueue.poll());
        }else {
            //将堆顶的数据插入到左边堆，这样保证左边堆插入的元素始终是右边堆的最小值。
            rightQueue.add(num);
            leftQueue.add(rightQueue.poll());
        }
    }

    public double findMedian() {
        return leftQueue.size() != rightQueue.size() ? leftQueue.peek() : (leftQueue.peek() + rightQueue.peek()) / 2;
    }



    public static void main(String[] args) {
        T41 o = new T41();
        o.addNum(2);
        System.out.println(o.findMedian());
        o.addNum(1);
        System.out.println(o.findMedian());
        o.addNum(3);
        System.out.println(o.findMedian());
        o.addNum(4);
        System.out.println(o.findMedian());
    }

    public void addNum1(double num) {
        if (leftQueue.isEmpty()) {
            leftQueue.add(num);
        } else if (leftQueue.peek() >= num) {
            leftQueue.add(num);
        } else {
            rightQueue.add(num);
        }
        balance();
    }

    public void balance() {
        if (Math.abs(leftQueue.size() - rightQueue.size()) > 1) {
            if (leftQueue.size() > rightQueue.size()) {
                rightQueue.add(leftQueue.poll());
            } else {
                leftQueue.add(rightQueue.poll());
            }
        }
    }

    public double findMedian1() {
        if (leftQueue.size() > rightQueue.size()) {
            return leftQueue.peek();
        } else if (rightQueue.size() > leftQueue.size()) {
            return rightQueue.peek();
        }
        return (leftQueue.peek() + rightQueue.peek()) / 2;
    }
}
