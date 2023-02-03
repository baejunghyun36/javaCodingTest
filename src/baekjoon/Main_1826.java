import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1826 {

  static int gasStationCnt;
  static List<GasStation> gasStations;
  static PriorityQueue<Integer> fuelEnergy;
  static int destination, startFuel;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    gasStationCnt = Integer.parseInt(st.nextToken());
    gasStations = new ArrayList<>();

    for(int i=0; i<gasStationCnt; i++){
      st = new StringTokenizer(br.readLine());
      int location = Integer.parseInt(st.nextToken());
      int fuel = Integer.parseInt(st.nextToken());
      GasStation gasStation = new GasStation(location, fuel);
      gasStations.add(gasStation);
    }

    st = new StringTokenizer(br.readLine());
    destination = Integer.parseInt(st.nextToken());
    startFuel = Integer.parseInt(st.nextToken());

    init();
    sb.append(logic());

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  static void init(){
    fuelEnergy = new PriorityQueue<>(Collections.reverseOrder());
    fuelEnergy.add(startFuel);
    Collections.sort(gasStations);
  }

  static int logic(){

    int curPossibleDistance = fuelEnergy.poll();
    int index = 0;
    int cnt = 0;

    while (curPossibleDistance<destination) {
      while(index<gasStationCnt&&curPossibleDistance>=gasStations.get(index).location){
        fuelEnergy.add(gasStations.get(index).fuel);
        index++;
      }
      if(fuelEnergy.isEmpty()){
        return -1;
      }
      else{
        curPossibleDistance += fuelEnergy.poll();
        cnt++;
      }
    }
    return cnt;
  }

  static class GasStation implements Comparable <GasStation> {

    int location;
    int fuel;

    public GasStation(int location, int fuel) {
      this.location = location;
      this.fuel = fuel;
    }

    public int compareTo(GasStation g){
      return this.location - g.location;
    }
  }
}
