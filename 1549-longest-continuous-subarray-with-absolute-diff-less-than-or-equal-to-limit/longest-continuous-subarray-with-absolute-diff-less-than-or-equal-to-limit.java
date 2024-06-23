// class Solution {
//     public int longestSubarray(int[] nums, int limit) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         PriorityQueue<Integer> pqs = new PriorityQueue<>(Collections.reverseOrder());
//         int ans = 1;
//         int i = 0;
//         int j = 1;
//         int n = nums.length;
//         pq.add(nums[0]);

//         // while(i<n){
//             // j = i+1;
//             while(i<n && j<n && i<j){
//                 // if(i==j)j++;
//                 // if(pq.isEmpty())pq.add(nums[i]);
//                 // System.out.println(pq.peek() + " " + j);
//                 if(Math.abs(pq.peek()-nums[j])<=limit && Math.abs(pqs.peek()-nums[j])<=limit){
//                     pq.add(nums[j]);
//                     j++;
//                     ans = Math.max(ans,pq.size());
//                 }
//                 else{
//                     ans = Math.max(ans,pq.size());
//                     int ele = pq.poll();
//                     while(i<n && nums[i]!=ele)i++;
//                     i++;
//                     if(j<=i){
//                         j=i+1;
//                         pq.clear();
//                         pq.add(nums[i]);
//                     }
//                     // break;
//                 }
//             }
//         // }

//         return ans;
//     }
// }

class Solution {
    public void adjust(Deque<Pair<Integer, Integer>> mono, int left) {
        while (!mono.isEmpty() && mono.peekFirst().getValue() < left) {
            mono.pollFirst();
        }
    }
    
    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;
        Deque<Pair<Integer, Integer>> monoMax = new ArrayDeque<>();
        Deque<Pair<Integer, Integer>> monoMin = new ArrayDeque<>();
        
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!monoMax.isEmpty() && nums[i] > monoMax.peekLast().getKey()) {
                monoMax.pollLast();
            }
            while (!monoMin.isEmpty() && nums[i] < monoMin.peekLast().getKey()) {
                monoMin.pollLast();
            }
            
            monoMin.offerLast(new Pair<>(nums[i], i));
            monoMax.offerLast(new Pair<>(nums[i], i));
            
            while (true) {
                adjust(monoMin, j);
                adjust(monoMax, j);
                if (monoMax.peekFirst().getKey() - monoMin.peekFirst().getKey() > limit) {
                    j++;
                } else {
                    break;
                }
            }
            
            ans = Math.max(ans, i - j + 1);
        }
        
        return ans;
    }
}