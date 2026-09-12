class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows > s.length()) {
            return s;
        }
        char[] st = s.toCharArray();
        char[] ans = new char[st.length];
        int ansIndex = 0;

        int cycle = 2 * numRows - 2;

        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < st.length; j += cycle) {
                ans[ansIndex++] = st[j];
                int dig = j + cycle - 2 * i;
                if(i > 0 && i < numRows - 1 && dig < st.length) {
                    ans[ansIndex++] = st[dig];
                }
            }
        }

        return new String(ans, 0, ansIndex);
        
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