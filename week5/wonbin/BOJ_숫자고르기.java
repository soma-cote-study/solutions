import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            search(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());

        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void search(int start, int depth) {
        int current = arr[depth];

        if(current == start){
            list.add(current);
        }

        else if (!visited[current]) {
            visited[current] = true;
            search(start, current);
            visited[current] = false;
        }
    }
}