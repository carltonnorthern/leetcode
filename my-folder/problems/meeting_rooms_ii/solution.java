class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] r1, int[] r2) {
                int value = Double.compare(r1[0], r2[0]);
                return value;
            }
        });
        
        
        int i = 0;
        List<List<List<Integer>>> rooms = new ArrayList();
        List<List<Integer>> room = new ArrayList();
        room.add(new ArrayList());
        rooms.add(new ArrayList());
        while(i < intervals.length) {
            int[] res = intervals[i];
            List<Integer> resList = new ArrayList();
            resList.add(res[0]);
            resList.add(res[1]);
            addRooms(rooms, resList);
            i++;
        }
        
        return rooms.size();
    }
    
    private void addRooms(List<List<List<Integer>>> rooms, List<Integer> res) {
        int i=0;
        List<List<Integer>> room = null;
        while(i < rooms.size()){
            room = rooms.get(i);
            if(addRoom(room, res)) {
                return;
            }
            i++;
        }
        room = new ArrayList();
        room.add(res);
        rooms.add(room);
    }
    
    private boolean addRoom(List<List<Integer>> room, List<Integer> res) {
        if(room.isEmpty()) {
            room.add(res);
            return true;
        }
        List<Integer> lastRoom = room.get(room.size()-1);
        if(res.get(0) >= lastRoom.get(1)) {
            room.add(res);
            return true;
        }
        return false;
    }
}