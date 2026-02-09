
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] liquids = new long[n];
        for (int i = 0; i < n; i++) {
            liquids[i] = sc.nextLong();
        }

        Arrays.sort(liquids);

        int left = 0;
        int right = n - 1;
        long minSum = Long.MAX_VALUE;
        long ans1 = 0;
        long ans2 = 0;

        while (left < right) {
            long sum = liquids[left] + liquids[right];

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                ans1 = liquids[left];
                ans2 = liquids[right];
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                break;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}