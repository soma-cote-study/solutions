import java.util.*;
import java.io.*;

class Main {
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String input = br.readLine();
        count = 0;

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == 'M'){
                count++;
            }else if(c == 'K'){
                if(count > 0){
                    sb2.append(1);
                    sb.append(5);
                    for(int j = 0; j < count; j++){
                        sb.append(0);
                    }
                    for(int j = 0; j < count - 1; j++){
                        sb2.append(0);
                    }
                    sb2.append(5);
                }else {
                    sb.append(5);
                    sb2.append(5);
                }
                count = 0;
            }
        }
        if(count > 0){
            sb2.append(1);
            for(int i = 0; i < count; i++){
                sb.append(1);
            }
            for(int i = 0; i < count - 1; i++){
                sb2.append(0);
            }
        }

        System.out.println(sb);
        System.out.println(sb2);
    }
}