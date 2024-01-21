package solution;

import java.util.Arrays;

public class SearchingAlgorithms {

    public boolean binarySearch(int[] arr, int searchingElement) {
        boolean isFound = false;
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (searchingElement == arr[mid]) {
                isFound = true;
                break;
            } else if (searchingElement > arr[mid]) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return isFound;
    }

}
