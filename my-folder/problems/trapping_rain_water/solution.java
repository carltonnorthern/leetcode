class Solution {
    public int trap(int[] height) {
        int area = 0;
        int La = 0, Lb = 0;
        int Ra = height.length-1, Rb = height.length-1;

        while (La < Ra ) {
            //left side
            if (height[La] == 0) {
                La++;
                Lb++;
            } else {
                if (height[La] <= height[Ra]) {
                    Lb++;
                    while (height[Lb] < height[La]) {
                        Lb++;
                    }
                    area = area + calcAreaLeft(height, La, Lb);
                    La = Lb;
                    if(La == Ra) {
                        break;
                    }
                }
            }

            //Right side
            if (height[Ra] == 0) {
                Ra--;
                Rb--;
            } else {
                if (height[Ra] <= height[La]) {
                    Rb--;
                    while (height[Rb] < height[Ra]) {
                        Rb--;
                    }
                    area = area + calcAreaRight(height, Ra, Rb);
                    Ra = Rb;
                }

            }
        }
        return area;
    }

    private static int calcAreaLeft(int[] elevations, int La, int Lb) {
        int min = Math.min(elevations[La], elevations[Lb]);
        int area = 0;
        for (int i=La+1; i<Lb; i++) {
            area = area + min - elevations[i];
        }
        return area;
    }

    private static int calcAreaRight(int[] elevations, int Ra, int Rb) {
        int min = Math.min(elevations[Ra], elevations[Rb]);
        int area = 0;
        for (int i=Ra-1; i>Rb; i--) {
            area = area + min - elevations[i];
        }
        return area;
    }
}