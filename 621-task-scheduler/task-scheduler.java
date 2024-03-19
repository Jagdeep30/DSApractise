class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Map<Character,Integer> mp = new HashMap<>();
        // Set<Character> temp = new HashSet<>();
        // for(int i=0;i<tasks.length;i++){
        //     mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);
        //     temp.add(tasks[i]);
        // }
        // List<Character> s = new ArrayList<>(temp);
        // int ans = 0;
        // int ind = 0;
        // int count = tasks.length;
        // ans+=s.size();
        // count-=s.size();

        // for(int i=0;i<s.size();i++){
        //     // if(mp.get(s.get(i))!=0){
        //         // ans++;
        //         // count--;
        //     mp.put(s.get(i),mp.get(s.get(i))-1);
        //     // }
        // }

        // if(count>0 && ans-ind<n+1){
        //     ans+=n+1-(ans-ind);
        // }


        // while(count!=0){
        //     ind=ans;
        //     for(int i=0;i<s.size();i++){
        //         if(mp.get(s.get(i))!=0){
        //             ans++;
        //             count--;
        //             mp.put(s.get(i),mp.get(s.get(i))-1);
        //         }
        //     }
        //     if(count>0 && ans-ind<n+1){
        //         ans+=n+1-(ans-ind);
        //     }
        // }

        // return ans;

        int[] freq = new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A'] += 1;
        }
        Arrays.sort(freq);
        int chunck = freq[25]-1;
        int idle = chunck*n;

        for(int i=24;i>=0;i--){
            idle-=Math.min(chunck,freq[i]);
        }

        return idle<0?tasks.length : tasks.length+idle;
    }
}