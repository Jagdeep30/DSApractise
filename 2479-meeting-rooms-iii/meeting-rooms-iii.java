class Solution {

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0]-b[0]);

        int[] roomCount = new int[n];
        long[] roomEndTime = new long[n];

        for(int[] meeting: meetings){
            int start = meeting[0];
            int end = meeting[1];

            boolean roomFound = false;
            long minRoomEndTime = Long.MAX_VALUE;
            int minRoomEndTimeIndex = -1;
            for(int i=0; i<n; i++){
                if(roomEndTime[i] < minRoomEndTime){
                    minRoomEndTime = roomEndTime[i];
                    minRoomEndTimeIndex = i;
                }
                if(roomEndTime[i] <= start){
                    roomEndTime[i] = end;
                    roomCount[i]++;
                    roomFound = true;
                    break;
                }
                
            }

            if(!roomFound){
                roomEndTime[minRoomEndTimeIndex] = roomEndTime[minRoomEndTimeIndex] + (end-start);
                roomCount[minRoomEndTimeIndex]++;
            }

        }


        int roomNo = 101, max = 0;

        for(int i=0; i<n; i++){
            if(roomCount[i] > max){
                roomNo = i;
                max = roomCount[i];
            } else if(roomCount[i] == max){
                roomNo = Math.min(roomNo, i);
            }
        }

        return roomNo;

    }
}

















// class Solution {
//     public int mostBooked(int n, int[][] meetings) {
//         PriorityQueue<Integer> free = new PriorityQueue<>();
//         PriorityQueue<List<Integer>> used = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(0)));
//         int[] arr = new int[n];

//         for(int i=0;i<n;i++)free.add(i);
//         Arrays.sort(meetings,(a,b)->{
//             return Integer.compare(a[0],b[0]);
//         });

//         // for(int i=0;i<meetings.length;i++)System.out.println(Arrays.toString(meetings[i]));
//         for(int i=0;i<meetings.length;i++){

//             while(!used.isEmpty() && used.peek().get(0)<=meetings[i][0]){
//                 free.add(used.poll().get(1));
//             }

//             if(!free.isEmpty()){
//                 int room = free.poll();
//                 List<Integer> temp = new ArrayList<>();
//                 temp.add(meetings[i][1]);
//                 temp.add(room);
//                 used.add(temp);
//                 arr[room]++;
//             }
//             else{
//                 int et = used.peek().get(0);
//                 while(!used.isEmpty() && used.peek().get(0)==et){
//                     free.add(used.poll().get(1));
//                 }

//                 int dur = meetings[i][1]-meetings[i][0];

//                 int room = free.poll();
//                 List<Integer> temp = new ArrayList<>();
//                 temp.add(et+dur);
//                 temp.add(room);
//                 used.add(temp);
//                 arr[room]++;
//             }
//         }

//         System.out.println(Arrays.toString(arr));
//         int max = 0;
//         int ele = -1;
//         for(int i=0;i<n;i++){
//             if(arr[i]>max){
//                 max=arr[i];
//                 ele=i;
//             }
//         }
//         return ele;
//     }
// }