class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Arrays.fill(rows,new HashSet<>());
        // Arrays.fill(cols,new HashSet<>());
        // Arrays.fill(boxes,new HashSet<>());

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]=='.')continue;

                int boxInd = (r/3)*3 + (c/3);
                if(rows[r].contains(board[r][c]) || cols[c].contains(board[r][c]) || boxes[boxInd].contains(board[r][c]))return false;

                rows[r].add(board[r][c]);
                cols[c].add(board[r][c]);
                boxes[boxInd].add(board[r][c]);
            }
        }
        return true;
    }
}