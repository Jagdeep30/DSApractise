class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for(Character ch: s.toCharArray()){
            arr[ch-'a']++;
        }
        for(Character ch: t.toCharArray()){
            arr[ch-'a']--;
        }

        for(int i=0;i<26;i++){
            if(arr[i]!=0)return false;
        }
        return true;
    }
}