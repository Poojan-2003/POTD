class Solution {
    static int MOD = 1000000007;
    // TC - O(Z * O * L) where Z is the number of zeros, O is the number of ones and L is the limit. SC - O(Z * O * 2) for the dp array.
    // The idea is to use dynamic programming to count the number of valid sequences.
    // We define a recursive function solve that takes the number of zeros left, the number of ones left, a boolean indicating whether the last used character was a one, the limit and the dp array. The function returns the number of valid sequences that can be formed with the given parameters.
    public static int solve(int zerosLeft, int onesLeft, boolean lastUsedOne, int limit, int dp[][][]) {

        if (zerosLeft == 0 && onesLeft == 0)
            return 1;

        int idx = lastUsedOne ? 1 : 0;

        if (dp[zerosLeft][onesLeft][idx] != -1)
            return dp[zerosLeft][onesLeft][idx];

        long res = 0;

        if (lastUsedOne) {
            for (int i = 1; i <= Math.min(zerosLeft, limit); i++) {
                res = (res + solve(zerosLeft - i, onesLeft, false, limit, dp)) % MOD;
            }
        } else {
            for (int i = 1; i <= Math.min(onesLeft, limit); i++) {
                res = (res + solve(zerosLeft, onesLeft - i, true, limit, dp)) % MOD;
            }
        }

        return dp[zerosLeft][onesLeft][idx] = (int) res;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        int dp[][][] = new int[201][201][2];
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int zerosFirst = solve(zero, one, true, limit, dp);
        int onesFirst = solve(zero, one, false, limit, dp);
        return (zerosFirst + onesFirst) % 1000000007;
    }
}