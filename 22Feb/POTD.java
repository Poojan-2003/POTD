class Solution {
    public int binaryGap(int n) {
        
        //TC - O(N) where N is the number of bits in the binary representation of n
        int prev = -1;
        int curr = 0;
        int ans = 0;
        while(n != 0){
            if((n&1) == 1){
                ans = prev != -1 ? Math.max(curr-prev,ans) : ans;
                prev = curr;
            }

            n = n>>1;
            curr++;
        }
        return prev == -1 ? 0 : ans;

        // int dist = 0;
        // int cnt1 = Integer.MIN_VALUE;
        // int cnt2 = Integer.MIN_VALUE;
        // int i = 1;
        // boolean vis = false;
        // while(n!=0){
        //     if( (n&1) == 1 && cnt1 == Integer.MIN_VALUE){
        //         cnt1 = i;
        //         System.out.println(cnt1);
        //         System.out.println(cnt2);
        //         if(cnt2 != Integer.MIN_VALUE)dist = Math.max(Math.abs(cnt2-cnt1),dist);
        //         cnt2 = Integer.MIN_VALUE;
        //     }else if( (n&1) == 1 && cnt2 == Integer.MIN_VALUE){
        //         cnt2 = i;
        //         System.out.println(cnt1);
        //         System.out.println(cnt2);
        //         dist = Math.max(Math.abs(cnt2-cnt1),dist);
        //         cnt1 = Integer.MIN_VALUE;
        //         vis = true;
        //     }
        //     n = n>>1;
        //     i++;
        // }
                
        // return !vis ? 0 : dist;
       
    }
}