// class Solution {
//     public int numTeams(int[] rating) {
//         int[][][] dp = new int[rating.length][4][rating.length+1];

//         return solve(0,rating.length,0,rating.length,rating,dp);
//     }

//     static int solve(int i, int n, int k, int j, int[] rating, int[][][] dp){
//         if(k==3){
//             // System.out.println();
//             return 1;}
//         if(i==n)return 0;

//         if(j>=0 && dp[i][k][j] != 0)return dp[i][k][j];
//         if(j<0 && dp[i][k][j*(-1)] != 0)return dp[i][k][j*(-1)];

//         int inc = 0;
        
//         //include
//         if(k==0){
//             System.out.println(rating[i]);
//             inc = solve(i+1,n,k+1,i,rating,dp);
//         }
//         else if(k==1){
//             if(rating[i]>rating[j]){
//                 System.out.println(rating[i]);
//                 inc = solve(i+1,n,k+1,i,rating,dp);
//             }
//             else {
//                 System.out.println(rating[i]);
//                 inc = solve(i+1,n,k+1,i*-1,rating,dp);}
//         }
//         else if(k==2){
//             if(j<0 && rating[i]<rating[(j*(-1))]){
//                 System.out.println(rating[i]);
//                 // System.out.println();
//                 // inc = solve(i+1,n,k+1,i,rating,dp);
//                 inc+=1;
//             }
//             else if(j>0 && rating[i]>rating[j]){
//                 System.out.println(rating[i]);
//                 // inc = solve(i+1,n,k+1,i,rating,dp);
//                 inc+=1;
//             }
//                 System.out.println();
//         }
//         //exclude
//         int exc = solve(i+1,n,k,j,rating,dp);
        
//         int res = inc + exc;
//         if(j<0)return dp[i][k][j*-1] = res;
//         return dp[i][k][j] = res;
//     }
// }

class Solution {
    public int numTeams(int[] rating) {
        int total = 0;
        int n = rating.length;
        
        for (int i = 0; i < n; i++) {
            int rightLess = 0, rightMore = 0, leftLess = 0, leftMore = 0;

            // Count soldiers after i
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i]) rightLess++;
                else if (rating[j] > rating[i]) rightMore++;
            }
            
            // Count soldiers before i
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) leftLess++;
                else if (rating[j] > rating[i]) leftMore++;
            }

            // Calculate the total number of valid teams
            total += rightLess * leftMore + rightMore * leftLess;
        }

        return total;
    }
}