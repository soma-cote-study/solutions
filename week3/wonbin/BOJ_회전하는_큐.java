import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        LinkedList<Integer> dq = new LinkedList<>();
        int count = 0;

        for(int i = 1; i <= N; i++){
            dq.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            q.offer(num);
        }
        
        while (!q.isEmpty()){
            int current = q.poll();
            int idx = dq.indexOf(current);
            int size = dq.size();
            int mid = size / 2;

            if(idx <= mid){
                while(dq.peekFirst() != current){
                    dq.addLast(dq.pollFirst());
                    count++;
                }
            }else {
                while(dq.peekFirst() != current){
                    dq.addFirst(dq.pollLast());
                    count++;
                }
            }
            dq.pollFirst();
        }

        System.out.println(count);
    }
}