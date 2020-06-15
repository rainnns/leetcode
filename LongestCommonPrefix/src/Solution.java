class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (strs[0].length() <= i) break;
            String flag = strs[0].substring(i, i + 1);
            for (int i1 = 0; i1 < strs.length; i1++) {
                if (strs[i1].length() <= i || !flag.equals(strs[i1].substring(i, i + 1))) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}