class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        boolean odd = false;
        int ans = 0;

        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }

        for(Map.Entry<Character,Integer> e:mp.entrySet()){
            if(e.getValue()%2==0)ans+=e.getValue();
            else{
                odd = true;
                ans+=e.getValue()-1;
            }
        }

        if(odd)ans++;
        return ans;
    }
}