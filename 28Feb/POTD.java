class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int digits = 0;
        for (int i = 1; i <= n; i++) {
            // if((i & (i-1)) == 0){
            // digits++;
            // }

            digits = (int) (Math.log(i) / Math.log(2)) + 1;
            res = ((res << digits) % 1000000007 + i) % 1000000007;
        }
        return (int) res;
    }
}