class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(arr.length!=pattern.length())return false;
        Map<Character,String> mp = new HashMap<>();
        Map<String,Character> mpp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            char c = pattern.charAt(i);
            String res = mp.getOrDefault(c,"");
            if(res.equals("")){
                if(mpp.getOrDefault(arr[i],'*')!='*')return false;
                mp.put(c,arr[i]);
                mpp.put(arr[i],c);
            }else{
                if(!res.equals(arr[i]))return false;
            }
        }
        return true;
    }
}