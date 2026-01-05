import java.util.*;
import java.io.*;

public class Main{
    static int MAX_NODE = 52;
    static boolean[][] graph = new boolean[MAX_NODE][MAX_NODE];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            char start = line.charAt(0);
            char end = line.charAt(5);

            if(start == end) continue;

            int u = charToInt(start);
            int v = charToInt(end);

            graph[u][v] = true;
        }

        path();
        int count = 0;
        for(int i = 0; i < MAX_NODE; i++){
            for(int j = 0; j < MAX_NODE; j++){
                if(i != j && graph[i][j]){
                    count++;
                    sb.append(intToChar(i)).append(" => ").append(intToChar(j)).append("\n");
                }
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }

    static void path(){
        for(int k = 0; k < MAX_NODE; k++){
            for(int i = 0; i < MAX_NODE; i++){
                if(!graph[i][k]) continue;

                for(int j = 0; j < MAX_NODE; j++){
                    if(graph[i][j] || (graph[i][k] && graph[k][j])){
                        graph[i][j] = true;
                    }
                }
            }
        }
    }

    static int charToInt(char c){
        if(c <= 'Z') return c - 'A';
        return c - 'a' + 26;
    }
    static char intToChar(int n){
        if(n <= 25) return (char)(n + 'A');
        return (char)(n - 26 + 'a');
    }
}