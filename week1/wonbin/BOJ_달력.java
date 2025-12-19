import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static int width, height;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for(int i = 1; i <= 366; i++){
            map.put(i, 0);
        }


        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for(int j = N; j <= M; j++){
                map.put(j, map.getOrDefault(j, 0) + 1);

            }
        }
        for(int i = 1; i <= 366; i++){
            if(map.get(i) > 0){
                height = Math.max(map.get(i), height);
                width++;
            }else {
                answer += width * height;
                width = 0;
                height = 0;
            }
        }

        System.out.println(answer);
    }
}