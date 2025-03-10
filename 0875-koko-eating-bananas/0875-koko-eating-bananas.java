class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = 0;
        for(int i=0;i<piles.length;i++)e = Math.max(e,piles[i]);

        while(s<e){
            int mid = s+(e-s)/2;
            int time = 0;
            for(int i=0;i<piles.length;i++){
                time+=piles[i]/mid;
                if(piles[i]%mid!=0)time++;
            }

            if(time>h)s = mid + 1;
            else e = mid;
        }
        return e;
    }
}