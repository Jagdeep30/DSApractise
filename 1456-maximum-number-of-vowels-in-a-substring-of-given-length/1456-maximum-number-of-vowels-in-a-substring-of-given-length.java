class Solution {
    public int maxVowels(String s, int k) {
        // String temp = "";
        int sum = 0;
        int ans = 0;
        // for(int i=0;i<s.length();i++){
        //     char ch = s.charAt(i);
        //     if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')temp+='1';
        //     else temp+='0';
        // }

        for(int i=0;i<k;i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')sum+=1;
            // else temp+='0';
        }
        ans = Math.max(ans,sum);
        for(int i=k;i<s.length();i++){
            char ch = s.charAt(i);
            char chh = s.charAt(i-k);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')sum++;
            if(chh=='a' || chh=='e' || chh=='i' || chh=='o' || chh=='u')sum--;
            ans = Math.max(ans,sum);
            // else temp+='0';
        }

        // System.out.println(temp);
        // for(int i=0;i<k;i++){
        //     if(temp.charAt(i)=='1')sum++;
        // }
        // ans = Math.max(ans,sum);
        // for(int i=k;i<temp.length();i++){
        //     sum += temp.charAt(i)=='1'?1:0;
        //     sum -= temp.charAt(i-k)=='1'?1:0;
        //     ans = Math.max(ans,sum);
        // }
        return ans;
    }
}