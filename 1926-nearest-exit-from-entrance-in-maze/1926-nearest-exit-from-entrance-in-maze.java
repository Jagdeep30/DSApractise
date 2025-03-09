class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        // Map<String,Boolean> mp = new HashMap<>();
        temp.addAll(Arrays.asList(entrance[0], entrance[1], 0));
        q.add(temp);
        // mp.put(Integer.toString(entrance[0])+","+Integer.toString(entrance[1]),true);
        maze[entrance[0]][entrance[1]] = '+';
        while(!q.isEmpty()){
            // System.out.println(q);
            List<Integer> ls = q.poll();
            int i = ls.get(0);
            int j = ls.get(1);
            if(ls.get(2)!=0 && (i==0 || i==n-1 || j==0 || j==m-1)){
                return ls.get(2);
            }

            //up
            int r = i-1;
            int c = j;
            if(r>=0 && maze[r][c]=='.'){
                // mp.put(Integer.toString(r)+","+Integer.toString(c),true);
                maze[r][c] = '+';
                temp = new ArrayList<>();
                temp.add(r);
                temp.add(c);
                temp.add(ls.get(2)+1);
                q.add(temp);
            }
            //down
            r = i+1;
            c = j;
            if(r<n && maze[r][c]=='.'){
                // mp.put(Integer.toString(r)+","+Integer.toString(c),true);
                maze[r][c] = '+';
                temp = new ArrayList<>();
                temp.add(r);
                temp.add(c);
                temp.add(ls.get(2)+1);
                q.add(temp);
            }
            //left
            r = i;
            c = j+1;
            if(c<m && maze[r][c]=='.'){
                // mp.put(Integer.toString(r)+","+Integer.toString(c),true);
                maze[r][c] = '+';
                temp = new ArrayList<>();
                temp.add(r);
                temp.add(c);
                temp.add(ls.get(2)+1);
                q.add(temp);
            }
            //right
            r = i;
            c = j-1;
            if(c>=0 && maze[r][c]=='.'){
                // mp.put(Integer.toString(r)+","+Integer.toString(c),true);
                maze[r][c] = '+';
                temp = new ArrayList<>();
                temp.add(r);
                temp.add(c);
                temp.add(ls.get(2)+1);
                q.add(temp);
            }
        }

        return -1;
    }
}