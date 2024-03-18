
package HW4;
import java.util.Arrays;

public class MeetingRooms {

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = {{7, 10}, {2, 4}};

        System.out.println(canAttendAllMeetings(intervals1)); 
        System.out.println(canAttendAllMeetings(intervals2)); 
    }

    private static boolean canAttendAllMeetings(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false; 
            }
        }
        return true; 
    }

    private static void quickSort(int[][] intervals, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(intervals, start, end);
            quickSort(intervals, start, partitionIndex - 1);
            quickSort(intervals, partitionIndex + 1, end);
        }
    }

    private static int partition(int[][] intervals, int start, int end) {
        int[] pivot = intervals[end];
        int i = (start - 1); 

        for (int j = start; j < end; j++) {
            if (intervals[j][0] <= pivot[0]) {
                i++;

                int[] temp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = temp;
            }
        }

        int[] temp = intervals[i + 1];
        intervals[i + 1] = intervals[end];
        intervals[end] = temp;

        return i + 1;
    }
}
