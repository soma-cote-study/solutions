import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, K;
    static Set<Integer> visited;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {1, -1};

    static class Node{
        int x;
        int dist;

        public Node(int x, int dist){
            this.x = x;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(st.nextToken());
            q.offer(new Node(a, 0));
            visited.add(a);
        }

        long answer = 0;
        int count = 0;

        while(!q.isEmpty()){
            Node current = q.poll();

            for(int i = 0; i < 2; i++){
                int nx = current.x + dx[i];

                if(!visited.contains(nx)){
                    visited.add(nx);
                    q.offer(new Node(nx, current.dist + 1));
                    answer += current.dist + 1;
                    count++;
                }

                if(count == K){
                    System.out.println(answer);
                    return;
                }
            }
        }
    }
}