class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int numberOfIndividualCars = position.length;
        if (numberOfIndividualCars == 0) return 0;  // ← Edge case!
        
        // Create array with (position, time)
        double[][] cars = new double[numberOfIndividualCars][2];
        for (int i = 0; i < numberOfIndividualCars; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        
        // Sort by position (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        int numberOfFleets = 0;  // ← Start at 0
        double currentMaxTime = 0;
        
        for (int i = 0; i < numberOfIndividualCars; i++) {
            double timeToReach = cars[i][1];
            if (timeToReach > currentMaxTime) {
                numberOfFleets++;
                currentMaxTime = timeToReach;
            }
        }
        
        return numberOfFleets;
    }
}