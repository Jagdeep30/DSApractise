class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        if(n==1)return s;
        char[] arr = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(i<n){
                if(arr[i]!='a' && arr[i]!='e' && arr[i]!='i' && arr[i]!='o' && arr[i]!='u' && arr[i]!='A' && arr[i]!='E' && arr[i]!='I' && arr[i]!='O' && arr[i]!='U'){
                    i++;
                }
                else break;
            }
            while(j>=0){
                if(arr[j]!='a' && arr[j]!='e' && arr[j]!='i' && arr[j]!='o' && arr[j]!='u' && arr[j]!='A' && arr[j]!='E' && arr[j]!='I' && arr[j]!='O' && arr[j]!='U'){
                    j--;
                }
                else break;
            }
            if(i<j){
                char t = arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                i++;j--;
            }
        }

        String ans = "";
        for(int k=0;k<n;k++)ans+=arr[k];
        return ans;
    }
}