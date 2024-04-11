// class Solution {
//     public String removeKdigits(String num, int k) {
//         if(num.length()==1)return "0"; 
//         Stack<Character> st = new Stack<>();
//         // int nums = Integer.parseInt(num);
//         char[] nums = num.toCharArray();
//         int req = nums.length-k;

//         for(int i=0;i<nums.length;i++){
//             int curr = 0;
//             if(!st.isEmpty())curr = st.peek()-48;
//             int currnum = nums[i]-48;
//             while(!st.isEmpty() && currnum<curr && st.size()+(nums.length-i)>req){
//                 st.pop();
//                 if(!st.isEmpty())curr = st.peek()-48;
//             }
//             st.push(nums[i]);
//             // System.out.println(st);
//         }

//         StringBuilder ans = new StringBuilder("");
//         while(!st.isEmpty()){
//             ans.append(st.pop());
//         }

//         String s = ans.reverse().toString();

//         int res = Integer.parseInt(s);
//         s = Integer.toString(res);
//         return s;
//     }
// }

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        // Remove remaining k digits from the end of the stack
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // Construct the resulting string from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse(); // Reverse to get the correct order
        
        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        // Handle edge case where result might be empty
        return sb.length() > 0 ? sb.toString() : "0";
    }
}