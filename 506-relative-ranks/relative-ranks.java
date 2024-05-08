class Solution {
    public String[] findRelativeRanks(int[] score) {
        List<List<Integer>> ls = new ArrayList<>();

        for(int i=0;i<score.length;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(score[i]);
            temp.add(i);
            ls.add(temp);
        } 

        Collections.sort(ls,(a,b)->{
            return Integer.compare(a.get(0),b.get(0));
        });

        String[] ans = new String[score.length];
        int rank = 1;
        for(int i=score.length-1;i>=0;i--){
            int j = ls.get(i).get(1);
            if(rank==1){
                ans[j] = "Gold Medal";
            }
            else if(rank==2){
                ans[j] = "Silver Medal";
            }
            else if(rank==3){
                ans[j] = "Bronze Medal";
            }
            else{
                ans[j] = Integer.toString(rank);
            }
            rank++;
        }

        return ans;
    }
}