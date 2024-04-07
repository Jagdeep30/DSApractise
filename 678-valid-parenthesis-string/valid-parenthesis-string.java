class Solution {
    public boolean checkValidString(String s) {
        Stack<Pair<Character,Integer>> brac = new Stack<>();
        Stack<Pair<Character,Integer>> star = new Stack<>();

        char[] arr = s.toCharArray();

        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                brac.push(new Pair<Character,Integer>('(',i));
            }
            else if(arr[i]==')'){
                if(!brac.isEmpty()){
                    brac.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }
                else{
                    return false;
                }
            }
            else{
                //for star
                star.push(new Pair<Character,Integer>('*',i));
            }
        }

        if(star.size()<brac.size())return false;

        while(!brac.isEmpty() && !star.isEmpty() && brac.peek().getValue() < star.peek().getValue()){
            brac.pop();
            star.pop();
        }

        if(brac.isEmpty())return true;
        return false;
    }
}