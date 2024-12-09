class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(1,-1);
        mp.put(2,-1);
        int max = 0;
        int i=0;
        int j=0;
        int n=fruits.length;
        while(j<n){
            if(mp.get(1)==-1){
                mp.put(1,j);
            }
            else if(fruits[j] == fruits[mp.get(1)]){
                mp.put(1,j);
            }
            else if(mp.get(2)==-1 && fruits[j]!=fruits[mp.get(1)]){
                mp.put(2,j);
            }
            else if(fruits[j] == fruits[mp.get(2)])mp.put(2,j);
            else if(fruits[j]!=fruits[mp.get(1)] && fruits[j]!=fruits[mp.get(2)]){
                max = Math.max(max,j-i);
                // System.out.println(i+"  "+j);
                // while(i<=j && fruits[i]==mp.get(1)){
                //     i++;
                // }
                // i = mp.get(1)+1;
                // mp.put(1,mp.get(2));
                // mp.put(2,j);
                i = Math.min(mp.get(1),mp.get(2))+1;
                if(mp.get(1)<mp.get(2)){
                    // i = mp.get(1)+1;
                    mp.put(1,mp.get(2));
                    mp.put(2,j);
                }
                else {
                    // i = mp.get(2)+1;
                    mp.put(2,j);
                }
            }
            j++;
        }
        return Math.max(max,j-i);
    }
}