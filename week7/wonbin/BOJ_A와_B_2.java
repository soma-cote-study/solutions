import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        String T = br.readLine();

        System.out.println(solve(T));
    }

    static int solve(String current) {
        if (current.length() == S.length()) {
            return current.equals(S) ? 1 : 0;
        }

        if (current.length() < S.length()) {
            return 0;
        }

        int possible = 0;

        if (current.charAt(current.length() - 1) == 'A') {
            possible += solve(current.substring(0, current.length() - 1));
        }

        if (possible > 0) return 1;
        if (current.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(current.substring(1));
            possible += solve(sb.reverse().toString());
        }

        return possible > 0 ? 1 : 0;
    }
}