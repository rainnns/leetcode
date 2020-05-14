import java.util.ArrayList;

class Solution {
    public int singleNumber(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums) {
            if (arrayList.contains(num)){
                arrayList.remove((Integer) num);
            }
            else {
                arrayList.add(num);
            }
        }
        return arrayList.get(0);
    }
}