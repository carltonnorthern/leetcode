class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegrees = new int[numCourses];
        Arrays.fill(indegrees, 0);

        for(int i=0; i<prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            //adjList
            if(!adjList.containsKey(pair[1])) {
                adjList.put(pair[1], new ArrayList<Integer>());
            }
            adjList.get(pair[1]).add(pair[0]);

            //indegree
            indegrees[pair[0]]++;

        }

        List<Integer> z = new ArrayList<Integer>();
        for(int i=0; i< indegrees.length; i++) {
            if(indegrees[i]==0) {
                z.add(i);
            }
        }

        int count=0;
        while(z.size()>0){
            int node = z.remove(0);
            count++;
            List<Integer> adjacents = adjList.get(node);
            if(adjacents!=null) {
                for (int i = 0; i < adjacents.size(); i++) {
                    int adjNode = adjacents.get(i);
                    indegrees[adjNode]--;
                    if (indegrees[adjNode] == 0) {
                        z.add(adjNode);
                    }
                }
            }
        }

        if(count == numCourses) {
            return true;
        } else {
            return false;
        }
    }
}