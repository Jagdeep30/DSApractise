class Solution {
    public List<String> commonChars(String[] words) {
        // int[] arr = new int[26];

        // for(int i=0;i<words.length;i++){
        //     char[] a = words[i].toCharArray();
        //     for(int j=0;j<a.length;j++){
        //         int ind = a[j]-'a';
        //         if(arr[ind]==i)arr[ind]++;
        //     }
        // }
        // List<String> ans = new ArrayList<>();
        // int n = words.length;
        // for(int i=0;i<26;i++){
        //     if(arr[i]==n){
        //         ans.add(((char)('a'+i))+"");
        //     }
        // }

        // return ans;


        Map<Character,Map<Integer,Integer>> mp = new HashMap<>();

        for(int i=0;i<words.length;i++){
            char[] a = words[i].toCharArray();
            for(int j=0;j<a.length;j++){
                // int ind = a[j]-'a';
                // mp.put(a[j],mp.getOrDefault(a[j],new HashMap<Integer,Integer>()).getOrDefault(i,0)+1);
                if(mp.get(a[j])!=null){
                    mp.get(a[j]).put(i,mp.get(a[j]).getOrDefault(i,0)+1);
                }
                else{
                    Map<Integer,Integer> temp = new HashMap<>();
                    temp.put(i,1);
                    mp.put(a[j],temp);
                }

                // if(arr[ind]==i)arr[ind]++;
            }
        }
        int n = words.length;
        // System.out.println(mp);
        List<String> ans = new ArrayList<>();

        for(Map.Entry<Character,Map<Integer,Integer>> e:mp.entrySet()){
            char key = e.getKey();
            Map<Integer,Integer> val = e.getValue();
            if(val.size()==n){
                int min = Integer.MAX_VALUE;
                for(Map.Entry<Integer,Integer> ent:val.entrySet()){
                    min = Math.min(min,ent.getValue());
                }

                for(int i=0;i<min;i++)ans.add(key+"");
            }
        }
        return ans;
    }
}