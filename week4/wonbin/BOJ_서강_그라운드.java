import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int n;
    int cost;

    public Node(int n, int cost){
        this.n = n;
        this.cost = cost;
    }
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

class Main {
    static int n, m, r;
    static int u, v, w;
    static int[] arr;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        int answer = 0;
        for(int i = 1; i <= n; i++){
            answer = Math.max(answer, dijkstra(i));
        }

        System.out.println(answer);
    }

    static int dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currentN = current.n;
            int currentCost = current.cost;

            if(currentCost > dist[currentN]) continue;

            for(Node next : graph[currentN]){
                int Cost = dist[currentN] + next.cost;

                if(Cost < dist[next.n]){
                    dist[next.n] = Cost;
                    pq.offer(new Node(next.n, Cost));
                }
            }
        }

        int item = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] <= m){
                item += arr[i];
            }
        }
        return item;
    }
}