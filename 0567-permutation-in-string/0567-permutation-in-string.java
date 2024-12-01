class Solution {
    public boolean checkInclusion(String p, String s) {
        if(p.length() > s.length())return false;
        int[] arr = new int[26];
        int[] temp = new int[26];

        for(int i=0;i<p.length();i++){
            arr[p.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length();i++){
            temp[s.charAt(i)-'a']++;
        }

        // List<Integer> ls = new ArrayList<Integer>();
        if(Arrays.equals(arr,temp))return true;
        int j=0;
        for(int i=p.length();i<s.length();i++){
            temp[s.charAt(i)-'a']++;
            temp[s.charAt(j)-'a']--;
            j++;
            if(Arrays.equals(arr,temp))return true;
        }
        return false;
    }
}