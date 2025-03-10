class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            pairs[i] = binaryS(potions, spells[i], success);
        }
        return pairs;
    }

    static int binaryS(int[] arr, int sp, long su){
        int s = 0;
        int e = arr.length;

        while(s<e){
            int mid = s+(e-s)/2;
            if(arr[mid]*(long)sp>=su)e = mid;
            else s = mid + 1;
        }

        return arr.length-e;
    }
}