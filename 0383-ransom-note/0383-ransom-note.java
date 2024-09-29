class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(int i=0;i<ransomNote.length();i++){
            arr[ransomNote.charAt(i)-'a'] += 1;
        }
        for(int i=0;i<magazine.length();i++){
            int c = magazine.charAt(i)-'a';
            if(arr[c]!=0){
                arr[c] -= 1;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0)return false;
        }
        return true;
    }   
}