class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> d = new ArrayDeque<>();
        char[] arr = senate.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='R'){
                r.offer(i);
            }
            else d.offer(i);
        }
        int ind = senate.length();
        while(!r.isEmpty() && !d.isEmpty()){
            int re = r.peek();
            int de = d.peek();
            if(re<de){
                r.offer(ind++);
                r.poll();
                d.poll();
            }
            else{
                d.offer(ind++);
                d.poll();
                r.poll();
            }
        }
        if(r.isEmpty())return "Dire";
        return "Radiant";
    }
}