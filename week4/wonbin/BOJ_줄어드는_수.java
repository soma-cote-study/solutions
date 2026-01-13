import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            search(i);
        }

        Collections.sort(list);

        if (N > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N - 1));
        }
    }

    static void search(long num) {
        list.add(num);

        int last = (int) (num % 10);
        for (int i = 0; i < last; i++) {
            search(num * 10 + i);
        }
    }
}