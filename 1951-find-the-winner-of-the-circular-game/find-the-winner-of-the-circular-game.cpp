class Solution {
public:
    int win(int n, int k){
        if(n==1)return 0;
        return (win(n-1,k)+k) %n;
    }
    int findTheWinner(int n, int k) {
        // vector<int> v;
        // for(int i=1;i<=n;i++){
        //     v.push_back(i);
        // }
        // int i=k-1;
        // while(v.size()!=1){
        //     while(i>=v.size()){
        //         i-=v.size();
        //     }
        //     vector<int>::iterator it = v.begin();
        //     it+=i;
        //     v.erase(it);
        //     i += k-1;
        // }

        // // for(int i=0;i<v.size();i++){
        // //     cout<<v[i]<<endl;
        // // }
        // return v[0];


        //USING RECURSION
        return win(n,k)+1;
    }
};