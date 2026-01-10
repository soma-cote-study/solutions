import java.util.*;
import java.io.*;

class Main {
    static int V, E;
    static int a, b, c;
    static int[][] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V][V];
        int INF = 100000000;
        for(int i = 0; i < V; i++){
            Arrays.fill(dist[i], INF);
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            dist[a - 1][b - 1] = c;
        }

        int answer = Integer.MAX_VALUE;
        for(int k = 0; k < V; k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 0; i < V; i++){
            answer = Math.min(answer, dist[i][i]);
        }

        if(answer == INF){
            System.out.println(-1);
            return;
        }else System.out.println(answer);
    }
}