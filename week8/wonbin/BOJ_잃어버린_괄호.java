import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        String[] minusSplit = expression.split("-");

        int result = sum(minusSplit[0]);
        for (int i = 1; i < minusSplit.length; i++) {
            result -= sum(minusSplit[i]);
        }

        System.out.println(result);
    }

    private static int sum(String str) {
        String[] parts = str.split("\\+");
        int total = 0;
        for (String s : parts) {
            total += Integer.parseInt(s);
        }
        return total;
    }
}