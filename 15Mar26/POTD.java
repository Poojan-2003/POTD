import java.util.*;

class Fancy {

    static long MOD = 1000000007;

    ArrayList<Long> list;
    long mul = 1;
    long add = 0;

    public Fancy() {
        list = new ArrayList<>();
    }

    public void append(int val) {
        long adjusted = ((val - add) % MOD + MOD) % MOD;
        adjusted = (adjusted * modInverse(mul)) % MOD;
        list.add(adjusted);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size())
            return -1;

        long val = list.get(idx);
        long ans = (val * mul) % MOD;
        ans = (ans + add) % MOD;

        return (int) ans;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % MOD;

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}