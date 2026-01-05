import java.util.*;
import java.io.*;

public class Main{
    static class Node{
        int end;
        int time;

        public Node(int end, int time){
            this.end = end;
            this.time = time;
        }
    }
    static int N, M;
    static ArrayList<Node>[] graph;
    static long[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
        }

        long INF = Long.MAX_VALUE;
        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        dist[1] = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                for(Node n : graph[j]){
                    if(dist[j] == INF) continue;
                    if(dist[n.end] > dist[j] + n.time){
                        dist[n.end] = dist[j] + n.time;

                        if(i == N){
                            System.out.println(-1);
                            return;
                        }
                    }
                }
            }
        }

        for(int i = 2; i <= N; i++){

            if(dist[i] == INF){
                System.out.println(-1);
            }else{
                System.out.println(dist[i]);
            }
        }
    }
}