class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int res1 = 0;
        int res2 = 0;
        if(start<destination){
            for(int i=start;i<destination;i++)res1+=distance[i];
            for(int i=0;i<start;i++)res2+=distance[i];
            for(int i=destination;i<distance.length;i++)res2+=distance[i];
        }
        else{
            for(int i=start;i<distance.length;i++)res1+=distance[i];
            for(int i=0;i<destination;i++)res1+=distance[i];
            for(int i=destination;i<start;i++)res2+=distance[i];
        }

        return Math.min(res1,res2);
    }
}