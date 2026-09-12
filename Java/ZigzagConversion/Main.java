class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();

        if (numRows == 1 || numRows >= n) {
            return s;
        }

        char[] ans = new char[n];
        int k = 0;
        int cycle = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {
            for (int j = row; j < n; j += cycle) {
                ans[k++] = s.charAt(j);

                if (row != 0 && row != numRows - 1) {
                    int diagonal = j + cycle - 2 * row;

                    if (diagonal < n) {
                        ans[k++] = s.charAt(diagonal);
                    }
                }
            }
        }

        return new String(ans);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int numRows = 3;
        String str = "PAYPALISHIRING";

        System.out.print(s.convert(str, numRows));
    }
}