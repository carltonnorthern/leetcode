class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for(int i=1; i<heights.length; i++) {
            int right = list.size()-1;
            while(right >=0 && heights[i] >= heights[list.get(right)]) {
                list.remove(right);
                right--;
            }
            list.add(i);
        }

    
        return list.stream().mapToInt(i->i).toArray();
    }
}