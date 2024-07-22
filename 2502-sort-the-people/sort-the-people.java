class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Pair<Integer,String>> arr = new ArrayList<>();

        for(int i=0;i<names.length;i++){
            arr.add(new Pair<Integer,String>(heights[i],names[i]));
        }

        Collections.sort(arr,(a,b)->{
            return a.getKey()>b.getKey()?-1:1;
        });

        for(int i=0;i<names.length;i++){
            names[i] = arr.get(i).getValue();
        }
        return names;

    }
}