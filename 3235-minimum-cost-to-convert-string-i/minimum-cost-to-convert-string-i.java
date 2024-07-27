// class Solution {
//     public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
//         Map<Character,List<Pair<Character,Integer>>> mp = new HashMap<>();
//         for(int i=0;i<original.length;i++){
//             List<Pair<Character,Integer>> ls = mp.getOrDefault(original[i],null);
//             if(ls==null)ls = new ArrayList<>();

//             Pair<Character,Integer> p = new Pair<>(changed[i],cost[i]);
//             ls.add(p);
//             mp.put(original[i],ls);
//         }
//         return solve(0,source.length(),source,target,mp);
        
//     }

//     static long solve(int i, int n, String source, String target, Map<Character,List<Pair<Character,Integer>>> mp){
//         if(i==n)return 0;
//         if(source.charAt(i)==target.charAt(i)){
//             // System.out.println("same   " + i);
//             return solve(i+1,n,source,target,mp);
//         }

//         //explore all the paths
//         List<Pair<Character,Integer>> pos = mp.getOrDefault(source.charAt(i),null);
//         if(pos==null)return -1;
//         // System.out.println(pos + "   " + i);
//         long min = Integer.MAX_VALUE;
//         for(Pair<Character,Integer> t : pos){
//             String temp = source;
//             temp = source.substring(0,i)+t.getKey()+source.substring(i+1,n);
//             // System.out.println("old: "+source+" new: "+temp);
//             long ans = 0;
//             if(t.getKey()==target.charAt(i)){
//                 ans = solve(i+1,n,temp,target,mp);
//             }
//             else{
//                 ans = solve(i,n,temp,target,mp);
//             }
//             if(ans==-1)return -1;
//             ans+=t.getValue();
//             min = Math.min(min,ans);
//         }

//         return min;
//     }
// }

class Solution {
    private static final int CHAR_COUNT = 26;
    private static final int INF = Integer.MAX_VALUE / 2;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] conversionGraph = buildConversionGraph(original, changed, cost);
        optimizeConversionPaths(conversionGraph);
        return computeTotalConversionCost(source, target, conversionGraph);
    }

    private int[][] buildConversionGraph(char[] original, char[] changed, int[] cost) {
        int[][] graph = new int[CHAR_COUNT][CHAR_COUNT];
        for (int[] row : graph) {
            Arrays.fill(row, INF);
        }
        for (int i = 0; i < CHAR_COUNT; i++) {
            graph[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            graph[from][to] = Math.min(graph[from][to], cost[i]);
        }
        return graph;
    }

    private void optimizeConversionPaths(int[][] graph) {
        for (int k = 0; k < CHAR_COUNT; k++) {
            for (int i = 0; i < CHAR_COUNT; i++) {
                if (graph[i][k] < INF) {
                    for (int j = 0; j < CHAR_COUNT; j++) {
                        if (graph[k][j] < INF) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }
    }

    private long computeTotalConversionCost(String source, String target, int[][] graph) {
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int sourceChar = source.charAt(i) - 'a';
            int targetChar = target.charAt(i) - 'a';
            if (sourceChar != targetChar) {
                if (graph[sourceChar][targetChar] == INF) {
                    return -1L;
                }
                totalCost += graph[sourceChar][targetChar];
            }
        }
        return totalCost;
    }
}