class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int m = s.length();

        if (m == 0) return true;

        for (int j = 0, n = t.length(); j < n; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                if (++i == m) return true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abc";
        String t = "ahgbjc";
        System.out.print(sol.isSubsequence(s, t));
    }
}