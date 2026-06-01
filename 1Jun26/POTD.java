import java.util.Arrays;

class Solution {
    
    // Time Complexity: O(NlogN + N) - Sorting the array
    // Space Complexity: O(1) - No extra space used

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);                  //O(nlogn) - Sorting the array
        int i = cost.length-1;
        int j = cost.length-2;
        int ans = 0;
        // if(cost.length == 1)return cost[0];
        // if(cost.length == 2)return cost[0] + cost[1];
        while(i>=0){                        //O(n) - Iterating through the array
            if(j<0){
                ans += cost[i];
            }
            else{
                ans += cost[i] + cost[j];
            }
            j-=3;
            i-=3;
        }
        return ans;
    }
}

/*
*  6 5 7 9 2 2
*  2 2 5 6 7 9 => 7 + 9 + 7
*
*/