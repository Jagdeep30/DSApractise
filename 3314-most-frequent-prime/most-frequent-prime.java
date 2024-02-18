class Solution {
    public int mostFrequentPrime(int[][] mat) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                solve(i,j,mat[i][j],n,m,mp,mat);
            }
        }
        System.out.println(mp);
        if(mp.size()==0)return -1;
       int freq = 0;
       int ele = 0;
       for(Map.Entry<Integer,Integer> e:mp.entrySet()){
           if(e.getValue()>freq){
               freq=e.getValue();
               ele=e.getKey();
           }
           else if(e.getValue() == freq && e.getKey()>ele)ele = e.getKey();
       }
       return ele;
    }

    static void solve(int i, int j, int curr, int n, int m, Map<Integer,Integer> mp,int[][] mat){
        // if(i==n){
        //     return;
        // }
        // if(mat[i][j]>9)return;

        if(curr>10 && isPrime(curr)){
            mp.put(curr,mp.getOrDefault(curr,0)+1);
        }
        // mat[i][j]*=10;

        //r
            curr = mat[i][j];
            for(int k=j+1;k<m;k++){
                curr = curr*10+mat[i][k];
                if(curr>10 && isPrime(curr)){
                    mp.put(curr,mp.getOrDefault(curr,0)+1);
                }
            }
            // solve(i,j+1,curr*10+mat[i][j+1],n,m,mp,mat);
        //rd
        // if(i+1<n && j+1<m){
            int k = i+1;
            int l = j+1;
            curr = mat[i][j];
            while(k<n && l<m){
                curr = curr*10+mat[k][l];
                if(curr>10 && isPrime(curr)){
                    mp.put(curr,mp.getOrDefault(curr,0)+1);
                }
                k++;l++;
            }
            // solve(i+1,j+1,curr*10+mat[i+1][j+1],n,m,mp,mat);
        // }
        //d
        // if(i+1<n){
            curr = mat[i][j];
            for(int kk=i+1;kk<n;kk++){
                curr = curr*10+mat[kk][j];
                if(curr>10 && isPrime(curr)){
                    mp.put(curr,mp.getOrDefault(curr,0)+1);
                }
            }
            // solve(i+1,j,curr*10+mat[i+1][j],n,m,mp,mat);
        // }
        //ld
        // if(i+1<n && j-1>=0){
            k = i+1;
            l = j-1;
            curr = mat[i][j];
            while(k<n && l>=0){
                curr = curr*10+mat[k][l];
                if(curr>10 && isPrime(curr)){
                    mp.put(curr,mp.getOrDefault(curr,0)+1);
                }
                k++;l--;
            }
            // solve(i+1,j-1,curr*10+mat[i+1][j-1],n,m,mp,mat);
        // }
        //l
        // if(j-1>=0){
            curr = mat[i][j];
            for(int kk=j-1;kk>=0;kk--){
                curr = curr*10+mat[i][kk];
                if(curr>10 && isPrime(curr)){
                    mp.put(curr,mp.getOrDefault(curr,0)+1);
                }
            }
            // solve(i,j-1,curr*10+mat[i][j-1],n,m,mp,mat);
        // }
        //lu
        // if(i-1>=0 && j-1>=0){
            k = i-1;
            l = j-1;
            curr = mat[i][j];
            while(k>=0 && l>=0){
                curr = curr*10+mat[k][l];
                if(curr>10 && isPrime(curr)){
                    mp.put(curr,mp.getOrDefault(curr,0)+1);
                }
                k--;l--;
            }
            // solve(i-1,j-1,curr*10+mat[i-1][j-1],n,m,mp,mat);
        // }
        //u
        // if(i-1>=0){
            curr = mat[i][j];
            for(int kk = i-1;kk>=0;kk--){
                curr = curr*10+mat[kk][j];
                if(curr>10 && isPrime(curr)){
                    mp.put(curr,mp.getOrDefault(curr,0)+1);
                }
            }
            // solve(i-1,j,curr*10+mat[i-1][j],n,m,mp,mat);
        // }
        //ru
        // if(i-1>=0 && j+1<m){
            k = i-1;
            l = j+1;
            curr = mat[i][j];
            while(k>=0 && l<m){
                curr = curr*10+mat[k][l];
                if(curr>10 && isPrime(curr)){
                    mp.put(curr,mp.getOrDefault(curr,0)+1);
                }
                k--;l++;
            }
            // solve(i-1,j+1,curr*10+mat[i-1][j+1],n,m,mp,mat);
        // }
        // mat[i][j]/=10;
        return;
    }

    static boolean isPrime(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)return false;
        }
        return true;
    }
}