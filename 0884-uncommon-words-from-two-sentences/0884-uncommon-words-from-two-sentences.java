class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] a = s1.split(" ");
        String[] b = s2.split(" ");
        Map<String,Integer> mp = new HashMap<>();
        for(int i=0;i<a.length;i++){
            mp.put(a[i],mp.getOrDefault(a[i],0)+1);
        System.out.println(mp);
        }
        System.out.println(mp);
        for(int i=0;i<b.length;i++){
            mp.put(b[i],mp.getOrDefault(b[i],0)+1);
        System.out.println(mp);
        }
        int n = 0;
        for(Map.Entry<String,Integer> e:mp.entrySet()){
            if(e.getValue()==1)n++;
        }
        String[] ans = new String[n];
        int i=0;
        for(Map.Entry<String,Integer> e:mp.entrySet()){
            if(e.getValue()==1){
                ans[i++] = e.getKey();
            }
        }

        return ans;
    }
}