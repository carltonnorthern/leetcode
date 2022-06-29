class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                // if the heights are equal, compare k-values
                return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for(int[] person : people){
            output.add(person[1], person);
        }

        return output.toArray(new int[people.length][2]);
    }
}