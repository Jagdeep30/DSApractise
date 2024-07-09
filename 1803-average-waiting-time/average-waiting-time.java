class Solution {
    public double averageWaitingTime(int[][] customers) {
        int curr = customers[0][0] + customers[0][1];
        double sum = customers[0][1];

        for(int i=1;i<customers.length;i++){
            if(customers[i][0]>curr){
                curr = customers[i][0];
            }
            curr+=customers[i][1];
            sum += curr-customers[i][0];
        }

        return sum/customers.length;
    }
}