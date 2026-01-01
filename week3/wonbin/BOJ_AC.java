import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrInput = br.readLine();
            arrInput = arrInput.substring(1, arrInput.length() - 1);

            List<Integer> list = new ArrayList<>();
            if (!arrInput.isEmpty()) {
                String[] nums = arrInput.split(",");
                for (String num : nums) {
                    list.add(Integer.parseInt(num));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else if (cmd == 'D') {
                    if (list.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    }
                    if (!isReversed) list.remove(0);
                    else list.remove(list.size() - 1);
                }
            }

            if (isError) continue;

            sb.append("[");
            if (isReversed) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    sb.append(list.get(j));
                    if (j != 0) sb.append(",");
                }
            } else {
                for (int j = 0; j < list.size(); j++) {
                    sb.append(list.get(j));
                    if (j != list.size() - 1) sb.append(",");
                }
            }

            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}