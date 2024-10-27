/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return solve(0,grid.length-1,0,grid[0].length-1,grid).getValue();
    }

    static Pair<Integer,Node> solve(int rs, int re, int cs, int ce, int[][] grid){
        if(rs==re && cs==ce){
            Node nw = new Node();
            nw.isLeaf = true;
            nw.val = grid[rs][cs]==1?true:false;
            return new Pair<Integer,Node>(grid[rs][cs],nw);
        }

        Pair<Integer,Node> tl = solve(rs,(rs+re)/2,cs,(cs+ce)/2,grid);
        Pair<Integer,Node> tr = solve(rs,(rs+re)/2,((cs+ce)/2)+1,ce,grid);
        Pair<Integer,Node> bl = solve(((rs+re)/2)+1,re,cs,(cs+ce)/2,grid);
        Pair<Integer,Node> br = solve(((rs+re)/2)+1,re,((cs+ce)/2)+1,ce,grid);

        Node n = new Node();
        int rVal = 1;

        if(tl.getKey()==1 && tr.getKey()==1 && bl.getKey()==1 && br.getKey()==1){
            n.val = true;
            rVal = 1;
            n.isLeaf = true;
        }
        else if(tl.getKey()==0 && tr.getKey()==0 && bl.getKey()==0 && br.getKey()==0){
            n.val = false;
            rVal = 0;
            n.isLeaf = true;
        }
        else{
            n.val = true;
            rVal = 3;
            n.topLeft = tl.getValue();
            n.topRight = tr.getValue();
            n.bottomLeft = bl.getValue();
            n.bottomRight = br.getValue();
        }

        // if(tl.getKey()==1 || tl.getKey()==0){
        //     System.out.println("reache");
        //     Node temp = tl.getValue();
        //     temp.topLeft = null;
        //     temp.topRight = null;
        //     temp.bottomLeft = null;
        //     temp.bottomRight = null;
        // }
        // if(tr.getKey()==1 || tr.getKey()==0){
        //     Node temp = tr.getValue();
        //     temp.topLeft = null;
        //     temp.topRight = null;
        //     temp.bottomLeft = null;
        //     temp.bottomRight = null;
        // }
        // if(bl.getKey()==1 || bl.getKey()==0){
        //     Node temp = bl.getValue();
        //     temp.topLeft = null;
        //     temp.topRight = null;
        //     temp.bottomLeft = null;
        //     temp.bottomRight = null;
        // }
        // if(br.getKey()==1 || br.getKey()==0){
        //     Node temp = br.getValue();
        //     temp.topLeft = null;
        //     temp.topRight = null;
        //     temp.bottomLeft = null;
        //     temp.bottomRight = null;
        // }

        

        return new Pair<Integer,Node>(rVal,n);
    }
}