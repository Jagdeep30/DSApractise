class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        int count = 0;
        int i=0;
        int n = chars.length;
        int index = 0;
        while(i<n){
            int ind = countC(chars,i);
            chars[index] = chars[i];
            count++;
            if(ind-i>1){
                count+=Integer.toString(ind-i).length();
                index+=editArray(chars, ind-i, index);
            }
            index++;
            // System.out.println(index);

            i=ind;
        }
        System.out.println(index);
        // count+=Integer.toString(ind-i).length();
        // chars[index] = chars[i];
        // index+=editArray(chars, ind-i, index);
            // System.out.println(Arrays.toString(chars));
        return count;
    }

    static int countC(char[] chars, int i){
        int j = i+1;
        char target = chars[i];
        while(j<chars.length && chars[j]==target)j++;
        return j;
    }
    static int editArray(char[] chars, int c, int i){
        String count = Integer.toString(c);
        i++;
            System.out.println(i);
        for(int j=0;j<count.length();j++){
            // System.out.println(Arrays.toString(chars));
            chars[i+j] = count.charAt(j);
        }
        return count.length();
    }
}