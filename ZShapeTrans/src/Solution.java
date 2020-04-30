import java.util.ArrayList;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        } else {
            ArrayList<String> fenzu = new ArrayList<>();
            int rest_length = s.length();
            while (rest_length > 0) {
                if (rest_length < numRows) {
                    fenzu.add(s.substring(s.length() - rest_length));
                    break;
                } else {
                    fenzu.add(s.substring(s.length() - rest_length, s.length() - rest_length + numRows));
                    rest_length -= numRows;
                    for (int i = 0; i < numRows - 2; i++) {
                        if (getMidString(s, rest_length, fenzu)) {
                            rest_length -= 1;
                        } else
                            break;
                    }
                }
            }
            System.out.println(fenzu);
            return getTransString(fenzu, numRows);
        }
    }

    boolean getMidString(String s, int rest_length, ArrayList<String> fenzu) {
        if (rest_length < 1) {
            return false;
        } else {
            fenzu.add(s.substring(s.length() - rest_length, s.length() - rest_length + 1));
            return true;
        }
    }

    String getTransString(ArrayList<String> fenzu, int numRows) {
        String[][] Z = new String[numRows][fenzu.size()];
        for (int j = 0; j < fenzu.size(); j++) {
            if (j == 0 || j % (numRows - 1) == 0) {
                for (int i = 0; i < numRows; i++) {
                    if (i < fenzu.get(j).length()) {
                        Z[i][j] = String.valueOf(fenzu.get(j).charAt(i));
                    }
                }
            } else {
                int cha = j % (numRows - 1);
                int row = numRows - 1 - cha;
                Z[row][j] = fenzu.get(j);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String[] strings : Z) {
            for (String string : strings) {
                if (string != null) {
                    res.append(string);
                }
            }
        }
        return res.toString();
    }
}