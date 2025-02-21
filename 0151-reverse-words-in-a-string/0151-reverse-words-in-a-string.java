class Solution {
    public String reverseWords(String s) {
        s = s.strip();
        String[] arr = s.split("\s+");
        // String ans = "";
        int i=0;
        int j=arr.length-1;
        while(i<j){
            String t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;j--;
        }
        return String.join(" ", arr);
        // System.out.println(ss);
        // return ss;
    }
}