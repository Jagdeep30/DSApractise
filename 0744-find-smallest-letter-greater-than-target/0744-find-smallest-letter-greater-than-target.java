class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0;
        int e = letters.length-1;
        int temp = -1;
        while(s<e){
            int mid = s + (e-s)/2;
            if(letters[mid]==target){
                temp = mid;
                s=mid+1;
            }
            else if(letters[mid]<target)s=mid+1;
            else e=mid;
        }
        // if(temp!=-1)return letters[temp+1];
        char ch = letters[e];
        // if(ch==target && e+1<letters.length)return letters[e+1];
        // return letters[0];

        if(ch<=target || e>=letters.length)return letters[0];
        return ch;
    }
}