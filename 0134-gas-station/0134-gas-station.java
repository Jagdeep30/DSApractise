class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int n = gas.length;
        // if(n==1){
        //     if(gas[0]<cost[0])return -1;
        //     else return 0;
        // }
        // // int[] temp = new int[n];
        // List<Integer> temp = new ArrayList<>();
        // for(int i=0;i<n;i++)temp.add(i);

        // Collections.sort(temp,(a,b)->{
        //     return Integer.compare(gas[a]-cost[a],gas[b]-cost[b]);
        // });
        // // System.out.println(temp);
        // for(int i=n-1;i>=0;i--){
        //     int ele = temp.get(i);
        //     int left = gas[ele]-cost[ele];
        //     int j = (ele+1)%n;
        //     // int prev = ele;
        //     boolean flag = false;
        //     while(j!=ele){
        //     // System.out.println(j);
        //         if(left+gas[j]>=cost[j]){
        //             left = left+gas[j]-cost[j];
        //             j++;
        //             if(j>=n)j=j%n;
        //         }
        //         else{
        //             flag=true;
        //             break;
        //         }
        //     }
        //     if(!flag)return ele;
        // }
        // return -1;


         int n=gas.length;
        int total_gas=0,total_cost=0;
        int curr_gas=0, starting_point=0;
        for(int i=0;i<n;i++)
        {
            //these two variable are to check if no case is possible
            total_gas+=gas[i];
            total_cost+=cost[i];
            //for checking the total present gas at index i
            curr_gas+=gas[i]-cost[i];
            if(curr_gas<0)
            {
               //there is a breakdown....so we will start from next point or index
                starting_point=i+1;
                //reset our fuel 
                curr_gas=0;
            }
        }
        return (total_gas<total_cost)?-1:starting_point;    
    }
}