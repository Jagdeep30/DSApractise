class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        if(arr.length==1){
            return pieces[0][0]==arr[0];
        }
        Map<Integer,Pair<Integer,Integer>> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(i==0){
                mp.put(arr[i],new Pair<Integer,Integer>(-2,arr[i+1]));
            }
            else if(i==arr.length-1){
                mp.put(arr[i],new Pair<Integer,Integer>(arr[i-1],-2));
            }
            else{
                mp.put(arr[i],new Pair<Integer,Integer>(arr[i-1],arr[i+1]));
            }
        }
        boolean ans = true;
        for(int i=0;i<pieces.length;i++){
            for(int j=0;j<pieces[i].length;j++){
                int p = -1;
                int n = -1;
                if(mp.getOrDefault(pieces[i][j],null)==null)return false;
                if(j>0){
                    p = mp.get(pieces[i][j]).getKey();
                    // if(mp.get(pieces[i][j]).getKey()==pieces[i][j-1])p = true;
                }
                if(j<pieces[i].length-1){
                    n = mp.get(pieces[i][j]).getValue();
                    // if(mp.get(pieces[i][j].getValue()==peices[i][j+1]))n = true;
                }
                if(p!=-1){
                    if(p!=pieces[i][j-1])return false;
                }
                if(n!=-1){
                    if(n!=pieces[i][j+1])return false;
                }
            }
        }
        return true;
    }
}