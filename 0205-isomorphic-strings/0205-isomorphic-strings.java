class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        // String a = "";
        // String b = "";
        List<Integer> ar = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Map<Character,Integer> mp = new HashMap<>();
        Map<Character,Integer> mpp = new HashMap<>();
        int num = 1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int n = mp.getOrDefault(c,num++);
            ar.add(n);
            mp.put(c,n);
        }
        num = 1;
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            int n = mpp.getOrDefault(c,num++);
            arr.add(n);
            mpp.put(c,n);
        }
        // System.out.println(a + "         " + b);
        for(int i=0;i<ar.size();i++){
            // System.out.println(a.charAt(i) + "______  "+b.charAt(i));
            if(ar.get(i)!=arr.get(i))return false;
        }
        return true;
    }
}