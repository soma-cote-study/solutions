import java.util.*;
import java.io.*;

class Main {
    static int time;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        List<Integer> box = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int n= Integer.parseInt(st.nextToken());
            list.add(n);
        }

        Collections.sort(list, Collections.reverseOrder());
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int n = Integer.parseInt(st.nextToken());
            box.add(n);
        }
        Collections.sort(box, Collections.reverseOrder());

        if(list.get(0) < box.get(0)){
            System.out.println(-1);
            return;
        }

        while(!box.isEmpty()){
            int boxIdx = 0;

            for(int i = 0; i < N; i++) {
                if(boxIdx == box.size()) break;

                while(true) {
                    if(boxIdx == box.size()) break;

                    if(list.get(i) >= box.get(boxIdx)) {
                        box.remove(boxIdx);
                        break;
                    } else {
                        boxIdx++;
                    }
                }
            }
            time++;
        }

        if(box.size() > 0){
            System.out.println(-1);
        }

        System.out.println(time);
    }
}