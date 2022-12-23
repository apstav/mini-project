package gr.aueb.cf.miniProjects;

public class Project2 {
    /**
     * Calculates Max sub array sum.
      *
     * @author ApostoliSt
     */
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Maximum contiguous sum is " + maxSubArraySum(arr));
    }

    /**
     * Calculates max sub array sum.
     * @param arr       the source array
     * @return          the max sum
     */
    static int maxSubArraySum(int arr[]) {
        int globalMax = arr[0];
        int localMax = arr[0];

        for (int i = 0; i < arr.length; i++) {
            localMax = Math.max(arr[i], localMax + arr[i]);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }
        return globalMax;
    }
}
