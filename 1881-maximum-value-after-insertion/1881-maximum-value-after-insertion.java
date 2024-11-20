class Solution {
    public String maxValue(String n, int x) {
        if(n.charAt(0)=='-'){
            int i=1;
            while(i<n.length() && n.charAt(i)-'0'<=x)i++;
            return n.substring(0,i) + Integer.toString(x) + n.substring(i);
        }
        else{
            int i=0;
            while(i<n.length() && n.charAt(i)-'0'>=x)i++;
            return n.substring(0,i) + Integer.toString(x) + n.substring(i);
        }
    }
}