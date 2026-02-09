import java.util.*;
import java.io.*;

class Main {
    static int mid, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        int money = Integer.parseInt(br.readLine());
        int left = money / N;
        int right = Collections.max(list);

        while (left <= right) {
            int mid = (left + right) / 2;
            long currentSum = 0;

            for(int l : list){
                if(mid >= l){
                    currentSum += l;
                }else{
                    currentSum += mid;
                }
            }

            if (currentSum > money) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}