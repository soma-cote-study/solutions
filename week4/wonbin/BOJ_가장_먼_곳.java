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
    static int A, B, C;
    static int N, M;
    static int D, E, L;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            graph[D].add(new Node(E, L));
            graph[E].add(new Node(D, L));
        }

        int[] distA = dijkstra(A);
        int[] distB = dijkstra(B);
        int[] distC = dijkstra(C);

        int maxDist = -1;
        int answer = -1;
        for(int i = 1; i <= N; i++){
            int distance = Math.min(distA[i], Math.min(distB[i], distC[i]));

            if(distance > maxDist){
                maxDist = distance;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    static int[] dijkstra(int start){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(dist[current.n] < current.cost) continue;

            for(Node next : graph[current.n]){
                if(dist[next.n] > dist[current.n] + next.cost){
                    dist[next.n] = dist[current.n] + next.cost;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
        return dist;
    }
}