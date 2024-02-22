class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<trust.length;i++){
            List<Integer> temp = mp.getOrDefault(trust[i][0],new ArrayList<>());
            temp.add(trust[i][1]);
            mp.put(trust[i][0],temp);
        }

        Stack<Integer> st = new Stack<>();
        for(int i=1;i<=n;i++)st.push(i);

        while(st.size()!=1){
            int a = st.pop();
            int b = st.pop();

            if(mp.getOrDefault(a,null)==null){
                st.push(a);
            }
            else{
                st.push(b);
            }
        }
        int a = st.pop();
        if(mp.getOrDefault(a,null)==null){
            int c = n;
            for(Map.Entry<Integer,List<Integer>> e: mp.entrySet()){
                if(e.getValue().contains(a))c--;
            }
            if(c==1)return a;
        }

        return -1;
    }
}