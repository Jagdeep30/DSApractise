// class Solution {
//     public int findMinDifference(List<String> p) {
//         Collections.sort(p);
//         int[] arr = new int[p.size()];
//         for(int i=0;i<p.size();i++){
//             // String a = p.get(i-1);
//             String b = p.get(i);
//             // int h1 = Integer.parseInt(a.charAt(0)+""+a.charAt(1));
//             int h2 = Integer.parseInt(b.charAt(0)+""+b.charAt(1));
//             // int m1 = Integer.parseInt(a.charAt(3)+""+a.charAt(4));
//             int m2 = Integer.parseInt(b.charAt(3)+""+b.charAt(4));
//             arr[i] = h2*60+m2;
//         }
//         int min = Integer.MAX_VALUE;
//         for(int i=1;i<arr.length;i++){
//             min = Math.min(Math.abs(arr[i]-arr[i-1]),min);
//         }
//         min = Math.min(min,24*60-arr[arr.length-1]+arr[0]);
//         return min;
//     }
// }
class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) return 0; 

        boolean[] seen = new boolean[1440]; 
        
        for (String time : timePoints) {
            int minutes = convertToMinutes(time);
            if (seen[minutes]) return 0; 
            seen[minutes] = true;
        }
        
        int first = Integer.MAX_VALUE, prev = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < 1440; i++) {
            if (seen[i]) {
                if (first == Integer.MAX_VALUE) {
                    first = i;
                } else {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }
        

        minDiff = Math.min(minDiff, 1440 - prev + first);
        
        return minDiff;
    }
    
    private int convertToMinutes(String time) {
        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 
             + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
    }
}
//Kartikdevsharmaa