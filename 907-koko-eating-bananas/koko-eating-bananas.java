class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = 0;
        int s = 1;
        int e = 0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]>e)e=piles[i];
        }

        int mid = 0;
        while(s<=e){
            mid = s+(e-s)/2;
            boolean res = check(mid,piles,h);
            if(!res){
                s = mid+1;
            }
            else{
                ans = mid;
                e = mid-1;
            }
        }

        return ans;
    }

    boolean check(int n, int[] piles, int h){
        // double left = 0;
        int[] dup = piles.clone();
        for(int i=0;i<dup.length;i++){
            // if(h<=0)return false;
            // while(h!=0 && dup[i]!=0){
            //     dup[i] = Math.max(0,dup[i]-n);
            //     h--;
            // }
            h -= Math.ceil((double)dup[i]/n);
            // System.out.println(Math.ceil((double)dup[i]/n)+"    "+h);
            
            // left+=Math.max(0,dup[i]-n);
            // h--;
        }
        // System.out.println(n+"  "+Arrays.toString(dup)+"   "+h);
        // if(dup[dup.length-1]!=0)return false;
        // else return true;
        if(h<0)return false;
        else return true;

        // if(left == 0)return true;
        // if(Math.ceil(left/n)<=h)return true;
        // else return false;
    }
}