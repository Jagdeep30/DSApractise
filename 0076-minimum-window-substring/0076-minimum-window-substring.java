class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mp = new HashMap<>();
        int c = 0;
        int min = Integer.MAX_VALUE;
        int sI = -1;
        for(int i=0;i<t.length();i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        }
        int l=0;
        int r=0;
        int n = s.length();
        int m = t.length();
        while(r<n){
            int count = mp.getOrDefault(s.charAt(r),0);
            if(count>0){
                c++;
            }
            mp.put(s.charAt(r),count-1);
            
            if(c==m){
                if(r-l+1<min){
                    min = r-l+1;
                    sI = l;
                    // System.out.println(sI);
                }
                while(c==m){
                    count = mp.getOrDefault(s.charAt(l),Integer.MIN_VALUE);
                    mp.put(s.charAt(l),count+1);
                    if(r-l+1<min){
                        min = r-l+1;
                        sI = l;
                    }
                    if(mp.get(s.charAt(l))>0)c--;
                    l++;
                }
            }
            r++;
        }
        if(c==m && r-l+1<min){
            min = r-l+1;
            sI = l;
        }
        return sI==-1?"":s.substring(sI,sI+min);
    }
}