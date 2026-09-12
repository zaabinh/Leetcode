class Solution {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        char[] r = new char[n];

        int index = n - 1;
        int k = 0;

        while (index >= 0) {
            while (index >= 0 && a[index] == ' ') {
                index--;
            }

            if (index < 0) break;

            int end = index;

            while (index >= 0 && a[index] != ' ') {
                index--;
            }

            int start = index + 1;

            if (k > 0) {
                r[k++] = ' ';
            }

            for (int i = start; i <= end; i++) {
                r[k++] = a[i];
            }
        }

        return new String(r, 0, k);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "Hello world";
        System.out.println(s.reverseWords(str));
    }
}