import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int idx;
    int cost;

    public Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }

    public int compareTo(Node o){
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main{
    static ArrayList<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for(int i = 0; i <= V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currentIdx = current.idx;
            int currentCost = current.cost;

            if(currentCost > dist[currentIdx]) continue;

            for(Node n : graph[currentIdx]){
                if(dist[n.idx] > currentCost + n.cost){
                    dist[n.idx] = currentCost + n.cost;
                    pq.offer(new Node(n.idx, dist[n.idx]));
                }
            }
        }
    }
}