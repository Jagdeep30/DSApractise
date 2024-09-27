class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        reverse(matrix.begin(),matrix.end());
        int n = matrix.size();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                swap(matrix[i][j],matrix[j][i]);
            }
        }
        // return matrix;
    }
};







// #include<unordered_map>
// class Solution {
// public:
//     void rotate(vector<vector<int>>& matrix) {
//         unordered_map<int,vector<int>> nums;
//         int n = matrix[0].size();
//         int count = 1;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 vector<int> pos;
//                 // pos.push_back(i);
//                 // pos.push_back(j);
//                 int r,c;
//                 if(i==0){
//                     r = j;
//                     c = n-1;
//                 }
//                 else if(i==n-1){
//                     r = j;
//                     c = 0;
//                 }
//                 else{
//                     r = j;
//                     c = n-i-1;
//                 }
//                 pos.push_back(r);
//                 pos.push_back(c);
//                 pos.push_back(matrix[i][j]);
//                 nums[count] = pos;
//                 count++;
//             }
//         }

//         for(auto k:nums){
//             matrix[k.second[0]][k.second[1]] = k.second[2];
//         }

//     }
// };