import java.util.*;
import java.io.*;

public class Main{
    static PriorityQueue<Node> pq;
    static boolean[] visited;

    static class Node implements Comparable<Node>{
        int x, time;

        Node(int x, int time){
            this.x = x;
            this.time = time;
        }

        public int compareTo(Node o){
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        visited = new boolean[100001];
        pq.offer(new Node(N, 0));

        int count = 0;
        while(!pq.isEmpty()){
            Node current = pq.poll();

            if(current.x == K){
                System.out.println(current.time);
                return;
            }

            if(visited[current.x]) continue;
            visited[current.x] = true;

            if(current.x + 1 <= 100000 && !visited[current.x + 1]){
                pq.offer(new Node(current.x + 1, current.time + 1));
            }
            if(current.x - 1 >= 0 && !visited[current.x - 1]){
                pq.offer(new Node(current.x - 1, current.time + 1));
            }
            if(current.x * 2 <= 100000 && !visited[current.x * 2]){
                pq.offer(new Node(current.x * 2, current.time));
            }
        }

    }
}