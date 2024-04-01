class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        // System.out.println(Arrays.toString(arr));
        // return 0;

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i] != " ")return arr[i].length();
        }
        return 0;
    }
}