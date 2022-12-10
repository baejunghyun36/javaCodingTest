package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution__5648_byCh
{
	static boolean[][]		visited = new boolean[4005][4005];
	static boolean[][]		collide = new boolean[4005][4005];
	static ArrayList<Atom>	atoms = new ArrayList<>();
	static int				count;
	static int				ans;
	public static void main(String[] args) throws Exception
	{
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder	sb = new StringBuilder();
		StringTokenizer	st;
		int				testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++)
		{
			sb.append('#').append(tc).append(' ');
			count = Integer.parseInt(br.readLine());
			ans = 0;
			for (int i = 0; i < count; i++)
			{
				st = new StringTokenizer(br.readLine());
				atoms.add(new Atom((Integer.parseInt(st.nextToken()) + 1000) * 2,
						(Integer.parseInt(st.nextToken()) + 1000) * 2,
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}
			for (int i = 0; i < 4001; i++)
			{
				Atom	temp;
				if (atoms.isEmpty())
					break ;
				count = atoms.size();
				for (int j = count - 1; j >= 0; j--)
				{
					temp = atoms.get(j);
					temp.move();
					if (temp.y < 0 || temp.y > 4000 || temp.x < 0 || temp.x > 4000)
					{
						atoms.remove(j);
						continue;
					}
					if (visited[temp.y][temp.x])
					{
						collide[temp.y][temp.x] = true;
						ans += temp.energy;
						atoms.remove(j);
					}
					else
						visited[temp.y][temp.x] = true;
				}
				count = atoms.size();
				for (int j = count - 1; j >= 0; j--)
				{
					temp = atoms.get(j);
					visited[temp.y][temp.x] = false;
					if (collide[temp.y][temp.x] == true)
					{
						ans += temp.energy;
						collide[temp.y][temp.x] = false;
						atoms.remove(j);
					}
				}
			}
			sb.append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}

class Atom {
	int	x;
	int	y;
	int	dir;
	int energy;
	static int[]	dx = {0, 0, -1, 1};
	static int[]	dy = {1, -1, 0, 0};
	
	public Atom()
	{
		
	}
	
	public Atom(int x, int y, int dir, int energy)
	{
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.energy = energy;
	}
	
	public void move()
	{
		x += dx[dir];
		y += dy[dir];
	}
}