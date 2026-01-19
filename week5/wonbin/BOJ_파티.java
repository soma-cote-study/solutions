import java.util*;
import java.io.*;

public Node implements Comparable<node>{
    int n. cost;

    public int(int n, int cost){
        this.n = n;
        this.cost = cost;
    }
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}
public class Main {
    static final int INF = 100_000_000;
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] reverse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverse = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            reverse[v].add(new Node(u, w));
        }

        int[] party = dijkstra(graph);
        int[] home = dijkstra(graph);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (answer < party[i] + home[i]) {
                answer = party[i] + home[i]
            }
        }

        System.out.println(answer);
    }

    static int[] dijkstra(ArrayList<Node>[] node){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        pq.offer(new Node(X, 0));
        dist[X] = 0;

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currentIdx = current.idx;
            int currentCost = current.cost;

            if(dist[currentIdx] < currentCost) continue;

            for(Node next : node[currentIdx]){
                if(dist[next.idx] > dist[currentIdx] + next.cost){
                    dist[next.idx] = dist[currentIdx] + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        return dist;
    }
}