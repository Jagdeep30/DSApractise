// class Solution {
//     public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
//         Stack<Pair<Integer,Integer>> st = new Stack<>();
//         char[] dir = directions.toCharArray();
//         int n = positions.length;
        
//         for(int i=0;i<n;i++){
//             if(st.isEmpty()){
//                 st.push(new Pair<Integer,Integer>(positions[i],i));
//                 continue;
//             }
//             int t = st.peek().getValue();
//             //handle if both are at same position

//             int left,right = 0;

//             if(st.peek().getKey()<positions[i]){
//                 left = t;
//                 right = i;
//             }else{
//                 left = i;
//                 right = t;
//             }
//             char cur = dir[left];
//             char next = dir[right];
//             if(cur=='R' && next=='L'){
//                 if(healths[t]==healths[i])st.pop();
//                 else if(healths[t]<healths[i]){
//                     st.pop();
//                     st.push(new Pair<Integer,Integer>(positions[i],i));
//                     healths[i]--;
//                 }
//                 else{
//                     healths[t]--;
//                 }
//             }else{
//                 st.push(new Pair<Integer,Integer>(positions[i],i));
//             }
//         }

//         List<Integer> ans = new ArrayList<>();
//         while(!st.isEmpty()){
//             Pair<Integer,Integer> temp = st.pop();
//             ans.add(healths[temp.getValue()]);
//         }
//         Collections.reverse(ans);
//         // System.out.println(st);
//         return ans;
//     }
// }


class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            robots.add(new int[]{positions[i], healths[i], directions.charAt(i), i});
        }

        Collections.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robots) {
            if (robot[2] == 'R' || stack.isEmpty() || stack.peek()[2] == 'L') {
                stack.push(robot);
                continue;
            }

            if (robot[2] == 'L') {
                boolean add = true;
                while (!stack.isEmpty() && stack.peek()[2] == 'R' && add) {
                    int last_health = stack.peek()[1];
                    if (robot[1] > last_health) {
                        stack.pop();
                        robot[1] -= 1;
                    } else if (robot[1] < last_health) {
                        stack.peek()[1] -= 1;
                        add = false;
                    } else {
                        stack.pop();
                        add = false;
                    }
                }

                if (add) {
                    stack.push(robot);
                }
            }
        }

        List<int[]> resultList = new ArrayList<>(stack);
        resultList.sort(Comparator.comparingInt(a -> a[3]));

        List<Integer> result = new ArrayList<>();
        for (int[] robot : resultList) {
            result.add(robot[1]);
        }

        return result;
    }
}