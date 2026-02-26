class Solution {
    // O(S.length) == O(500)
    public static String addOne(String s) {
        int carry = s.charAt(s.length() - 1) == '1' ? 1 : 0;
        StringBuilder builder = new StringBuilder(s);

        if (carry == 0) {
            builder.setCharAt(s.length() - 1, '1');
            s = builder.toString();
            return s;
        } else {
            builder.setCharAt(s.length() - 1, '0');
            s = builder.toString();
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                builder.setCharAt(i, '0');
            } else {
                builder.setCharAt(i, '1');
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            builder = builder.insert(0, '1');
        }
        return builder.toString();
    }

    // O(N^2) where N is the length of the string s. In the worst case, we might have to perform N steps, and each step involves creating a new string which takes O(N) time.
    public int numSteps(String s) {
        int cnt = 0;
        // Iterate over string
        while (s.length() >= 1) {

            if (s.length() == 1 && s.charAt(0) == '1')
                return cnt;

            // Num is Odd
            if (s.charAt(s.length() - 1) == '1') {
                s = addOne(s);
            } else {
                s = s.substring(0, s.length() - 1);
            }
            // System.out.println(s);
            cnt++;
        }
        return cnt;
    }
}