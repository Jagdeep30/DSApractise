class Solution {
    public int romanToInt(String ss) {
        Map<Character,Integer> mp = new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);

        int s = 0;
        int prev = mp.get(ss.charAt(0));
        for(int i=1;i<ss.length();i++){
            int curr = mp.get(ss.charAt(i));
            if(curr<=prev){
                s+=prev;
                prev=curr;
            }else{
                prev = curr - prev;
            }
        }
        s+=prev;
        return s;
    }
}