import java.util.*;
import java.io.*;

class Main {
    static class Node{
        int n, cost;
        Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int target, answer;
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            answer = 0;

            dfs(start, 0);

            sb.append(answer).append('\n');
        }

        System.out.print(sb.toString());
    }

    static void dfs(int cur, int dist){
        if(cur == target){
            answer = dist;
            return;
        }

        visited[cur] = true;

        for(Node next : graph[cur]){
            if(!visited[next.n]){
                dfs(next.n, dist + next.cost);
            }
        }
    }
}