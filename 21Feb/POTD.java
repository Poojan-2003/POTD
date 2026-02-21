import java.util.*;

class Solution {
    // O(N)
    public static boolean isPrime(int num){
        if(num<2)return false;
	    boolean ans[] = new boolean[num+1];
        
        //O(Right)
        Arrays.fill(ans,true);
	    ans[0] = false;
        ans[1] = false;

        //O(Num Log Log Num)
        for(int i=2;i*i<=num;i++){
            if(ans[i]){
                for(int j=i*i;j<=num;j+=i){
                ans[j] = false;
                }
            }
        }
        return ans[num];
    }

    //O(Log right)
    public static int countSetBit(int num){
        int cnt = 0;
        while(num!=0){
            cnt += (num & 1) == 1 ? 1 : 0;
            num = num >>> 1;
        }
        return cnt;
    }


    public int countPrimeSetBits(int left, int right) {
        int ans = 0;

        // O(N × (Log Right + Log Right Log Log Right))
        for(int i=left;i<=right;i++){
            if(isPrime(countSetBit(i)))ans++;
        }
        return ans;
    }
}