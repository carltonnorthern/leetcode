class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTimes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(!map.containsKey(manager[i])) {
                map.put(manager[i], new ArrayList<Integer>());
            }
            map.get(manager[i]).add(i);
        }

        return DFS(headID, map, informTimes, 0);
    }

    private int DFS(int node, Map<Integer, List<Integer>> map, int[] informTimes, int informTime) {
        if(!map.containsKey(node)) {
            return informTime;
        }

        int maxInformTime = informTime;

        List<Integer> children = map.get(node);

        for(int i=0; i< children.size(); i++){
            maxInformTime = Math.max(maxInformTime, DFS(children.get(i), map, informTimes, informTime + informTimes[node]));
        }

        return maxInformTime;

    }
}