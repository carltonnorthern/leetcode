class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->b[1] - a[1]);
        queue.addAll(Arrays.asList(boxTypes));
        int currentTruckSize = 0;
        int unitsInTruck = 0;
        while(currentTruckSize < truckSize) {
            int remaining = truckSize - currentTruckSize;
            int[] box = queue.poll();
            if(box == null) {
                return unitsInTruck;
            }
            int boxAmount = box[0];
            int unitsInBox = box[1];
            if(boxAmount <= remaining){
                unitsInTruck += unitsInBox * boxAmount;
                currentTruckSize += boxAmount;
            } else {
                unitsInTruck += unitsInBox * remaining;
                currentTruckSize += remaining;
            }
        }
        return unitsInTruck;
    }
}