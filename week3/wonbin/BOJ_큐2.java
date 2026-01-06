import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            if(input.equals("push")){
                int N = Integer.parseInt(st.nextToken());
                q.add(N);
            }else if(input.equals("front")){
                if(!q.isEmpty()){
                    int front = q.peekFirst();
                    sb.append(front).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }else if(input.equals("back")){
                if(!q.isEmpty()){
                    int back = q.peekLast();
                    sb.append(back).append("\n");
                }else sb.append(-1).append("\n");
            }else if(input.equals("empty")){
                if(q.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(input.equals("size")){
                int size = q.size();
                sb.append(size).append("\n");
            }else if(input.equals("pop")){
                if(!q.isEmpty()){
                    int pop = q.removeFirst();
                    sb.append(pop).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}