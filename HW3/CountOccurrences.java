package HW3;
public class CountOccurrences {

    public static void main(String[] args) {
        int[] array = {2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15};
        System.out.println("Target 4 = " + countOccurrences(array, 4) + " Occurrences");
        System.out.println("Target 2 = " + countOccurrences(array, 2) + " Occurrences");
        System.out.println("Target 5 = " + countOccurrences(array, 5) + " Occurrences");
    }

    public static int countOccurrences(int[] array, int target) {
        int firstIndex = findFirst(array, target);
        if (firstIndex == -1) return 0; 
        int lastIndex = findLast(array, target);
        return lastIndex - firstIndex + 1;
    }

    private static int findFirst(int[] array, int target) {
        int low = 0, high = array.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if (array[mid] == target) index = mid;
        }
        return index;
    }

    private static int findLast(int[] array, int target) {
        int low = 0, high = array.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            if (array[mid] == target) index = mid;
        }
        return index;
    }
}
