import java.util.Scanner;

class Solution
{
    static int[] dr = {1, 0, 1, 1};
    static int[] dc = {0, 1, -1, 1};
    static char[][] map;
    static int N;
    
    public static boolean check(int dir, int r, int c)
    {
    	for(int i = 1; i <= 4; i++)
        {
        	r += dr[dir];
            c += dc[dir];
            
            if(r < 0 || r >= N || c < 0 || c >= N) 
                return false;
            if(map[r][c] != 'o')
                return false;
        }
        return true;
    }
	
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
            map = new char[N][N];
            
            for(int i = 0; i < N; i++)
            {
            	String tmp = sc.next();
                for(int j = 0; j < N; j++)
                    map[i][j] = tmp.charAt(j);
            }
            
            boolean isExist = false;
            for(int i = 0; i < N; i++)
            {
            	for(int j = 0; j < N; j++)
                {
                	if(map[i][j] == 'o')
                    {
                    	for(int k = 0; k < 4; k++)
                        {
                        	if(check(k, i, j))
                            {
                            	isExist = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(isExist)
                System.out.println("#" + test_case + " YES");
            else
                System.out.println("#" + test_case + " NO");
		}
	}
}