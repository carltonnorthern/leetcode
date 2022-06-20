class Solution {
    public class Pair implements Comparable<Pair>{
        private int first;
        private int second;
        public Pair(int a, int b) {
            first = a;
            second = b;
        }

        @Override
        public int compareTo(Pair p) {
            return p.second > this.second ? 1 : -1;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        //create adjacency list
        for(int i=0; i<times.length; i++) {
            int[] time = times[i];
            if(!adjList.containsKey(time[0])) {
                adjList.put(time[0], new ArrayList<Pair>());
            }
            adjList.get(time[0]).add(new Pair(time[1], time[2]));
        }

        int[] dji = new int[n+1];
        Arrays.fill(dji, Integer.MAX_VALUE);
        dji[k] = 0;

        Queue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k, dji[k]));

        while(!pq.isEmpty()) {

            Pair node = pq.poll();
            List<Pair> children = adjList.get(node.first);
            if(children!=null) {
                for (Pair child : children) {
                    int temp = node.second + child.second;
                    if (dji[child.first] > temp) {
                        dji[child.first] = temp;
                        pq.add(new Pair(child.first, temp));
                    }
                }
            }
        }

        int maxTime = 0;
        for(int i=1; i<dji.length; i++){
            maxTime = Math.max(maxTime, dji[i]);
        }

        if(maxTime==Integer.MAX_VALUE) {
            return -1;
        }


        return maxTime;
    }

    private Pair getNode(List<Pair> pq, int first) {
        for(int i=0; i<pq.size(); i++) {
            if(pq.get(i).first == first) {
                return pq.get(i);
            }
        }
        return null;
    }
}