class Solution {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int maximum = 0;
        for (int x : gain) {
            current += x;
            maximum = Math.max(maximum, current);
        }
        return maximum;
    }
}
Input
gain =
[-5,1,5,0,-7]
Output
1
Expected
1
