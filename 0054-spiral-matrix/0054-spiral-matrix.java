class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int round = 0;
        int count = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int i=-1;
        int j=-1;
        while(count<r*c){
            i++;
            j++;
            //right
            while(j<c-round && count<r*c){
                count++;
                ans.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            //down
            while(i<r-round && count<r*c){
                count++;
                ans.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            //left
            while(j>=round && count<r*c){
                count++;
                ans.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            //up
            while(i>round && count<r*c){
                count++;
                ans.add(matrix[i][j]);
                i--;;
            }
            
            round++;
        }

        return ans;
    }
}