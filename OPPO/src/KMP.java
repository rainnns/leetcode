/**
 * @author wwx-sys
 * @time 2021-10-20-16:33
 * @description kmp字符串匹配算法
 */
public class KMP {
    /**
     * @param ts 主串
     * @param ps 模式串
     * @return 返回匹配的索引
     */
    public int kmp(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        //主串的当前游标
        int i = 0;
        //模式串的当前游标
        int j = 0;
        int[] next = getNext(p);
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == p.length) {
            return i - j;
        }
        return -1;
    }

    /**
     * @param ts 主串
     * @param ps 模式串
     * @return 返回匹配的个数
     */
    public int kmpCount(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        //主串的当前游标
        int i = 0;
        //模式串的当前游标
        int j = 0;
        int[] next = getNext(p);
        int count = 0;
        while (i < t.length) {
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == p.length) {
//                System.out.println(i-j);
                count++;
                j = -1;
            }
        }
        return count;
    }

    public int[] getNext(char[] p) {
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                if (p[++j] == p[++k]) { // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k; //等于最大公共前后缀长度 + 1
                }
            } else {
                k = next[k];
            }
        }

        return next;
    }

    public static void main(String[] args) {
        System.out.println(new KMP().kmpCount("qweqwoppoadadoppoad", "oppo"));
    }
}
