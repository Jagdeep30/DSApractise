class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int ans = 0;
        int i=0;
        int j=people.length-1;

        while(i<people.length && i<=j){
            // int sum = people[j];
            // while(i<j && sum<limit){
                // if(sum+people[i]<=limit){
                //     sum+=people[i++];
                // }
                // else break;
            // }

            if(people[i]+people[j]<=limit){
                i++;
            }
            j--;
            ans++;
        }

        return ans;
    }
}