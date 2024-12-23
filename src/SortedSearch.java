public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
       // throw new UnsupportedOperationException("Waiting to be implemented.");
       int low = 0;
        int high = sortedArray.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sortedArray[mid] < lessThan) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
    
    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}