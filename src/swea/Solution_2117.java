package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2117 {

	static int testCase; 
	static int N; 
	static int [][] map; 
	static int M; 
	static int result; 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = null; 
		StringBuilder sb = new StringBuilder(); 
		
		testCase = Integer.parseInt(br.readLine()); 
			
		for(int t = 1; t<=testCase; t++) {
			
			result = 0; // 집의 개수를 담을거야 ㅎㅎ
			st = new StringTokenizer(br.readLine()); 
			N = Integer.parseInt(st.nextToken()); //지도 크기야 이건!
			M = Integer.parseInt(st.nextToken()); //집이 지불하는 비용이야~
			
			map = new int [N][N]; //맵을 먼저 만들어야지!
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); //입력해 
				}
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 자! 지금부터 맵의 원소 하나하나씩 살펴볼거야~
					// 얘네가 해밀턴의 시작점인거지 			
					
					int k = 1; 
					// 자 일단 운영 영역은 1부터 시작이라는 것을 알고 있지 ㅎㅎ
					
					int [][] temp = new int[N][N]; 
					// 여기는 어떤값을 넣을거냐면 해밀턴이 적용된 면적이 갱신될거야 
					
					int cnt = 0; 
				
					while(true) {
						//일단 계속 돌려버려!!!!
						
						int x = k-1; 
						// 현재 지점으로부터 왼쪽과 오른쪽의 길이 범위야 
						int y = k-1; 
						// 현재 지점으로부터 위쪽과 아래쪽의 길이 범위야 
						boolean flag = false; 
						//더이상 갱신할 곳이 없으면 이 플래그는 갱신되지 않아ㅎㅎ 
						
						
						for(int yy = i-y; yy<=i+y; yy++) {
							//쇼숑쇼숑 돌리는 중! 이건 뭐냐면 해밀턴 범위에 해당하는 애들인거야 
							for(int xx = j - x; xx <= j+x; xx++) {
								// 돌려 돌려 
								// 이것도 해밀턴 범위에 해당하는 애들이겠쥐? 
								
								if(yy<0||yy>=N||xx<0||xx>=N)continue; 
								// 맵 초과했어 그러면 무시해버려 크하하 
								
								if(Math.abs(yy-i)+Math.abs(xx-j)<k) {
									// 지금 해밀턴 범위인 애들이네??? 
									
									if(temp[yy][xx]==1)continue; 
									//만약 이미 갱신되어 있네? 무시해 
									//마름모 모양으로 퍼지기 때문에 이전에 거쳤던 애들은 이미 세팅 되어있어 
									
									if(temp[yy][xx]==0) {
										
										flag = true; 
										// 이때 갱신했다고 true로 설정
										temp[yy][xx]=1; 
										// 마름모 모양으로 퍼져야겟지?
										if(map[yy][xx]==1) {
											cnt++; 
											//만약 퍼진 곳이 집이라면 집의 개수 갱신
											//
										}
									}
								}								
								
							}
						}			
						if(flag == false) break; // 갱신된 곳이 없어 그러면 멈춰라 크하하. 현 지점 반복문 끝났어 
						int price = k*k+(k-1)*(k-1); // 비용 공식 적용해서 넣어 
						if(price <= cnt*M) {// 이익이 될 때에만 최대 집의 개수 체크하는거자나 바보야 
							if(result<cnt)result = cnt; // 갱신해줘 
						}
						k++; 					
						// 해밀턴 거리 늘려줘 
					}
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}
