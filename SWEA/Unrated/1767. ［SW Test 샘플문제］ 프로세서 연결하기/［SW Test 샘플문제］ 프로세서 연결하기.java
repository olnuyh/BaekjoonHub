import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Core{
    int r, c;
     
    public Core(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
 
public class Solution {
    public static int n;
     
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
     
    public static int[][] processor;
    public static ArrayList<Core> list;
    public static int[] index;
     
    public static int maxCore;
    public static int minSumLine;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int t = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
                     
            processor = new int[n][n];
            list = new ArrayList<>();
             
            int already = 0;
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    processor[i][j] = Integer.parseInt(st.nextToken());
                    if(processor[i][j] == 1) {
                        if(i == 0 || i == n - 1 || j == 0 || j == n - 1)
                            already++;
                        else
                            list.add(new Core(i, j));
                    }
                }
            }
             
            index = new int[list.size()];
             
            for(int i = 0; i < index.length; i++)
                index[i] = i;
             
            maxCore = Integer.MIN_VALUE;
            minSumLine = Integer.MAX_VALUE;
            connection(0, already, 0);
         
            sb.append("#").append(tc).append(" ").append(minSumLine).append("\n");
        }
 
        System.out.println(sb);
    }
     
    public static void connection(int cnt, int core, int line) {
        if(cnt == index.length) {
            if(core > maxCore) {
                maxCore = core;
                minSumLine = line;
            }else if(core == maxCore)
                minSumLine = Math.min(minSumLine, line);
            return;
        }
         
        if(core + index.length - cnt < maxCore)
            return;
         
        Core curCore = list.get(cnt);
 
        for(int i = 0; i < 4; i++) {             
            int l = isAvailable(curCore.r, curCore.c, i);
            if(l == 0)
                connection(cnt + 1, core, line);
            else {
                connection(cnt + 1, core + 1, line + l);
                revert(curCore.r, curCore.c, i, l);
            }
        }
    }
     
    public static int isAvailable(int r, int c, int d) {
        int cnt = 0;
        for(int l = 1; ; l++) {
            int nr = r + dr[d] * l;
            int nc = c + dc[d] * l;
             
            if(nr < 0 || nr >= n || nc < 0 || nc >= n) break;
             
            if(processor[nr][nc] == 1)
                return 0;
             
            cnt++;
        }
         
        for(int l = 1; l <= cnt; l++) {
            int nr = r + dr[d] * l;
            int nc = c + dc[d] * l;
             
            processor[nr][nc] = 1;
        }
         
        return cnt;
    }
     
    public static int revert(int r, int c, int d, int cnt) {
        for(int l = 1; l <= cnt; l++) {
            int nr = r + dr[d] * l;
            int nc = c + dc[d] * l;
             
            processor[nr][nc] = 0;
        }
         
        return cnt;
    }
}