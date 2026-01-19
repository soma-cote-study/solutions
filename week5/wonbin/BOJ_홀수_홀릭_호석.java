import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        search(S, 0);

        System.out.println(min + " " + max);
    }

    static void search(String s, int totalOdd) {
        int currentOdd = countOdd(s);
        totalOdd += currentOdd;

        if (s.length() == 1) {
            min = Math.min(min, totalOdd);
            max = Math.max(max, totalOdd);
            return;
        }

        if (s.length() == 2) {
            int n1 = Integer.parseInt(s.substring(0, 1));
            int n2 = Integer.parseInt(s.substring(1));
            search(String.valueOf(n1 + n2), totalOdd);
        } else {
            for (int i = 1; i < s.length() - 1; i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j);

                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    search(String.valueOf(sum), totalOdd);
                }
            }
        }
    }

    static int countOdd(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num % 2 != 0) cnt++;
        }
        return cnt;
    }
}