import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long count = 0;
        int maxVal = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            maxVal = Math.max(maxVal, num);

            if(!stack.isEmpty() && stack.peek() == num)continue;

            while(!stack.isEmpty() && stack.peek() < num) {
                int val = stack.pop();
                int left = stack.isEmpty() ? num : stack.peek();
                int bound = Math.min(left, num);
                count += (bound - val);
            }
            stack.push(num);
        }

        while(!stack.isEmpty()) {
            int val = stack.pop();
            if (!stack.isEmpty()) {
                count += (stack.peek() - val);
            }
        }

        System.out.println(count);
    }
}