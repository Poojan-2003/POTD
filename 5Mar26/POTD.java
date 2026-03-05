class Solution {
    // TC - O(N) where N is the length of the string s. We need to iterate through the string once to count the number of operations needed for both patterns.
    // SC - O(1) as we are using only a constant amount of extra space to store the counts of operations needed for both patterns.
    public int minOperations(String s) {
        int cnt = 0;
        int cnt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            // Pattern 1 - 101010...
            if (i % 2 == 0) {
                if (s.charAt(i) != '1')
                    cnt++;
            } else {
                if (s.charAt(i) != '0')
                    cnt++;
            }
            // Pattern 2 - 010101...
            if (i % 2 == 0) {
                if (s.charAt(i) != '0')
                    cnt1++;
            } else {
                if (s.charAt(i) != '1')
                    cnt1++;
            }
        }
        
        return Math.min(cnt, cnt1);
    }
}