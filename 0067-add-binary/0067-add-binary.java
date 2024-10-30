class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder ans = new StringBuilder();
        char carry = '0';

        while(i>=0 && j>=0){
            char aa = a.charAt(i);
            char bb = b.charAt(j);
            if(aa=='1' && bb=='1'){
                if(carry=='1'){
                    ans.append('1');
                }
                else{
                    ans.append('0');
                    carry = '1';
                }
            }
            else if(aa=='0' && bb=='0'){
                if(carry=='1'){
                    ans.append('1');
                    carry='0';
                }else{
                    ans.append('0');
                }
            }
            else{
                if(carry=='0'){
                    ans.append('1');
                }
                else{
                    ans.append('0');
                    carry='1';
                }
            }
            i--;
            j--;
        }
        while(i>=0){
            char aa = a.charAt(i);
            if(aa=='1'){
                if(carry=='1'){
                    ans.append('0');
                }
                else{
                    ans.append('1');
                    // carry = '1';
                }
            }
            else{
                if(carry=='1'){
                    ans.append('1');
                    carry='0';
                }
                else{
                    ans.append('0');
                    // carry = '1';
                }
            }
            i--;
        }
        while(j>=0){
            char aa = b.charAt(j);
            if(aa=='1'){
                if(carry=='1'){
                    ans.append('0');
                }
                else{
                    ans.append('1');
                    // carry = '1';
                }
            }
            else{
                if(carry=='1'){
                    ans.append('1');
                    carry='0';
                }
                else{
                    ans.append('0');
                    // carry = '1';
                }
            }
            j--;
        }
        if(carry=='1')ans.append('1');
        return ans.reverse().toString();
    }
}