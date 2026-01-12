import java.util.*;
import java.io.*;

class Node{
    int end, w;

    public Node(int end, int w){
        this.end = end;
        this.w = w;
    }
}

class Main {
    static int N, M, W;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static final int INF = 100000000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < TC; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken ());

            graph = new ArrayList[N + 1];
            for(int i = 0; i <= N; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph[u].add(new Node(v, t));
                graph[v].add(new Node(u, t));
            }

            for(int  i = 0; i < W; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph[u].add(new Node(v, -t));
            }

            if(search(N)){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean search(int n){
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean update = false;

        for(int i = 1; i < n; i++){
            update = false;

            for(int j = 1; j <= n; j++){
                for(Node next : graph[j]){
                    if(dist[next.end] > dist[j] + next.w){
                        dist[next.end] = dist[j] + next.w;
                        update = true;
                    }
                }
            }
            if(!update) break;
        }
        if(update){
            for(int j = 1; j <= n; j++){
                for(Node next : graph[j]){
                    if(dist[next.end] > dist[j] + next.w){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}