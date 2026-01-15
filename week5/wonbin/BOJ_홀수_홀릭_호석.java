import java.util.*;
import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        search(input, 0);

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        System.out.println(sb);
    }

    static void search(String s, int odd) {
        int currentOdd = countOdd(s);
        odd += currentOdd;

        if (s.length() == 1) {
            min = Math.min(min, odd);
            max = Math.max(max, odd);
            return;
        }
        else if (s.length() == 2) {
            int n1 = Integer.parseInt(s.substring(0, 1));
            int n2 = Integer.parseInt(s.substring(1));

            search(String.valueOf(n1 + n2), odd);
        }
        else {
            for (int i = 1; i < s.length() - 1; i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j);

                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);

                    search(String.valueOf(sum), odd);
                }
            }
        }
    }

    static int countOdd(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num % 2 != 0) {
                count++;
            }
        }
        return count;
    }
}