import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] <= arr.length && arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else
                i++;
        }

        int missing = 0;
        int missingCount = 0;
        Set<Integer> extraNumbers = new HashSet<>();
        for (i = 0; i < arr.length && missingCount < k; i++)
            if (arr[i] != i + 1) {
                missing = i + 1;
                missingCount++;
                extraNumbers.add(arr[i]);
            }

        for (i = 1; missingCount < k; i++) {
            int candidateNumber = i + arr.length;

            if (!extraNumbers.contains(candidateNumber)) {
                missing = candidateNumber;
                missingCount++;
            }
        }

        return missing;
    }
}