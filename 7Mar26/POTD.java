class Solution {
    public int minFlips(String s) {
        // TC - O(N) where N is the length of the string s. We need to iterate through the string once to count the number of flips needed for both patterns and then iterate through the string again to find the minimum flips.
        // SC - O(1) as we are using only a constant amount of extra space to store the counts of flips needed for both patterns and the result.
        int n = s.length();
        int res = n;
        int[] op = { 0, 0 };

        // Count the number of flips needed for both patterns
        for (int i = 0; i < n; i++)
            op[(s.charAt(i) ^ i) & 1]++;

        // Find the minimum flips needed for both patterns
        for (int i = 0; i < n; i++) {
            op[(s.charAt(i) ^ i) & 1]--;
            op[(s.charAt(i) ^ (n + i)) & 1]++;
            res = Math.min(res, Math.min(op[0], op[1]));
        }

        return res;
    }
}