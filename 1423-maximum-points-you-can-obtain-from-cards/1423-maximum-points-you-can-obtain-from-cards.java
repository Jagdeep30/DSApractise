class Solution {
    public int maxScore(int[] card, int k) {
        // if(k==1)return Math.max(card[0],card[card.length-1]);
        // int[] arr = new int[card.length*2];
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = card[i%card.length];
        // }

        // int ans = Integer.MIN_VALUE;
        // // for(int i=card.length-k;i<arr.length-k;i++)
        // int i = card.length-k;
        // int j = i;
        // int kk = k;
        // int win = 0;
        // while(kk!=0){
        //     win+=card[j];
        //     j++;
        //     kk--;
        // }
        // if(k==card.length)return win;
        // ans = Math.max(ans,win);
        // while(j<card.length+k){
        //     // System.out.println(win);
        //     win+=arr[j];
        //     j++;
        //     win-=arr[i];
        //     i++;
        //     ans = Math.max(ans,win);
        // }
        // return ans;
        return solve(card,k);
    }

    static int solve(int[] cards ,int k){
        int n = cards.length;
        int win = 0;
        int total = 0;
        for(int i=0;i<cards.length;i++){
            total+=cards[i];
        }
        if(n==k)return total;

        int i=0;
        k = n-k;
        int kk = k;
        int j=i;
        while(kk!=0){
            win+=cards[j];
            j++;
            kk--;
        }
        int ans = Integer.MAX_VALUE;
        while(j<n){
            ans = Math.min(ans,win);
            win+=cards[j];
            j++;
            win-=cards[i];
            i++;
        }
        ans = Math.min(ans,win);
        return total-ans;
    }
}