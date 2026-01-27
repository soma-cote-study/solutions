import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        int sum = 0;
        String input;
        while((input = br.readLine()) != null){
            if(input.length() == 0) break;
            sum++;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        for(String key : keyList){
            int value = map.get(key);
            double result = (double) value / sum * 100;
            System.out.printf("%s %.4f\n", key, result);
        }
    }
}