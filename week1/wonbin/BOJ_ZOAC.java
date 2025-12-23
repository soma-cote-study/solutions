import java.util.*;
import java.io.*;

class Main {
    static String input;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        visited = new boolean[input.length()];

        search(0, input.length() - 1);
    }

    
    static void search(int start, int end){
        if(start > end) return;

        int min = -1;
        char minChar = Character.MAX_VALUE;

        for(int i = start; i <= end; i++){
            if(input.charAt(i) < minChar){
                minChar = input.charAt(i);
                min = i;
            }
        }

        visited[min] = true;
        sb = new StringBuilder();

        for(int i = 0; i < input.length(); i++){
            if(visited[i]){
                sb.append(input.charAt(i));
            }
        }
        System.out.println(sb);

        search(min + 1, end);
        search(start, min - 1);
    }
}