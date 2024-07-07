class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = numBottles;
        int ans = empty;

        while(empty>=numExchange){
            int temp = (empty/numExchange);
            empty -= (temp*numExchange);
            empty+=temp;
            ans+=temp;
        }

        return ans;
    }
}