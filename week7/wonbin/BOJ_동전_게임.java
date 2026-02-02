import java.util.*;
import java.io.*;

class Main {
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int start = 0;

            for(int i = 0; i < 3; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 3; j++){
                    String val = st.nextToken();
                    if(val.equals("H")){
                        int k = i * 3 + j;
                        start |= (1 << k);
                    }
                }
            }

            if(start == 0 || start == 511){
                System.out.println(0);
            }else{
                System.out.println(bfs(start));
            }
        }
    }
    static int bfs(int start){
        if(start == 0 || start == 511) return 0;

        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[512];

        q.offer(start);
        visited[start] = true;

        int[] masks = makeMask();
        int dist = 0;

        while(!q.isEmpty()){
            int size = q.size();
            dist++;

            for(int s = 0; s < size; s++){
                int current = q.poll();

                for(int mask : masks){
                    int next = current ^ mask;

                    if(next == 0 || next == 511) return dist;

                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    static int[] makeMask(){
        int[] masks = new int[8];

        masks[0] = (1 << 0) | (1 << 1) | (1 << 2); // 7
        masks[1] = (1 << 3) | (1 << 4) | (1 << 5); // 56
        masks[2] = (1 << 6) | (1 << 7) | (1 << 8); // 448

        masks[3] = (1 << 0) | (1 << 3) | (1 << 6); // 73
        masks[4] = (1 << 1) | (1 << 4) | (1 << 7); // 146
        masks[5] = (1 << 2) | (1 << 5) | (1 << 8); // 292

        masks[6] = (1 << 0) | (1 << 4) | (1 << 8); // 273
        masks[7] = (1 << 2) | (1 << 4) | (1 << 6); // 84

        return masks;
    }
}