class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] fr = new int[26];
        int[] len = new int[words.length];

        for(int i=0;i<words.length;i++){
            len[i] = words[i].length();
            for(char ch:words[i].toCharArray()){
                fr[ch-'a']++;
            }
        }

        int pairs = 0;
        int odd = 0;
        for(int i=0;i<26;i++){
            pairs+=fr[i]/2;
            if(fr[i]%2!=0)odd++;
        }

        Arrays.sort(len);
        int ans = 0;
        for(int i=0;i<len.length;i++){
            if(len[i]%2==0){
                pairs-=len[i]/2;
                if(pairs>=0)ans++;
            }
            else{
                pairs-=len[i]/2;
                if(odd>0){
                    odd--;
                }
                else{
                    pairs--;
                    odd+=1;
                }
                if(pairs>=0)ans++;
            }
        }

        return ans;
    }
}