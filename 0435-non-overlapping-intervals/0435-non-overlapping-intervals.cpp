class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        // int count = 0;
        // int i = 0;
        // while(i+1<intervals.size()){
        //     if(intervals[i+1][0]<intervals[i][1]){
        //         //erase i+1;
        //         vector<vector<int>>::iterator it;
        //         it = intervals.begin();
        //         it+=i+1;
        //         intervals.erase(it);
        //         count++;
        //         continue;
        //     }
        //     i++;
        // }
        // return count;

        vector<vector<int>> ans;
        vector<int> temp = intervals[0];
        int i=1;
        while(i<intervals.size()){
            if(intervals[i][0]<temp[1]){
                if(intervals[i][1]<temp[1]){
                    temp = intervals[i];
                }
                i++;
            }
            else{
                ans.push_back(temp);
                temp = intervals[i];
                i++;
            }
        }
        return intervals.size() - ans.size() - 1;







    }
};