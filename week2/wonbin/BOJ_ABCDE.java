import java.util.*;
import java.io.*;

class Main {
    static boolean[] visited;
    static int N, M;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        list = new ArrayList[N];
        for(int i = 0; i < N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 0; i < N; i++){
            visited[i] = true;
            search(i, 1);
            visited[i] = false;
        }
        System.out.println(0);
    }

    static void search(int start, int depth){
        if(depth == 5){
            System.out.println(1);
            System.exit(0);
        }

        for(int next : list[start]){
            if(!visited[next]){
                visited[next] = true;
                search(next, depth + 1);
                visited[next] = false;
            }
        }
    }
}