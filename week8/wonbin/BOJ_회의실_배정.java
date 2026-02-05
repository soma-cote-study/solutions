import java.io.*;
import java.util.*;

class Room implements Comparable<Room>{
    int stime;
    int etime;
    public Room(int stime, int etime){
        super();
        this.stime = stime;
        this.etime = etime;
    }
    @Override
    public int compareTo(Room o){
        int time = etime - o.etime;
        if(time == 0){
            time = stime - o.etime;
        }
        return time;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Room> list = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Room(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int endTime = list.get(0).etime;
        int count = 1;

        for (int i = 1, size = list.size(); i < size; i++) {
            if(endTime <= list.get(i).stime){
                count++;
                endTime = list.get(i).etime;
            }
        }
        System.out.println(count);
    }
}
