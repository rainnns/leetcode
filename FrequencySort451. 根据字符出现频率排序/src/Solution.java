import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/3 18:12
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFre = 0;
        for (int i = 0; i < s.length(); i++) {
            int charInt = s.charAt(i);
            int fre = freqMap.getOrDefault(charInt, 0) + 1;
            if (maxFre < fre){
                maxFre += 1;
            }
            freqMap.put(charInt, fre);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = maxFre; i >= 0; i--) {
            int finalI = i;
            freqMap.forEach((c, count) -> {
                if (count == finalI) {
                    sb.append(String.valueOf((char) (int) c).repeat(count));
                }
            });
        }
        return sb.toString();
    }

    //按照出现频率排序
    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(String.valueOf(c).repeat(map.get(c)));
        }
        return sb.toString();
    }

    //桶排序
    public String frequencySort3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuffer();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i];
            for (int j = 0; j < bucket.length(); j++) {
                sb.append(String.valueOf(bucket.charAt(j)).repeat(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(new Solution().frequencySort(s));
    }
}
