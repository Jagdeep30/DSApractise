class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        return getMaximumScore(tokens,power);
    }

    static int getMaximumScore(int[] tokens, int power){
        int score = 0;
        int maxScore = 0;
        int length = tokens.length;

        int s = 0;
        int e = length - 1;

        Arrays.sort(tokens);

        while(s<=e){
            if(power>=tokens[s]){
                power-=tokens[s];
                score++;
                s++;
                
            }
            else if(score==0)return maxScore;
            else{
                power+=tokens[e];
                maxScore = Math.max(maxScore,score);
                score--;
                e--;
            }
        }



        return maxScore = Math.max(maxScore,score);
    }
}