import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Long> list = new ArrayList<>();
        List<Long> minus = new ArrayList<>();
        int count = 0;
        int answer = 0;

        for(int i = 0; i < N; i++){
            long n = Integer.parseInt(br.readLine());
            if(n > 0 && n != 1){
                list.add(n);
            }else if(n == 1){
                count++;
            }else{
                minus.add(n);
            }
        }
        Collections.sort(minus);
        Collections.sort(list, Collections.reverseOrder());

        while (list.size() > 1) {
            answer += (list.remove(0) * list.remove(0));
        }
        if (!list.isEmpty()) {
            answer += list.remove(0);
        }

        while (minus.size() > 1) {
            answer += (minus.remove(0) * minus.remove(0));
        }
        if (!minus.isEmpty()) {
            answer += minus.remove(0);
        }

        answer += count;

        System.out.println(answer);
    }
}