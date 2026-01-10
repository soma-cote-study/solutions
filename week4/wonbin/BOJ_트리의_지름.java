import java.util.*;
import java.io.*;

class Node{
    int n;
    int w;

    public Node(int n, int w){
        this.n = n;
        this.w = w;
    }
}

class Main {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int maxNode;
    static int maxDist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[parent].add(new Node(child, weight));
            graph[child].add(new Node(parent, weight));
        }

        visited = new boolean[n + 1];
        search(1, 0);

        visited = new boolean[n + 1];
        maxDist = 0;
        search(maxNode, 0);

        System.out.println(maxDist);
    }

    static void search(int node, int dist){
        visited[node] = true;

        if (dist > maxDist) {
            maxDist = dist;
            maxNode = node;
        }

        for (Node next : graph[node]) {
            if (!visited[next.n]) {
                search(next.n, dist + next.w);
            }
        }
    }
}