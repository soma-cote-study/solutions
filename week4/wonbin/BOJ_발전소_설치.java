import java.util.*;
import java.io.*;

class Coord{
    int x;
    int y;

    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Node implements Comparable<Node>{
    int idx;
    double cost;

    public Node(int idx, double cost){
        this.idx = idx;
        this.cost = cost;
    }

    public int compareTo(Node o){
        return Double.compare(this.cost, o.cost);
    }
}
class Main {
    static int N;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        double M = Double.parseDouble(br.readLine());

        Coord[] arr = new Coord[N + 1];
        graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            arr[i] = new Coord(X, Y);
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                double dist = distance(arr[i], arr[j]);

                if(dist <= M){
                    graph[i].add(new Node(j, dist));
                    graph[j].add(new Node(i, dist));
                }
            }
        }

        for(int i = 0; i < W; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, 0.0));
            graph[v].add(new Node(u, 0.0));
        }

        dijkstra(1);
    }

    static double distance(Coord c1, Coord c2){
        long dx = (long)c1.x - c2.x;
        long dy = (long)c1.y - c2.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    static void dijkstra(int start){
        double[] dist = new double[N + 1];

        Arrays.fill(dist, Double.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currentIdx = current.idx;
            double currentCost = current.cost;

            if(currentCost > dist[currentIdx]) continue;
            for(Node next : graph[currentIdx]){
                if(dist[next.idx] > currentCost + next.cost){
                    dist[next.idx] = currentCost + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        System.out.println((long)(dist[N] * 1000));
    }
}