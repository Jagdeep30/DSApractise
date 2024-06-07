class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Map<Character,Map<Integer,String>> mp = new HashMap<>();

        String[] arr = sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            Map<Integer,String> temp = mp.getOrDefault(arr[i].charAt(0),new HashMap<>());
            temp.put(i,arr[i]);
            mp.put(arr[i].charAt(0),temp);
        }
        String[] ans = new String[arr.length];
        for(int i=0;i<dictionary.size();i++){
            Map<Integer,String> t;
            t = mp.get(dictionary.get(i).charAt(0));
            // mp.remove(dictionary.get(i).charAt(0));
            if(t!=null){

            
            for(Map.Entry<Integer,String> e:t.entrySet()){
                if(e.getValue().startsWith(dictionary.get(i))){
                    // ans[e.getKey()] = dictionary.get(i);
                    t.put(e.getKey(),dictionary.get(i));
                }
                // else{
                //     ans[e.getKey()] = e.getValue();
                // }
            }
            }
        }

        for(Map.Entry<Character,Map<Integer,String>> e:mp.entrySet()){
            for(Map.Entry<Integer,String> et:e.getValue().entrySet()){
                ans[et.getKey()] = et.getValue();
            }
        }

        // System.out.println(mp);


        return String.join(" ",ans);


    }
}