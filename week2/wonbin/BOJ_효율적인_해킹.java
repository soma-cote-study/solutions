import java.util.*;
import java.io.*;

class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[B].add(A);
        }

        int[] count = new int[N + 1];
        int haking = 0;
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            Arrays.fill(visited, false);
            count[i] = search(i);
            haking = Math.max(haking, count[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(count[i] == haking){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    static int search(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int count = 1;

        while(!q.isEmpty()){
            int current = q.poll();

            for(int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}